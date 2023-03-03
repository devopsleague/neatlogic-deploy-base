package neatlogic.framework.deploy.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author lvzk
 * @date 2022/7/27 9:55 上午
 */
public class DeployVersionRedirectUrlCredentialUserNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 8963497592790439405L;

    public DeployVersionRedirectUrlCredentialUserNotFoundException(String userUuid) {
        super("exception.deploy.deployversionredirecturlcredentialusernotfoundexception", userUuid);
    }

}
