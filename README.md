# Personal Budget
This project is a financial management system that automatically categorizes bank and credit card statements using Java (Spring Boot), Python, and n8n.

# How to execute the project

This project uses Docker to assure the enviroment runs consistently across any computer

## 1. Requirements
- Docker Desktop Installed
- Java 17+ Installed

## 2. Enviroment Settings
For security reasons, sensitive credentials are NOT stored in the repository.
Follow these steps to set up your enviroment:
- Locate the `.env .example` file;
- Create a copy of this file and rename it to `.env`;
- This file already has some default credentials to facilitate your evaluation.

## 3. Building the Infrastructure
With your terminal open in the project root, execute the following command to start Postgres, RabbitMQ and N8N:
``docker-compose up -d``

## 4. Accessing the tools
Once the containers are running, the services will be available at:
- API Spring Boot: http://localhost:8080
- Painel RabbitMQ: http://localhost:15672 (User: admin | Pass: 1234)
- n8n Workflow: http://localhost:5678 (User: admin | Pass: 1234)

### Architecture decisions ###3
- UUID over Incremental ID: I chose to use UUIDs instead of auto-incrementing IDis to ensure identifier immutability and prevent data exposure via URL (mitigating ID Enumeration Attack);
- Abstract Base Classes: I implemented a hierarchy of abstract classes to standardize ID generation and basic registration fields. This ensures a consistent default for all entities and separates nominative records (Users, Vendors), from financial transaction data;
- Time Zone Integrity: Instead of local timestamps, I used OffsetDateTime to audit creation dates. This ensures data integrity and avoids ambiguity across different time zones, which is critical requirement for financial systems.