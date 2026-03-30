# Contributing

This file contains information useful for contributing to the Krenalis Java SDK.

## Before commit

1. Run the tests

1. Apply code formatting:

    ```
    mvn spotless:apply
    ```

## Testing the SDK

To test the SDK:

1. Make sure the Java Development Kit (JDK) and Maven are installed. [Install JDK](https://docs.oracle.com/en/java/javase/21/install/overview-jdk-installation.html). [Install Maven](https://maven.apache.org/install.html).

1. Run the tests from the root of the repository:

    ```
    mvn clean test
    ```

## Running the sample application

To run the sample application:

1. Make sure the Java Development Kit (JDK) and Maven are installed. [Install JDK](https://docs.oracle.com/en/java/javase/21/install/overview-jdk-installation.html). [Install Maven](https://maven.apache.org/install.html).

1. In `Main.java`, set the `WRITE_KEY` and `ENDPOINT` constants using values from a Krenalis Java source.

1. Build the application:

    ```
    mvn clean package
    ```

1. Run the application, replacing the `[VERSION]` placeholder with the current version of the SDK:

    ```
   java -jar analytics-sample/target/analytics-sample-[VERSION]-jar-with-dependencies.jar
    ```

1. You should see new logged events in the event debugger of the Krenalis Java source.
