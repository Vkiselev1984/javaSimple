## Task 1 - Data/model

- Create a package – model.
- Implement the abstract User class and its heirs Student and Teacher.

The parent has general data (for example: full name, year of birth, etc.), and the heirs have their own parameters (which ones, according to your choice – an example: student Id for Student, TeacherID for Teacher).

## Task 2 - Service

- Create a DataService class with methods in the User entity management (create, read) and aggregating all users logged into the system;
- studentIds must be created according to the algorithm – the maximum id in the collection is + 1. The same is true for Teacher Id. Solution is through iterating over the elements and instanceOf.

## Task 3 - View

Create a StudentView class containing a method for displaying student data submitted to the console.

## Task 4 - Controller

Create a Controller class aggregating the necessary classes in the form of fields, and initialize them directly in the field.

- Creating a Student Creation method – implementing the logic by calling the appropriate interface methods:
  - Creating a Student in the service
  - The return of all students in the service
  - Calling the view and sending the list of found students

## Task 5

- Create a Study Group class containing the Teacher and Student list fields;
- Create a class of a training service group in which the function is implemented (input parameters - (Teacher, List<Strudent>)) formation of a study group of Students and a teacher and his return;
- Create a method in the Controller in which the functions of obtaining a list of students (their id) and a teacher (his id) and forming a study group are aggregated by calling the method from the service;
- Create all of the above according to the principles of the PLO, passed at the seminar.

## Task 6

Demonstrate the application of SOLID principles.
It is necessary to comment on the sections of code in the project that we refactor, which principle apply and why

The code provided follows the Single Responsibility Principle by separating concerns into specific classes with distinct responsibilities.

Each class is responsible for a specific aspect of the application, such as data management, user representation, user interactions, and view display.

This separation of concerns makes the codebase easier to maintain, understand, and extend.

The Model-View-Controller (MVC) architectural pattern is utilized in the codebase, where the Controller handles user interactions, the Model represents the data and business logic, and the View displays information to the user.

This separation allows for better organization and modularity in the application.

The User class serves as a base class for both Student and Teacher, encapsulating common attributes like full name and birth year.

This inheritance hierarchy promotes code reusability and adheres to the DRY (Don't Repeat Yourself) principle.

The Service classes (StudentService, TeacherService, StudyGroupService, DataService) encapsulate specific operations related to students, teachers, study groups, and data management.

Each service class focuses on a single responsibility, such as creating, reading, or managing entities, which aligns with the SRP.

The DataService class manages data storage and retrieval using HashMaps to store students and teachers with unique identifiers.

This centralized data management approach simplifies data access and manipulation throughout the application.

The Controller class acts as an intermediary between user input and the underlying services, coordinating actions such as creating students, teachers, and study groups.

By delegating tasks to the appropriate service classes, the Controller maintains a clear separation of concerns and adheres to the SRP.

Overall, the codebase demonstrates good adherence to the SOLID principles, particularly the SRP, by organizing functionality into cohesive units with well-defined responsibilities.
