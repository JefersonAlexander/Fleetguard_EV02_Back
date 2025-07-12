[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=JefersonAlexander_Fleetguard_EV02_Back&metric=bugs)](https://sonarcloud.io/summary/new_code?id=JefersonAlexander_Fleetguard_EV02_Back)

[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=JefersonAlexander_Fleetguard_EV02_Back&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=JefersonAlexander_Fleetguard_EV02_Back)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=JefersonAlexander_Fleetguard_EV02_Back&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=JefersonAlexander_Fleetguard_EV02_Back)

[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=JefersonAlexander_Fleetguard_EV02_Back&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=JefersonAlexander_Fleetguard_EV02_Back)

[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=JefersonAlexander_Fleetguard_EV02_Back&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=JefersonAlexander_Fleetguard_EV02_Back)

[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=JefersonAlexander_Fleetguard_EV02_Back&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=JefersonAlexander_Fleetguard_EV02_Back)

[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=JefersonAlexander_Fleetguard_EV02_Back&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=JefersonAlexander_Fleetguard_EV02_Back)

[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=JefersonAlexander_Fleetguard_EV02_Back&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=JefersonAlexander_Fleetguard_EV02_Back)

# Fleetguard_EV02_Back

Implementation of a microservices-based system with the following operations:

- Real-time location tracking of transport units  
- Create, update and delete transport units  
- Authenticate users and protect endpoints using **JWT**


The system is composed of:
- `microservice-fleetLocation` (location and transport unit management)
- `microservice-authentication` (user auth and JWT)
- `api-gateway` (entry point and route protection)
- `service-discovery` (Eureka)



## 📁 Folders Structure

- `microservice-fleetLocation/` → microservice fleet Location
- `microservice-authentication/` → microservice auth
- `api-gateway/` → gateway to route and filter requests
- `service-discovery/` → Eureka service 


## How to install it  
Execute:

```bash
$ mvnw spring-boot:run

```
to download the node dependencies


## How to test it 
Execute:

```bash
$ mvnw clean install

```

## How to get coverage test
Execute:

```bash
$ mvwn -B package -DskipTests --file pom.xml

```
