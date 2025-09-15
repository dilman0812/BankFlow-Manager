-- Create Database
CREATE DATABASE IF NOT EXISTS bankmanagementsystem;

USE bankmanagementsystem;

-- Users Table for Signup Information
CREATE TABLE signup (
    formno VARCHAR(20), 
    name VARCHAR(20), 
    father_name VARCHAR(20), 
    dob VARCHAR(20), 
    gender VARCHAR(20), 
    email VARCHAR(30), 
    marital VARCHAR(20), 
    address VARCHAR(40), 
    city VARCHAR(25), 
    state VARCHAR(20), 
    pincode VARCHAR(25)
);
