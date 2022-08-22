package codedriver.framework.deploy.dto.app;

import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.auth.core.AuthActionChecker;
import codedriver.framework.cmdb.dto.resourcecenter.ResourceSearchVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.deploy.auth.DEPLOY_MODIFY;
import codedriver.framework.dto.AuthenticationInfoVo;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author longrf
 * @date 2022/6/23 5:33 下午
 */
public class DeployResourceSearchVo extends ResourceSearchVo {
    @EntityField(name = "是否已配置（1：已配置，0：未配置）", type = ApiParamType.INTEGER)
    private Integer isConfig;
    @EntityField(name = "应用系统id", type = ApiParamType.LONG)
    private Long appSystemId;
    @EntityField(name = "模块id", type = ApiParamType.LONG)
    private Long appModuleId;
    @EntityField(name = "环境id", type = ApiParamType.LONG)
    private Long envId;

    @JSONField(serialize = false)
    private List<Long> appSystemIdList;
    @JSONField(serialize = false)
    private Integer isHasAllAuthority; //是否拥有发布管理员权限
    @JSONField(serialize = false)
    List<String> authorityActionList; //权限列表
    @JSONField(serialize = false)
    private List<String> authUuidList; //用户、分组、角色的uuid列表

    public Integer getIsConfig() {
        return isConfig;
    }

    public void setIsConfig(Integer isConfig) {
        this.isConfig = isConfig;
    }

    public Long getAppSystemId() {
        return appSystemId;
    }

    public void setAppSystemId(Long appSystemId) {
        this.appSystemId = appSystemId;
    }

    @Override
    public Long getAppModuleId() {
        return appModuleId;
    }

    @Override
    public void setAppModuleId(Long appModuleId) {
        this.appModuleId = appModuleId;
    }

    @Override
    public Long getEnvId() {
        return envId;
    }

    @Override
    public void setEnvId(Long envId) {
        this.envId = envId;
    }

    @Override
    public List<Long> getAppSystemIdList() {
        return appSystemIdList;
    }

    @Override
    public void setAppSystemIdList(List<Long> appSystemIdList) {
        this.appSystemIdList = appSystemIdList;
    }

    public Integer getIsHasAllAuthority() {
        if (isHasAllAuthority == null) {
            if (AuthActionChecker.check(DEPLOY_MODIFY.class)) {
                isHasAllAuthority = 1;
            } else {
                isHasAllAuthority = 0;
            }
        }
        return isHasAllAuthority;
    }

    public void setIsHasAllAuthority(Integer isHasAllAuthority) {
        this.isHasAllAuthority = isHasAllAuthority;
    }

    public List<String> getAuthUuidList() {
        if (CollectionUtils.isEmpty(authUuidList)) {
            authUuidList = new ArrayList<>();
            AuthenticationInfoVo authInfo = UserContext.get().getAuthenticationInfoVo();
            authUuidList.add(authInfo.getUserUuid());
            if (CollectionUtils.isNotEmpty(authInfo.getTeamUuidList())) {
                authUuidList.addAll(authInfo.getTeamUuidList());
            }
            if (CollectionUtils.isNotEmpty(authInfo.getRoleUuidList())) {
                authUuidList.addAll(authInfo.getRoleUuidList());
            }
        }
        return authUuidList;
    }

    public void setAuthUuidList(List<String> authUuidList) {
        this.authUuidList = authUuidList;
    }

    public List<String> getAuthorityActionList() {
        return authorityActionList;
    }

    public void setAuthorityActionList(List<String> authorityActionList) {
        this.authorityActionList = authorityActionList;
    }
}
