LoginSideChannels
=================

The LoginSideChannels project is a Java Server Page (JSP) webapp vulnerable to various side channel attacks.

## Vulnerabities
The login mechanism has some short circuit logic that does not compute the hash of the given password if the user does not exist in the database.  By examining the response times of various users (reguardless of the provided password) an attacker can enumerate and discover the web applications users.  A demo of this attack using the Burp Suite penetration testing tool can be found in this repository in the [Demo](./Demo/) directory.

## Requirements
This application requires a MySQL server.  The web application assumes the MySQL server is running on the localhost at port 3306.  The app connects to the server with the username "root"" and the password "badpass"".  These details can be changed in the Database.java class.

This app was tested using Java 7 and Tomcat 7 on Ubuntu and OSX.  You will need a JSP translator such as Tomcat to run this application.

## Development
The Eclipse project contained in this repository is an Eclipse Dynamic Web project.  The [Eclipse IDE for Java EE Developers](https://www.eclipse.org/downloads/) bundles come with the neccessary plugins to run the application in this repository in a development environment with a Tomcat installation.
