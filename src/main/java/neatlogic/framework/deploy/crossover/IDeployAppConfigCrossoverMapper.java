/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.deploy.crossover;

import neatlogic.framework.crossover.ICrossoverService;
import neatlogic.framework.deploy.dto.app.DeployAppConfigAuthorityVo;
import neatlogic.framework.deploy.dto.app.DeployAppSystemVo;

import java.util.List;

public interface IDeployAppConfigCrossoverMapper extends ICrossoverService {
    List<DeployAppConfigAuthorityVo> getAppConfigAuthorityListByAppSystemId(Long appSystemId);

    List<DeployAppSystemVo> getBatchAppConfigAuthorityListByAppSystemIdList(List<Long> appSystemIdList);
}
