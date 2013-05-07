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
package com.googlecode.wicketcontinuouscalendar.wicket6;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import com.googlecode.wicketcontinuouscalendar.options.ContinuousCalendarOptions;
import com.googlecode.wicketcontinuouscalendar.wicket6.panel.SimpleCalendarPanel;

/**
 * {@link WebMarkupContainer} as a place holder for the <i>jQuery-Continuous-Calendar</i> which must be a <strong>DIV</strong>.
 * <p>
 * Use {@link SimpleCalendarPanel} if you'd like a {@link Panel} instead.
 * 
 * @see ContinuousCalendarOptions Options for the calendar
 * @author Paul Bors (Paul@Bors.ws)
 */
public class ContinuousCalendar extends WebMarkupContainer {
    private static final long serialVersionUID = 1L;
    
    public ContinuousCalendar(String id, IModel<ContinuousCalendarOptions> model) {
        super(id, model);
        add(new ContinuousCalendarBehavior(this));
    }
    
    public ContinuousCalendarOptions getOptions() {
        return (ContinuousCalendarOptions)getDefaultModel().getObject();
    }
    
    /**
     * Handles this calendar's tag. OVERRIDES MUST CALL SUPER.
     * 
     * @param tag
     *            the component tag
     * @see org.apache.wicket.Component#onComponentTag(ComponentTag)
     */
    @Override
    protected void onComponentTag(final ComponentTag tag) {
        // Default handling for tag
        super.onComponentTag(tag);
        
        // Force the tag to be a DIV
        if( !tag.getName().equalsIgnoreCase("div") )  {
            throw new WicketRuntimeException("a jQuery-Continuous-Calendar component was set on " + tag.getName() +
                " but it has to be attached to a DIV tag");
        }
    }
}
