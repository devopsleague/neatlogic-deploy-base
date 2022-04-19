package codedriver.framework.deploy.dto.scenario;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

/**
 * @author longrf
 * @date 2022/4/15 12:06 下午
 */
public class DeployScenarioVo extends BaseEditorVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "被应用引用个数", type = ApiParamType.INTEGER)
    private Integer ciEntityReferredCount;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCiEntityReferredCount() {
        return ciEntityReferredCount;
    }

    public void setCiEntityReferredCount(Integer ciEntityReferredCount) {
        this.ciEntityReferredCount = ciEntityReferredCount;
    }
}
