# Design patterns in spring boot 
[![CircleCI](https://circleci.com/gh/indrekru/design-patterns-spring-boot.svg?style=svg)](https://circleci.com/gh/indrekru/design-patterns-spring-boot) 

This repository is a simple spring boot application, that demonstrates a few design patterns:

* Singleton
* Controller
* Factory
* Strategy
* Proxy
* Observer
* Aspect-oriented programming

This demo application retrieves contact phone numbers from 2 different bank's websites (more banks can be added) with specific implementations per bank and offers a nice interface to hide the specifics.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See running for notes on how to run the project on a system.

### Prerequisites

1. Clone the project to your local environment:
    ```
    git clone https://github.com/indrekru/design-patterns-spring-boot.git
    ```

2. You need maven installed on your environment:

    #### Mac (homebrew):
    
    ```
    brew install maven
    ```
    #### Ubuntu:
    ```
    sudo apt-get install maven
    ```

### Installing

Once you have maven installed on your environment, install the project dependencies via:

```
mvn install
```

## Testing

Run all tests:
```
mvn test
```

## Running

Once you have installed dependencies, this can be run from the `Application.java` main method directly,
or from a command line:
```
mvn spring-boot:run
```

Open browser and go to http://localhost:8080/api/v1/banks and you should see the results

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot 2
* [Spock](http://spockframework.org/) - Spock testing framework
* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

If you have any improvement suggestions please create a pull request and I'll review it.


## Authors

* **Indrek Ruubel** - *Initial work* - [Github](https://github.com/indrekru)

See also the list of [contributors](https://github.com/indrekru/design-patterns-spring-boot/graphs/contributors) who participated in this project.

## License

This project is licensed under the MIT License

## Acknowledgments

* Big thanks to Pivotal for Spring Boot framework, love it!
* Also check out my Spring Boot 2 Oauth2 resource server example: https://github.com/indrekru/spring-boot-2-oauth2-resource-server
