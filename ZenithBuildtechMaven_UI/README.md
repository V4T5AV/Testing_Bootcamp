# Zenith Buildtech Online Enquiry - Maven Selenium Project

Built from the supplied Test Plan ZB_OE_1.0 dated 29-Aug-2026.

## Requirements
- Windows
- Java 17+
- Maven 3.9+
- Microsoft Edge
- Eclipse IDE with Maven/TestNG support

## Eclipse
1. Extract the ZIP.
2. Eclipse -> File -> Import -> Maven -> Existing Maven Projects.
3. Select the extracted `ZenithBuildtechMaven` folder.
4. Right-click the project -> Maven -> Update Project.
5. Right-click `testng.xml` -> Run As -> TestNG Suite.

## Run from Command Prompt
From the project folder:

mvn clean test

## Screenshots
After execution, screenshots are created in:
`target/screenshots/`

The project uses a local HTML version of the Zenith Buildtech Online Enquiry form because the supplied test plan states that the application URL/build was not supplied. This makes the project runnable for demonstration and screenshot capture without requiring an external application.
