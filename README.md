# EduAssess 🎓

**EduAssess** is an Educational Assessment and Preparation Platform designed to enhance student learning through a structured testing system. The platform offers trainers the ability to manage tests and monitor student progress, while students can prepare using video tutorials, attempt different types of tests, and view their results.

## 🛠️ Tech Stack

- **Frontend**: AngularJS, TypeScript, HTML, CSS
- **Backend**: Java, Spring Boot
- **Database**: MySQL
- **IDE**: VS Code, Spring Tool Suite 4

## 👥 Roles

### Trainer Interface
- Test Management (Written, MCQ, GTO)
- Question Management (Add/Edit/Delete Questions)
- Answer Verification (Manual review of written answers)
- Student Registration and Management
- Result Viewing (Written, MCQ, GTO)
- Video Session Uploads for preparation

### Student Interface
- Attempt **Written Tests** (400+ word answers)
- Attempt **MCQ Tests** (Auto-evaluated)
- Attempt **GTO - Guess the Output** (Auto-evaluated Java logic-based outputs)
- Watch Preparation **Videos**
- View Results for all test types

## 🔍 Key Features

- Auto evaluation for MCQ and GTO sections
- Manual evaluation for descriptive written answers
- Progress tracking for each student
- Video preparation library with category filters
- Trainer dashboard and student dashboard with login authentication

## ⚙️ How to Run Locally

### 1. Backend (Spring Boot)
- Import the project into **Spring Tool Suite 4**
- Set up your MySQL database and update `application.properties`
- Run the Spring Boot application

### 2. Frontend (AngularJS)
- Open the AngularJS project in **VS Code**
- Run `npm install` to install dependencies
- Start the frontend using `ng serve`

### 3. Database
- Create a MySQL database named `eduassess`
- Import the provided `.sql` file (if available) to create tables

## 📁 Project Structure
EduAssess/
│
├── backend/ # Spring Boot code
├── frontend/ # AngularJS project
├── database/ # SQL files (schema and seed data)
└── README.md # Project documentation



## 🧑‍💻 Author

**Vyankatesh Manohar Bankwad**  
- MCA, Anantrao Pawar College of Engineering and Research, Pune  
- Contact: [LinkedIn/GitHub if you want to include]

## 📃 License

This project is for academic and educational purposes only.
