LoginSideChannels
=================

The LoginSideChannels project is a Java Server Page (JSP) web app vulnerable to various side channel attacks.

## Vulnerabities
The login mechanism has some short circuit logic that does not compute the hash of the given password if the user does not exist in the database.  By examining the response times of various users (regardless of the provided password) an attacker can enumerate and discover the web applications users.  A demo of this attack using the [Burp Suite](https://portswigger.net/burp/) penetration-testing  tool can be found in this repository in the [Demo](./Demo/) directory, as well as an [audit walkthrough on YouTube](https://www.youtube.com/watch?v=dtTAMmXsloA).

Usernames can also be enumerated using the different response messages produced by the create user page.

The binary of this application can be analyzed using [Atlas](http://www.ensoftcorp.com/atlas/) with the [AtlasWBP](https://github.com/benjholla/AtlasWBP) plugin frontend.

## Requirements
This application requires a MySQL server.  The web application assumes the MySQL server is running on the localhost at port 3306.  The app connects to the server with the username "root" and the password "badpass".  These details can be changed in the Database.java class.

This app was tested using Java 7 and Tomcat 7 on Ubuntu and OSX.  You will need a JSP translator such as Tomcat to run this application.

## Development
The Eclipse project contained in this repository is an Eclipse Dynamic Web project.  The [Eclipse IDE for Java EE Developers](https://www.eclipse.org/downloads/) bundles come with the necessary plugins to run the application in this repository in a development environment with a Tomcat installation.

## Deployment
### Installing Tomcat
#### Step 1) 

Download the core Tomcat 7 distribution from [https://tomcat.apache.org/](https://tomcat.apache.org/).

#### Step 2) 

Unzip and move contents to the location where you would like to run Tomcat.

`tar xvzf apache-tomcat-7.0.55.tar.gz`

`sudo mv apache-tomcat-7.0.55 /opt/tomcat`

#### Step 3) 
Set the file permissions.  Tomcat files need to be readable and scripts need to be executable.

`sudo chown -R <your_username_here> /opt/tomcat`

`sudo chmod +x /opt/tomcat/bin/*.sh`

#### Step 4) 

Test the Tomcat installation.

Run `/opt/tomcat/bin/startup.sh` to startup the Tomcat server.  Navigate to [http://localhost:8080](http://localhost:8080).  If Tomcat is properly installed you should see a Tomcat welcome page.  Once you know the installation is working you can shutdown the server with the `/opt/tomcat/bin/shutdown.sh` script.
