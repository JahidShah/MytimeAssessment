# MyTime Assessment

									   =======================
										Framework Architecture:
									   =======================

Project - Maven
Framework - Page Object Model[POM] using Page Factory in Selenium.
Language - Java
WebDriver - 3.141.59 version
Browsers - chrome
Test Executions - JUnit (or) maven test
Logger - Log4j - {rootfolder}/target/Log.log
Reports - Cucumber Report - {rootfolder}\target\cucumber-reports\index.html
          Extent Report - {rootfolder}\test-output\HtmlReport\ExtentReportHtml.html
		  Spark Report - {rootfolder}\test-output\SparkReport\SparkReport.html

Editor - Eclipse

=================
Folder Structure
=================
src/main/java - Individual pages are classified in to their corresponding packages and written inside java file
				Framework related codes

src/main/resources - contains config folder related to Chromedriver Execution File, Extent Properties Files and log4j.xml file

src/test/java -  Cucumber Runner and Step Definition Files

src/test/resources - Feature Files

target/Log.log - contains test execution log informations

pom.xml - contains dependencies,plugins,etc

===========
Executions:
===========
=======
JUnit
=======
 
1) For UI - MyTimeAssessment Test (Individual Feature File Running):
   Right click on src/test/java/com.runners/MyTimeMensHaircutRunnerTest.java and Run As-> JUnit Test

2) Test Run through Maven Command:
   mvn clean -Dtest=MyTimeMensHaircutRunnerTest test

   
Note:
=====
The ChromeDriver Executable File used in this project under 'src/main/resources' folder is applicable for Browser Version 93.0. If you have other version,
then please delete the chromedriver executable file fron above folder path and download appropriate driver version.
#