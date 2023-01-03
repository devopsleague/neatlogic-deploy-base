package codedriver.framework.deploy.dto.sql;

import codedriver.framework.autoexec.constvalue.JobNodeStatus;
import codedriver.framework.autoexec.dto.ISqlNodeDetail;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import codedriver.framework.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author longrf
 * @date 2022/4/27 11:29 上午
 */
public class DeploySqlNodeDetailVo extends BaseEditorVo implements ISqlNodeDetail {

    private static final long serialVersionUID = -3906325036032471623L;

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    private Long resourceId;
    @EntityField(name = "runner id", type = ApiParamType.LONG)
    private Long runnerId;
    @EntityField(name = "runner ip", type = ApiParamType.STRING)
    private String runnerHost;
    @EntityField(name = "runner 端口", type = ApiParamType.INTEGER)
    private Integer runnerPort;
    @EntityField(name = "runner url", type = ApiParamType.STRING)
    private String runnerUrl;
    @EntityField(name = "sysId", type = ApiParamType.LONG)
    private Long sysId;
    @EntityField(name = "moduleId", type = ApiParamType.LONG)
    private Long moduleId;
    @EntityField(name = "envId", type = ApiParamType.LONG)
    private Long envId;
    @EntityField(name = "version", type = ApiParamType.STRING)
    private String version;
    @EntityField(name = "sql文件名", type = ApiParamType.STRING)
    private String sqlFile;
    @EntityField(name = "作业节点名", type = ApiParamType.STRING)
    private String nodeName;
    @EntityField(name = "ip", type = ApiParamType.STRING)
    private String host;
    @EntityField(name = "端口", type = ApiParamType.INTEGER)
    private Integer port;
    @EntityField(name = "用户名", type = ApiParamType.STRING)
    private String username;
    @EntityField(name = "服务地址", type = ApiParamType.STRING)
    private String serviceAddr;
    @EntityField(name = "节点类型", type = ApiParamType.STRING)
    private String nodeType;
    @EntityField(name = "状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "状态名", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "完成率", type = ApiParamType.INTEGER)
    private Integer completionRate = 0;
    @EntityField(name = "md5", type = ApiParamType.STRING)
    private String md5;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "作业剧本名", type = ApiParamType.STRING)
    private String phaseName;
    @EntityField(name = "是否已经被删除", type = ApiParamType.INTEGER)
    private Integer isDelete = 0;
    @EntityField(name = "开始时间", type = ApiParamType.LONG)
    private Date startTime;
    @EntityField(name = "结束时间", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "耗时", type = ApiParamType.STRING)
    private String costTime;
    @EntityField(name = "sql排序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "是否改动", type = ApiParamType.INTEGER)
    private Integer isModified;
    @EntityField(name = "告警个数", type = ApiParamType.INTEGER)
    private Integer warnCount;

    @EntityField(name = "sql文件名列表", type = ApiParamType.JSONARRAY)
    private List<String> sqlFiles;


    public DeploySqlNodeDetailVo(JSONObject paramObj) {
        this.sysId = (paramObj.getLong("sysId"));
        this.moduleId = (paramObj.getLong("moduleId"));
        this.envId = (paramObj.getLong("envId"));
        this.version = (paramObj.getString("version"));
        if (StringUtils.isNotBlank(paramObj.getString("status"))) {
            this.status = (paramObj.getString("status"));
        }
        this.sqlFile = (paramObj.getString("sqlFile"));
        this.md5 = (paramObj.getString("md5"));
        this.host = (paramObj.getString("host"));
        this.port = (paramObj.getInteger("port"));
        this.nodeName = (paramObj.getString("nodeName"));
        this.resourceId = (paramObj.getLong("resourceId"));
        this.runnerId = (paramObj.getLong("runnerId"));
        if (paramObj.getInteger("isModified") != null) {
            this.isModified = (paramObj.getInteger("isModified"));

        }
        if (paramObj.getInteger("warnCount") != null) {
            this.warnCount = (paramObj.getInteger("warnCount"));

        }
    }

    public DeploySqlNodeDetailVo(Long sysId, Long envId, Long moduleId, String version, String sqlFile, Long jobId, String phaseName, Long resourceId) {
        this.sysId = sysId;
        this.moduleId = moduleId;
        this.envId = envId;
        this.version = version;
        this.sqlFile = sqlFile;
        this.jobId = jobId;
        this.phaseName = phaseName;
        this.resourceId = resourceId;
    }

    public DeploySqlNodeDetailVo(Long sysId, Long moduleId, Long envId, String version) {
        this.sysId = sysId;
        this.moduleId = moduleId;
        this.envId = envId;
        this.version = version;
    }

    public DeploySqlNodeDetailVo() {
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getRunnerHost() {
        return runnerHost;
    }

    public void setRunnerHost(String runnerHost) {
        this.runnerHost = runnerHost;
    }

    public Integer getRunnerPort() {
        return runnerPort;
    }

    public void setRunnerPort(Integer runnerPort) {
        this.runnerPort = runnerPort;
    }

    public String getRunnerUrl() {
        return runnerUrl;
    }

    public void setRunnerUrl(String runnerUrl) {
        this.runnerUrl = runnerUrl;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getEnvId() {
        return envId;
    }

    public void setEnvId(Long envId) {
        this.envId = envId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSqlFile() {
        return sqlFile;
    }

    public void setSqlFile(String sqlFile) {
        this.sqlFile = sqlFile;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getServiceAddr() {
        return serviceAddr;
    }

    public void setServiceAddr(String serviceAddr) {
        this.serviceAddr = serviceAddr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        if (StringUtils.isBlank(statusName) && StringUtils.isNotBlank(status)) {
            statusName = JobNodeStatus.getText(status);
        }
        return statusName;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCompletionRate() {
        if (StringUtils.isNotBlank(status) && Objects.equals(JobNodeStatus.SUCCEED.getValue(), status)) {
            return 100;
        }
        return completionRate;
    }

    public String getCostTime() {
        if (startTime != null) {
            if (endTime != null) {
                return TimeUtil.millisecondsTransferMaxTimeUnit(endTime.getTime() - startTime.getTime());
            } else {
                return TimeUtil.millisecondsTransferMaxTimeUnit(new Date().getTime() - startTime.getTime());
            }
        }
        return costTime;
    }

    public List<String> getSqlFiles() {
        return sqlFiles;
    }

    public void setSqlFiles(List<String> sqlFiles) {
        this.sqlFiles = sqlFiles;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsModified() {
        return isModified;
    }

    public void setIsModified(Integer isModified) {
        this.isModified = isModified;
    }

    public Integer getWarnCount() {
        return warnCount;
    }

    public void setWarnCount(Integer warnCount) {
        this.warnCount = warnCount;
    }
}
