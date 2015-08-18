## Wicket jQuery-Continuous-Calendar

### Version 1.0.2 released
Added new TimeframeCalendarPanel to show the From and To date text fields by default.

### ChangeLog
- Basic functionality of the continuous calendar in Wicket 1.5.x and 6.x
    - Calendar icon shows today's date
    - Exclude predefined holidays or blacked-out days
    - Quick links to select a month or a week
    - Allows for a date range or a date picker
    - Click and drag to select a range or single click for a date picker
    - Click and drag on a selection to move it
    - CSS custom skin with 3 predefined styles
    - Custom jQuery callback functions
- Ajax friendly form fields
- Accessibility and internationalization

### Maven coordinates
Depending on what web framework you use, add one of the following dependencies to your Maven build:

#### Wicket 6.x
```xml
<dependency>
  <groupId>com.googlecode.wicket-continuous-calendar</groupId>
  <artifactId>wicket-continuous-calendar-wicket6</artifactId>
  <version>1.0.2</version>
</dependency>
```

#### Wicket 1.5.x
```xml
<dependency>
  <groupId>com.googlecode.wicket-continuous-calendar</groupId>
  <artifactId>wicket-continuous-calendar-wicket15</artifactId>
  <version>1.0.2</version>
</dependency>
```

#### Plain Java Abstraction
If you want to use the Java abstraction and JSON serializer of the Wicket Continuous Calendar options (for example to add the Continuous Calendar to an application built with a different web framework than Wicket), add the following dependency:
```xml
<dependency>
  <groupId>com.googlecode.wicket-continuous-calendar</groupId>
  <artifactId>wicket-continuous-calendar</artifactId>
  <version>1.0.2</version>
</dependency>
```

### What is Wicket Continuous Calendar?
Wicket Continuous Calendar is a Java abstraction of the jQuery-Continuous-Calendar javascript library. With Wicket Continuous Calendar, you can configure the continuous calendar in Java and display it in any web application based on Apache Wicket. Or you can use the Java abstraction to integrate it in web applications built with other java web frameworks.

### Continuous-Calendar Demo
Issue 2 has been created to add a Showcase app for the project. Until then you can check out the jQuery-Continuous-Calendar Playground at http://reaktor.github.io/jquery-continuous-calendar/site/playground.html.

### How does it work?

#### General Concept
Wicket Continuous Calendar does not create the calendar itself, but delegates the creation of the calendar to the jQuery-Continuous-Calendar JavaScript library. Wicket Continuous Calendar provides you with two things:

- Java classes to define the settings of the calendar, starting from the Options class
- Components for Wicket which are able to call jQuery-Continuous-Calendar to display a calendar defined by you

#### Defining a Calendar
To define the contents of a calendar, you simply have to instantiate an ContinuousCalendarOptions object and use its setter methods to define the metadata you want. This ContinuousCalendarOptions object is then passed into a web component that takes care of the rendering.

For details on the effects of each option, please refer to the jQuery-Continuous-Calendar API reference. The naming of the options was adopted from there. If you come across a calendar option that Wicket Continuous Calendar doesn't support yet, please create an issue.

The following example creates a pop-up calendar displaying the current date with a range of 52 weeks before and after it which will fade off the screen in 5 seconds.
```java
  ContinuousCalendarOptions options = new ContinuousCalendarOptions();
  options.setIsPopup(true);
  options.setFadeOutDuration(500);
```

#### Adding a Continuous Calendar to your Wicket Page
First, add the dependency to the current version of wicket-continuous-calendar-wicket15 to your classpath.

To add a calendar to a page in a Wicket application, you need to add a div component to your HTML page, like this:
```xml
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

Using the TimeframeCalendarPanel as shown in the above example you'll end up with the two date text fields visible on the page labeled as From and To. You can change those labels using the properties file within your own application. Also, setting it as a pop-up will render the pop-up icon to the right of the two fields as seen in the screenshot on the project's home page.

### Your Framework is not supported?
If your Java-based framework of choice is not supported by Wicket Continuous Calendar, feel free to get in touch with us. It shouldn't be much work to get the basic features also working for your framework (most of the work has already been done).

### Want to contribute?
If you're interested in supporting us in developing Wicket Continuous Calendar further, get in touch with us and we'll see how you can contribute.

### License
Copyright (C) 2013 Wicket Continuous Calendar (https://github.com/paulbors/wicket-continuous-calendar)

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

### Sugested projects of interest
Some other easy to integrate OSS Java projects you might be interested in are:

- Wicked-Charts
    - https://github.com/thombergs/wicked-charts
    - Java abstraction of the HighCharts javascript library.
- Wicket-Dashboard
    - https://github.com/decebals/wicket-dashboard
    - Dashboard with standard and custom widgets to your wicket application.
