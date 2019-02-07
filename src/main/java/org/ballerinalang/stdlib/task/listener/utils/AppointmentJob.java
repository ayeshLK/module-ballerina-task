/*
 *  Copyright (c) 2019 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.ballerinalang.stdlib.task.listener.utils;

import org.ballerinalang.bre.Context;
import org.ballerinalang.connector.api.Service;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

import static org.ballerinalang.stdlib.task.listener.utils.TaskConstants.APPOINTMENT_PARENT_CONTEXT;
import static org.ballerinalang.stdlib.task.listener.utils.TaskConstants.APPOINTMENT_SERVICE_OBJECT;

/**
 * Represents a Quartz job related to an appointment.
 */
public class AppointmentJob implements Job {

    public AppointmentJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        Context context = (Context) jobDataMap.get(APPOINTMENT_PARENT_CONTEXT);
        Service service = (Service) jobDataMap.get(APPOINTMENT_SERVICE_OBJECT);

        TaskExecutor.execute(context, service);
    }
}
