## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is for API Test Automation of MY_TEST project.

## Technologies
* Programming language – Java 11.
* Build tool – Maven.
* TA framework – TestNG.

[comment]: <> (* API Testing – custom implementation using REST Assured.)

[comment]: <> (* Java ORM for PostgresSQL – Hibernate.)

[comment]: <> (* Assertions tool - AssertJ.)

[comment]: <> (* Reporting Tool – Allure.)

[comment]: <> (* CI/ CD – Jenkins)
* VCS – Gitlab

## Setup
To run this project locally from cmd:
* Java 11 should be installed
* Maven should be installed

[comment]: <> (* "test_credentials.json" file with all required credentials should be created &#40;e.g. with DB creds&#41;)
* Go to the project directory
* Execute the following command:
```
$ mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testsuites/${TESTNG_FILE.XML} -Denv=${ENVIRONMENT}
```

[comment]: <> (-Denv=${ENVIRONMENT} -Dtestcredentials=${PATH_TO_TEST_CREDENTIALS.JSON} -Duseauth=${USE_AUTH_BOOLEAN_VALUE} -Ddeletetestdata=${DELETE_TEST_DATA_BOOLEAN_VALUE})

where
* ${TESTNG_FILE.XML} - file that contains set of tests for execution (e.g. ui-full-positive.xml)

* ${ENVIRONMENT} - environment where tests should be run (e.g. dev)

[comment]: <> (* {PATH_TO_TEST_CREDENTIALS.JSON} - path to file with all required credentials should be created &#40;e.g. with DB creds&#41;)

[comment]: <> (* {USE_AUTH_BOOLEAN_VALUE} - if API requests should use authorization &#40;true/ false&#41;)

[comment]: <> (* {DELETE_TEST_DATA_BOOLEAN_VALUE} - if Test Automation data should be deleted &#40;true/ false&#41;)
