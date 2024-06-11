# Some standard Java interfaces and examples of their use, generalizations

## Task 1 - Iterator
- Create a Student Class
- Create a Classroom Study Group
- Create an Iterator Learning Group class by making it implement the Iterator interface
- Implement its contracts (including deletion)

## Task 2 - Iterable
- Modify the Learning Group class by making it implement the Iterable interface
- Implement the iterator() method that returns an instance of the iterator we created
- Create a class of a learning service group, adding to it a method for deleting a student by full name
- Create a Controller class by adding a student deletion method to it and calling the created method from the Learning Group in it.

## Task 3 - Comparable
- Modify the Student's class by making it implement the interface Comparable
- Implement a compareTo () contract with a comparison by some parameter (example student Id)
- Modify the classroom of the Educational Service group by adding a method for sorting the list of students by id
- Modify the Controller class by adding a method for sorting the list of students by id and calling the created method in it from Educational Groupservice

## Task 4 - Comparator
- Create a Student Comparator class implementing the Comparator interface
- Implement a compare () contract with a comparison by some parameter (example: combination of First name+Last Name)
- Modify the classroom of the Educational Service group by adding to it a method for sorting the list of students by full name
- Modify the Controller class by adding a method for sorting the list of students by name and calling the created method in it from Educational Groupservice

## Task 4 - Comparator
- Create a Flow class containing a list of Study Groups and implementing the Iterator interface
- Create a StreamComparator class that implements a comparison of the number of groups included in the Stream
- Create a Streamservice class by adding a method to sort the list of streams using the created StreamComparator
- Modify the Controller class by adding the created service to it
- Modify the Controller class by adding a method sorting the list of threads to it by calling the created service

## Task 5
- Create a User class and transfer the basic fields ( full name ) to it. 
- Modify the previously created Student Comparator class
- Rename to the User Comparator
- Type it T inheriting from the User type ( T extends User )
- To type the implemented interface Comparator T
- Change the comparer method by typing T in the input data instead of specific classes
- Make edits to the place where the previous comparator was used

## Task 6
- Create a User View interface
- Type it T inherited from the User type
- Create the sendOnConsole(List<Student> students) method in it using typing
- Create a Student View class that implements the created interface

## Task 7
- Modify the previously created Controller class by renaming it to StudentController
- Create a new UserController interface
- Describe the create method in it
- Type it T inherited from the User type
- In the Student Controller class, implement the UserController interface
- Add console output to the controller methods using the sendOnConsole method

## Task 8
- Create a Teacher Service class and implement it in a similar way to what was done at the seminar
- Create a teacher 's class and implement it in the same way as the one discussed at the seminar
- Create a teacher controller class and implement the ability to create, edit a specific teacher and display a list of teachers available in the system