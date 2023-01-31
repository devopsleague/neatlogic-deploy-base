/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.deploy.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author linbq
 * @since 2021/9/29 18:11
 **/
public class DeployScheduleNotFoundException extends ApiRuntimeException {
    private static final long serialVersionUID = -977863275722446183L;

    public DeployScheduleNotFoundException(String uuid) {
        super("定时作业：'" + uuid + "'不存在");
    }

    public DeployScheduleNotFoundException(Long id) {
        super("定时作业：'" + id + "'不存在");
    }
}
