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
package com.googlecode.wicketcontinuouscalendar.wicket15;

import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * A registry for the JavaScript and CSS dependencies used by wicket-continuous-calendar.
 * By default, all JavaScript references will be loaded from the web. If you want
 * to package your own JavaScript files or change the URLs, you can do so by calling
 * the setter methods from the init() method of your Wicket application.
 * 
 * @author Paul Bors (Paul@Bors.ws)
 */
public class ResourceRegistry {
    
    public class RegistryEntry {
        private String url;
        private ResourceReference reference;

        public RegistryEntry(final ResourceReference reference) {
            this.url = null;
            this.reference = reference;
        }

        public RegistryEntry(final String url) {
            this.url = url;
            this.reference = null;
        }

        public void addToHeaderResponse(final IHeaderResponse response) {
            if(this.url != null) {
                if(url.toLowerCase().endsWith(".css")) {
                    response.renderCSSReference(this.url);
                } else if(url.toLowerCase().endsWith(".js")) {
                    response.renderJavaScriptReference(this.url);
                } else {
                    throw new IllegalStateException(
                        "Only CSS or JS types are accepted for the RegistryEntry types!"
                    );
                }
            } else if(this.reference != null) {
                if(reference.getExtension().toLowerCase().endsWith("css")) {
                    response.renderCSSReference(this.reference);
                } else if(reference.getExtension().toLowerCase().endsWith("js")) {
                    response.renderJavaScriptReference(this.reference);
                } else {
                    throw new IllegalStateException(
                        "Only CSS or JS types are accepted for the RegistryEntry types!"
                    );
                }
            }
        }
    }

    public static final String DEFAULT_JQUERY_URL = "https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js";
    public static final String DEFAULT_CONTINUOUS_CALENDAR_JQUERY_URL = "http://reaktor.github.com/jquery-continuous-calendar/build/jquery.continuousCalendar-latest.js";
    public static final String DEFAULT_CONTINUOUS_CALENDAR_CSS_URL = "http://reaktor.github.com/jquery-continuous-calendar/build/jquery.continuousCalendar-latest.css";
    public static final String DEFAULT_CONTINUOUS_CALENDAR_CSS_THEME_ROUND_URL = "http://reaktor.github.com/jquery-continuous-calendar/src/main/theme.rounded.css";

    public static ResourceRegistry getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResourceRegistry();
        }
        return INSTANCE;
    }

    private RegistryEntry jqueryEntry = new RegistryEntry(DEFAULT_JQUERY_URL);
    private RegistryEntry continuousCalendarEntry = new RegistryEntry(DEFAULT_CONTINUOUS_CALENDAR_JQUERY_URL);
    private RegistryEntry continuousCalendarCssEntry = new RegistryEntry(DEFAULT_CONTINUOUS_CALENDAR_CSS_URL);
    private RegistryEntry continuousCalendarCssThemeRoundEntry = new RegistryEntry(DEFAULT_CONTINUOUS_CALENDAR_CSS_THEME_ROUND_URL);

    private static ResourceRegistry INSTANCE;

    private ResourceRegistry() {

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
     * <p>
     * Set it to <code>null</code> not to include it (not advised!).
     */
    public void setContinuousCalendarReference(final PackageResourceReference reference) {
        this.continuousCalendarEntry = new RegistryEntry(reference);
    }
    /**
     * Sets the URL to use to load the jQuery-Continuous-Calendar
     * library (jquery.continuousCalendar-latest.js). Use this method if you want
     * to include the javascript file in your web application.
     * <p>
     * Set it to <code>null</code> not to include it (not advised!).
     */
    public void setContinuousCalendarReference(final String url) {
        this.continuousCalendarEntry = new RegistryEntry(url);
    }

    /**
     * Sets the {@link ResourceReference} to use to load the jQuery-Continuous-Calendar
     * CSS (jquery.continuousCalendar-latest.css). Use this method if you want
     * to include the javascript file in your web application.
     * <p>
     * Set it to <code>null</code> not to include it (not advised!).
     */
    public void setContinuousCalendarCssReference(final PackageResourceReference reference) {
        this.continuousCalendarCssEntry = new RegistryEntry(reference);
    }
    /**
     * Sets the URL to use to load the jQuery-Continuous-Calendar
     * CSS (jquery.continuousCalendar-latest.css). Use this method if you want
     * to include the javascript file in your web application.
     * <p>
     * Set it to <code>null</code> not to include it (not advised!).
     */
    public void setContinuousCalendarCssReference(final String url) {
        this.continuousCalendarCssEntry = new RegistryEntry(url);
    }

    /**
     * Sets the {@link ResourceReference} to use to load the jQuery-Continuous-Calendar
     * CSS round theme (theme.rounded.css). Use this method if you want to
     * include the javascript file in your web application.
     * <p>
     * Set it to <code>null</code> not to include it (if you don't use this theme).
     */
    public void setContinuousCalendarCssThemeRoundReference(final PackageResourceReference reference) {
        this.continuousCalendarCssThemeRoundEntry = new RegistryEntry(reference);
    }
    /**
     * Sets the URL to use to load the jQuery-Continuous-Calendar CSS round theme
     * (theme.rounded.css). Use this method if you want to load the javascript file
     * from an external URL.
     * <p>
     * Set it to <code>null</code> not to include it (if you don't use this theme).
     */
    public void setContinuousCalendarCssThemeRoundReference(final String url) {
        this.continuousCalendarCssThemeRoundEntry = new RegistryEntry(url);
    }

    /**
     * Sets the {@link ResourceReference} to use to load JQuery (jquery.js).Use
     * this method if you want to include the javascript file in your web
     * application.
     * <p>
     * Set it to <code>null</code> not to include it (if you manage your own jQuery library).
     */
    public void setJQueryReference(final PackageResourceReference reference) {
        this.jqueryEntry = new RegistryEntry(reference);
    }
    /**
     * Sets the URL to use to load JQuery (jquery.js). Use this method if you
     * want to load the javascript file from an external URL.
     * <p>
     * Set it to <code>null</code> not to include it (if you manage your own jQuery library).
     */
    public void setJQueryReference(final String url) {
        this.jqueryEntry = new RegistryEntry(url);
    }

}

