````markdown
# 📡 E2 Sensors Monitoring Platform

Spring Boot application for **IoT sensor monitoring**, **threshold management**, **alerting**, and **maintenance tracking**.  
Built with Java 17+, Spring Boot 3.x, JPA/Hibernate, H2 (in-memory DB), and Swagger/OpenAPI.

---

## 🚀 Getting Started

### Prerequisites
- Java **17 or later**
- Maven **3.9+**
- IDE (IntelliJ IDEA / Eclipse) or terminal access

### Run with Maven
```bash
# clean & build
mvn clean package

# run Spring Boot app
mvn spring-boot:run
````

### Run Packaged JAR

```bash
java -jar target/e2-sensors-0.0.1-SNAPSHOT.jar
```

### Swagger & H2 Console

* Swagger UI → [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
* H2 Console → [http://localhost:8080/h2](http://localhost:8080/h2)

  * JDBC URL: `jdbc:h2:mem:e2db`
  * User: `sa` / Password: *(blank)*

---

## 📂 Modules Overview

* **Admin Management** – manage platform users & roles
* **Warehouse & Zones** – physical storage spaces for assets/sensors
* **Sensors** – metadata & manufacturers
* **Readings** – time-series sensor data
* **Thresholds** – warning/critical limits per sensor/type
* **Alerts & Tickets** – auto-triggered incidents with resolution tracking
* **Maintenance & Calibration** – track servicing and calibration logs
* **Notifications & Reports** – system messages and generated reports

---

## 🔗 REST API Endpoints

### 👤 Admins

| Method | Endpoint           | Description      |
| ------ | ------------------ | ---------------- |
| POST   | `/api/admins/`     | Create new admin |
| GET    | `/api/admins/`     | Get all admins   |
| GET    | `/api/admins/{id}` | Get admin by ID  |
| PUT    | `/api/admins/{id}` | Update admin     |
| DELETE | `/api/admins/{id}` | Delete admin     |

---

### 🏬 Warehouses

| Method | Endpoint               | Description         |
| ------ | ---------------------- | ------------------- |
| POST   | `/api/warehouses/`     | Create warehouse    |
| GET    | `/api/warehouses/`     | Get all warehouses  |
| GET    | `/api/warehouses/{id}` | Get warehouse by ID |
| PUT    | `/api/warehouses/{id}` | Update warehouse    |
| DELETE | `/api/warehouses/{id}` | Delete warehouse    |

---

### 🏭 Device Manufacturers

| Method | Endpoint                  | Description            |
| ------ | ------------------------- | ---------------------- |
| POST   | `/api/manufacturers/`     | Create manufacturer    |
| GET    | `/api/manufacturers/`     | Get all manufacturers  |
| GET    | `/api/manufacturers/{id}` | Get manufacturer by ID |
| PUT    | `/api/manufacturers/{id}` | Update manufacturer    |
| DELETE | `/api/manufacturers/{id}` | Delete manufacturer    |

---

### 📡 Sensors

| Method | Endpoint                                  | Description                |
| ------ | ----------------------------------------- | -------------------------- |
| POST   | `/api/sensors/`                           | Create sensor              |
| GET    | `/api/sensors/`                           | Get all sensors            |
| GET    | `/api/sensors/{id}`                       | Get sensor by ID           |
| PUT    | `/api/sensors/{id}`                       | Update sensor              |
| DELETE | `/api/sensors/{id}`                       | Delete sensor              |
| GET    | `/api/sensors/by-warehouse/{warehouseId}` | Get sensors in a warehouse |

---

### 📏 Thresholds

| Method | Endpoint               | Description         |
| ------ | ---------------------- | ------------------- |
| POST   | `/api/thresholds/`     | Create threshold    |
| GET    | `/api/thresholds/`     | Get all thresholds  |
| GET    | `/api/thresholds/{id}` | Get threshold by ID |
| PUT    | `/api/thresholds/{id}` | Update threshold    |
| DELETE | `/api/thresholds/{id}` | Delete threshold    |

---

### 📊 Sensor Readings

| Method | Endpoint                             | Description                            |
| ------ | ------------------------------------ | -------------------------------------- |
| POST   | `/api/readings/`                     | Create new reading (auto-checks alert) |
| GET    | `/api/readings/`                     | Get all readings                       |
| GET    | `/api/readings/{id}`                 | Get reading by ID                      |
| PUT    | `/api/readings/{id}`                 | Update reading                         |
| DELETE | `/api/readings/{id}`                 | Delete reading                         |
| GET    | `/api/readings/by-sensor/{sensorId}` | Get readings for sensor                |
| GET    | `/api/readings/latest/{sensorId}`    | Get latest reading for sensor          |

---

### 🚨 Alerts

| Method | Endpoint               | Description          |
| ------ | ---------------------- | -------------------- |
| POST   | `/api/alerts/`         | Create alert         |
| GET    | `/api/alerts/`         | Get all alerts       |
| GET    | `/api/alerts/{id}`     | Get alert by ID      |
| PUT    | `/api/alerts/{id}`     | Update alert         |
| DELETE | `/api/alerts/{id}`     | Delete alert         |
| POST   | `/api/alerts/{id}/ack` | Acknowledge an alert |

---

### 🎫 Alert Tickets

| Method | Endpoint                  | Description      |
| ------ | ------------------------- | ---------------- |
| POST   | `/api/tickets/`           | Create ticket    |
| GET    | `/api/tickets/`           | Get all tickets  |
| GET    | `/api/tickets/{id}`       | Get ticket by ID |
| PUT    | `/api/tickets/{id}`       | Update ticket    |
| DELETE | `/api/tickets/{id}`       | Delete ticket    |
| POST   | `/api/tickets/{id}/close` | Close ticket     |

---

## 🛠 Development Notes

* Entities & relationships based on provided ER diagram
* Generic threshold evaluation on reading insert
* CRUD-first approach with simple JSON payloads
* Extend with:

  * DTOs & validation (`@Valid`)
  * Real DB (PostgreSQL/MySQL)
  * AuthN/AuthZ with Spring Security

---

```
```
