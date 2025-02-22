package neatlogic.framework.deploy.auth;

import neatlogic.framework.auth.core.AuthBase;
import neatlogic.framework.autoexec.auth.AUTOEXEC;
import neatlogic.framework.cmdb.auth.label.CMDB;

import java.util.Arrays;
import java.util.List;

/**
 * @author longrf
 * @date 2022/3/23 10:52 上午
 */
public class DEPLOY_BASE extends AuthBase {
    @Override
    public String getAuthDisplayName() {
        return "发布基础权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "查看发布模块";
    }

    @Override
    public String getAuthGroup() {
        return "deploy";
    }

    @Override
    public Integer getSort() {
        return 1;
    }

    @Override
    public List<Class<? extends AuthBase>> getIncludeAuths() {
        return Arrays.asList(CMDB.class, DEPLOY.class, AUTOEXEC.class);
    }
}
