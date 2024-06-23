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