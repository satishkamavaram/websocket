# websocket
Websocket implementation to add student and push added students to clients who are listening

NOTE : This code requires JDK1.8 and Tomcat 8.

This websocket endpoint is used for adding students : 
http://localhost:8080/websocket/addStudent.html

This websocket endpoint allows to see added students pushed from server (server pushes only if any new student added from above endpoint):
http://localhost:8080/websocket/getStudent.html

Please read my blog on how websocket works compared to HTTP :
http://satishkamavaram.blogspot.in/2015/10/websocket.html



