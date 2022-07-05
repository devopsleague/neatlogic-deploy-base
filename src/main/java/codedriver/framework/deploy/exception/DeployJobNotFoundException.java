package codedriver.framework.deploy.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author laiwt
 * @date 2022/6/14 9:55 上午
 */
public class DeployJobNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -857892516459228779L;

    public DeployJobNotFoundException(String appSystemName, String appModuleName) {
        super(appSystemName + "下的" + appModuleName + "模块尚未执行过任何作业");
    }

}
