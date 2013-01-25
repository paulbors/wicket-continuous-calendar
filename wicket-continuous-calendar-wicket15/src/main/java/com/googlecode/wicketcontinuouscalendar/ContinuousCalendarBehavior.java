/**
 *   Copyright 2012 Wicket Continuous Calendar (http://Wicket-Continuous-Calendar.GoogleCode.com/)
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

package com.googlecode.wicketcontinuouscalendar;

import java.text.MessageFormat;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.IHeaderResponse;

import com.googlecode.wicketcontinuouscalendar.jackson.JsonRenderer;
import com.googlecode.wicketcontinuouscalendar.options.Options;
import com.googlecode.wicketcontinuouscalendar.panel.ContinuousCalendar;
import com.googlecode.wicketcontinuouscalendar.wicket15.JavaScriptResourceRegistry;
import com.googlecode.wicketcontinuouscalendar.wicket15.Wicket15JsonRendererFactory;

/**
 * This behavior takes in an {@link Options} object containing the configuration
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
	 * @param options
	 *          the options for the calendar. The {@link Options} class is very
	 *          similar in structure to the jQuery-Continuous-Calendar API reference.
	 * @see <a href="http://reaktor.github.com/jquery-continuous-calendar/index.html#api_documentation">jQuery-Continuous-Calendar API</a>
	 */
	public ContinuousCalendarBehavior(ContinuousCalendar continuousCalendar) {
		this.continuousCalendar = continuousCalendar;
	}
	
	@Override
	public void renderHead(final Component component, final IHeaderResponse response) {
		component.setOutputMarkupId(true);
		Options options = this.continuousCalendar.getOptions();
		final String id = component.getMarkupId();
		JsonRenderer renderer = Wicket15JsonRendererFactory.getInstance().getRenderer();
		includeJavascriptDependencies(response, options);
		includeCalendarJavascript(response, options, renderer, id);
	}
	
	/**
     * Includes the javascript that calls the jQuery-Continuous-Calendar library to visualize the calendar.
     * 
     * @param response
     *          the Wicket HeaderResponse
     * @param options
     *          the options containing the settings for the calenar to display
     * @param renderer
     *          the JsonRenderer responsible for rendering the options
     * @param markupId
     *          the DOM ID of the chart component.
     */
    protected void includeCalendarJavascript(final IHeaderResponse response,
        final Options options, final JsonRenderer renderer, final String markupId) {
        String calendarVarname = markupId;
        response.renderOnDomReadyJavaScript(
            MessageFormat.format(
                "$({0}).continuousCalendar({1});", calendarVarname, renderer.toJson(options)
            )
        );
    }
    
    private void includeJavascriptDependencies(final IHeaderResponse response, final Options options) {
        JavaScriptResourceRegistry.getInstance().getJQueryEntry().addToHeaderResponse(response);
        JavaScriptResourceRegistry.getInstance().getContinuousCalendarEntry().addToHeaderResponse(response);
        JavaScriptResourceRegistry.getInstance().getContinuousCalendarCssEntry().addToHeaderResponse(response);
        JavaScriptResourceRegistry.getInstance().getContinuousCalendarCssThemeRoundEntry().addToHeaderResponse(response);
    }
}
