# SpringMon - Generic Spring Boot Application

## 📋 Overview

**SpringMon** è un'applicazione Spring Boot generica e modulare, trasformata dal template "movie-watchlist" in un framework riutilizzabile per qualsiasi dominio applicativo.

## 🏗️ Architecture

### Project Structure
```
springmon/
├── src/main/java/com/example/springmon/
│   ├── SpringMonApplication.java       # Main application class
│   ├── controller/
│   │   └── ApiController.java         # REST API endpoints
│   ├── service/
│   │   └── ApplicationService.java    # Business logic layer
│   ├── repository/
│   │   └── BaseRepository.java        # Data access layer
│   ├── model/
│   │   └── BaseEntity.java            # Base entity with timestamps
│   └── config/
│       └── WebConfig.java             # Web configuration (CORS, etc.)
└── src/main/resources/
    └── application.properties         # Application configuration
```

## 🚀 Features

### Core Endpoints
- **Health Check**: `GET /api/health` - Application health status
- **Info**: `GET /api/info` - Application information
- **Status**: `GET /api/status` - Runtime status

### Database
- **H2 In-Memory**: Development database (auto-configured)
- **H2 Console**: Available at `/h2-console` (dev only)
- **PostgreSQL Ready**: Commented configuration available

### Configuration
- **Multi-Environment**: dev, test, production profiles
- **Actuator**: Health checks and metrics enabled
- **CORS**: Configured for localhost development

## 🔧 Quick Start

### Prerequisites
- Java 17+
- Maven 3.6+

### Build & Run
```bash
# Build application
./mvnw clean package

# Run application
./mvnw spring-boot:run

# Access application
http://localhost:8080/api/health
```

### Docker Support
```bash
# Build image
docker build -t springmon .

# Run container
docker run -p 8080:8080 springmon
```

## 📊 API Documentation

### Health Endpoint
```
GET /api/health
Response:
{
  "status": "UP",
  "application": "SpringMon", 
  "version": "1.0.0",
  "timestamp": 1733317890123
}
```

### Info Endpoint
```
GET /api/info
Response:
{
  "name": "SpringMon",
  "description": "Generic Spring Boot Application",
  "version": "1.0.0",
  "status": "ACTIVE"
}
```

### Status Endpoint
```
GET /api/status
Response:
{
  "status": "RUNNING",
  "version": "1.0.0"
}
```

## 🔧 Configuration

### Database Configuration
```properties
# H2 Development (Default)
spring.datasource.url=jdbc:h2:mem:springmon
spring.h2.console.enabled=true

# PostgreSQL Production (Commented)
# spring.datasource.url=jdbc:postgresql://localhost:5432/springmon
# spring.datasource.username=springuser
# spring.datasource.password=change_me
```

### Application Properties
```properties
spring.application.name=springmon
server.port=8080
app.name=SpringMon
app.version=1.0.0
```

## 🧩 Customization

### Adding New Features

1. **Create Entity**:
```java
@Entity
public class YourEntity extends BaseEntity {
    private String name;
    // ... fields and methods
}
```

2. **Create Repository**:
```java
public interface YourRepository extends BaseRepository<YourEntity> {
    // Custom queries
}
```

3. **Create Service**:
```java
@Service
public class YourService {
    // Business logic
}
```

4. **Create Controller**:
```java
@RestController
@RequestMapping("/api/your-resource")
public class YourController {
    // REST endpoints
}
```

## 🛡️ Security

### Current Status
- ✅ Input validation ready
- ✅ CORS configured
- ✅ Error handling
- ⚠️ Authentication: Not implemented (ready for Spring Security)
- ⚠️ Authorization: Not implemented

### Adding Security
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

## 📈 Monitoring

### Actuator Endpoints
- `/actuator/health` - Health status
- `/actuator/info` - Application info
- `/actuator/metrics` - Application metrics

## 🔄 Development Workflow

1. **Customize Domain**: Modify entities, services, controllers
2. **Configure Database**: Switch from H2 to PostgreSQL for production
3. **Add Security**: Implement Spring Security if needed
4. **Add Features**: Extend with business-specific functionality
5. **Deploy**: Use Docker or JAR deployment

## 📦 Maven Commands

```bash
# Clean build
./mvnw clean compile

# Package application
./mvnw clean package

# Run tests
./mvnw test

# Run application
./mvnw spring-boot:run

# Skip tests
./mvnw clean package -DskipTests
```

## 🎯 Migration from Movie Template

### Completed Changes
- ✅ Renamed `MovieWatchlistApplication` → `SpringMonApplication`
- ✅ Changed package `com.example` → `com.example.springmon`
- ✅ Transformed `Movie.java` → `BaseEntity.java`
- ✅ Updated `MovieController` → `ApiController`
- ✅ Renamed `MovieRepository` → `BaseRepository`
- ✅ Updated Maven artifact: `springmon`
- ✅ Generic configuration and endpoints

### Generic Structure Created
- 📁 **controller/** - REST API layer
- 📁 **service/** - Business logic layer  
- 📁 **repository/** - Data access layer
- 📁 **model/** - Domain entities
- 📁 **config/** - Application configuration

## 🚀 Production Readiness

### For Production Deployment
1. Switch to PostgreSQL database
2. Configure environment-specific properties
3. Add Spring Security if authentication needed
4. Configure logging (Logback)
5. Add monitoring (Prometheus/Grafana)
6. Set up CI/CD pipeline

### Environment Profiles
- **dev**: H2 database, debug logging
- **test**: In-memory database, test configuration  
- **prod**: PostgreSQL, production logging

---

**SpringMon** è ora pronto per essere utilizzato come base per qualsiasi applicazione Spring Boot! 🎉
