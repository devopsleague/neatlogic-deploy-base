/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package neatlogic.framework.deploy.dto.app;

import neatlogic.framework.autoexec.constvalue.ParamType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.util.RC4Util;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class DeployAppEnvAutoConfigKeyValueVo {
    @EntityField(name = "common.key", type = ApiParamType.LONG)
    private String key;

    @EntityField(name = "common.type", type = ApiParamType.LONG)
    private String type;
    @EntityField(name = "common.value", type = ApiParamType.LONG)
    private String value;

    public DeployAppEnvAutoConfigKeyValueVo() {
    }

    public DeployAppEnvAutoConfigKeyValueVo(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        if(StringUtils.isNotBlank(getType())&& Objects.equals(getType(),ParamType.PASSWORD.getValue())){
            return RC4Util.encrypt(value);
        }
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeText() {
        if (StringUtils.isNotBlank(this.type)) {
            ParamType paramType = ParamType.getParamType(type);
            if (paramType != null) {
                return paramType.getText();
            }
        }
        return StringUtils.EMPTY;
    }

}
