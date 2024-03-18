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

package neatlogic.framework.deploy.exception.schedule;

import neatlogic.framework.exception.core.NotFoundEditTargetException;

/**
 * @author linbq
 * @since 2021/9/29 18:11
 **/
public class DeployScheduleNotFoundEditTargetException extends NotFoundEditTargetException {
    private static final long serialVersionUID = -977863275722446182L;

    public DeployScheduleNotFoundEditTargetException(Long id) {
        super("nfaes.autoexecschedulenotfoundedittargetexception.autoexecschedulenotfoundedittargetexception", id);
    }
}
