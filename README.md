# Test Automation University - Automating your API tests with REST Assured

This repository contains resources related to the "Automating your API tests with REST Assured" course at Test Automation University (TAU). Here, you'll find my implementation to the REST Assured tests presented throughout the course, along with my solutions to the course quizzes.

## Table of Contents

- [Introduction](#introduction)
- [Topics Covered](#topics-covered)
- [Directory Structure](#directory-structure)
- [APIs Used](#apis-used)
- [Usage](#usage)
- [Contributions](#contributions)
- [Disclaimer](#disclaimer)

## Introduction

The "[Automating your API tests with REST Assured](https://testautomationu.applitools.com/automating-your-api-tests-with-rest-assured/)" course on Test Automation University is a great resource for learning and mastering APIs. From diving into the secrets of RESTful APIs to creating powerful and automated test suites, this course is a great guide for REST Assured library and how to use it to write powerful, readable, and maintainable tests in Java.\
This repository provides comprehensive implementation of the course lecture examples and solutions to the quizzes presented throughout the course.

## Topics Covered

- Writing tests in Java using REST Assured and JUnit
- REST Assured features
- Parameterization and data driven testing
- POJO Classes
- Verifying response headers and bodies
- Optimizing test code through reuse
- Working with XML Responses
- (De-)serializing request and response bodies

## Directory Structure

The repository is organized as follows:

- `Chapter X/`: Each lecture from the course has its own directory.
  - `Chapter X Quiz.txt`: A text file corresponding to the quiz for the lecture. These files contain my solutions to the quiz questions.
- `tau-rest-assured/`: This directory contains my implementation to code presented throughout the course
  - `pom.xml`: The `pom.xml file` is a Maven Project Object Model (POM) file used for managing dependencies and build configurations for the project.
  - `src/test/`:  This directory, located within the `tau-rest-assured` directory, contains Java source code files. These files represent my own implementations to the examples presented in the lectures.
    - `resources/`: This directory contains essential resources for the project.
      - `mappings/`: Holds JSON files that mock the API using WireMock, aiding in testing scenarios.
      - `__files/`: Contains XML response files, used for simulating API responses during testing.
    - `java/`: This directory is dedicated to Java-specific code.
      - `dataentities/`: A directory that contains the Plain Old Java Object (POJO) classes.
        - `Location.java`: A POJO class representing the Location entity.
        - `Place.java`: A POJO class representing the Place entity.
      - `examples/`: This Java package contains test cases written throughout the course.
        - `ChapterXTest.java`: Each chapter's code has a dedicated class, like `Chapter1Test.java`.


## APIs Used

The code samples invoke the [Zippopotam.us](http://api.zippopotam.us/) API.

In those cases where the actual API could not be used (it doesn't have an option to return XML response bodies), calls have been mocked using [WireMock](http://wiremock.org/).

## Usage

You can go ahead and explore my collection and quiz solutions by navigating to the specific chapter and associated directories within the repository. Each quiz text file contains my quiz answers.

Feel free to use these collections as reference code, study materials, or review materials to enhance your understanding of Postman. Additionally, you can review my quiz solutions to reinforce your knowledge of the course content.

## Contributions

Contributions to this repository are welcome. If you have alternative code implementations, suggestions for improvements, or corrections to my answers, please consider submitting a pull request. If you encounter any issues with my solutions or have additional insights to share, please open an issue.

## Disclaimer
> This is not the official implementation. The official implementation may be found [here](https://github.com/basdijkstra/tau-rest-assured/).
