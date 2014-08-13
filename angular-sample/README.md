angular-sample
=============

Sample project integrating Spring + Jersey + AngularJS

Provides example code for consuming a REST service using Angular's ngResource module.

## Getting Started

Project is setup using default Maven project folder structure.

### Run method one

From project root directory, where pom.xml is located, run:

`mvn jetty:run`

After Jetty server starts, access application at http://localhost:8080/

### Run method two

From project root directory, where pom.xml is located, run:

`mvn package`

This will compile and generate a war file in the /target directory. Simply deploy
war file to your container, and start.

### Run method three

From within Eclipse, setup a server (e.g. Tomcat.)

Right click properties for angular-sample project:
 * under "server" specify your server
 * under "targeted Runtimes" specify your server
 * under "Deployment Assembly" click "Add" and make sure the "Maven Dependencies" are added.



