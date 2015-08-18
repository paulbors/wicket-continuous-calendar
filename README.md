
## Wicket Continuous Calendar ##
Wicket Continuous Calendar is a Java abstraction of the <a href='http://reaktor.github.com/jquery-continuous-calendar'>jQuery-Continuous-Calendar</a> javascript library. With Wicket Continuous Calendar, you can configure the continuous calendar in Java and display it in any web application based on Apache Wicket. Or you can use the Java abstraction to integrate it in web applications built with other java web frameworks.

![http://wicket-continuous-calendar.googlecode.com/files/Wicket-Continuous-Calendar.png](http://wicket-continuous-calendar.googlecode.com/files/Wicket-Continuous-Calendar.png)

### Version 1.0.2 released ###
Added new TimeframeCalendarPanel to show the _From_ and _To_ date text fields by default.

  * Check out the [ChangeLog](ChangeLog.md)
  * Basic functionality of the continuous calendar in Wicket 1.5.x and 6.x
    * Calendar icon shows today's date
    * Exclude predefined holidays or blacked-out days
    * Quick links to select a month or a week
    * Allows for a date range or a date picker
    * Click and drag to select a range or single click for a date picker
    * Click and drag on a selection to move it
    * CSS custom skin with 3 predefined styles
    * Custom jQuery callback functions
  * Ajax friendly form fields
  * Accessibility and internationalization

## Maven coordinates ##
Depending on what web framework you use, add one of the following dependencies to your Maven build:
### Wicket 6.x ###
```xml
<dependency>
  <groupId>com.googlecode.wicket-continuous-calendar</groupId>
  <artifactId>wicket-continuous-calendar-wicket6</artifactId>
  <version>1.0.2</version>
</dependency>
```
### Wicket 1.5.x ###
```xml
<dependency>
  <groupId>com.googlecode.wicket-continuous-calendar</groupId>
  <artifactId>wicket-continuous-calendar-wicket15</artifactId>
  <version>1.0.2</version>
</dependency>
```
### Plain Java Abstraction ###
If you want to use the Java abstraction and JSON serializer of the Wicket Continuous Calendar options (for example to add the Continuous Calendar to an application built with a different web framework than Wicket), add the following dependency:
```xml
<dependency>
  <groupId>com.googlecode.wicket-continuous-calendar</groupId>
  <artifactId>wicket-continuous-calendar</artifactId>
  <version>1.0.2</version>
</dependency>
```
## Continuous-Calendar Demo ##

A ticket has been created to add a Showcase app for the project. Until then you can check out the <a href='http://reaktor.github.com/jquery-continuous-calendar/site/playground.html'>jQuery-Continuous-Calendar Playground</a>.

## How does it work? ##
For a quick start on how to use Wicket Continuous Calendar in your Wicket application, visit the [GettingStarted](GettingStarted.md) page.

## Your Framework is not supported? ##
If your Java-based framework of choice is not supported by Wicket Continuous Calendar, feel free to get in touch with us. It shouldn't be much work to get the basic features also working for your framework (most of the work has already been done).

## License ##
Copyright (C) 2013 Wicket Continuous Calendar (https://github.com/paulbors/wicket-continuous-calendar)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
> http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


---


### Sugested projects of interest ###
Some other easy to integrate OSS Java projects you might be interested in are:

<blockquote>
    <table>
        <tr>
            <td><strong>Project Name:</strong></td>
            <td><a href='https://github.com/thombergs/wicked-charts'>Wicked-Charts</a></td>
        </tr>
        <tr>
            <td><strong>Description:</strong></td>
            <td>Java abstraction of the <a href='http://www.highcharts.com'>HighCharts</a> javascript library.</td>
        </tr>
        <tr>
            <td colspan="2"><img src='http://wicked-charts.googlecode.com/files/chart.png' /></td>
        </tr>
        <tr>
            <td colspan="2"><br /></td>
        </tr>
        <tr>
            <td><strong>Project Name:</strong></td>
            <td><a href='https://github.com/decebals/wicket-dashboard'>Wicket-Dashboard</a></td>
        </tr>
        <tr>
            <td><strong>Description:</strong></td>
            <td>Dashboard with standard and custom widgets to your wicket application.</td>
        </tr>
        <tr>
            <td colspan="2"><img src='http://wicket-continuous-calendar.googlecode.com/files/wicket-dashboard.png' /></td>
        </tr>
    </table>
</blockquote>
