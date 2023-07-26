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

package neatlogic.framework.deploy.exception.pipeline;

import neatlogic.framework.exception.core.NotFoundEditTargetException;

public class DeployPipelineNotFoundEditTargetException extends NotFoundEditTargetException {

    private static final long serialVersionUID = 3138988475130730712L;

    public DeployPipelineNotFoundEditTargetException(Long id) {
        super("nfdep.deploypipelinenotfoundedittargetexception.deploypipelinenotfoundedittargetexception", id);
    }

}
