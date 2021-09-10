# shop-solution

## Pre-requisite
This application runs on the below environmen:

* [Spring boot](https://spring.io/)
* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3.6](https://maven.apache.org/)

## Run all test cases

JUnit and Mockito was used to make test cases.

Run [mvn clean install] to install and run all the test cases.

I used Jacoco plugin for Coverage Analysis and Reporting.After running [mvn clean install] reports directory(on this project) will be created under target/my-reports. Click index file and open it with a browser and inspect generated reports. For code quality, Sonarqube shall be used.

Sample report:

<img src="https://github.com/Bontsokwane/shop-solution/blob/master/docs/code_coverage.PNG" title="Reports diagram"><br/>

## Documentation

Api documentation was done using swagger as shown below. run the application then go to (http://localhost:8787/swagger-ui.html#/) to view the api documentation.

<img src="https://github.com/Bontsokwane/shop-solution/blob/master/docs/swagger_ui.PNG" title="Swagger diagram"><br/>


