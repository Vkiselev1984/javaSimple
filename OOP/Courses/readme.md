# Some standard Java interfaces and examples of their use

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