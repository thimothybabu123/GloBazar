# 🛍️ Globazaar - Product and User Management System

Globazaar is a RESTful Spring Boot application that enables users to register and list products. Built with a modular structure, it includes DTOs, services, and controllers for clean code separation. PostgreSQL is used for persistent storage.

---

## 🚀 Features

- 🧑‍💼 Create and manage user profiles
- 📦 Add products for registered users
- 🔍 Retrieve products by user and product ID
- ❌ Delete user accounts
- 🎯 Input validation using Jakarta Bean Validation
- 🗂️ Clean controller-service-dto architecture

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **Validation**: Jakarta Bean Validation
- **Tools**: Maven, Lombok

---

## 🔁 API Endpoints

### 👤 User APIs

| Method | Endpoint           | Description                |
|--------|--------------------|----------------------------|
| POST   | `/api/users`       | Create a new user          |
| GET    | `/api/users/{id}`  | Retrieve a user by ID      |
| DELETE | `/api/users/{id}`  | Delete a user by ID        |

### 📦 Product APIs

| Method | Endpoint                             | Description                      |
|--------|--------------------------------------|----------------------------------|
| POST   | `/api/users/{id}/products`           | Add a product for a user         |
| GET    | `/api/users/{userid}/products/{id}`  | Get a product for a user by ID   |

---

## 📐 Relationships

- **One-to-Many**: One user can have many products

---

## 🧪 Validation

- All input data is validated using Jakarta annotations like `@Valid`, `@NotNull`.

---

## ✅ Setup Instructions

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/globazaar.git
   cd globazaar
   ```

2. Set up PostgreSQL and update your DB credentials in `application.properties`.

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Use tools like Postman to test the APIs.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

---

## 🙋‍♂️ Author
Developed with ❤️ by [Thimothi Babu Ramagalla](https://github.com/thimothybabu123)
