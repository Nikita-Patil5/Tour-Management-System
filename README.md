# Tour-Management-System

## Overview
Take-A-Tour is a web application that allows users to plan, book, and manage tours. The project consists of a frontend built with React and a backend built with Spring Boot.

## Project Structure


## Frontend

### Setup
1. Clone the repository:
    ```bash
    git clone <repository-url>
    ```
2. Navigate to the project directory:
    ```bash
    cd Take-A-Tour-Frontend
    ```
3. Install the dependencies:
    ```bash
    npm install
    ```

### Running the Application
1. Start the development server:
    ```bash
    npm start
    ```
2. Open your browser and navigate to `http://localhost:3000`

### Key Components
- `ApprovalPlanTourComponent.js`: Component for approving or rejecting planned tours.
- `BookTourComponent.js`: Component for booking tours.
- `SignUpTouristComponent.js`: Component for tourist registration.
- `AddEmployeeComponent.js`: Component for adding employees.
- `LoginComponent.js`: Component for user login.

### Styles
- `App.css`: Main CSS file for the application.
- `Style.css`: Additional styles for components.
- `loginstyle.css`: Styles specific to the login component.

## Backend

### Setup
1. Clone the repository:
    ```bash
    git clone <repository-url>
    ```
2. Navigate to the project directory:
    ```bash
    cd Take-A-Tour-Backend
    ```
3. Build the project:
    ```bash
    mvn clean install
    ```

### Running the Application
1. Start the application:
    ```bash
    mvn spring-boot:run
    ```
2. The backend server will be running at `http://localhost:8080`

### Key Endpoints

#### User Authentication
- **POST /chkLogin**
  - Description: Check user login credentials.
  - Request Body: `{ "uid": "string", "pwd": "string" }`
  - Response: `200 OK` if successful, `401 Unauthorized` if credentials are incorrect.

#### Planned Tours
- **GET /getallplantour**
  - Description: Fetch all planned tours.
  - Response: `200 OK` with a list of planned tours.

- **POST /approvetour**
  - Description: Approve a planned tour.
  - Query Parameter: `tid` (tour ID)
  - Response: `200 OK` if successful, `500 Internal Server Error` if there is a server error.

- **POST /rejecttour**
  - Description: Reject a planned tour.
  - Query Parameter: `tid` (tour ID)
  - Response: `200 OK` if successful, `500 Internal Server Error` if there is a server error.

#### Tour Booking
- **POST /Booktourbytourist**
  - Description: Book a tour by a tourist.
  - Request Body: `{ "touristid": "int", "tourid": "int", "travellernumber": "int", "totamount": "float", "paymenttype": "string" }`
  - Response: `200 OK` if successful, `500 Internal Server Error` if there is a server error.

- **POST /insertTravellerInfo**
  - Description: Insert traveller information.
  - Request Body: `{ "fname": "string", "lname": "string", "gender": "string", "bdate": "date", "orderid": "int" }`
  - Response: `200 OK` if successful, `500 Internal Server Error` if there is a server error.

#### Employee Management
- **POST /empReg**
  - Description: Register a new employee.
  - Request Body: `{ "uid": "string", "pwd": "string", "e_fname": "string", "e_lname": "string", "e_email": "string", "e_contact": "string", "e_designation": "string", "e_adharno": "string", "e_bdate": "date", "e_hiredate": "date", "addressline": "string", "district": "string", "city": "string", "state": "string", "country": "string", "postalcode": "string" }`
  - Response: `200 OK` if successful, `500 Internal Server Error` if there is a server error.

### Entities
- `Login.java`: Entity representing user login details.
- `Employee.java`: Entity representing employee details.

