DROP DATABASE IF EXISTS cinemagic;
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
('Lewis Hamilton', 'lewis@example.com', 'password123', 'Spectator'),
('Max Verstappen', 'max@example.com', 'password123', 'Spectator'),
('Checo Perez', 'checo@example.com', 'password123', 'Administrator');


-- Insert initial records into the Movies table
INSERT INTO Movies (title, description, director, duration, release_date, genre) VALUES
('Back to the Future', 'Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, eccentric scientist Doc Brown.', 'Robert Zemeckis', 116, '1985-07-03', 'Adventure'),
('Ready Player One', 'When the creator of a virtual reality world called the OASIS dies, he releases a video in which he challenges all OASIS users to find his Easter Egg, which will give the finder his fortune.', 'Steven Spielberg', 140, '2018-03-29', 'Sci-Fi');

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
(2, 2, 4, 'Amazing scenes.');
