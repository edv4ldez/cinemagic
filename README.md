# Cinemagic API Documentation

Welcome to the Cinemagic API documentation. This guide provides detailed information on the various endpoints available in the Cinemagic system. The API is structured into different categories: Tickets, Users, Seats, Schedules, Ratings, Movies, and Halls.

## Base URL

All API endpoints use the base URL: http://localhost:8080

## Endpoints

### Tickets

- **Get Ticket By Id**
    - **URL:** `/tickets/{id}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/tickets/2`

- **Get All Tickets**
    - **URL:** `/tickets`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/tickets`

- **Create Ticket**
    - **URL:** `/tickets`
    - **Method:** POST
    - **Request Body:**
      ```json
      {
        "user": { "id": 1 },
        "schedule": { "id": 1 },
        "seat": { "id": 4 },
        "price": 10.00,
        "purchaseDate": "2024-07-28T14:30:00"
      }
      ```
    - **Example:** `http://localhost:8080/api/tickets`

- **Delete Ticket by ID**
    - **URL:** `/tickets/{id}`
    - **Method:** DELETE
    - **Example:** `http://localhost:8080/api/tickets/1`

### Users

- **Get Users**
    - **URL:** `/users`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/users`

- **Create User**
    - **URL:** `/users`
    - **Method:** POST
    - **Request Body:**
      ```json
      {
        "name": "Sebastian Vettel",
        "email": "sebastian@example.com",
        "password": "password123",
        "userType": "Customer",
        "registrationDate": "2024-07-24T14:48:00Z"
      }
      ```
    - **Example:** `http://localhost:8080/api/users`

- **Get User By Id**
    - **URL:** `/users/{id}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/users/3`

- **Delete User By Id**
    - **URL:** `/users/{id}`
    - **Method:** DELETE
    - **Example:** `http://localhost:8080/api/users/4`

### Seats

- **Create Seat**
    - **URL:** `/seats`
    - **Method:** POST
    - **Headers:**
        - `Content-Type: application/json`
    - **Request Body:**
      ```json
      {
        "hall": { "id": 1 },
        "seatRow": "A",
        "number": 7,
        "isReserved": false
      }
      ```
    - **Example:** `http://localhost:8080/api/seats`

- **Get Seats by Hall**
    - **URL:** `/seats/hall/{hallId}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/seats/hall/1`

### Schedules

- **Create Schedule**
    - **URL:** `/schedules`
    - **Method:** POST
    - **Request Body:**
      ```json
      {
        "movie": { "id": 1 },
        "date": "2024-07-21",
        "time": "18:00:00",
        "hall": { "id": 2 }
      }
      ```
    - **Example:** `http://localhost:8080/api/schedules`

- **Get Schedule by ID**
    - **URL:** `/schedules/{id}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/schedules/1`

- **Get All Schedules**
    - **URL:** `/schedules`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/schedules`

- **Get Schedules by Movie ID**
    - **URL:** `/schedules/movie/{movieId}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/schedules/movie/1`

- **Get Schedules by Date**
    - **URL:** `/schedules/date/{date}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/schedules/date/2024-07-21`

- **Get Schedules by Hall**
    - **URL:** `/schedules/hall/{hallId}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/schedules/hall/1`

- **Delete Schedule by ID**
    - **URL:** `/schedules/{id}`
    - **Method:** DELETE
    - **Example:** `http://localhost:8080/api/schedules/3`

### Ratings

- **Create Rating**
    - **URL:** `/ratings`
    - **Method:** POST
    - **Request Body:**
      ```json
      {
        "user": { "id": 1 },
        "movie": { "id": 1 },
        "rating": 5,
        "comment": "Great movie!",
        "ratingDate": "2024-07-25T12:00:00Z"
      }
      ```
    - **Example:** `http://localhost:8080/api/ratings`

- **Get Rating by ID**
    - **URL:** `/ratings/{id}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/ratings/1`

- **Get All Ratings**
    - **URL:** `/ratings`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/ratings`

- **Get Ratings by User ID**
    - **URL:** `/ratings/user/{userId}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/ratings/user/1`

- **Get Ratings by Movie ID**
    - **URL:** `/ratings/movie/{movieId}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/ratings/movie/1`

- **Get Rating by User ID and Movie ID**
    - **URL:** `/ratings/user/{userId}/movie/{movieId}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/ratings/user/1/movie/1`

- **Update Rating**
    - **URL:** `/ratings/{id}`
    - **Method:** PUT
    - **Request Body:**
      ```json
      {
        "user": { "id": 1 },
        "movie": { "id": 1 },
        "rating": 4,
        "comment": "Updated comment.",
        "ratingDate": "2024-07-25T12:00:00Z"
      }
      ```
    - **Example:** `http://localhost:8080/api/ratings/1`

- **Delete Rating**
    - **URL:** `/ratings/{id}`
    - **Method:** DELETE
    - **Example:** `http://localhost:8080/api/ratings/1`

### Movies

- **Create or Update Movie**
    - **URL:** `/movies`
    - **Method:** POST
    - **Request Body:**
      ```json
      {
        "title": "Inception",
        "description": "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.",
        "director": "Christopher Nolan",
        "duration": 148,
        "releaseDate": "2010-07-16",
        "genre": "Sci-Fi"
      }
      ```
    - **Example:** `http://localhost:8080/api/movies`

- **Get Movie by ID**
    - **URL:** `/movies/{id}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/movies/1`

- **Get All Movies**
    - **URL:** `/movies`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/movies`

- **Get Movies by Title**
    - **URL:** `/movies/title/{title}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/movies/title/Inception`

- **Get Movies by Genre**
    - **URL:** `/movies/genre/{genre}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/movies/genre/Sci-Fi`

- **Get Movies by Director**
    - **URL:** `/movies/director/{director}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/movies/director/Christopher%20Nolan`

- **Delete Movie by ID**
    - **URL:** `/movies/{id}`
    - **Method:** DELETE
    - **Example:** `http://localhost:8080/api/movies/3`

### Halls

- **Create Hall**
    - **URL:** `/halls`
    - **Method:** POST
    - **Request Body:**
      ```json
      {
        "name": "Hall 1",
        "totalSeats": 30
      }
      ```
    - **Example:** `http://localhost:8080/api/halls`

- **Get Hall by ID**
    - **URL:** `/halls/{id}`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/halls/1`

- **Get All Halls**
    - **URL:** `/halls`
    - **Method:** GET
    - **Example:** `http://localhost:8080/api/halls`

- **Update Hall**
    - **URL:** `/halls/{id}`
    - **Method:** PUT
    - **Request Body:**
      ```json
      {
        "name": "Hall 1 Updated",
        "totalSeats": 40
      }
      ```
    - **Example:** `http://localhost:8080/api/halls/1`

- **Delete Hall by ID**
    - **URL:** `/halls/{id}`
    - **Method:** DELETE
    - **Example:** `http://localhost:8080/api/halls/2`

## Error Handling

The API responds with appropriate HTTP status codes and messages to indicate the success or failure of a request. Common responses include:

- **200 OK:** Request was successful.
- **201 Created:** Resource was created successfully.
- **204 No Content:** Resource was deleted successfully.
- **400 Bad Request:** Invalid request format or parameters.
- **404 Not Found:** Resource not found.
- **500 Internal Server Error:** Server encountered an unexpected condition.

For any additional questions or issues, please contact support or refer to the detailed error messages provided by the API.
