# Workshop-PostgreSQL Project

The Workshop-PostgreSQL project is a backend application developed as part of the Java COMPLETO Programação Orientada a Objetos course by Dr. Nelio Alves on Udemy. It is designed to provide a comprehensive control system for managing orders. The application allows clients to place orders, and the system efficiently processes and fulfills these orders by including the requested products.

Key Features:

- Order Management: The application enables clients to create and manage orders, ensuring a seamless workflow.
- Product Integration: Products are seamlessly integrated into the ordering process, ensuring accurate fulfillment.
- Robust Backend: The project leverages the power of Spring Boot and JPA/Hibernate to provide a reliable and efficient backend infrastructure.
- Database Support: The application supports both H2 Database for testing and PostgreSQL for production, ensuring flexibility and scalability.

By utilizing industry-standard technologies and following best practices, the Workshop-PostgreSQL project aims to deliver a robust and efficient order management system.


![UML Diagram](https://user-images.githubusercontent.com/67349235/170148039-85eb86a9-93fe-4c93-9fd2-48d609d044d2.png)

## Technologies Used

The project utilizes the following technologies:

- JDK 15: Java Development Kit 15 - a development kit for building applications and components using the Java programming language.
- NetBeans: NetBeans IDE is a free and open-source integrated development environment for software developers in the Java languages.
- Spring Boot: Spring Boot is an open-source framework for Java that provides a simplified way to create production-grade applications.
- Apache Tomcat: Apache Tomcat is a Java web server and servlet container.
- Maven: Maven is a build automation tool primarily used for Java projects.
- H2 Database: H2 is an in-memory SQL database commonly used for testing purposes.
- Postman: Postman is an API testing tool used to send HTTP requests and analyze responses.
- PostgreSQL: PostgreSQL is a powerful open-source object-relational database management system.

## Endpoints

The application exposes the following endpoints:

- `/categories`: 
  - `GET /{id}`: Get a specific category by ID.
- `/orders`:
  - `GET`: Get all orders.
  - `GET /{id}`: Get a specific order by ID.
  - `POST`: Create a new order.
- `/products`:
  - `GET`: Get all products.
  - `GET /{id}`: Get a specific product by ID.
- `/users`:
  - `GET`: Get all users.
  - `GET /{id}`: Get a specific user by ID.
  - `POST`: Create a new user.
  - `DELETE /{id}`: Delete a user by ID.
  - `PUT /{id}`: Update a user by ID.

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository.
2. Set up the required dependencies, such as JDK 15, NetBeans, and Maven.
3. Configure the database connection, either using the H2 in-memory database for testing or PostgreSQL for production.
4. Build and run the project using your preferred IDE or command line.
5. Use Postman or any API testing tool to interact with the exposed endpoints.

For more detailed information about the project, please refer to the project documentation and source code.

## License

This project is licensed under the [MIT License](LICENSE).

