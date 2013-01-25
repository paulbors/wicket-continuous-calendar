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

package com.googlecode.wicketcontinuouscalendar.wicket15;

import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * A registry for the JavaScript dependencies used by wicket-continuous-calendar.
 * By default, all JavaScript references will be loaded from the web. If you want
 * to package your own JavaScript files or change the URLs, you can do so by calling
 * the setter methods from the init() method of your Wicket application.
 * 
 * @author Paul Bors (Paul@Bors.ws)
 */
public class JavaScriptResourceRegistry {

    public class RegistryEntry {
        private String url;
        private ResourceReference reference;

        public RegistryEntry(final ResourceReference reference) {
            this.reference = reference;
        }

        public RegistryEntry(final String url) {
            this.url = url;
        }

        public void addToHeaderResponse(final IHeaderResponse response) {
            if (this.url != null) {
                response.renderJavaScriptReference(this.url);
            } else if (this.reference != null) {
                response.renderJavaScriptReference(this.reference);
            } else {
                throw new IllegalStateException(
                    "A RegistryEntry must have at least a non-null url or a non-null reference!"
                );
            }
        }
    }

    public static final String DEFAULT_JQUERY_URL = "https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js";
    public static final String DEFAULT_CONTINUOUS_CALENDAR_JQUERY_URL = "http://reaktor.github.com/jquery-continuous-calendar/build/jquery.continuousCalendar-latest.js";
    public static final String DEFAULT_CONTINUOUS_CALENDAR_CSS_URL = "http://reaktor.github.com/jquery-continuous-calendar/build/jquery.continuousCalendar-latest.css";
    public static final String DEFAULT_CONTINUOUS_CALENDAR_CSS_THEME_ROUND_URL = "http://reaktor.github.com/jquery-continuous-calendar/src/main/theme.rounded.css";

    public static JavaScriptResourceRegistry getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JavaScriptResourceRegistry();
        }
        return INSTANCE;
    }

    private RegistryEntry jqueryEntry = new RegistryEntry(DEFAULT_JQUERY_URL);
    private RegistryEntry continuousCalendarEntry = new RegistryEntry(DEFAULT_CONTINUOUS_CALENDAR_JQUERY_URL);
    private RegistryEntry continuousCalendarCssEntry = new RegistryEntry(DEFAULT_CONTINUOUS_CALENDAR_CSS_URL);
    private RegistryEntry continuousCalendarCssThemeRoundEntry = new RegistryEntry(DEFAULT_CONTINUOUS_CALENDAR_CSS_THEME_ROUND_URL);

    private static JavaScriptResourceRegistry INSTANCE;

    private JavaScriptResourceRegistry() {

    }

    public RegistryEntry getContinuousCalendarEntry() {
        return this.continuousCalendarEntry;
    }

    public RegistryEntry getContinuousCalendarCssEntry() {
        return this.continuousCalendarCssEntry;
    }

    public RegistryEntry getContinuousCalendarCssThemeRoundEntry() {
        return this.continuousCalendarCssThemeRoundEntry;
    }

    public RegistryEntry getJQueryEntry() {
        return this.jqueryEntry;
    }

    /**
     * Sets the {@link ResourceReference} to use to load the jQuery-Continuous-Calendar
     * library (jquery.continuousCalendar-latest.js). Use this method if you want
     * to include the javascript file in your web application.
     */
    public void setContinuousCalendarReference(final ResourceReference reference) {
        this.continuousCalendarEntry = new RegistryEntry(reference);
    }
    /**
     * Sets the URL to use to load the jQuery-Continuous-Calendar
     * library (jquery.continuousCalendar-latest.js). Use this method if you want
     * to include the javascript file in your web application.
     */
    public void setContinuousCalendarReference(final String url) {
        this.continuousCalendarEntry = new RegistryEntry(url);
    }

    /**
     * Sets the {@link ResourceReference} to use to load the jQuery-Continuous-Calendar
     * CSS (jquery.continuousCalendar-latest.css). Use this method if you want
     * to include the javascript file in your web application.
     */
    public void setContinuousCalendarCssReference(final ResourceReference reference) {
        this.continuousCalendarCssEntry = new RegistryEntry(reference);
    }
    /**
     * Sets the URL to use to load the jQuery-Continuous-Calendar
     * CSS (jquery.continuousCalendar-latest.css). Use this method if you want
     * to include the javascript file in your web application.
     */
    public void setContinuousCalendarCssReference(final String url) {
        this.continuousCalendarCssEntry = new RegistryEntry(url);
    }

    /**
     * Sets the {@link ResourceReference} to use to load the jQuery-Continuous-Calendar
     * CSS round theme (theme.rounded.css). Use this method if you want to
     * include the javascript file in your web application.
     */
    public void setContinuousCalendarCssThemeRoundReference(final ResourceReference reference) {
        this.continuousCalendarCssThemeRoundEntry = new RegistryEntry(reference);
    }
    /**
     * Sets the URL to use to load the jQuery-Continuous-Calendar CSS round theme
     * (theme.rounded.css). Use this method if you want to load the javascript file
     * from an external URL.
     */
    public void setContinuousCalendarCssThemeRoundReference(final String url) {
        this.continuousCalendarCssThemeRoundEntry = new RegistryEntry(url);
    }

    /**
     * Sets the {@link ResourceReference} to use to load JQuery (jquery.js).Use
     * this method if you want to include the javascript file in your web
     * application.
     */
    public void setJQueryReference(final ResourceReference reference) {
        this.jqueryEntry = new RegistryEntry(reference);
    }
    /**
     * Sets the URL to use to load JQuery (jquery.js). Use this method if you
     * want to load the javascript file from an external URL.
     */
    public void setJQueryReference(final String url) {
        this.jqueryEntry = new RegistryEntry(url);
    }

}

