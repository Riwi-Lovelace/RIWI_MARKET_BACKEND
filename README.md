# Riwi Market

## Description

Riwi Market is a complete store management system designed to streamline retail operations. It offers a suite of features to help manage inventory, track sales, manage employee functions efficiently and financial reporting to help store owners effectively manage their business. The system is developed using SpringBoot and MySQL, ensuring a robust and scalable solution for store management needs.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK):** Version 8 or higher, Make sure you can run SpringBoot applications
- **MySQL**: Install MySQL to manage your database.
- **Postman**: Have Postman installed for API testing and interaction.

## Installation

Follow these steps to install and set up Riwi Market:

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/Riwi-Lovelace/RIWI_MARKET_BACKEND
    cd RIWI_MARKET_BACKEND
    ```

2. **Set Up the Database**:
    - Create a new database in MySQL.
    - Update the database configuration in `application.properties` with your MySQL credentials.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    ```

3. **Build and Run the Application**:
    ```bash
    ./mvn spring-boot:run
    ```

## Functionalities

1. **Register Products**:
    - Use the product registration feature to keep your inventory updated.
    
2. **Generate Purchase Bills**:
    - Create and manage purchase bills directly through the system.

3. **Automatic Stock Management**:
    - The system automatically updates stock levels based on sales and purchases.

4. **View Sales Charts**:
    - Access detailed charts and reports on sales performance.

5. **Employee Management**:
    - Automatically calculate pay based on hours worked.
    - Use the role system to manage employee permissions and roles.

6. **Additional Features**:
    - Return invoice system for processing returns.
    - Daily earnings notifications to keep track of daily revenue.
    - Alerts for products nearing expiration.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
