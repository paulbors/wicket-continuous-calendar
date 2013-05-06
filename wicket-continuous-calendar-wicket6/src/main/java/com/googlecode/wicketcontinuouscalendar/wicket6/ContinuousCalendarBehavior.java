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

import java.text.MessageFormat;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;

import com.googlecode.wicketcontinuouscalendar.jackson.JsonRenderer;
import com.googlecode.wicketcontinuouscalendar.jackson.JsonRendererFactory;
import com.googlecode.wicketcontinuouscalendar.options.ContinuousCalendarOptions;

/**
 * This behavior takes in an {@link ContinuousCalendarOptions} object containing the configuration
 * of a continuous calendar and calls the proper javascript to display the chart in the
 * component to which this behavior is added.
 * 
 * @author Paul Bors (Paul@Bors.ws)
 * 
 */
public class ContinuousCalendarBehavior extends Behavior {
    private static final long serialVersionUID = 1L;
    
    private final ContinuousCalendar continuousCalendar;
    
    /**
     * Constructor.
     * 
     * @param continuousCalendar
     *          The {@link ContinuousCalendar} along with its {@link ContinuousCalendarOptions} model object that
     *          similar in structure to the jQuery-Continuous-Calendar API reference.
     * @see <a href="http://reaktor.github.com/jquery-continuous-calendar/index.html#api_documentation">jQuery-Continuous-Calendar API</a>
     */
    public ContinuousCalendarBehavior(ContinuousCalendar continuousCalendar) {
        this.continuousCalendar = continuousCalendar;
    }
    
    @Override
    public void renderHead(final Component component, final IHeaderResponse response) {
        component.setOutputMarkupId(true);
        JsonRenderer renderer = JsonRendererFactory.getInstance().getRenderer();
        includeJavascriptDependencies(response);
        includeCalendarJavascript(response, renderer, component.getMarkupId());
    }
    
    /**
     * Includes the JavaScript that calls the jQuery-Continuous-Calendar library to visualize the calendar.
     * 
     * @param response
     *          the Wicket HeaderResponse
     * @param options
     *          the options containing the settings for the calendar to display
     * @param renderer
     *          the JsonRenderer responsible for rendering the options
     * @param markupId
     *          the DOM ID of the chart component.
     */
    private void includeCalendarJavascript(final IHeaderResponse response, final JsonRenderer renderer, final String markupId) {
        ContinuousCalendarOptions options = continuousCalendar.getOptions();
        response.render(OnDomReadyHeaderItem.forScript(
            MessageFormat.format(
                "$({0}).continuousCalendar({1})", markupId, renderer.toJson(options)
            )
        ));
    }
    
    protected void includeJavascriptDependencies(final IHeaderResponse response) {
        ResourceRegistry.getInstance().getJQueryEntry().addToHeaderResponse(response);
        ResourceRegistry.getInstance().getContinuousCalendarEntry().addToHeaderResponse(response);
        ResourceRegistry.getInstance().getContinuousCalendarCssEntry().addToHeaderResponse(response);
        ResourceRegistry.getInstance().getContinuousCalendarCssThemeRoundEntry().addToHeaderResponse(response);
    }
}
