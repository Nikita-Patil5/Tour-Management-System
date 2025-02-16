# Take-A-Tour Backend

## Overview
Take-A-Tour is a web application that allows users to plan, book, and manage tours. The backend is built with Spring Boot.

## Project Structure


## Setup
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

## Running the Application
1. Start the application:
    ```bash
    mvn spring-boot:run
    ```
2. The backend server will be running at [http://localhost:8080](http://_vscodecontentref_/2)

## API Endpoints

### User Authentication
- **POST /chkLogin**
  - Description: Check user login credentials.
  - Request Body: 
    ```json
    {
      "uid": "user123",
      "pwd": "password123"
    }
    ```
  - Response: 
    - [200 OK](http://_vscodecontentref_/3) if successful
    - `401 Unauthorized` if credentials are incorrect

### Planned Tours
- **GET /getallplantour**
  - Description: Fetch all planned tours.
  - Response: 
    ```json
    [
      {
        "tour_id": 1,
        "packageidobj": {
          "packagename": "Tour Package 1",
          "locations": "Location 1, Location 2"
        },
        "startdate": "2025-03-01",
        "lastdate": "2025-03-10",
        "availseats": 20,
        "lastdate_apply": "2025-02-25",
        "packageprice": 5000
      },
      ...
    ]
    ```
    - [200 OK](http://_vscodecontentref_/4) with a list of planned tours

- **POST /approvetour**
  - Description: Approve a planned tour.
  - Query Parameter: `tid` (tour ID)
  - Example: [http://localhost:8080/approvetour?tid=1](http://_vscodecontentref_/5)
  - Response: 
    - [200 OK](http://_vscodecontentref_/6) if successful
    - `500 Internal Server Error` if there is a server error

- **POST /rejecttour**
  - Description: Reject a planned tour.
  - Query Parameter: `tid` (tour ID)
  - Example: [http://localhost:8080/rejecttour?tid=1](http://_vscodecontentref_/7)
  - Response: 
    - [200 OK](http://_vscodecontentref_/8) if successful
    - `500 Internal Server Error` if there is a server error

### Tour Booking
- **POST /Booktourbytourist**
  - Description: Book a tour by a tourist.
  - Request Body: 
    ```json
    {
      "touristid": 1,
      "tourid": 1,
      "travellernumber": 2,
      "totamount": 10000,
      "paymenttype": "Credit Card"
    }
    ```
  - Response: 
    - [200 OK](http://_vscodecontentref_/9) if successful
    - `500 Internal Server Error` if there is a server error

- **POST /insertTravellerInfo**
  - Description: Insert traveller information.
  - Request Body: 
    ```json
    {
      "fname": "John",
      "lname": "Doe",
      "gender": "Male",
      "bdate": "1990-01-01",
      "orderid": 1
    }
    ```
  - Response: 
    - [200 OK](http://_vscodecontentref_/10) if successful
    - `500 Internal Server Error` if there is a server error

### Employee Management
- **POST /empReg**
  - Description: Register a new employee.
  - Request Body: 
    ```json
    {
      "uid": "emp123",
      "pwd": "password123",
      "e_fname": "Jane",
      "e_lname": "Doe",
      "e_email": "jane.doe@example.com",
      "e_contact": "1234567890",
      "e_designation": "Manager",
      "e_adharno": "1234-5678-9012",
      "e_bdate": "1985-05-15",
      "e_hiredate": "2025-01-01",
      "addressline": "123 Main St",
      "district": "District 1",
      "city": "City 1",
      "state": "State 1",
      "country": "Country 1",
      "postalcode": "123456"
    }
    ```
  - Response: 
    - [200 OK](http://_vscodecontentref_/11) if successful
    - `500 Internal Server Error` if there is a server error

### Package Management
- **POST /addPackage**
  - Description: Add a new package.
  - Request Body: 
    ```json
    {
      "packagename": "Tour Package 1",
      "locations": "Location 1, Location 2",
      "packageprice": 5000
    }
    ```
  - Response: 
    - [200 OK](http://_vscodecontentref_/12) if successful
    - `500 Internal Server Error` if there is a server error

- **GET /getallpackagesforemp**
  - Description: Fetch all packages for employees.
  - Response: 
    ```json
    [
      {
        "package_id": 1,
        "packagename": "Tour Package 1",
        "locations": "Location 1, Location 2",
        "packageprice": 5000
      },
      ...
    ]
    ```
    - [200 OK](http://_vscodecontentref_/13) with a list of packages

### Email Service
- **POST /email/sendemail**
  - Description: Send an email with optional attachment.
  - Request Parameters:
    - [recipient](http://_vscodecontentref_/14) (string, required): Recipient email address.
    - [subject](http://_vscodecontentref_/15) (string, required): Email subject.
    - [message](http://_vscodecontentref_/16) (string, required): Email message.
    - [file](http://_vscodecontentref_/17) (file, optional): Attachment file.
  - Response: 
    - [200 OK](http://_vscodecontentref_/18) if successful
    - `500 Internal Server Error` if there is a server error

