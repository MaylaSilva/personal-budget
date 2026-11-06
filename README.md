# Personal Budget
This project is a financial management system that automatically categorizes bank and credit card statements using Java (Spring Boot), Python, and n8n.

# 💰 Personal Budget & Automated Financial System

![Java 21](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=flat-square&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-blue?style=flat-square&logo=postgresql)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-Latest-orange?style=flat-square&logo=rabbitmq)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue?style=flat-square&logo=docker)

# How to execute the project

This project uses Docker to assure the enviroment runs consistently across any computer

## 1. Requirements
- Docker Desktop Installed
- Java 21+ Installed

## 2. Environment Settings
For security reasons, sensitive credentials are NOT stored in the repository.
Follow these steps to set up your enviroment:
- Locate the `.env.example` file;
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

### Architecture decisions ###
- UUID over Incremental ID: I chose to use UUIDs instead of auto-incrementing IDs to ensure identifier immutability and prevent data exposure via URL (mitigating ID Enumeration Attack);
- Abstract Base Classes: I implemented a hierarchy of abstract classes to standardize ID generation and basic registration fields. This ensures a consistent default for all entities and separates nominative records (Users, Vendors), from financial transaction data;
- Time Zone Integrity: Instead of local timestamps, I used OffsetDateTime to audit creation dates. This ensures data integrity and avoids ambiguity across different time zones, which is critical requirement for financial systems.
- Why PostgreSQL? I needed a DB that I can trust, with ACID, supports MVCC, rich native data types and because this DB is one of the most used on companies.