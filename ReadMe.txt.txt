Hi,

The framework is developed using Page Object model Pattern using Junit with Cucumber

All the java codes comes under src/test/java under which we have 6 packages:
acceptancetestpackage->It has runner file for execution
basetest->Driver Initialization
hooks->performs opening and closing browser before actual test starts
pages->Page Object model pattern
stepdefs->All stepdefs are present
utils->read data from property files

All no coding stuffs comes under src/test/resources
feature->All feature files are present in this folder

propertFIles folder has URL.properties file which has URL info


In order to handle Driver files I have used WebDriverManager plugin which will automatically
download correpsonding driver based on chrome version and I have gone with chrome as default browser
as there was no info on browser type.

Maven Command to run the test is:
mvn test -Dcucumber.options="--tags @test_001"