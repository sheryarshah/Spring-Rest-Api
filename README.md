##Tech Stack
* Java 8
* Spring Boot
* H2 In-Memory Database
* Docker


# How to Build

1. Run Docker. Install docker if not already installed [Docker Install](https://docs.docker.com/get-docker/)
    1. **Note: The application can be run without docker, scroll to section 
    `If you don't have docker installed` in bottom on how to run**
2. Open terminal / command prompt / powershell and navigate to project root directory. Run the following command:

`docker build -t noyo/noyorest -f Dockerfile ./`

Wait for the build to complete. Please note that this may take a few minutes.

### Starting Noyo Rest Server
Run the following command in project root directory:

`./scripts/startserver.sh`

For Windows

`.\scripts\startserver.sh`

This will open a new bash shell for server.

### Interactive Mode [Optional]

Server can also be initialized in an interactive mode in the following manner. 

1. Run `docker run --net=host -ti noyo/noyorest sh` at project root. This will take you within docker environment. 
1. Once inside docker environment, run `./startserver.sh`

## How to Copy Build Artifacts From Docker To Local
To copy build artifacts from docker to local environment, run the following command in project root directory:

`./scripts/copy.sh`

For Windows:

`.\scripts\copy.sh`

This command will copy the following to the _build_ directory of project root.

* noyo.jar

# Troubleshooting

## Problem Running Server

In case the server cannot be started for some reason, chances are that an instance of the server is already 
running and in that case, you can run the following command at project root to shutdown the server:

`./scripts/stopserver.sh`

For Windows

`.\scripts\stopserver.sh`

# If you don't have docker installed

The jar is already build and is in **build** directory.
To rebuild the jar, here are the following steps:

1. Building Noyo jar: Go to project root dir and run `mvn clean compile package`. This will build 
Noyo jar and place it in _target_ dir.

To Run:
1. Go to project root dir -> target folder: run noyo jar: `java -jar noyo.jar`

# Rest Endpoints

Postman collections is included in root folder with all the below requests

1. Create Person: Post[http://localhost:8081/persons]
`{"firstName":"Sheryar","middleName":"Hasan","lastName":"Shah", "email":"sheryar.shah@gmail.com", "age":27}`
2. Get Person: Get[http://localhost:8081/persons/1]
3. Get All Persons: Get[http://localhost:8081/persons]
4. Update Person: Put[http://localhost:8081/persons/1]
`{"firstName":"Sherry","middleName":"Hasan","lastName":"Shah", "email":"sherry.shah@gmail.com", "age":22}`
5. Get All Version of Person: Get[http://localhost:8081/persons/1/version]
6. Get specfic version of Person: Get[http://localhost:8081/persons/version?id=1&version=1]
7. Delete Person: Delete[http://localhost:8081/persons/1]
