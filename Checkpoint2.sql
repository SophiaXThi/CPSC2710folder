/* 
Create the tables
*/

CREATE TABLE Employee (
    Employee_ID INT PRIMARY KEY,
    First_Name VARCHAR(50) NOT NULL,
    Last_Name VARCHAR(50) NOT NULL,
    Role VARCHAR(50) NOT NULL
);

/* 
Include the types of employees here to make sure all of them have been accounted for
Use the REFERENCE KEYWORD as these tables have an IS-A relationship to the Employee table    
*/

CREATE TABLE Administrator (
    Admin_ID INT PRIMARY KEY,
    Employee_ID INT,
    FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID)
);

CREATE TABLE Nurse (
    Nurse_ID INT PRIMARY KEY,
    Employee_ID INT,
    FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID)
);

CREATE TABLE Technician (
    Tech_ID INT PRIMARY KEY,
    Employee_ID INT,
    FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID)
);

CREATE TABLE Doctor (
    Doctor_ID INT PRIMARY KEY,
    Employee_ID INT UNIQUE,
    Specialty VARCHAR(50),
    FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID)
);

-- ***************************************************************

CREATE TABLE Room (
    Room_Num INT PRIMARY KEY,
    Is_Occupied BOOLEAN
);

CREATE TABLE Patient (
    Patient_ID INT PRIMARY KEY,
    First_Name VARCHAR(50) NOT NULL,
    Last_Name VARCHAR(50) NOT NULL,
    Room_Num INT,
    Primary_Dr INT,
    FOREIGN KEY (Room_Num) REFERENCES Room(Room_Num),
    FOREIGN KEY (Primary_Dr) REFERENCES Doctor(Doctor_ID)
);

CREATE TABLE Insurance (
    Insurance_ID INT PRIMARY KEY,
    Provider_Name VARCHAR(50),
    Policy_Num VARCHAR(20)
);

CREATE TABLE Emergency_Contact (
    Contact_ID INT PRIMARY KEY,
    First_Name VARCHAR(50),
    Last_Name VARCHAR(50),
    Phone_Num VARCHAR(15),
    Relationship VARCHAR(50)
);

/*
Tables that have a relationship to patient
*/

CREATE TABLE Patient_Insurance (
    Patient_ID INT,
    Insurance_ID INT,
    PRIMARY KEY (Patient_ID, Insurance_ID),
    FOREIGN KEY (Patient_ID) REFERENCES Patient(Patient_ID),
    FOREIGN KEY (Insurance_ID) REFERENCES Insurance(Insurance_ID)
);

CREATE TABLE Patient_Contact (
    Patient_ID INT,
    Contact_ID INT,
    PRIMARY KEY (Patient_ID, Contact_ID),
    FOREIGN KEY (Patient_ID) REFERENCES Patient(Patient_ID),
    FOREIGN KEY (Contact_ID) REFERENCES Emergency_Contact(Contact_ID)
);

--*******************************************************************

CREATE TABLE Admission (
    Admission_ID INT PRIMARY KEY,
    Patient_ID INT,
    Admission_Date DATE,
    Diagnosis_ID INT,
    Diagnosis VARCHAR(255),
    Discharge_Date DATE,
    FOREIGN KEY (Patient_ID) REFERENCES Patient(Patient_ID)
);

CREATE TABLE Doctor_Patient_Assignment (
    Assignment_ID INT PRIMARY KEY,
    Admission_ID INT,
    Doctor_ID INT,
    FOREIGN KEY (Admission_ID) REFERENCES Admission(Admission_ID),
    FOREIGN KEY (Doctor_ID) REFERENCES Doctor(Doctor_ID)
);

CREATE TABLE Treatment (
    Treatment_ID INT PRIMARY KEY,
    Patient_ID INT,
    Doctor_ID INT,
    Tech_ID INT, 
    Nurse_ID INT,
    Procedures VARCHAR(255),
    Medication VARCHAR(255),
    Descriptions TEXT,
    Order_Timestamp TIMESTAMP,
    FOREIGN KEY (Patient_ID) REFERENCES Patient(Patient_ID),
    FOREIGN KEY (Doctor_ID) REFERENCES Doctor(Doctor_ID)
);


/* 
Insert into tables
*/

