-- Bank Management System Database Schema
-- Creates the database and tables for the banking application

CREATE DATABASE IF NOT EXISTS bankmanagementsystem;
USE bankmanagementsystem;

-- Table for storing basic personal information (Signup One)
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

-- Table for storing financial and identification details (Signup Two)
CREATE TABLE signuptwo (
    formno VARCHAR(20),
    religion VARCHAR(20),
    category VARCHAR(20),
    income VARCHAR(20),
    education VARCHAR(20),
    occupation VARCHAR(30),
    pan VARCHAR(20),
    aadhar VARCHAR(20),
    senior_citizen VARCHAR(20),
    existing_account VARCHAR(20)
);

-- Table for storing account configuration and security details (Signup Three)
CREATE TABLE signupthree (
    formno VARCHAR(20),
    accountType VARCHAR(40),
    card_number VARCHAR(25),
    pin_number VARCHAR(10),
    facility VARCHAR(100)
);