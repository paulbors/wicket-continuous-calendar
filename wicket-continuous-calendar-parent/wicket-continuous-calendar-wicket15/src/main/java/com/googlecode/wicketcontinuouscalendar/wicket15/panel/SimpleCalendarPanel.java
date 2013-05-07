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
package com.googlecode.wicketcontinuouscalendar.wicket15.panel;

import java.util.Date;

import org.apache.wicket.datetime.DateConverter;
import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.googlecode.wicketcontinuouscalendar.options.ContinuousCalendarOptions;
import com.googlecode.wicketcontinuouscalendar.wicket15.ContinuousCalendar;

/**
 * {@link Panel} holding on to the {@link ContinuousCalendar} as well as the two {@link DateTextField}
 * for the user selection date range. By default those are hidden and a date range label in shown.
 * <p>
 * Use a {@link TimeframeCalendarPanel} or the following CSS to hide the labels and show the two {@link DateTextField}s:<br>
 * <code>
 * &#x002F;* Hide the date range labels. *&#x002F;<br>
 * .continuousCalendarContainer div.label span.clickable {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;display: none; visibility: hidden;<br>
 * }<br>
 * &#x002F;* Show the <b>From</b> and <b>To</b> date range text fields. See the <i>*.properties.xml</i> for localization keys. *&#x002F;<br>
 * .continuousCalendarContainer input.endDate, .continuousCalendarContainer input.startDate {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;display: inline;<br>
 * }
 * </code>
 * 
 * @see ContinuousCalendarOptions Options for the calendar
 * @author Paul Bors (Paul@Bors.ws)
 */
public class SimpleCalendarPanel extends Panel {
    private static final long serialVersionUID = 1L;
    
    private DateTextField startDateTextField;
    private DateTextField endDateTextField;
    
    /**
     * {@link Panel} holding on to the {@link ContinuousCalendar} as well as the two {@link DateTextField}
     * for the user selection date range. By default those are hidden and a date range label in shown.
     * 
     * @param id                Wicket {@link Component} ID
     * @param optionsModel      {@link IModel} for the {@link ContinuousCalendarOptions}
     * @param startDateModel    {@link IModel} for the <code>From</code> hidden {@link DateTextField} and visible label
     * @param endDateModel      {@link IModel} for the <code>To</code> hidden {@link DateTextField} and visible label
     */
    public SimpleCalendarPanel(String id, IModel<ContinuousCalendarOptions> optionsModel,
            IModel<Date> startDateModel, IModel<Date> endDateModel) {
        super(id);
        ContinuousCalendar continuousCalendar = new ContinuousCalendar("continuousCalendar", optionsModel);
        add(continuousCalendar);
        
        startDateTextField = DateTextField.withConverter(
            "startDate", startDateModel, getDateConverter()
        );
        continuousCalendar.add(startDateTextField);
        
        endDateTextField = DateTextField.withConverter(
            "endDate", endDateModel, getDateConverter()
        );
        continuousCalendar.add(endDateTextField);
    }
    
    /**
     * {@link DateTextField} used by the continuous calendar. Use this reference if you need to add additional behaviors.
     * 
     * @return {@link DateTextField} used for the start date range of the user, the <b>From</b> field.
     */
    public DateTextField getStartDateTextField() {
        return startDateTextField;
    }
    
    /**
     * {@link DateTextField} used by the continuous calendar. Use this reference if you need to add additional behaviors.
     * 
     * @return {@link DateTextField} used for the end date range of the user, the <b>To</b> field.
     */
    public DateTextField getEndDateTextField() {
        return endDateTextField;
    }
    
    /**
     * The {@link DateConverter} to use with the two {@link DateTextField}.<br>
     * By default this returns a "MM/dd/yyyy" {@link PatternDateConverter}
     * applying the time zone difference.
     * <p>
     * <b>NOTE:</b> At the present jQuery-continuous-calendar only support short date formats.
     * If changed, do preserve 4 digits for the year or set an offset.
     * 
     * @return {@link DateConverter} to use.
     */
    protected DateConverter getDateConverter() {
        return new PatternDateConverter("MM/dd/yyyy", true);
    }
}