/* 
Insert sample data into Employee table */
INSERT INTO Employee (Employee_ID, First_Name, Last_Name, Role) 
VALUES 
(1, 'Michael', 'Smith', 'Administrator'),
(2, 'Christopher', 'Johnson', 'Doctor'),
(3, 'Samantha', 'Brown', 'Nurse'),
(4, 'Vincent', 'Davis', 'Technician'),
(5, 'Miles', 'Wright', 'Administrator'),
(6, 'Claire', 'Jones', 'Doctor'),
(7, 'Simone', 'Lee', 'Nurse'),
(8, 'Alicia', 'Davies', 'Technician'),
(9, 'Heather', 'Anderson', 'Administrator'),
(10, 'Meredith', 'Grey', 'Doctor'),
(11, 'Olivia', 'Jenkins', 'Nurse'),
(12, 'Sean', 'Byrd', 'Technician'),
(13, 'Joshua', 'Reed', 'Doctor'),
(14, 'Daniel', 'Harris', 'Administrator'),
(15, 'Emily', 'Walker', 'Nurse'),
(16, 'Madison', 'King', 'Technician'),
(17, 'James', 'Hill', 'Doctor'),
(18, 'Elizabeth', 'Scott', 'Nurse'),
(19, 'Matthew', 'Green', 'Administrator'),
(20, 'Sophia', 'Young', 'Technician'),
(21, 'Lucas', 'Baker', 'Doctor'),
(22, 'Emma', 'Carter', 'Nurse'),
(23, 'Alexander', 'Parker', 'Administrator'),
(24, 'Isabella', 'Evans', 'Technician'),
(25, 'Benjamin', 'Phillips', 'Doctor'),
(26, 'Ava', 'Campbell', 'Nurse'),
(27, 'Nathan', 'Mitchell', 'Technician'),
(28, 'Abigail', 'Roberts', 'Administrator'),
(29, 'Ethan', 'Turner', 'Doctor'),
(30, 'Chloe', 'Perez', 'Nurse'),
(31, 'Jacob', 'Collins', 'Technician'),
(32, 'Victoria', 'Edwards', 'Administrator'),
(33, 'Andrew', 'Morris', 'Doctor'),
(34, 'Ella', 'Stewart', 'Nurse'),
(35, 'William', 'Rogers', 'Technician'),
(36, 'Grace', 'Cook', 'Administrator'),
(37, 'Henry', 'Morgan', 'Doctor'),
(38, 'Avery', 'Bell', 'Nurse'),
(39, 'Ryan', 'Murphy', 'Technician'),
(40, 'Lily', 'Bailey', 'Administrator'),
(41, 'Aaron', 'Rivera', 'Doctor'),
(42, 'Zoey', 'Cooper', 'Nurse'),
(43, 'Justin', 'Richardson', 'Technician'),
(44, 'Natalie', 'Howard', 'Administrator'),
(45, 'Logan', 'Ward', 'Doctor'),
(46, 'Hannah', 'Peterson', 'Nurse'),
(47, 'Adam', 'Gray', 'Technician'),
(48, 'Charlotte', 'Watson', 'Administrator'),
(49, 'Jack', 'Brooks', 'Doctor'),
(50, 'Scarlett', 'Powell', 'Nurse');


/* 
Insert sample data into Administrator table 
*/
INSERT INTO Administrator (Admin_ID, Employee_ID) VALUES
(1, 1),
(2, 5),
(3, 9),
(4, 14),
(5, 19),
(6, 23),
(7, 28),
(8, 32),
(9, 36),
(10, 40),
(11, 44),
(12, 48);


/* Insert sample data into Doctor table */
INSERT INTO Doctor (Doctor_ID, Employee_ID, Specialty) VALUES 
(1, 2, 'Cardiology'),
(2, 6, 'Pediatrics'),
(3, 10, 'Neurology'),
(4, 13, 'Oncology'),
(5, 17, 'Orthopedics'),
(6, 21, 'Dermatology'),
(7, 25, 'General Surgery'),
(8, 29, 'Psychiatry'),
(9, 33, 'Radiology'),
(10, 37, 'Endocrinology'),
(11, 41, 'Urology'),
(12, 45, 'Gastroenterology'),
(13, 49, 'Pulmonology');




/* Insert sample data into Nurse table */
INSERT INTO Nurse (Nurse_ID, Employee_ID) VALUES 
(1, 3), 
(2, 7), 
(3, 11), 
(4, 15), 
(5, 18), 
(6, 22), 
(7, 26), 
(8, 30), 
(9, 34), 
(10, 38), 
(11, 42), 
(12, 46), 
(13, 50); 



