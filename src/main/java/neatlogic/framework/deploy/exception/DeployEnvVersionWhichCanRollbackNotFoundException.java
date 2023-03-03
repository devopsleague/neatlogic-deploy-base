package neatlogic.framework.deploy.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author laiwt
 * @date 2022/6/14 9:55 上午
 */
public class DeployEnvVersionWhichCanRollbackNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 4737429531340859128L;

    public DeployEnvVersionWhichCanRollbackNotFoundException(String envName) {
        super("exception.deploy.deployenvversionwhichcanrollbacknotfoundexception", envName);
    }
}
