package neatlogic.framework.deploy.constvalue;

import neatlogic.framework.common.constvalue.ParamType;
import neatlogic.framework.notify.core.INotifyParam;
import neatlogic.framework.util.$;

/**
 * @author longrf
 * @date 2022/12/29 10:24
 */

public enum DeployJobNotifyParam implements INotifyParam {
    APPSYSTEMNAMEANDABBRNAME("appSystemNameAndAbbrName", "应用", ParamType.STRING),
    APPMODULENAMEANDABBRNAME("appModuleNameAndAbbrName", "模块", ParamType.STRING),
    ENVNAME("envName", "环境", ParamType.STRING),
    VERSION("version", "版本号", ParamType.STRING),
    SCENARIONAME("scenarioName", "场景", ParamType.STRING),
    JOBID("deployJobId", "作业ID", ParamType.NUMBER),
    JOBNAME("deployJobName", "作业名称", ParamType.STRING),
    JOBSTATUS("deployJobStatus", "作业状态", ParamType.STRING),
    JOBSTATUSNAME("deployJobStatusName", "作业状态名", ParamType.STRING),
    JOBPHASELIST("deployJobPhaseList", "阶段列表", ParamType.ARRAY),
    TRIGGERTYPENAME("deployTriggerTypeName", "触发方式", ParamType.STRING),
    DEPLOYJOBSTARTTIME("deployJobStartTime", "作业开始时间", ParamType.STRING),
    DEPLOYJOBENDTIME("deployJobEndTime", "作业结束时间", ParamType.STRING),
    ;
    private final String value;
    private final String text;
    private final ParamType paramType;

    DeployJobNotifyParam(String value, String text, ParamType paramType) {
        this.value = value;
        this.text = text;
        this.paramType = paramType;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getText() {
        return $.t(text);
    }

    @Override
    public ParamType getParamType() {
        return paramType;
    }
}