/* Insert sample data into Technician table */
INSERT INTO Technician (Tech_ID, Employee_ID) VALUES 
(1, 4), 
(2, 8), 
(3, 12), 
(4, 16), 
(5, 20), 
(6, 24), 
(7, 27), 
(8, 31), 
(9, 35), 
(10, 39), 
(11, 43), 
(12, 47); 



/* Insert sample data for 20 rooms in the Room table */
INSERT INTO Room (Room_Num, Is_Occupied) VALUES 
(101, TRUE),
(102, TRUE),
(103, TRUE),
(104, TRUE),
(105, TRUE),
(106, TRUE),
(107, FALSE),
(108, FALSE),
(109, FALSE),
(110, FALSE),
(111, FALSE),
(112, FALSE),
(113, FALSE),
(114, FALSE),
(115, FALSE),
(116, FALSE),
(117, FALSE),
(118, FALSE),
(119, FALSE),
(120, FALSE);


/* Insert sample data into Patient table */
INSERT INTO Patient (Patient_ID, First_Name, Last_Name, Room_Num, Primary_Dr) VALUES 
 (1, 'Emily', 'White', 101, 1),
 (2, 'Frank', 'Black', 102, 1),
 (3, 'John', 'Watts', 103, 2),
 (4, 'Jeffery', 'Thomas', 104, 1),
 (5, 'John', 'Anderson', 105, 2),
 (6, 'Anthony', 'Thomas', 106, 1),
 (7, 'Sophia', 'Brown', 107, 3),
 (8, 'Grace', 'Wilson', 108, 4),
 (9, 'Mason', 'Davis', 109, 2),
 (10, 'Olivia', 'Clark', 110, 5),
 (11, 'Liam', 'Johnson', 111, 4),
 (12, 'Noah', 'Moore', 112, 3),
 (13, 'Ava', 'Taylor', 113, 6),
 (14, 'William', 'Miller', 114, 3),
 (15, 'Isabella', 'Anderson', 115, 5),
 (16, 'James', 'White', 116, 4),
 (17, 'Charlotte', 'Harris', 117, 6),
 (18, 'Benjamin', 'Martinez', 118, 2),
 (19, 'Amelia', 'Robinson', 119, 5),
 (20, 'Lucas', 'Garcia', 120, 6);


/* Insert sample data into Insurance table */
INSERT INTO Insurance (Insurance_ID, Provider_Name, Policy_Num) VALUES 
(1, 'Aetna', 'HP12345'),
(2, 'MediCare', 'MC67890'),
(3, 'Tricare', 'AB12345'),
(4, 'BCBS', 'BCBS678'),
(5, 'Cigna', 'CW12345'),
(6, 'Kaiser', 'KZ67890'),
(7, 'UnitedHealth', 'UH43210'),
(8, 'Humana', 'HU76543'),
(9, 'Aetna', 'HP98765'),
(10, 'MediCare', 'MC54321'),
(11, 'Cigna', 'CW98765'),
(12, 'Tricare', 'TR54321'),
(13, 'Kaiser', 'KZ12345'),
(14, 'BCBS', 'BCBS123'),
(15, 'UnitedHealth', 'UH67890'),
(16, 'Humana', 'HU12345'),
(17, 'Cigna', 'CW43210'),
(18, 'MediCare', 'MC87654'),
(19, 'Aetna', 'HP67890'),
(20, 'Kaiser', 'KZ54321');


/* Insert sample data into Emergency_Contact table */
INSERT INTO Emergency_Contact (Contact_ID, First_Name, Last_Name, Phone_Num, Relationship) VALUES 
(1, 'Grace', 'Hernandez', '601-555-1234', 'Mother'),
(2, 'Henry', 'Smith', '601-555-5678', 'Father'),
(3, 'Jack', 'Watts', '601-237-1234', 'Child'),
(4, 'Hank', 'Williams', '601-235-9785', 'Friend'),
(5, 'Anna', 'Morgan', '601-237-4953', 'Spouse'),
(6, 'Anders', 'Wilks', '601-235-9788', 'Spouse'),
(7, 'Linda', 'Brown', '601-555-9102', 'Sister'),
(8, 'James', 'Taylor', '601-555-3345', 'Brother'),
(9, 'Sophia', 'Carter', '601-555-8921', 'Daughter'),
(10, 'Samuel', 'Green', '601-555-1142', 'Son'),
(11, 'Evelyn', 'Johnson', '601-555-2348', 'Friend'),
(12, 'Oliver', 'Martinez', '601-555-9475', 'Cousin'),
(13, 'Isabella', 'Garcia', '601-555-8274', 'Grandmother'),
(14, 'William', 'Lopez', '601-555-6143', 'Grandfather'),
(15, 'Sophia', 'Kim', '601-555-3347', 'Aunt'),
(16, 'Daniel', 'Moore', '601-555-1128', 'Uncle'),
(17, 'Emily', 'Rivera', '601-555-8814', 'Niece'),
(18, 'Benjamin', 'Cooper', '601-555-9911', 'Nephew'),
(19, 'Charlotte', 'Young', '601-555-5467', 'Mother-in-law'),
(20, 'Jackson', 'Hall', '601-555-7134', 'Father-in-law');


