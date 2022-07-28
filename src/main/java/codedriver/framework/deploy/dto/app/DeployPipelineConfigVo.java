/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.deploy.dto.app;

import codedriver.framework.autoexec.dto.AutoexecParamVo;
import codedriver.framework.autoexec.dto.combop.*;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeployPipelineConfigVo implements Serializable {
    @EntityField(name = "阶段列表", type = ApiParamType.JSONARRAY)
    private List<DeployPipelinePhaseVo> combopPhaseList;

    @EntityField(name = "阶段组列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopGroupVo> combopGroupList;

    @EntityField(name = "执行信息配置", type = ApiParamType.JSONOBJECT)
    private DeployPipelineExecuteConfigVo executeConfigVo;

    @EntityField(name = "场景列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopScenarioVo> scenarioList;

    @EntityField(name = "默认场景id", type = ApiParamType.LONG)
    private Long defaultScenarioId;

    @EntityField(name = "运行时参数列表", type = ApiParamType.INTEGER)
    private List<AutoexecParamVo> runtimeParamList;

    @EntityField(name = "重载预置参数集列表", type = ApiParamType.JSONARRAY)
    private List<DeployProfileVo> overrideProfileList;

    @JSONField(serialize = false)
    private AutoexecCombopConfigVo autoexecCombopConfigVo;

    public List<DeployPipelinePhaseVo> getCombopPhaseList() {
        return combopPhaseList;
    }

    public void setCombopPhaseList(List<DeployPipelinePhaseVo> combopPhaseList) {
        this.combopPhaseList = combopPhaseList;
    }

    public List<AutoexecCombopGroupVo> getCombopGroupList() {
        return combopGroupList;
    }

    public void setCombopGroupList(List<AutoexecCombopGroupVo> combopGroupList) {
        this.combopGroupList = combopGroupList;
    }

    public DeployPipelineExecuteConfigVo getExecuteConfigVo() {
        if (executeConfigVo == null) {
            executeConfigVo = new DeployPipelineExecuteConfigVo();
        }
        return executeConfigVo;
    }

    public void setExecuteConfigVo(DeployPipelineExecuteConfigVo executeConfigVo) {
        this.executeConfigVo = executeConfigVo;
    }

    public List<AutoexecCombopScenarioVo> getScenarioList() {
        return scenarioList;
    }

    public void setScenarioList(List<AutoexecCombopScenarioVo> scenarioList) {
        this.scenarioList = scenarioList;
    }

    public Long getDefaultScenarioId() {
        return defaultScenarioId;
    }

    public void setDefaultScenarioId(Long defaultScenarioId) {
        this.defaultScenarioId = defaultScenarioId;
    }

    public List<AutoexecParamVo> getRuntimeParamList() {
        return runtimeParamList;
    }

    public void setRuntimeParamList(List<AutoexecParamVo> runtimeParamList) {
        this.runtimeParamList = runtimeParamList;
    }

    public List<DeployProfileVo> getOverrideProfileList() {
        if (overrideProfileList == null) {
            overrideProfileList = new ArrayList<>();
        }
        return overrideProfileList;
    }

    public void setOverrideProfileList(List<DeployProfileVo> overrideProfileList) {
        this.overrideProfileList = overrideProfileList;
    }

    public AutoexecCombopConfigVo getAutoexecCombopConfigVo() {
        autoexecCombopConfigVo = new AutoexecCombopConfigVo();
        autoexecCombopConfigVo.setCombopGroupList(this.combopGroupList);
        autoexecCombopConfigVo.setRuntimeParamList(this.runtimeParamList);
        autoexecCombopConfigVo.setScenarioList(this.scenarioList);
        if (CollectionUtils.isNotEmpty(this.combopPhaseList)) {
            List<AutoexecCombopPhaseVo> autoexecCombopPhaseList = new ArrayList<>();
            for (DeployPipelinePhaseVo deployPipelinePhaseVo : combopPhaseList) {
                autoexecCombopPhaseList.add(deployPipelinePhaseVo);
            }
            autoexecCombopConfigVo.setCombopPhaseList(autoexecCombopPhaseList);
        }
        return autoexecCombopConfigVo;
    }
}
