
This project has been developed for library management purposes

Requirements:
::
  JDK8
  Maven
  MySql -> you can change if you want. Configure persistence.xml
  Application server or web server (like tomcat, tomcat EE, payara, glassfish, websphere) 
  
Note: 
I didn't use CDI or like things. So tomcat can be used

How to install and deploy/run ? 
--------------------------------

Before you need to a running mysql server with ``openlibrary`` database/schema and configure in persistence.xml 

I highly recommend using Docker. You also don't need to edit persistence or any

for docker:
:: 
  docker run -d -p 3306:3306 --name openlibrary -e MYSQL_ROOT_PASSWORD=secretpass mysql:latest
  docker exec -it openlibrary bash
  mysql -u root -p secretpass
  CREATE DATABASE openlibrary;

Well done. Now, get our war file
::
  git clone https://github.com/alaybey/OpenLibrary.git
  cd ./OpenLibrary
Make sure maven is installed
::
  mvn clean
  mvn install
  mvn package

... and OpenLibrary.war file will be created in ``./target`` directory

So, you need to import ``webapps`` directory in your application server. I used ``Glassfish 5``

Notes:
::
  jpa mode default on UPDATE
  Web pages looking like a SPAM. Sorry for this CSS disaster 
  do not use but need to use -> Firstly EJB and CDI (@inject, @named...), Apache shiro and much more Apache tools/frameworks - spring security, jetty, thymeleaf, webservlet, validation, nice CSS or frontend frameworks
  
For production
::
  Passwords should be kept as hash or encrypted
