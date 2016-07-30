# NG-Login
Just a login app

#### Features
- A user can signin to the system by providing necessary information
- Registered user can login into the system by providing username and password
- User can view his/her personal information if authentication is successful

#### Tools and Technologies
###### Backend
- Framework: Jersey RESTful Web Services framework 
- Build tool: Maven
- IDE: IntelliJ IDEA

###### Frontend
- Framework: AngularJS, Bootstrap 3

#### Build
###### Linux
- General
	- Linux users can simply go to the project folder and run the <strong>build.sh</strong> script to generate the war file
- Advanced
	- Setup a tomcat server in the /opt/tomcat/ngloginserver directory
	- Run the <strong>advance-build.sh</strong> to generate the war file and deploy it into the server(ngloginserver)

###### Windows
- Go to the project folder and execute <strong>build.bat</strong>

*`For the above operations 'maven' must be installed in the system`*
