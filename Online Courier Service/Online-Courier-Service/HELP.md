# Read Me First
The following was discovered as part of building this project:

* The original package name 'Online Courier Service.' is invalid and this project uses 'Online.Courier.Service' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.0/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.0/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.0/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.0/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/3.4.0/reference/web/spring-security.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Who to run This Api for User
1. POST /users/register – Register a new user
   Request:
   Method: POST
   URL: http://localhost:8080/users/register
   Headers:
   Content-Type: application/json

  ## Body (JSON):
   json
   Copy code
   {
   "username": "john_doe",
   "password": "password123",
   "email": "john@example.com"
   }

   Expected Response:
   Status Code: 200 OK
   Body (JSON):
   json
   Copy code
   {
   "id": 1,
   "username": "john_doe",
   "email": "john@example.com",
   "role": "USER"
   }

### 2. POST /orders/place – Place an order

Request:
Method: POST
URL: http://localhost:8080/orders/place
Headers:
Content-Type: application/json
Authorization: Basic {base64(username:password)} (e.g., hussain_basha:hussain123)
Body (JSON):
{
"user": {
"id": 1
},
"pickupAddress": "123 Main Street, City A",
"dropoffAddress": "456 Elm Street, City B",
"deliveryDate": "2023-12-10",
"status": "SCHEDULED"
}
Expected Response:
Status Code: 200 OK
Body (JSON):
{
"id": 1,
"pickupAddress": "123 Main Street, City A",
"dropoffAddress": "456 Elm Street, City B",
"deliveryDate": "2023-12-10",
"status": "SCHEDULED",
"user": {
"id": 1
}
}

### 3. GET /orders/user/{userId} – Fetch orders for a user

Request:
Method: GET
URL: http://localhost:8080/orders/user/1
Headers:
Authorization: Basic {base64(username:password)}
Expected Response:
Status Code: 200 OK
Body (JSON):
[
{
"id": 1,
"pickupAddress": "123 Main Street, City A",
"dropoffAddress": "456 Elm Street, City B",
"deliveryDate": "2023-12-10",
"status": "SCHEDULED"
}
]

### 4. PATCH /orders/{orderId}/status – Update order status
Request:
Method: PATCH
URL: http://localhost:8080/orders/1/status?status=IN_TRANSIT
Headers:
Authorization: Basic {base64(username:password)}
Expected Response:
Status Code: 200 OK