/* Insert sample data into Patient_Insurance table */
INSERT INTO Patient_Insurance (Patient_ID, Insurance_ID) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8), 
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18), 
(19, 19),
(20, 20);


/* Insert sample data into Patient_Contact table */
INSERT INTO Patient_Contact (Patient_ID, Contact_ID) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8), 
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18), 
(19, 19),
(20, 20);


/* Insert sample data into Admission table */
INSERT INTO Admission (Admission_ID, Patient_ID, Admission_Date, Diagnosis_ID, Diagnosis, Discharge_Date) VALUES
 (1, 1, '2023-10-01', 1, 'Flu', '2023-10-10'),
 (2, 2, '2023-10-05', 2, 'Fractured Leg', NULL),
 (3, 3, '2023-10-06', 3, 'Broken Arm', '2023-10-10'),
 (4, 4, '2023-10-06', 4, 'Flu', '2023-10-12'),
 (5, 5, '2023-10-07', 5, 'Stomach Virus', '2023-10-13'),
 (6, 6, '2023-10-07', 6, 'Covid', NULL),
 (7, 7, '2023-10-15', 7, 'Pneumonia', NULL),
 (8, 8, '2023-10-16', 1, 'Sprain ankle', '2023-10-16'),
 (9, 9, '2023-12-17', 2, 'Heart attack', NULL),
 (10, 10, '2023-12-19', 3, 'Kidney infection', '2023-12-20'),
 (11, 11, '2024-01-01', 4, 'Seizure', '2024-01-01'),
 (12, 12, '2024-01-02', 5, 'Stomach Virus', '2024-01-02'),
 (13, 13, '2024-01-15', 6, 'Covid', NULL),
 (14, 14, '2024-01-22', 7, 'Pneumonia', NULL),
 (15, 15, '2024-01-23', 5, 'Stomach Virus', '2024-01-24'),
 (16, 16, '2024-01-31', 6, 'Heart attack', NULL),
 (17, 17, '2024-02-02', 7, 'Pneumonia', NULL),
 (18, 18, '2024-02-03', 5, 'Broken arm', '2024-02-03'),
 (19, 19, '2024-02-05', 6, 'Covid', NULL),
 (20, 20, '2024-02-22', 7, 'Pneumonia', NULL),


/* Add return visits for some patients */
 (21, 1, '2023-11-01', 1, 'Flu', '2023-11-07'), -- Return visit for Emily White
 (22, 3, '2023-11-03', 8, 'Sprained Wrist', '2023-11-10'), -- Return visit for John Watts
 (23, 4, '2023-11-04', 9, 'Sinus Infection', '2023-11-09'), -- Return visit for Jeffery Thomas
 (24, 5, '2023-11-05', 10, 'Food Poisoning', '2023-11-11'), -- Return visit for John Anderson
 (25, 6, '2023-11-06', 6, 'Covid', '2023-11-20'), -- Continued care for Anthony Thomas
 (26, 7, '2023-11-07', 7, 'Asthma Attack', '2023-11-15'); -- Return visit for Emily White



