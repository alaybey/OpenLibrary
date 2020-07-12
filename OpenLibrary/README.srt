
This project has been developed for library management purposes

Requirements:
::
  JDK8
  Maven
  MySql -> you can change if you want. Configure persistence.xml
  
Note: 
`` Completely developed for experiential purpose with Jsf and Jpa ``

How to install and deploy/run ? 
--------------------------------

Before you need to a mysql server. I highly recommend using Docker.
for docker:
:: 
  docker run -d -p 3306:3306 --name openlibrary -e MYSQL_ROOT_PASSWORD=supersecret mysql:latest
  docker exec -it openlibrary bash
  mysql -u root -p supersecret
  CREATE DATABASE openlibrary;

Well done. Now, get our war file
``git clone https://github.com/alaybey/OpenLibrary.git``
``cd ./OpenLibrary``
Make sure maven is installed
``mvn clean``
``mvn install``
``mvn package``

... and OpenLibrary.war file will be created in ``./target`` directory

So, you need to import ``webapps`` directory in your application server. I used ``Glassfish 5``

Notes:
::
  jpa mode default on UPDATE
  Web pages looking like a SPAM. Sorry for this CSS disaster 
  do not use but need to use -> Firstly EJB and CDI (@inject, @named...), Apache shiro and much more Apache tools/frameworks - spring security, jetty, thymeleaf, webservlet, validation, nice CSS or frontend frameworks
  
