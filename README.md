**Car Dealership System**
**Tasks:**
  
1. **Login & Signup (Mohithi)**
Description:
* Implements user authentication for customers.
* Enables new users to sign up and existing users to log in.

Fields:
* User ID
* Name
* Email
* Password
* Phone Number

Events:
* User Registration
* User Login
* Password Encryption & Verification

2. **Add Cars (Ashish)**
Description:
* Allows admins to add new cars to the system.
* Stores relevant details for each car.

Fields:
* Car ID
* Make
* Model
* Year
* Price
* Color
* Status

Events:
* Add New Car Entry
* Validate Car Details

3. **Search Cars (Harsh)**
Description:
* Implements search functionality for available cars.
* Filters cars based on different criteria.

Fields:
* Search Query (Make, Model, Year, Price, etc.)

Events:
* Execute Search Query
* Display Matching Results

4. **Update Car Details (Ridhi)**
Description:
* Enables modifications to existing car details.
* Ensures accurate and updated car records.

Fields:
* Car ID
* Editable Fields (Make, Model, Price, Color, Status, etc.)

Events:
* Fetch Car Details
* Update Car Information

5. **Buy Car (Anna)**
Description:
* Handles car purchase transactions.
* Removes purchased cars from the available list.
* Adds purchase details to sales records.

Fields:
* Sale ID
* Car ID
* Buyer ID
* Sale Date
* Amount
* Payment Status

Events:
* Confirm Purchase
* Update Sales Record
* Remove Car from Inventory

6. **Delete Cars (Deanne)**

Description:
* Allows admins to remove cars from the system if they are no longer available.

Fields:
* Car ID

Events:
* Select car to delete
* Remove car from database

**Database Description:**

1. **Users Table**
* Stores customer details and login credentials.

Fields:
* user_id (Primary Key)
* name
* email (Unique)
* password
* phone_number

2. **Cars Table**
* Maintains records of available cars in the system.

Fields:
* car_id (Primary Key)
* make
* model
* year
* price
* color
* status (Available/Sold)
* km_driven
* no_owners

3. **Sales Table**
* Tracks car purchases by customers.

Fields:
* sale_id (Primary Key)
* car_id (Foreign Key referencing Cars)
* buyer_id (Foreign Key referencing Users)
* sale_date
* amount
* payment_status (Pending/Completed)
