# Hotelier Project

## Overview
The Hotelier project was developed as part of the coursework for the subject **Design and Analysis of Information Systems (MAS)**. 
The aim of this subject is to integrate the conceptual domain model, derived from the analysis and specification of requirements phase, into a concrete implementation environment (both object-oriented and relational). 
The project covers the construction and implementation of data structures, business logic, and user interfaces.

## Course Information
**Design and Analysis of Information Systems (MAS)** focuses on:
- Embedding conceptual models into specific implementation environments.
- Realizing necessary constructions not present in the chosen programming language.
- Discussing elements related to the usability and testing of graphical user interfaces.
- Practical implementation of data structures, business logic, and user interfaces using dedicated editors.


## Project Description
The Hotelier project is a comprehensive hotel management system that includes various functionalities to manage hotel resources, reservations, employees, guests, and more. This project demonstrates the integration of theoretical knowledge into a practical application.

## Features
- **Resource Management**: Manage hotel resources with associations to hotels and orders.
- **Order Management**: Create and manage orders with resources and employees.
- **Reservation System**: Book and manage reservations for rooms, linking guests and employees.
- **User Interfaces**: Develop user-friendly graphical interfaces for different roles within the hotel management system.


## Classes and Their Descriptions
### Resource
Represents hotel resources such as rooms, equipment, etc. Includes associations to orders and hotels.

### Order
Manages orders within the hotel, linking resources and employees to specific orders.

### Reservation
Handles room reservations, linking guests to specific rooms with detailed information on the reservation period and preferences.

### Room
Represents individual rooms within a hotel, including reservations and availability status.

### HotelResource
Manages resources associated with the hotel, including the quantities and types of resources available.

### HotelResourceAssociation
Represents the association between hotel resources and specific hotels, including additional attributes like quantity.

### Ticket
Represents helpdesk tickets raised by guests or staff, including details such as priority, status, and descriptions.

### UndercoverEmployee
Represents employees working undercover, inheriting from both Employee and IGuest interfaces.

## Usage
- **Resource Management**: Add, update, and remove hotel resources.
- **Order Management**: Create and manage orders, assign resources and employees.
- **Reservation System**: Book rooms, manage reservations, and view reservation details.
- **Helpdesk**: Raise and manage helpdesk tickets for issues and requests.

