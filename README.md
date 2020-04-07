# MaxValue
Spring Boot Project demonstrating finding maximum value in a list after series of addition operations.

## Requirements
To run it on your machine you would need the following to be pre-installed:
1. Apache maven 3.6.3 
2. Java 8 SDK
3. Git

## Technical overview
1. Technologies used: SpringBoot 2.1, Java 8.
2. Architecture: Layered
3. Version control: Git
4. Build tool: Apache maven 3.6.3

## Build instructions (using IDE)
1. Git clone https://github.com/anandchouksey/MaxValue.git.
2. Successful cloning creates a folder name: 'MaxValue'.
3. Open your fav IDE, in my case I use Intellij: \
   File > Open > go to folder MaxValue location >> select MaxValue >> open 
   new window.
4. Run mvn clean install on MaxValue project using IntelliJ.
5. Run MaxValueApp.
6. Open your IDE console.
7. Input values in the respective format either all at once or one by one
8. Appropriate loggers will track the application progress.
9. To continue testing the application, kindly enter yes.
In case of any other input, application exits.

```cmd
In case of running from command line
Navigate to Project folder and execute following commands:
execute > mvn clean install
(after successful build)
execute > mvn spring-boot:run
Input values in the respective format either all at once or one by one
appropriate loggers will track the application progress.
In case of continue to test the application, kindly enter yes.
In case of any other input application exits.
```

## Result types
In case of successful run, application will return the largest element 
in the list after series of addition operations.

## Limitations
Application works only for single threaded environment.

## Trade offs
Current approach: \
Pros-
1. Usage of array to get O(1) for accessing elements.
2. Small reusable overloaded methods.
3. Layered architecture with minimum services.
4. Usage of primitives and local variables for efficient memory utilization
and fast performance.
5. Faster application start up time with minimum dependencies.

Cons-
1. Numerous small readable methods in console service(still follows 5-9 rules methods per class).
2. Single threaded

Other proposed approach: 
1. Usage of bean validation replacing validation service.
2. Thread safe methods.

Cons-
1. Objects consume more memory than primitives
2. Hibernate validator slows down application start up time
3. Pre compiled regex could be used, but is over engineered solution in this case.

## Documentation
1. Appropriate comments have been added in the code for code walkthrough.\
Should be removed in production environment.
2. Method name follows the clean code conventions.

## Test coverage
1. MaxValueService and ValidationService are covered with Junit tests.
2. ConsoleService is more appropriate for integration testing (to be added). 

