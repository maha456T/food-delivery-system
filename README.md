---
permalink: /index.html
---
# 🍕 Food Delivery System

A full-stack online food delivery application built with Java Spring Boot and HTML/CSS/JavaScript.

## 🚀 Features

- ✅ User Registration & Login with JWT Authentication
- ✅ Password Encryption with BCrypt
- ✅ Restaurant Management
- ✅ Shopping Cart
- ✅ Order Management
- ✅ Responsive Design

## 🛠️ Tech Stack

### Backend
- Java 17
- Spring Boot 3.2.0
- Spring Security
- Spring Data JPA
- MySQL 8.0
- JWT Authentication
- Maven

### Frontend
- HTML5
- CSS3
- JavaScript (Vanilla)
- Responsive Design

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Modern web browser

## ⚙️ Installation & Setup

### Backend Setup

1. Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/food-delivery-system.git
cd food-delivery-system
```

2. Configure MySQL Database
```bash
mysql -u root -p
CREATE DATABASE food_delivery_db;
exit;
```

3. Update database credentials in `food-delivery-backend/src/main/resources/application.properties`

4. Build and run backend
```bash
cd food-delivery-backend
mvn clean install
mvn spring-boot:run
```

Backend runs on: `http://localhost:8080`

### Frontend Setup

Open `frontend/index.html` in your browser.

## 📡 API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login

## 👤 Author

Created with ❤️ by [Your Name]

## 📄 License

This project is open source.