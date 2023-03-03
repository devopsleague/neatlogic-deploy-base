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

package neatlogic.framework.deploy.chart;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@RootComponent
public class DeployVersionChartHandlerFactory extends ModuleInitializedListenerBase {

    private static final Map<String, IDeployVersionChartHandler> handlerMap = new HashMap<>();

    public static IDeployVersionChartHandler getHandler(String handler) {
        return handlerMap.get(handler);
    }

    @Override
    public void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, IDeployVersionChartHandler> map = context.getBeansOfType(IDeployVersionChartHandler.class);
        for (Entry<String, IDeployVersionChartHandler> entry : map.entrySet()) {
            handlerMap.put(entry.getValue().getName(), entry.getValue());
        }
    }

    @Override
    protected void myInit() {

    }

}
