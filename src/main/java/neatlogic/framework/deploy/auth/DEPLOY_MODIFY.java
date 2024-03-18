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

package neatlogic.framework.deploy.auth;

import neatlogic.framework.auth.core.AuthBase;

import java.util.Arrays;
import java.util.List;

/**
 * @author longrf
 * @date 2022/4/15 5:09 下午
 */
public class DEPLOY_MODIFY extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "nfda.deploy_modify.getauthdisplayname";
    }

    @Override
    public String getAuthIntroduction() {
        return "nfda.deploy_modify.getauthintroduction";
    }

    @Override
    public String getAuthGroup() {
        return "deploy";
    }

    @Override
    public Integer getSort() {
        return 4;
    }

    @Override
    public List<Class<? extends AuthBase>> getIncludeAuths() {
        return Arrays.asList(BATCHDEPLOY_VERIFY.class, APP_CONFIG_MODIFY.class);
    }
}
