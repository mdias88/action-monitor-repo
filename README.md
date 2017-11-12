# action-monitor-repo

Action Monitor was tested using:
-Tomvat V8.0.33
-Maven 3.5.2
-jdk1.8.0
-jre1.8.0_20

Make sure you have added the enviroment variables: 
-JAVA_HOME - JDK folder
-JRE_HOME - JRE folder
-M2_HOME - Maven folder
-MAVEN_HOME - Maven folder

Add to path variable:
-%M2_HOME%\bin
-Path to JDK

To build action-monitor you can do it running the build.bat
To deploy just copy the resulted war to your tomcat webapps directory

To run the Action Monitor:

http://localhost8080/action-monitor
	- DB Interface where you can Insert, Update or Delete rows.
	- In the same page you have the console reporting all the users interactions with the DB
	
http://localhost8080/action-monitor/content
	- Here you have the list of all rows in the DB
	
http://localhost8080/action-monitor/version
	- Current version os the application
	
http://localhost8080/action-monitor/health
	- Current status of the application
	
UNIT TESTS
	All DAO methods was tested with JUNIT using a specific in memory H2 DB (only used in tests).
		
