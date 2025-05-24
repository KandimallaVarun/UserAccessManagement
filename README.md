# User Access Management System

## How to Run
1. Import the project into your IDE as a Maven Project.
2. Configure PostgreSQL and create a database named `user_access`.
3. Run the `database/schema.sql` to set up the tables.
4. Update DB credentials in `DBConnection.java`.
5. Deploy on Apache Tomcat server.

## Project Structure
- Java Servlets in `src/main/java`
- JSP pages in `src/main/webapp`
- SQL scripts in `database`
- `web.xml` under `WEB-INF`

## Dependencies
- PostgreSQL JDBC Driver
- Java Servlet API
