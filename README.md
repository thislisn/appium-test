## VODQA 1.0 app is first tested app
* min SDK ver is 16 (Android 4.1 - JELLY_BEAN)
* max SDK ver is 30 (Android 11 - Red Velvet Cake) (ver 29-30 has warning that app can be unstable)
* target SDK ver is 22 (Android 5.1 - Lollipop)
* first emulated device is Pixel 3A SDK 28 (as newest app that works without warnings with Cumulative
  usage - 90.3%. List of apps, devices and SDK version will be increased)

## Steps to run

* If run locally - run with command "mvn clean" or with button Run in IDE
* Report can be found by path - target/html_report/cucumber-report/cucumber-report.html
* Example of ready report is here - test/resources/report
* If run on cloud - ensure that environment configured properly in docker as appium, node.js, emulated device.
Need to check what remote OS has remote environment and check that path delimiters are described related to proper OS.
* If you want to add extra app, you need to add your app to resources and add it to AppDriverManager.
* Test data files stored in resources in json format

## Improvements to do
* Investigate to use selenide-appium library
* Upgrade Java to 11 version and upgrade to new Appium version that can be used with at least Java 11
* Upgrade Junit to 5 ver

## Dependencies
* Java 8
* Appium 2.0
* Lombok
* Hamcrest
* Junit 4