

## Version 1.0.2 released (05/07/2013) ##
Mapping from 1.0.1 classes to 1.0.2 classes

| **Classes in 1.0.1** | **New classes in 1.0.2** |
| --------------------- | ------------------------- |
| com.googlecode.wicketcontinuouscalendar | com.googlecode.wicketcontinuouscalendar.wicket15 |
| com.googlecode.wicketcontinuouscalendar.panel | com.googlecode.wicketcontinuouscalendar.wicket15.panel |
| n/a                  | com.googlecode.wicketcontinuouscalendar.wicket6 |
| n/a                  | com.googlecode.wicketcontinuouscalendar.wicket6.panel |

API Changes:
  * A second wicket6 module and package to the project and also restructured the project

```xml
<dependency>
  <groupId>com.googlecode.wicket-continuous-calendar</groupId>
  <artifactId>wicket-continuous-calendar-wicket6</artifactId>
  <version>1.0.2</version>
</dependency>
```

## Version 1.0.1 released (02/06/2013) ##
Mapping from 1.0.0 classes to 1.0.1 classes

| **Classes in 1.0.0**  | **New classes in 1.0.1**  |
| --------------------- | ------------------------- |
| com.googlecode.wicketcontinuouscalendar.panel.ContinuousCalendarPanel | com.googlecode.wicketcontinuouscalendar.panel.SimpleCalendarPanel |
| n/a                   | com.googlecode.wicketcontinuouscalendar.panel.TimeframeCalendarPanel |

API Changes:
  * Allow for obmission of resources by passing _null_ for c.g.w.wicket15.ResourceRegistry#setContinuousCalendar**<Type/Name>**Reference(null)
  * Removed c.g.w.wicket15.ResourceRegistry.Type enum
  * [Issue 3](https://code.google.com/p/wicket-continuous-calendar/issues/detail?id=3): Add a second CalendarPanel that shows the two date text fields by default

```xml
<dependency>
  <groupId>com.googlecode.wicket-continuous-calendar</groupId>
  <artifactId>wicket-continuous-calendar-wicket15</artifactId>
  <version>1.0.1</version>
</dependency>
```

## Version 1.0.0 released (01/29/2013) ##
  * Basic functionality of the continuous calendar in Wicket 1.5.x
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

```xml
<dependency>
  <groupId>com.googlecode.wicket-continuous-calendar</groupId>
  <artifactId>wicket-continuous-calendar-wicket15</artifactId>
  <version>1.0.0</version>
</dependency>
```
