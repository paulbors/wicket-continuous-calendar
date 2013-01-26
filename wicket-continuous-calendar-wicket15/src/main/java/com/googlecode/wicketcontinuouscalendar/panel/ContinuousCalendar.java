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
package com.googlecode.wicketcontinuouscalendar.panel;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import com.googlecode.wicketcontinuouscalendar.ContinuousCalendarBehavior;
import com.googlecode.wicketcontinuouscalendar.options.ContinuousCalendarOptions;

public class ContinuousCalendar extends WebMarkupContainer {
    private static final long serialVersionUID = 1L;
    
    public ContinuousCalendar(String id, IModel<ContinuousCalendarOptions> model) {
        super(id, model);
        add(new ContinuousCalendarBehavior(this));
    }
    
    public ContinuousCalendarOptions getOptions() {
        return (ContinuousCalendarOptions)getDefaultModel().getObject();
    }   
}
