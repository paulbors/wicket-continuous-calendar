

## General Concept ##

Wicket Continuous Calendar does not create the calendar itself, but delegates the creation of the calendar to the <a href='http://reaktor.github.com/jquery-continuous-calendar'>jQuery-Continuous-Calendar</a> JavaScript library. Wicket Continuous Calendar provides you with two things:
  * Java classes to define the settings of the calendar, starting from the Options class
  * Components for Wicket which are able to call jQuery-Continuous-Calendar to display a calendar defined by you

## Defining a Calendar ##

To define the contents of a calendar, you simply have to instantiate an ContinuousCalendarOptions object and use its setter methods to define the metadata you want. This ContinuousCalendarOptions object is then passed into a web component that takes care of the rendering.

For details on the effects of each option, please refer to the <a href='http://reaktor.github.com/jquery-continuous-calendar/#api_documentation'>jQuery-Continuous-Calendar API reference</a>. The naming of the options was adopted from there. If you come across a calendar option that Wicket Continuous Calendar doesn't support yet, please create an issue.

The following example creates a pop-up calendar displaying the current date with a range of 52 weeks before and after it which will fade off the screen in 5 seconds.

```java
  ContinuousCalendarOptions options = new ContinuousCalendarOptions();
  options.setIsPopup(true);
  options.setFadeOutDuration(500);
```

## Adding a Continuous Calendar to your Wicket Page ##
First, add the dependency to the current version of **wicket-continuous-calendar-wicket15** to your classpath.

To add a calendar to a page in a Wicket application, you need to add a div component to your HTML page, like this:
```html
<form wicket:id="calendarForm">
    <div wicket:id="continuousCalendar"/>
</form>
```

In your Wicket page class you can then create an ContinuousCalendarOptions object and pass it as a IModel into an instance of either the SimpleCalendarPanel or TimeframeCalendarPanel along with two IModel<java.util.Date> for the start and end date range. Then add this component to a form on the page. Done.
```java
  Form<T> calendarForm = new Form<T>("calendarForm");
  add(calendarForm);
  
  Date startTime = new Date(); // Also used for single date picker selection
  Date endTime = new Date();
  ContinuousCalendarOptions options = new ContinuousCalendarOptions();
  options.setIsPopup(true); // false will render an in-line calendar (default option)
  ... // add any calendar configuration you like, see above
  TimeframeCalendarPanel calendarPanel = new TimeframeCalendarPanel(
    "continuousCalendar", new Model<ContinuousCalendarOptions>(options),
    new Model<Date>(startTime), new Model<Date>(endTime)
  );
  calendarForm.add(calendarPanel);
```

Using the SimpleCalendarPanel will hide the two date text fields and you'll end up with the calendar icon along with the date range link labels for the user's selection as set by the start and end time models.

Using the TimeframeCalendarPanel as shown in the above example you'll end up with the two date text fields visible on the page labeled as _From_ and _To_. You can change those labels using the properties file within your own application. Also, setting it as a pop-up will render the pop-up icon to the right of the two fields as seen in the screenshot on the project's home page.
