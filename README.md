Performance REST Server
=======================

Rest Server used for performance tests. It generates a WAR package, so it can be deployed using Apache Tomcat.

If you want to use it, you just need to run "mvn clean install". This command will create the war file.

###Rest calls:

####GET  /letters/{amountOfLetters}
This returns a payload with the amount of letters that the user requested in the pathParam.

Example:
```
➜  ~ ✗ curl -XGET http://localhost:8080/rest-server/letters/4

ffff
```
-----------------------------------------------------------------------------------------------------

####GET  /strictdelay?miliseconds={miliseconds}
This call makes a response after an strict amount of miliseconds

Example:
```
➜  ~ ✗ curl -XGET http://localhost:8080/rest-server/strictdelay/?miliseconds\=400

Waited for 400 miliseconds
```
-----------------------------------------------------------------------------------------------------

####GET  /randomdelay?miliseconds={miliseconds}
This call makes a response after a random amount of miliseconds, between 0 and the given path parameter

Examples:
```
➜  ~ ✗ curl -XGET http://localhost:8080/rest-server/randomdelay/?miliseconds\=400

Waited for 343 miliseconds
```

```
➜  ~ ✗ curl -XGET http://localhost:8080/rest-server/randomdelay/?miliseconds\=400

Waited for 105 miliseconds
```
-----------------------------------------------------------------------------------------------------

####GET  /rest-server/strictdelay?miliseconds={miliseconds}&letters={letters}
This call returns a payload with the amount of letters that the user requested in the query parameter.
It makes a response after an strict amount of miliseconds.

Example:
```
➜  ~ ✗ curl -XGET http://localhost:8080/rest-server/strictdelay/?miliseconds\=30\&letters\=3

fff
```
-----------------------------------------------------------------------------------------------------

####GET  /rest-server/randomdelay?miliseconds={maxMiliseconds}&letters={letters}
This call returns a payload with the amount of letters that the user requested in the query parameter.
It makes a response after a random amount of miliseconds, between 0 and the given path parameter

Example:
```
➜  ~ ✗ curl -XGET http://localhost:8080/rest-server/randomdelay/?miliseconds\=30\&letters\=3

fff
```
