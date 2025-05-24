-- Create users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);

-- Create software table
CREATE TABLE software (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    access_levels TEXT NOT NULL
);

-- Create requests table
CREATE TABLE requests (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(id),
    software_id INTEGER REFERENCES software(id),
    access_type TEXT NOT NULL,
    reason TEXT NOT NULL,
    status TEXT NOT NULL
);
