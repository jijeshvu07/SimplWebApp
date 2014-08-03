SimpleWebApp
Simple web application using Maven Spring MVC with security and hibernate.

Create a database in MySQL
Download data.sql from repositry and import it into your database
user table have two records -(a)- user with authority ROLL_NORMAL -(b)- admin with authority ROLL_ADMIN
Browse src/main/webapp/WEB-INF/spring-database.xml in project and change database credentials
Setting for Tomcat7 Running C:\Users\xxxx.m2 inside .m2 folder create settings.xml and following 

<settings>
    <servers>
        <server>
            <id>my-tomcat</id>
            <username>manager</username>
            <password>manager</password>
        </server>
    </servers>
</settings>


C:\apache-tomcat-7.0.29\conf\tomcat-users.xml and add following

 <role rolename="tomcat"/>
  <role rolename="role1"/>
   
  <user username="tomcat" password="tomcat" roles="tomcat"/>
  <user username="tomcat" password="tomcat" roles="tomcat,role1"/>
  <user username="role1" password="admin" roles="role1"/>
  

<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<user username="managerGui" password="manager" roles="manager-gui"/>
<user username="manager" password="manager" roles="manager-script"/> 

Setup the project into eclipse using following steps

Go to File -> Import.
Select Existing Projects into Workspace.
Browse the location of your project and click finish.
Right click on pom.xml select Run As-->Maven clean
Start Tomcat and run your application
To run 'mvn clean package'--> mvn tomcat7:deploy