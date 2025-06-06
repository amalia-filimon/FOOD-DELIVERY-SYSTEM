# Food Delivery System (Java Swing)

This project is a Java Swing-based desktop application designed to manage food orders for a catering company. The system supports three types of users—Client, Administrator, and Employee—and provides tailored interfaces and operations for each role. The application supports advanced menu filtering, order processing, PDF invoice generation, and administrator reporting features.

---

## 🎯 Objective

To design and implement a food ordering system for a catering company that:
- Allows clients to register, search for meals, and place orders
- Enables administrators to manage menus and generate reports
- Notifies employees of incoming orders
- Provides real-time interaction via graphical interfaces

---

## 👥 User Roles and Functionalities

### 👤 Client
- Register and log in
- View two types of menus:
  - **Base Products** (e.g., salad, steak)
  - **Composite Products** (e.g., menu of the day: soup + steak + dessert)
- Search products using filters:
  - Title, Rating, Calories, Protein, Fat, Sodium, Price
- Place orders (mix of base & composite products)
- Automatically receive a **PDF invoice** after placing an order

### 🛠️ Administrator
- Log in using credentials (username: `Admin10`, password: `aaa`)
- View both product menus
- Add, delete, or edit base products
- Create and manage composite products
- Generate 4 types of reports:
  1. Orders within a given time interval
  2. Products ordered more than N times
  3. Clients with more than N orders & order value above a threshold
  4. Products ordered on a specific date

### 📦 Employee
- Gets notified of every new order
- Can monitor the order queue in real time

---

## 🧱 Technologies Used

- Java 
- Java Swing (`javax.swing`)
- Object-Oriented Programming
- Java Streams & Lambda Expressions
- Serialization & File I/O
- Map collections (`Map<Order, List<MenuItem>>`)
- PDF Generation
- Custom GUI Design

---

## 📂 Project Structure

- `businessLogic/` – core logic for products, orders, and delivery service
- `model/` – user classes (Client, Administrator)
- `enums/` – user role definitions
- `presentation/` – all GUI classes (Login, Registration, Menus, Reports, etc.)

---

## 🧾 Output

### 📄 PDF Invoice
When a client places an order, a **PDF invoice** is automatically generated and saved locally. It includes:
- Client details
- Ordered products (base and/or composite)
- Total price
- Order timestamp

### 📊 Administrator Reports
Reports are saved as `.txt` files and include:
- Orders within specific time intervals
- Frequently ordered products
- Loyal clients and their order values
- Products ordered on a specific day

---

## ✅ Example Scenario

> A client logs into the system, browses the daily menu, and selects a few dishes. After submitting the order, a PDF invoice is generated. Simultaneously, the employee is notified of the new order, and the administrator can generate a report including this transaction.
