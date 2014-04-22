Performance REST Server
=======================

Rest Server used for performance tests. It generates a WAR package, so it can be deployed using Apache Tomcat.

If you want to use it, you just need to run "mvn clean install".

Rest call:

http://localhost:8080/rest-server/letters/{number}

This returns a payload with the amount of letters that the user requested in the pathParam.
Example:


http://localhost:8080/rest-server/letters/3

Response: "fff"
