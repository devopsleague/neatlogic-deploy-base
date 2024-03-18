/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/
package neatlogic.framework.deploy.auth.core;

import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.auth.core.AuthActionChecker;
import neatlogic.framework.common.constvalue.UserType;
import neatlogic.framework.crossover.CrossoverServiceFactory;
import neatlogic.framework.deploy.auth.DEPLOY_MODIFY;
import neatlogic.framework.deploy.constvalue.DeployAppConfigActionType;
import neatlogic.framework.deploy.crossover.IDeployAppConfigCrossoverMapper;
import neatlogic.framework.deploy.dto.app.DeployAppConfigAuthorityActionVo;
import neatlogic.framework.deploy.dto.app.DeployAppConfigAuthorityVo;
import neatlogic.framework.deploy.dto.app.DeployAppSystemVo;
import neatlogic.framework.dto.AuthenticationInfoVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DeployAppAuthChecker {
    
    //权限类型
    private final static List<String> actionTypeList = DeployAppConfigActionType.getValueList();

    /**
     * 校验单个系统权限的构造方法
     *
     * @param appSystemId 系统id
     * @return Builder
     */
    public static Builder builder(Long appSystemId) {
        return new Builder(appSystemId);
    }

    /**
     * 校验多的系统权限的构造方法
     *
     * @return BatchBuilder
     */
    public static BatchBuilder batchbuilder() {
        return new BatchBuilder();
    }

    //校验单个系统权限内部类
    public static class Builder {

        //校验单系统权限时配合check()使用
        private final List<String> typeActionList = new ArrayList<>();
        private final Long appSystemId;

        public Builder(Long appSystemId) {
            this.appSystemId = appSystemId;
        }

        public Builder addOperationAction(String operationString) {
            typeActionList.add(DeployAppConfigActionType.OPERATION.getValue() + "#" + operationString);
            return this;
        }

        public Builder addEnvAction(Long envId) {
            typeActionList.add(DeployAppConfigActionType.ENV.getValue() + "#" + envId);
            return this;
        }

        public Builder addScenarioAction(Long scenarioId) {
            typeActionList.add(DeployAppConfigActionType.SCENARIO.getValue() + "#" + scenarioId);
            return this;
        }

        public Builder addOperationActionList(List<String> operationStringList) {
            for (String operationString : operationStringList) {
                typeActionList.add(DeployAppConfigActionType.OPERATION.getValue() + "#" + operationString);
            }
            return this;
        }

        public Builder addEnvActionList(List<Long> envIdList) {
            for (Long envId : envIdList) {
                typeActionList.add(DeployAppConfigActionType.ENV.getValue() + "#" + envId);
            }
            return this;
        }

        public Builder addScenarioActionList(List<Long> scenarioIdList) {
            for (Long scenarioId : scenarioIdList) {
                typeActionList.add(DeployAppConfigActionType.SCENARIO.getValue() + "#" + scenarioId);
            }
            return this;
        }

        public Set<String> check() {
            return DeployAppAuthChecker.check(appSystemId, typeActionList);
        }

    }

    //批量校验多个系统权限内部类
    public static class BatchBuilder {

        //校验多系统时batchCheck()使用
        private final Map<Long, Set<String>> typeActionSetMap = new HashMap<>();

        public BatchBuilder addOperationActionMap(Long appSystemId, List<String> operationList) {
            Set<String> oldOperationSet = typeActionSetMap.get(appSystemId);
            Set<String> paramOperationSet = new HashSet<>();
            for (String operation : operationList) {
                paramOperationSet.add(DeployAppConfigActionType.OPERATION.getValue() + "#" + operation);
            }
            if (CollectionUtils.isNotEmpty(oldOperationSet)) {
                oldOperationSet.addAll(paramOperationSet);
            } else {
                typeActionSetMap.put(appSystemId, paramOperationSet);
            }
            return this;
        }

        public BatchBuilder addEnvActionMap(Long appSystemId, List<Long> envIdList) {
            Set<String> oldEnvIdSet = typeActionSetMap.get(appSystemId);
            Set<String> paramEnvSet = new HashSet<>();
            for (Long envId : envIdList) {
                paramEnvSet.add(DeployAppConfigActionType.ENV.getValue() + "#" + envId);
            }
            if (CollectionUtils.isNotEmpty(oldEnvIdSet)) {
                oldEnvIdSet.addAll(paramEnvSet);
            } else {
                typeActionSetMap.put(appSystemId, paramEnvSet);
            }
            return this;
        }

        public BatchBuilder addScenarioActionMap(Long appSystemId, List<Long> scenarioIdList) {
            Set<String> oldScenarioSet = typeActionSetMap.get(appSystemId);
            Set<String> paramScenarioIdSet = new HashSet<>();
            for (Long scenarioId : scenarioIdList) {
                paramScenarioIdSet.add(DeployAppConfigActionType.SCENARIO.getValue() + "#" + scenarioId);
            }
            if (CollectionUtils.isNotEmpty(oldScenarioSet)) {
                oldScenarioSet.addAll(paramScenarioIdSet);
            } else {
                typeActionSetMap.put(appSystemId, paramScenarioIdSet);
            }
            return this;
        }


        public Map<Long, Set<String>> batchCheck() {
            return DeployAppAuthChecker.batchCheck(typeActionSetMap);
        }
    }

    /**
     * 校验单个系统权限
     *
     * @param appSystemId    系统id
     * @param typeActionList 权限列表
     * @return 拥有的权限列表
     */
    private static Set<String> check(Long appSystemId, List<String> typeActionList) {

        if (appSystemId == null || CollectionUtils.isEmpty(typeActionList)) {
            return new HashSet<>();
        }

        /*发布管理员拥有所有权限*/
        if (AuthActionChecker.check(DEPLOY_MODIFY.class)) {
            return DeployAppConfigActionType.getActionList(typeActionList);
        }
        IDeployAppConfigCrossoverMapper deployAppConfigCrossoverMapper = CrossoverServiceFactory.getApi(IDeployAppConfigCrossoverMapper.class);
        List<DeployAppConfigAuthorityVo> appSystemAuthList = deployAppConfigCrossoverMapper.getAppConfigAuthorityListByAppSystemId(appSystemId);
        /*如果当前系统没有配置权限，则所有人均没有权限*/
        if (CollectionUtils.isEmpty(appSystemAuthList)) {
            return new HashSet<>();
        }

        return getHasAuthoritySet(typeActionList, appSystemAuthList);

    }

    /**
     * 批量校验多系统下的多权限
     *
     * @param typeActionSetMap 需要校验的map
     * @return 拥有的权限map
     */
    private static Map<Long, Set<String>> batchCheck(Map<Long, Set<String>> typeActionSetMap) {
        IDeployAppConfigCrossoverMapper deployAppConfigCrossoverMapper = CrossoverServiceFactory.getApi(IDeployAppConfigCrossoverMapper.class);
        HashMap<Long, Set<String>> returnMap = new HashMap<>();
        if (MapUtils.isEmpty(typeActionSetMap)) {
            return returnMap;
        }

        /*将其分类为有特权和无特权（发布管理员权限和没有配置过的系统）两种，有特权直接拼接需要验权的权限列表到returnMap里，无特权的用sql语句进行批量验权，再拼接数据到returnMap里*/

        //1、查询系统信息列表
        List<DeployAppSystemVo> needCheckAppSystemVoList = deployAppConfigCrossoverMapper.getBatchAppConfigAuthorityListByAppSystemIdList(new ArrayList<>(typeActionSetMap.keySet()));

        //2、循环入参系统id，将其分类为有特权和无特权两种
        for (DeployAppSystemVo appSystemVo : needCheckAppSystemVoList) {
            List<DeployAppConfigAuthorityVo> appSystemAuthList = appSystemVo.getAuthList();
            /*如果当前系统没有配置权限，则所有人均拥有所有权限*/
            if (CollectionUtils.isEmpty(appSystemAuthList)) {
                //没有配置过权限的
                returnMap.put(appSystemVo.getId(), DeployAppConfigActionType.getActionList(new ArrayList<>(typeActionSetMap.get(appSystemVo.getId()))));

            } else if (AuthActionChecker.check(DEPLOY_MODIFY.class)) {
                //拥有发布管理员特权的
                returnMap.put(appSystemVo.getId(), DeployAppConfigActionType.getActionList(new ArrayList<>(typeActionSetMap.get(appSystemVo.getId()))));
            } else {
                //单个验权的
                returnMap.put(appSystemVo.getId(), getHasAuthoritySet(new ArrayList<>(typeActionSetMap.get(appSystemVo.getId())), appSystemAuthList));
            }
        }
        return returnMap;
    }

    /**
     * 获取鉴权成功的列表
     *
     * @param needCheckTypeActionList 需要鉴权的权限列表 会有权限类型前缀 比如operation#view
     * @param nowAppSystemAuthList    当前系统已配置的权限列表
     * @return 鉴权成功的列表
     */
    private static Set<String> getHasAuthoritySet(List<String> needCheckTypeActionList, List<DeployAppConfigAuthorityVo> nowAppSystemAuthList) {
        Set<String> returnActionSet = new HashSet<>();


        /*发布管理员拥有所有权限*/
        if (AuthActionChecker.check(DEPLOY_MODIFY.class)) {
            return DeployAppConfigActionType.getActionList(needCheckTypeActionList);
        }

        /*如果当前系统没有配置权限，则所有人均没有权限*/
        if (CollectionUtils.isEmpty(nowAppSystemAuthList)) {
            return new HashSet<>();
        }

        //分组角色信息
        AuthenticationInfoVo authInfo = UserContext.get().getAuthenticationInfoVo();
        //循环已配置的权限列表，解析权限，并构造结构
        for (DeployAppConfigAuthorityVo authVo : nowAppSystemAuthList) {
            if (authInfo.getUserUuid().equals(authVo.getAuthUuid()) || authInfo.getRoleUuidList().contains(authVo.getAuthUuid()) || authInfo.getTeamUuidList().contains(authVo.getAuthUuid()) || StringUtils.equals(UserType.ALL.getValue(), authVo.getAuthUuid())) {
                for (DeployAppConfigAuthorityActionVo actionVo : authVo.getActionList()) {
                    if (StringUtils.equals(actionVo.getAction(), "all")) {
                        returnActionSet.addAll(DeployAppConfigActionType.getActionList(needCheckTypeActionList.stream().filter(e -> e.startsWith(actionVo.getType())).collect(Collectors.toList())));

                    } else if (needCheckTypeActionList.contains(actionVo.getType() + "#" + actionVo.getAction())) {
                        returnActionSet.add(actionVo.getAction());

                    }
                }
            }
        }
        return returnActionSet;
    }

}
