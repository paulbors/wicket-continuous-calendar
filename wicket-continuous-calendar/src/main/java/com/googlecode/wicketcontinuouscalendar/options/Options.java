/**
 *   Copyright 2012-2013 Wicket Continuous Calendar (http://Wicket-Continuous-Calendar.GoogleCode.com/)
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

package com.googlecode.wicketcontinuouscalendar.options;

import java.io.Serializable;

/**
 * This is the main class for configuring a chart. The structure of this class
 * is designed to be very close to the jQuery-Continuous-Calendar options object. For
 * explanations of all options, please consult the jQuery-Continuous-Calendar API reference.
 * <p/>
 * The options object will be serialized to a JSON object which is passed into
 * the Calendar Javascript library. Options that are not set (i.e. that are
 * null), are not serialized into JSON, so that the default values of the
 * jQuery-Continuous-Calendar library will be used.
 * 
 * @see <a href="http://reaktor.github.com/jquery-continuous-calendar/index.html#api_documentation">jQuery-Continuous-Calendar API</a>
 * @see <a href="http://reaktor.github.com/jquery-continuous-calendar/site/playground.html">jQuery-Continuous-Calendar Playground</a>
 * @author Paul Bors (Paul@Bors.ws)
 */
public class Options implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer weeksBefore;
    private Integer weeksAfter;
    private String  firstDate;
    private String  lastDate;
    private String  startField;
    private String  endField;
    private Boolean isPopup;
    private Boolean selectToday;
    //private Locale  locale;
    private Boolean disableWeekends;
    private String  disabledDates;
    private Integer minimumRange;
    private Boolean selectWeek;
    private Integer fadeOutDuration;
    private String  callback;
    private String  theme;
    
    /** Specifies amount of weeks displayed before selection. If no default selection then count from current day. */
    public Integer getWeeksBefore() {
        return weeksBefore;
    }
    /** Specifies amount of weeks displayed before selection. If no default selection then count from current day. */
    public void setWeeksBefore(Integer weeksBefore) {
        this.weeksBefore = weeksBefore;
    }
    
    /** Specifies amount of weeks displayed after selection. If no default selection then count from current day. */
    public Integer getWeeksAfter() {
        return weeksAfter;
    }
    /** Specifies amount of weeks displayed after selection. If no default selection then count from current day. */
    public void setWeeksAfter(Integer weeksAfter) {
        this.weeksAfter = weeksAfter;
    }
    
    /** Specifies exact date for calendar start. this is alternative for weeksBefore. Date is in current short date format, i.e. 12/31/2011 or 31.1.2011. */
    public String getFirstDate() {
        return firstDate;
    }
    /** Specifies exact date for calendar start. this is alternative for weeksBefore. Date is in current short date format, i.e. 12/31/2011 or 31.1.2011. */
    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }
    
    /** Specifies exact date for calendar end. This is alternative for weeksAfter. Date is in current short date format, i.e. 12/31/2011 or 31.1.2011. */
    public String getLastDate() {
        return lastDate;
    }
    /** Specifies exact date for calendar end. This is alternative for weeksAfter. Date is in current short date format, i.e. 12/31/2011 or 31.1.2011. */
    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
    
    /** Specifies jquery element for start input field. This is used also for single date calendar */
    public String getStartField() {
        return startField;
    }
    /** Specifies jquery element for start input field. This is used also for single date calendar */
    public void setStartField(String startField) {
        this.startField = startField;
    }
    
    /** Specifies jquery element for end input field. */
    public String getEndField() {
        return endField;
    }
    /** Specifies jquery element for end input field. */
    public void setEndField(String endField) {
        this.endField = endField;
    }
    
    /** Specifies if calendar opens as popup or as inline version */
    public Boolean getIsPopup() {
        return isPopup;
    }
    /** Specifies if calendar opens as popup or as inline version */
    public void setIsPopup(Boolean isPopup) {
        this.isPopup = isPopup;
    }
    
    /** True, of current date is to be chosen, even if input field is empty. */
    public Boolean getSelectToday() {
        return selectToday;
    }
    /** True, of current date is to be chosen, even if input field is empty. */
    public void setSelectToday(Boolean selectToday) {
        this.selectToday = selectToday;
    }
    
    /** True if weekends are disabled. */
    public Boolean getDisableWeekends() {
        return disableWeekends;
    }
    /** True if weekends are disabled. */
    public void setDisableWeekends(Boolean disableWeekends) {
        this.disableWeekends = disableWeekends;
    }
    
    /** Space separated list of disabled dates. Dates are presented in short date format of current locale. */
    public String getDisabledDates() {
        return disabledDates;
    }
    /** Space separated list of disabled dates. Dates are presented in short date format of current locale. */
    public void setDisabledDates(String disabledDates) {
        this.disabledDates = disabledDates;
    }
    
    /** Sets minimum range permitted in days. Shorter selections are expanded automatically. */
    public Integer getMinimumRange() {
        return minimumRange;
    }
    /** Sets minimum range permitted in days. Shorter selections are expanded automatically. */
    public void setMinimumRange(Integer minimumRange) {
        this.minimumRange = minimumRange;
    }
    
    /** Set to true for automatically selecting full weeks. */
    public Boolean getSelectWeek() {
        return selectWeek;
    }
    /** Set to true for automatically selecting full weeks. */
    public void setSelectWeek(Boolean selectWeek) {
        this.selectWeek = selectWeek;
    }
    
    /** Duration for fade out. Value is passed for jQuery's .fadeOut function. */
    public Integer getFadeOutDuration() {
        return fadeOutDuration;
    }
    /** Duration for fade out. Value is passed for jQuery's .fadeOut function. */
    public void setFadeOutDuration(Integer fadeOutDuration) {
        this.fadeOutDuration = fadeOutDuration;
    }
    
    /** Function called in init and after date selection. DateRange or Date is passed as argument and this points to calendar container. */
    public String getCallback() {
        return callback;
    }
    /** Function called in init and after date selection. DateRange or Date is passed as argument and this points to calendar container. */
    public void setCallback(String callback) {
        this.callback = callback;
    }
    
    /** Theme to be used. Currently available alternative themes are rounded and transparent. Don't forget to include the required css for the theme. */
    public String getTheme() {
        return theme;
    }
    /** Theme to be used. Currently available alternative themes are rounded and transparent. Don't forget to include the required css for the theme. */
    public void setTheme(String theme) {
        this.theme = theme;
    }
}
