#!/bin/bash
BLUE='\033[1;034m'
GREEN='\033[1;32m'

echo -e "${BLUE}Building WAR ... ... ..."
mvn clean package
echo -e "${GREEN}Completed"

echo -e "========================================"

echo -e "${BLUE}Shutting down tomcat server ... ... ..."
sudo /opt/tomcat/ngloginserver/bin/shutdown.sh
echo -e "${GREEN}Completed"

echo -e "========================================"

echo -e "${BLUE}Removing previous WAR ... ... ..."
sudo rm -rf /opt/tomcat/ngloginserver/webapps/ROOT /opt/tomcat/ngloginserver/webapps/ROOT.war
echo -e "${GREEN}Completed"

echo -e "========================================"

echo -e "${BLUE}Tranferring generated WAR file to tomcar server ... ... ..."
sudo cp target/ng-login.war /opt/tomcat/ngloginserver/webapps/ROOT.war
echo -e "${GREEN}Completed"

echo -e "========================================"

echo -e "${BLUE}Starting up tomcar server ... ... ..."
sudo /opt/tomcat/ngloginserver/bin/startup.sh
echo -e "${GREEN}Completed"

echo -e "========================================"


