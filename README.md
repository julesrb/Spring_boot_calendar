# Event Management Backend

## Overview

This is a **Spring Boot** backend for managing events. It provides a **REST API** to create, retrieve, and delete events. The backend supports filtering events by date range and retrieving events scheduled for today.

## Getting Started

### Prerequisites

Make sure you have the following installed on your system:

- **Java 17+**
- **Gradle**
- **Spring Boot**
- **Database (MySQL or H2 for testing)**

### Installation & Running the Project

1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   cd BackendCalendarEvents
   ```
2. **Build the project:**
   ```sh
   ./gradlew build
   ```
3. **Run the application:**
   ```sh
   ./gradlew run
   ```
   The server will start at [**http://localhost:8080**](http://localhost:8080).

## API Endpoints

### Get All Events

**GET** `/event`

- Retrieves all events or filters them by a date range.
- **Query Parameters:**
  - `start_time` (optional) - Start date filter.
  - `end_time` (optional) - End date filter.
- **Response:**
  ```json
  [
    {
      "id": 1,
      "name": "Event Name",
      "date": "2024-03-02"
    }
  ]
  ```

### Get Event by ID

**GET** `/event/{id}`

- Fetches a specific event by its ID.
- **Response:**
  ```json
  {
    "id": 1,
    "name": "Event Name",
    "date": "2024-03-02"
  }
  ```
- **Error Handling:**
  - Returns `404 Not Found` if the event doesn't exist.

### Create an Event

**POST** `/event`

- Creates a new event.
- **Request Body:**
  ```json
  {
    "name": "New Event",
    "date": "2024-03-02"
  }
  ```
- **Response:**
  ```json
  {
    "id": 2,
    "name": "New Event",
    "date": "2024-03-02",
    "status": "Added Successfully"
  }
  ```

### Delete an Event

**DELETE** `/event/{id}`

- Deletes an event by ID.
- **Response:**
  ```json
  {
    "id": 1,
    "name": "Deleted Event",
    "date": "2024-03-02"
  }
  ```
- **Error Handling:**
  - Returns `404 Not Found` if the event doesn't exist.

### Get Today's Events

**GET** `/event/today`

- Retrieves events occurring today.
- **Response:**
  ```json
  [
    {
      "id": 3,
      "name": "Today's Event",
      "date": "2024-03-02"
    }
  ]
  ```

## Error Handling

The backend throws **custom exceptions**:

- `404 Not Found`: If an event doesn't exist.
- `400 Bad Request`: If the request payload is invalid.

## Technologies Used

- **Spring Boot**
- **Spring Web & REST**
- **Spring Data JPA**
- **Gradle**
- **H2/MySQL Database**

