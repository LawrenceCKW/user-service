# Capstone Project

A Spring Boot microservice that manages users (CRUD), credentials, roles/groups, and authentication hooks. Built for a microservices architecture (Gateway/Eureka-ready), with PostgreSQL as the primary datastore.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running Locally](#running-locally)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [Docker](#docker)
- [Troubleshooting](#troubleshooting)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)

---

## Overview
- <What problem it solves / core responsibilities>
- <Where it fits in the larger system>

## Features
- User CRUD: create, read, update, soft delete
- Credential management (hashed passwords)
- Role & group assignment
- JWT
- Pagination, sorting, and filtering
- Health checks & metrics (Actuator)
- Dockerized (app + PostgreSQL)
- CI-friendly (Maven)

## Tech Stack
- Language: Java 21
- Framework: Spring Boot 3.x
- Dependencies:
    - Spring Web
    - Spring Data JPA
    - PostgreSQL Driver
    - Lombok
    - JUnit 5, Spring Boot Test
- Build: Maven
- Database: PostgreSQL 15

## Prerequisites
- <JDK/Node/etc> version
- <Build tool> version
- <Docker> (optional)
- <Database> (if running locally)

## Installation
```bash
git clone https://github.com/<owner>/<repo>.git
cd <repo>
<build_command>    # e.g., mvn clean package -DskipTests
