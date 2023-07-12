## Backend(API) for E-Commerce (Admin View)

This is an API for the Admin view of an e-commerce platform. It allows the admin to manage categories, subcategories, products, and their attributes.

### Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Configuration](#configuration)
- [Usage Examples](#usage-examples)


### Features

- Create, read, update, and delete categories
- Create, read, update, and delete subcategories
- Create, read, update, and delete products
- Add and manage attributes for products
- RESTful API endpoints for all operations
- Authentication and authorization for admin access


### Technologies Used

- Java 11
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- IntelliJ IDE


### Getting Started

#### Prerequisites

To run this project, you need to have the following installed:

- Java Development Kit (JDK) 11 or later
- MySQL database
- Maven

#### Installation

1. Clone the repository:
```bash
git clone git@github.com:KunalJaiswal-17/E-commerce-Api.git
```

2. Open the project in IntelliJ idea 
    - It'll index the jdk version as well as build the maven too so that now you have to only run the main file.

3. Alternatively you can do this: 
    - Navigate to project directory
    ```bash
    cd E-commerce-Api
    ```

    - Build the project using Maven
    ```bash
    mvn clean install
    ```

#### Configuration

1. Open the `application.properties` file in the `src/main/resources` directory.

2. Configure the MySQL database connection:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=password
```
- Also you need to make a database of name ecommerce before hand running this project.
Update the values for `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` to match your MySQL configuration.

3. Run the application:
    - You can either run this file in IntelliJ: `ECommerceWebsiteApplication.java`
    - Or you can run this command:
    ```bash
    mvn spring-boot:run
    ```

### Usage Examples

Here are some examples of how to use the API:

1. Create a new category:
```http
POST /addCategory
Content-Type: json

{
  "categoryName": "Electronics"
}
```

2. Create a new subcategory under a category:
```http
POST /subCategory/{categoryName}
Content-Type: json

{
  "subCategoryName": "Mobile Phones"
}
```

3. Create a new product under a subcategory:
```http
POST /addProduct/{subCategoryName}
Content-Type: json

{
  "name": "iPhone 12",
  "description": "All new Apple iPhone 12",
  "price": 1099.99
}
```

4. Add attributes to a product:
```http
POST /addAttribute/{productId}
Content-Type: json

{
  "property": "Brand",
  "value": "Apple"
}
```