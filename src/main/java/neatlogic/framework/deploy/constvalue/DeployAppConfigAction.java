package neatlogic.framework.deploy.constvalue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.utils.CollectionUtils;
import neatlogic.framework.util.$;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvzk
 * @date 2022/05/24 4:16 下午
 */
public enum DeployAppConfigAction {
    VIEW("view", "查看配置"),
    EDIT("edit", "编辑配置"),
    EXECUTE("execute", "执行"),
    VERSION_AND_PRODUCT_MANAGER("versionAndProductManager", "版本&制品管理"),
    PIPELINE("pipeline", "超级流水线权限"),
    ;

    private final String value;
    private final String text;

    DeployAppConfigAction(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static List<JSONObject> getValueTextList() {
        List<JSONObject> returnList = new ArrayList<>();
        for (DeployAppConfigAction action : DeployAppConfigAction.values()) {
            returnList.add(new JSONObject() {
                private static final long serialVersionUID = 1670544546905960015L;

                {
                    this.put("value", action.getValue());
                    this.put("text", action.getText());
                }
            });
        }
        return returnList;
    }

    /**
     * 只获取需要的actionValueText
     *
     * @param authActionArray 需要的action入参
     */
    public static List<JSONObject> getValueTextList(JSONArray authActionArray) {
        List<JSONObject> returnList = new ArrayList<>();
        for (DeployAppConfigAction action : DeployAppConfigAction.values()) {
            if (CollectionUtils.isEmpty(authActionArray) || authActionArray.contains(action.getValue())) {
                returnList.add(new JSONObject() {
                    private static final long serialVersionUID = 1670544546905960015L;
                    {
                        this.put("value", action.getValue());
                        this.put("text", action.getText());
                    }
                });
            }
        }
        return returnList;
    }

    public static List<String> getValueList() {
        List<String> returnList = new ArrayList<>();
        for (DeployAppConfigAction action : DeployAppConfigAction.values()) {
            returnList.add(action.getValue());
        }
        return returnList;
    }
}
