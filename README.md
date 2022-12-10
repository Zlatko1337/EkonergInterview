Coding challenge for company Ekonerg, Java developer position.
Not a production grade code its just for demo purpose... For simplicity there is no proper exception handeling, DTO to DAO mapping, service layer etc. I know, i have Sonar ;)
Made with: Spring framework (boot, data, jpa), Fremarker, H2 DB, Apache POI, Bootstrap..
Task that was given is defined in /resources/task folder.

To build:

1.Import as Maven project

2.run 'clean package' or 'mvn clean package'


To run:

1.Run .exe or .jar (java -jar EkonergInterview.jar)

OR

2.Import as Maven project in IDE of your choice and run EkonergInterviewApplication.java  


In case of problems:

1.netstat -ano | findStr "8080" //which process (pid_id) uses port 8080

2.taskkill /F /PID pid_id

3.Run .exe or .jar
