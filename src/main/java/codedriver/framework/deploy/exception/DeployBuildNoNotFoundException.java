package codedriver.framework.deploy.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author lvzk
 * @date 2022/7/29 9:55 上午
 */
public class DeployBuildNoNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 4672351140551885969L;

    public DeployBuildNoNotFoundException(String appSystemName, String appModuleName, String version) {
        super(String.format("%s/%s/%s buildNo 不存在", appSystemName, appModuleName, version));
    }

}
