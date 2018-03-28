# MSWW
This projct provides a sampling of how Spring Boot helps you accelerate and facilitate application development. [Features](https://docs.spring.io/spring-boot/docs/current/reference/html/_learning_about_spring_boot_features.html) 

## Set up project
	1. git clone git@github.com:yusz620/MSWW.git
	2. mvn eclipse:eclipse (mvn clean eclipse:clean eclipse:eclipse)
	3. Import this Maven project into Eclipse.
	4. Run main method of class "com.msww.ms.MswwApplication"
	5. In console, it will point which url should to access. e.g. http://localhost:8080

## Features
[Tutoria](https://www.udemy.com/spring-boot-tutorial-for-beginners/)

#### H2 database
	1. Keep project is running.
	2. Access url: http://localhost:8080/h2-console
	3. Keep default value then click "connect"
	4. Verify the table "Customer"
### NO-SQL
#### MongoDB
	https://spring.io/guides/gs/accessing-data-mongodb/

## Messaging:
	
### Health
	/actuator/health
	/actuator/scheduledtasks

## Testing: 
	com.msww.management.system.MswwApplicationTests
### Job
	1, ScheduledTask com.msww.ms.user.tasks.ScheduledTask add @EnableScheduling on MswwApplication
	2, AsyncTask com.msww.ms.user.tasks.AsyncTask add @EnableAsync on MswwApplication

### Aspect 
	add @Aspect and @Component on com.msww.ms.user.aspect.UserControllerAspect	


