# Applitools UFG Hackathon Attempt - Thomas Knee

## Introduction
This is my attempt at completing the Applitools Ultra Fast Grid Hackathon.
I have attempted to complete both the modern version utilising Applitools Ultra Fast Grid, 
as well the longer and far more difficult traditional approach, 
which utilise TestNG to run the test across different browsers in parallel,
 as well as using the hackathonReporter() function provided by Applitools to help print out reports of all the elements.
 
 [Official Hackathon instructions can be found here](https://applitools.com/cross-browser-testing-hackathon-v20-1-instructions)
 
## Pre-Requisites

To be able to run the test suites, you will need the following:

* [Java JDK 14](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)
* [Google Chrome](https://www.google.com/chrome/)
* [Mozilla Firefox](https://www.mozilla.org/en-GB/firefox/new/)
* [Microsoft Edge](https://www.microsoft.com/en-us/edge)

### Setting your Eyes API Key
#### ModernTestsV1
1. Open up the ModernTestsV1 folder/project
2. Rename the 'config.properties.sample' file in src/main/resources directory to config.properties
3. Input your eyes API key for the 'eyes.api.key' property

#### ModernTestsV2
1. Open up the ModernTestsV1 folder/project
2. Rename the 'config.properties.sample' file in src/main/resources directory to config.properties
3. Input your eyes API key for the 'eyes.api.key' property

## Running the tests locally

- Open up a Terminal window and change directory in to the ufg-hackathon project root: ```cd path/to/ufg-hackathon```

### ModernTestsV1
- Run the tests: ```./gradlew :ModernTestsV1:test```

### ModernTestsV2
- Run the tests: ```./gradlew :ModernTestsV2:test```

### TraditionalTestsV1
- Run the tests: ```./gradlew :TraditionalTestsV1:test -Psuite```

### TraditionalTestsV2
- Run the tests: ```./gradlew :TraditionalTestsV2:test -Psuite```

## Running remotely
To run the traditional tests remotely, you will need your own grid setup, then just edit the 'environment' property in the src/main/resources/config/general.properties file to 'remote'.

Additionally, you can set the url and port properties of your remote grid in the src/main/resources/config/grid.properties file in the Traditional folders/projects 