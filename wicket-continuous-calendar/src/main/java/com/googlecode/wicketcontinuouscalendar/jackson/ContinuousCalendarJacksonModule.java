/**
 *   Copyright (C) 2013 Wicket Continuous Calendar (http://Wicket-Continuous-Calendar.GoogleCode.com/)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.googlecode.wicketcontinuouscalendar.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
* @author Paul Bors (Paul@Bors.ws)
* 
*/
public class ContinuousCalendarJacksonModule extends SimpleModule {
    public ContinuousCalendarJacksonModule() {
        super("wicked-charts", new Version(
            1, 0, 0, null, "com.googlecode.wicket-continuous-calendar", "wicket-continuous-calendar")
        );
    }
}