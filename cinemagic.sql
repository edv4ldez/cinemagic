-- Drop existing database if it exists and create a new one
DROP DATABASE IF EXISTS CineMagic;
CREATE DATABASE CineMagic;

USE CineMagic;

-- Create Users table
CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_type ENUM('Customer', 'Admin') NOT NULL,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Movies table
CREATE TABLE Movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    director VARCHAR(255),
    duration INT,  -- duration in minutes
    release_date DATE,
    genre VARCHAR(255)
);

-- Create Halls table
CREATE TABLE Halls (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    total_seats INT NOT NULL
);

-- Create Schedules table with hall_id and time
CREATE TABLE Schedules (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT,
    hall_id INT,
    date DATE,
    time TIME,
    FOREIGN KEY (movie_id) REFERENCES Movies(id),
    FOREIGN KEY (hall_id) REFERENCES Halls(id) ON DELETE CASCADE,
    UNIQUE (movie_id, hall_id, date, time)  -- Ensure unique schedule for a movie in a hall at a specific date and time
);

-- Create Seats table with hall_id and a unique constraint
CREATE TABLE Seats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hall_id INT,
    seat_row CHAR(1),  -- Seat row (A, B, C, etc.)
    number INT,  -- Seat number
    isReserved BOOLEAN DEFAULT FALSE,  -- Default value set to FALSE
    FOREIGN KEY (hall_id) REFERENCES Halls(id) ON DELETE CASCADE,
    UNIQUE (hall_id, seat_row, number)  -- Ensure unique seat in a hall
);

-- Create Tickets table
CREATE TABLE Tickets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    schedule_id INT,
    seat_id INT,
    price DECIMAL(10, 2),
    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (schedule_id) REFERENCES Schedules(id) ON DELETE CASCADE,
    FOREIGN KEY (seat_id) REFERENCES Seats(id),
    UNIQUE (user_id, schedule_id, seat_id)  -- Ensure unique seat for a user per schedule
);

-- Create Ratings table
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

-- Insert initial data into Users table
INSERT INTO Users (name, email, password, user_type) VALUES
('Lewis Hamilton', 'lewis@example.com', 'password123', 'Customer'),
('Max Verstappen', 'max@example.com', 'password123', 'Customer'),
('Checo Perez', 'checo@example.com', 'password123', 'Admin');

-- Insert initial data into Movies table
INSERT INTO Movies (title, description, director, duration, release_date, genre) VALUES
('Back to the Future', 'Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, eccentric scientist Doc Brown.', 'Robert Zemeckis', 116, '1985-07-03', 'Adventure'),
('Ready Player One', 'When the creator of a virtual reality world called the OASIS dies, he releases a video in which he challenges all OASIS users to find his Easter Egg, which will give the finder his fortune.', 'Steven Spielberg', 140, '2018-03-29', 'Sci-Fi');

-- Insert initial data into Halls table
INSERT INTO Halls (name, total_seats) VALUES
('Hall 1', 30),
('Hall 2', 30);

-- Insert initial data into Schedules table
INSERT INTO Schedules (movie_id, hall_id, date, time) VALUES
(1, 1, '2024-07-21', '18:00:00'),
(1, 1, '2024-07-21', '21:00:00'),
(2, 2, '2024-07-21', '19:00:00');

-- Insert initial data into Seats table
INSERT INTO Seats (hall_id, seat_row, number) VALUES
(1, 'A', 1), (1, 'A', 2), (1, 'A', 3),
(1, 'B', 1), (1, 'B', 2), (1, 'B', 3),
(2, 'A', 1), (2, 'A', 2), (2, 'A', 3),
(2, 'B', 1), (2, 'B', 2), (2, 'B', 3);

-- Insert initial data into Tickets table
INSERT INTO Tickets (user_id, schedule_id, seat_id, price) VALUES
(1, 1, 1, 10.00),
(2, 2, 2, 10.00);

-- Insert initial data into Ratings table
INSERT INTO Ratings (user_id, movie_id, rating, comment) VALUES
(1, 1, 5, 'Amazing movie!'),
(2, 2, 4, 'Amazing scenes.');

select * from Tickets;
