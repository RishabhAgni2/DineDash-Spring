# 🍽️ Food Fiesta - Professional Spring Boot & Java Fullstack Project

**Food Fiesta** is a high-performance **Fullstack Project** and **Backend Project** ecosystem. Developed using **Java 25** and **Spring Boot 3.4**, this project demonstrates a modern **REST API** architecture integrated with a **Postgres** database.

### 🏷️ Project Tags
`#SpringBoot` `#Java` `#RestAPI` `#BackendProject` `#Postgres` `#FullstackProject` `#EnterpriseApp`

---

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-25-orange.svg)](https://www.oracle.com/java/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-latest-blue.svg)](https://www.postgresql.org/)
[![Swagger](https://img.shields.io/badge/Swagger-OpenAPI%203-85EA2D.svg)](https://swagger.io/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

**Food Fiesta** is a professional-grade, full-stack dining management ecosystem designed for high-end restaurant operations. Built with modern technologies, it offers a seamless blend of aesthetic excellence and robust backend logic.

---

## 📸 Interface Preview

> [!TIP]
> **Recruiters:** Click the images below to view high-resolution previews of our premium UI/UX.

### 🏠 Landing & Identity
<p align="center">
  <img src="./screenshot/about.png" width="800" alt="About Page">
</p>

### 👤 Authentication & Security
<p align="center">
  <img src="./screenshot/login.png" width="45%" alt="Dual Login System">
  <img src="./screenshot/register.png" width="45%" alt="User Registration">
</p>

### 🛒 User Experience & Dashboard
<p align="center">
  <img src="./screenshot/userLogin.png" width="800" alt="User Personalized Dashboard">
</p>

### 🛡️ Admin Management Console
<p align="center">
  <img src="./screenshot/admin-services.png" width="800" alt="Admin Dashboard Overview">
</p>

### 📄 Professional API Documentation
<p align="center">
  <img src="./screenshot/swagger-ui-index-html.png"  width="800" alt="Swagger OpenAPI Docs">
</p>

---

## 🚀 Core Features

- **🎨 Premium UI Overhaul**: Implemented a cohesive "Burnt Orange & Slate" design language with glassmorphism components and fluid animations.
- **🛡️ Secure Gateway**: Role-based access control (RBAC) ensuring dedicated environments for Admins and Customers.
- **🔍 Smart Search**: Case-insensitive, partial-match product discovery powered by optimized JPA queries.
- **📦 Inventory Suite**: Comprehensive management for food categories (Biryani, North Indian, Chinese, Desserts).
- **🔑 Social Authentication**: Integrated **Google OAuth2** for seamless signup and login experience.
- **📄 Interactive Documentation**: Full OpenAPI/Swagger integration allowing for direct API testing and exploration.
- **📊 Real-time Order Tracking**: Personalized order history and status tracking for registered users.

---

## 🛠️ Technology Stack

| Layer | Technology |
| :--- | :--- |
| **Backend** | Java 25, Spring Boot 3.4.2, Spring Security, Hibernate |
| **Database** | PostgreSQL |
| **Documentation** | SpringDoc OpenAPI (Swagger UI) |
| **Frontend** | Thymeleaf, Vanilla CSS (Modern CSS3 Variables), JavaScript |
| **Build Tool** | Maven (wrapper included) |
| **API Testing** | Postman, Swagger |

---

## 📊 Database Architecture (ER Diagram)

The following diagram illustrates the relationship between the core entities in the **Food Fiesta** ecosystem:

```mermaid
erDiagram
    USER ||--o{ ORDERS : "places"
    USER {
        int u_id PK
        string uname
        string uemail
        string upassword
        long unumber
    }
    ADMIN {
        int adminId PK
        string adminName
        string adminEmail
        string adminPassword
        string adminNumber
    }
    PRODUCT {
        int pid PK
        string pname
        double pprice
        string pdescription
    }
    ORDERS {
        int oId PK
        string oName
        double oPrice
        int oQuantity
        date orderDate
        double totalAmmout
        int user_u_id FK
    }
```

---

## ⚙️ Setup and Installation

### Prerequisites
- JDK 21 or later (Java 25 recommended)
- PostgreSQL (running on port 5432)
- Maven 3.8+

### Quick Start
1. **Clone the Project**
   ```bash
   git clone https://github.com/imrajeevnayan/Food-Fiesta.git
   ```

---

## 🐳 Docker Deployment

The application is fully dockerized for seamless deployment.

### 1. Build the Image
```bash
docker build -t food-fiesta .
```

### 2. Run the Container
```bash
docker run -p 8080:8080 --name food-fiesta-app food-fiesta
```

### 3. Orchestrate with Docker Compose (Recommended)
Launch both the App and the PostgreSQL database with a single command:
```bash
docker-compose up -d
```

> [!TIP]
> Use `docker-compose logs -f app` to follow the application logs.

> [!NOTE]
> Ensure you have a PostgreSQL instance running and accessible if not using Compose. You can override database credentials using environment variables:
> `docker run -e SPRING_DATASOURCE_URL=... -p 8080:8080 food-fiesta`

---

2. **Configure PostgreSQL**
   Update `src/main/resources/application.properties` with your local database credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/foodfiesta
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD
   ```

3. **Configure Google OAuth2** (Optional but Recommended)
   To enable and use Google Login:
   - Go to [Google Cloud Console](https://console.cloud.google.com/).
   - Create a new project and navigate to **APIs & Services > Credentials**.
   - Create an **OAuth 2.0 Client ID**.
   - Add `http://localhost:8080/login/oauth2/code/google` to the **Authorized redirect URIs**.
   - Update `src/main/resources/application.properties` with your credentials:
     ```properties
     spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
     spring.security.oauth2.client.registration.google.client-secret=YOUR_CLIENT_SECRET
     ```

4. **Build & Execute**
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```
4. **Explore the App**
   - **Frontend**: [http://localhost:8080/](http://localhost:8080/)
   - **API Docs**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🤝 Contributing
1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License
Distributed under the MIT License. See `LICENSE` for more information.

---

## 📈 Search Optimization & Keywords Index
<!-- 
Target Search Terms:
- Spring Boot Project
- Java Fullstack Project
- REST API Backend Project
- Postgres Database Integration
- Professional Java Backend Project
- Fullstack Web Application Spring Boot
- Spring Security & JWT
-->

Developed with ❤️ by **imrajeevnayan**
