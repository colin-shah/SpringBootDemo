# SpringBootDemo

### Versions
- Java 11
- Spring Boot 2.5.7

### API Details
- POST http://localhost:8080/api/user 
-- {
  "name" : "Shah Colin"
  }
- GET http://localhost:8080/api/user
-- [
  {
  "id": 1,
  "name": "Colin Shah"
  }
  ]
- GET http://localhost:8080/api/user/1 
  -- {
  "id": 1,
  "name": "Colin Shah"
  }
  
### Run Tests:
- ./gradlew clean test

### Run application
- ./gradlew bootRun
