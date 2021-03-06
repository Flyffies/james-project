/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/
package org.apache.james.modules.mailbox;

import org.apache.commons.configuration.HierarchicalConfiguration;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

public class ListenerConfiguration {

    public static ListenerConfiguration from(HierarchicalConfiguration configuration) {
        String listenerClass = configuration.getString("class");
        Preconditions.checkState(!Strings.isNullOrEmpty(listenerClass), "class name is mandatory");
        return new ListenerConfiguration(listenerClass);
    }

    private final String clazz;

    @VisibleForTesting ListenerConfiguration(String clazz) {
        this.clazz = clazz;
    }

    public String getClazz() {
        return clazz;
    }
}