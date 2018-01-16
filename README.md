# Portfolio

I built a multi-page portfolio to introduce myself :grinning: :wave: and showcase projects I've built.

## Built with

* Maven
* Java 8 (JDK 1.8.131)
* Spring Boot
* JavaScript
* HTML5
* CSS3
* Thymeleaf 
* Bootstrap
* PostgresSQL

I created an admin section which uses authorization and authentication to ensure only authorized users can make updates to the project information stored in the database and rendered to the Projects page. 

This project is deployed using AWS Elastic Beanstalk and can be viewed [here](http://ccornell.us-east-2.elasticbeanstalk.com). Use the following if you want to log in and view the admin section: 

`username: adminDemo password: demo123`

To run this project locally:

You will need to create a Postgres database 

`createdb [dbname]`

`psql [dbname]`

with the following schema:

```
CREATE TABLE projects (
    id SERIAL INTEGER PRIMARY KEY,
    title VARCHAR(255),
    image VARCHAR(255),
    technologies VARCHAR(255),
    description VARCHAR(1000),
    completed VARCHAR(255),
    url VARCHAR(255),
    code VARCHAR(255),
    walkthrough VARCHAR(255),
    viewable BOOLEAN
);

CREATE TABLE role (
    id SERIAL INTEGER PRIMARY KEY, 
    name VARCHAR(20)
);

CREATE TABLE user_data (
    id SERIAL INTEGER PRIMARY KEY, 
    username VARCHAR(50),
    password VARCHAR(50),
    role_id INTEGER REFERENCES role(id)
);
```

* Clone this repository and in your terminal type `git clone` and paste the url that you copied. 
* Open the application.properties file and replace portfoliocdc in the `spring.datasource.url` with your database name, and update the username and password if applicable to your database. 
* Run `mvn clean package` from your project directory (this will build the project and create a jar file in the target directory).


To run the project type: `java -jar target/portfolio-1.0.41-RELEASE.jar`, then open a browser window and go to `localhost:8080`.


