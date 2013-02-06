/**
 *   Copyright (C) ${year} Wicket Continuous Calendar (http://Wicket-Continuous-Calendar.GoogleCode.com/)
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
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.googlecode.wicketcontinuouscalendar.options.ContinuousCalendarOptions;

/**
 * {@link Panel} holding on to a {@link SimpleCalendarPanel} which contains the two visible
 * {@link DateTextField} for the user selection date range and it shows the calendar icon to
 * the right of the form fields when used as a pop-up.
 * <p>
 * Use {@link SimpleCalendarPanel} if you would like labels instead of the two {@link DateTextField}.
 * <p>
 * To override the <code>From</code> and <code>To</code> labels, see the {@link SimpleCalendarPanel}'s
 * properties file.
 * 
 * @see ContinuousCalendarOptions Options for the calendar
 * @author Paul Bors (Paul@Bors.ws)
 */
public class TimeframeCalendarPanel extends SimpleCalendarPanel {
    private static final long serialVersionUID = 1L;
    
    /**
     * {@link Panel} holding on to a {@link SimpleCalendarPanel} which contains the two visible
     * {@link DateTextField} for the user selection date range and it shows the calendar icon to
     * the right of the form fields when used as a pop-up.
     * 
     * @param id                Wicket {@link Component} ID
     * @param optionsModel      {@link IModel} for the {@link ContinuousCalendarOptions}
     * @param startDateModel    {@link IModel} for the <code>From</code> {@link DateTextField}
     * @param endDateModel      {@link IModel} for the <code>To</code> {@link DateTextField}
     */
    public TimeframeCalendarPanel(String id, IModel<ContinuousCalendarOptions> optionsModel,
            IModel<Date> startDateModel, IModel<Date> endDateModel) {
        super(id, optionsModel, startDateModel, endDateModel);
    }
}
