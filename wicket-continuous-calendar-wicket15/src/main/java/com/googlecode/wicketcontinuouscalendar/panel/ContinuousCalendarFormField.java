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

import java.util.Date;

import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.time.TimeFrame;

import com.googlecode.wicketcontinuouscalendar.options.ContinuousCalendarOptions;

public class ContinuousCalendarFormField extends FormComponentPanel<TimeFrame> {
    private static final long serialVersionUID = 1L;
    
    public ContinuousCalendarFormField(String id, IModel<ContinuousCalendarOptions> model) {
        super(id);
        
        ContinuousCalendar continuousCalendar = new ContinuousCalendar("continuousCalendar", model);
        add(continuousCalendar);
        
        DateTextField startDateTextField = DateTextField.forDatePattern(
            "startDate", 
// TODO Get it from Options - new Model<Date>(model.getObject().getFirstDate()),
            new Model<Date>(),
            "MM/dd/yyyy"
        );
        continuousCalendar.add(startDateTextField);
        
        DateTextField endDateTextField = DateTextField.forDatePattern(
                "endDate", 
// TODO Get it from Options - new Model<Date>(model.getObject().lastDate()),
                new Model<Date>(),
                "MM/dd/yyyy"
            );
        continuousCalendar.add(endDateTextField);
    }
}