/* Insert sample data into Doctor_Patient_Assignment table */
INSERT INTO Doctor_Patient_Assignment (Assignment_ID, Admission_ID, Doctor_ID)
VALUES 
(1, 1, 1), -- Patient 1 assigned to Doctor 1
(2, 2, 1), -- Patient 2 assigned to Doctor 1
(3, 3, 2), -- Patient 3 assigned to Doctor 2
(4, 4, 3), -- Patient 4 assigned to Doctor 3
(5, 5, 4), -- Patient 5 assigned to Doctor 4
(6, 6, 5), -- Patient 6 assigned to Doctor 5
(7, 7, 6), -- Patient 7 assigned to Doctor 6
(8, 8, 7), -- Patient 8 assigned to Doctor 7
(9, 9, 8), -- Patient 9 assigned to Doctor 8
(10, 10, 9), -- Patient 10 assigned to Doctor 9
(11, 11, 10), -- Patient 11 assigned to Doctor 10
(12, 12, 11), -- Patient 12 assigned to Doctor 11
(13, 13, 12), -- Patient 13 assigned to Doctor 12
(14, 14, 13), -- Patient 14 assigned to Doctor 13
(15, 15, 1), -- Patient 15 assigned to Doctor 1
(16, 16, 2), -- Patient 16 assigned to Doctor 2
(17, 17, 3), -- Patient 17 assigned to Doctor 3
(18, 18, 4), -- Patient 18 assigned to Doctor 4
(19, 19, 5), -- Patient 19 assigned to Doctor 5
(20, 20, 6), -- Patient 20 assigned to Doctor 6
-- Repeat visits
(21, 21, 1),  
(22, 22, 3),  
-- Repeat visit with a new doctor
(23, 23, 4),  
(24, 24, 5), 
(25, 25, 6), 
(26, 26, 7);  


/* Insert sample data into Treatment table */
INSERT INTO Treatment (Treatment_ID, Patient_ID, Doctor_ID, Tech_ID, Nurse_ID, Procedures, Medication, Descriptions, Order_Timestamp)
VALUES
-- Treatments for Patient 1
(1, 1, 1, 2, 3, 'X-Ray', 'Ibuprofen', 'Administered pain reliever after X-Ray procedure.', '2023-10-01 10:00:00'),
(2, 1, 1, NULL, 3, 'Blood Test', 'Vitamin C Supplement', 'Prescribed supplements after routine blood test.', '2023-10-03 14:00:00'),
-- Treatments for Patient 2 (Discharge pending)
(3, 2, 1, 4, NULL, 'CT Scan', 'Antibiotics', 'CT Scan for fractured leg; antibiotics prescribed.', '2023-10-05 09:30:00'),
-- Treatments for Patient 3
(4, 3, 2, 5, 6, 'Surgery', 'Anesthetic', 'Surgery for broken arm; anesthetic administered.', '2023-10-06 08:00:00'),
(5, 3, 2, NULL, 6, 'Physical Therapy', NULL, 'Scheduled post-surgery therapy session.', '2023-10-10 15:00:00'),
-- Treatments for Patient 4
(6, 4, 3, 7, NULL, 'Flu Test', 'Tamiflu', 'Administered Tamiflu for flu symptoms.', '2023-10-06 11:30:00'),
-- Treatments for Patient 5
(7, 5, 4, NULL, 8, 'Ultrasound', 'Antacid', 'Ultrasound to diagnose stomach issues; antacid prescribed.', '2023-10-07 13:45:00'),
-- Treatments for Patient 6 (Discharge pending)
(8, 6, 5, 9, 11, 'COVID Test', 'Paxlovid', 'Confirmed positive for COVID; antiviral medication provided.', '2023-10-07 16:30:00'),
-- Treatments for Patient 7
(9, 7, 6, 10, 12, 'Chest X-Ray', 'Antibiotics', 'X-Ray revealed pneumonia; antibiotics prescribed.', '2023-10-15 09:00:00'),
-- Repeat visit for Patient 1
(10, 1, 1, 2, NULL, 'MRI', 'Painkiller', 'Conducted MRI for further evaluation of recurring pain.', '2023-10-20 10:30:00'),
-- Repeat visit for Patient 3
(11, 3, 2, 5, 6, 'Physical Therapy', NULL, 'Continued post-surgery therapy session.', '2023-10-25 14:00:00'),
-- Treatments for remaining patients
(12, 8, 7, NULL, 3, 'Blood Test', 'Iron Supplement', 'Detected anemia; iron supplements prescribed.', '2023-10-16 12:00:00'),
(13, 9, 8, 4, NULL, 'MRI', 'Painkiller', 'MRI performed for chronic back pain.', '2023-10-17 10:00:00'),
(14, 10, 9, NULL, 5, 'Vaccination', NULL, 'Administered flu vaccine.', '2023-10-18 15:30:00'),
(15, 11, 10, 6, NULL, 'X-Ray', NULL, 'Routine X-Ray for monitoring post-surgery recovery.', '2023-10-19 11:45:00'),
(16, 12, 11, NULL, 7, 'CT Scan', 'Antibiotics', 'CT Scan for internal infection; antibiotics prescribed.', '2023-10-20 08:15:00');
