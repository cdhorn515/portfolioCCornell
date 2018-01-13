# Portfolio

I built a multi-page portfolio to introduce myself and showcase projects I've built.

## Built with

* Java 8 
* HTML5
* CSS3
* Thymeleaf 
* Bootstrap
* PostgresSQL

I created an admin section which uses authorization and authentication to ensure only authorized users can make updates to the project information stored in the database and rendered to the Projects page. 

This project is deployed using AWS Elastic Beanstalk and can be viewed here: [www.christinacornell.com](http://www.christinacornell.com). Use the following to log in to the admin section: 

`username: adminDemo password: demo123`

To run this project locally:

Make sure you have `Java8` and `JDK 1.8` installed (this project uses 1.8.131, but you can use the latest version)

You will need to create a Postgres database with the following schema:

`createdb [dbname]`

`psql [dbname]`

```
CREATE TABLE projects (
    id SERIAL INTEGER NOT NULL PRIMARY KEY,
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
    id SERIAL INTEGER NOT NULL PRIMARY KEY, 
    name VARCHAR(20)
);

CREATE TABLE user_data (
    id SERIAL INTEGER NOT NULL PRIMARY KEY, 
    username VARCHAR(50),
    password VARCHAR(50),
    role_id (foreign key to role (id))
);
```

* Clone this repository and in your terminal type `git clone` and paste the url that you copied. 
* Open the application.properties file and replace portfoliocdc in the `spring.datasource.url` with your database name, and update the username and password if applicable to your database. 
* Run `mvn clean package` from your project directory (this will build the project and create a jar file in the target directory).


To run the project type: `java -jar target/portfolio-0.0.1-SNAPSHOT.jar`, then open a browser window and go to `localhost:8080`.


