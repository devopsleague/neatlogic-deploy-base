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
package neatlogic.framework.deploy.constvalue;

import neatlogic.framework.autoexec.constvalue.JobStatus;
import neatlogic.framework.notify.core.INotifyTriggerType;
import neatlogic.framework.util.$;

import java.util.Arrays;
import java.util.List;

/**
 * @author longrf
 * @date 2022/12/29 11:36
 */

public enum DeployJobNotifyTriggerType implements INotifyTriggerType {

    JOB_FAILED("jobfailed", "nfac.autoexecjobnotifytriggertype.text.jobfailed", "nfac.autoexecjobnotifytriggertype.description.jobfailed",
            Arrays.asList(JobStatus.FAILED.getValue())),

    JOB_COMPLETED("jobcompleted", "nfac.autoexecjobnotifytriggertype.text.jobcompleted", "nfac.autoexecjobnotifytriggertype.description.jobcompleted",
            Arrays.asList(JobStatus.COMPLETED.getValue())),

    JOB_WAIT_INPUT("jobwaitinput", "nfac.autoexecjobnotifytriggertype.text.jobwaitinput", "nfac.autoexecjobnotifytriggertype.description.jobwaitinput",
            Arrays.asList(JobStatus.WAIT_INPUT.getValue())),
    ;

    private final String trigger;
    private final String text;
    private final String description;
    private final List<String> jobStatusList;

    DeployJobNotifyTriggerType(String _trigger, String _text, String _description, List<String> _jobStatusList) {
        this.trigger = _trigger;
        this.text = _text;
        this.description = _description;
        this.jobStatusList = _jobStatusList;
    }

    @Override
    public String getTrigger() {
        return trigger;
    }

    @Override
    public String getText() {
        return $.t(text);
    }

    @Override
    public String getDescription() {
        return $.t(description);
    }

    public static String getText(String trigger) {
        for (DeployJobNotifyTriggerType n : values()) {
            if (n.getTrigger().equals(trigger)) {
                return n.getText();
            }
        }
        return "";
    }

    public static DeployJobNotifyTriggerType getTrigger(String trigger) {
        for (DeployJobNotifyTriggerType n : values()) {
            if (n.getTrigger().equals(trigger)) {
                return n;
            }
        }
        return null;
    }

    public static DeployJobNotifyTriggerType getTriggerByStatus(String status) {
        for (DeployJobNotifyTriggerType n : values()) {
            if (n.jobStatusList.contains(status)) {
                return n;
            }
        }
        return null;
    }
}
