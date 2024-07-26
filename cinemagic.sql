CREATE DATABASE CineMagic;

USE CineMagic;

-- Create the Users table
CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_type ENUM('Spectator', 'Administrator') NOT NULL,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the Movies table
CREATE TABLE Movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    director VARCHAR(255),
    duration INT,  -- duration in minutes
    release_date DATE,
    genre VARCHAR(255)
);

-- Create the Schedules table
CREATE TABLE Schedules (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT,
    date DATE,
    time TIME,
    hall INT,
    FOREIGN KEY (movie_id) REFERENCES Movies(id)
);

-- Create the Seats table
CREATE TABLE Seats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hall INT,
    seat_row CHAR(1),  -- Seat row (A, B, C, etc.)
    number INT  -- Seat number
);

-- Create the Tickets table
CREATE TABLE Tickets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    schedule_id INT,
    seat_id INT,
    price DECIMAL(10, 2),
    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (schedule_id) REFERENCES Schedules(id),
    FOREIGN KEY (seat_id) REFERENCES Seats(id)
);

-- Create the Ratings table
CREATE TABLE Ratings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    movie_id INT,
    rating INT,  -- Rating from 1 to 5
    comment TEXT,
    rating_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (movie_id) REFERENCES Movies(id)
);

-- Insert initial records into the Users table
INSERT INTO Users (name, email, password, user_type) VALUES
('Alice Johnson', 'alice@example.com', 'password123', 'Spectator'),
('Bob Smith', 'bob@example.com', 'password123', 'Administrator'),
('Charlie Davis', 'charlie@example.com', 'password123', 'Spectator');

-- Insert initial records into the Movies table
INSERT INTO Movies (title, description, director, duration, release_date, genre) VALUES
('Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.', 'Christopher Nolan', 148, '2010-07-16', 'Sci-Fi'),
('The Dark Knight', 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.', 'Christopher Nolan', 152, '2008-07-18', 'Action');

-- Insert initial records into the Schedules table
INSERT INTO Schedules (movie_id, date, time, hall) VALUES
(1, '2024-07-21', '18:00:00', 1),
(1, '2024-07-21', '21:00:00', 1),
(2, '2024-07-21', '19:00:00', 2);

-- Insert initial records into the Seats table
INSERT INTO Seats (hall, seat_row, number) VALUES
(1, 'A', 1), (1, 'A', 2), (1, 'A', 3),
(1, 'B', 1), (1, 'B', 2), (1, 'B', 3),
(2, 'A', 1), (2, 'A', 2), (2, 'A', 3),
(2, 'B', 1), (2, 'B', 2), (2, 'B', 3);

-- Insert initial records into the Tickets table
INSERT INTO Tickets (user_id, schedule_id, seat_id, price) VALUES
(1, 1, 1, 10.00),
(2, 2, 2, 10.00);

-- Insert initial records into the Ratings table
INSERT INTO Ratings (user_id, movie_id, rating, comment) VALUES
(1, 1, 5, 'Amazing movie!'),
(2, 2, 4, 'Great action scenes.');
