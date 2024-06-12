# Model-View-Controller 

«Модель-Представление-Контроллер» — схема разделения данных приложения и управляющей логики на три отдельных компонента: модель, представление и контроллер — таким образом, что модификация каждого компонента может осуществляться независимо.

- Модель (Model) предоставляет данные и реагирует на команды контроллера, изменяя своё состояние.
- Представление (View) отвечает за отображение данных модели пользователю, реагируя на изменения модели.
- Контроллер (Controller) интерпретирует действия пользователя, оповещая модель о необходимости изменений.

## Task 1 - Data/model

- Create a package – model.
- Implement the abstract User class and its heirs Student and Teacher.

The parent has general data (for example: full name, year of birth, etc.), and
the heirs have their own parameters (which ones, according to your choice – an example:
student Id for Student, TeacherID for Teacher)

## Task 2 - Service

- Create a package – service.
- Create a DataService class with methods in the User entity management (create, read) and aggregating all users logged into the system
- studentIds must be created according to the algorithm – the maximum id in the collection is + 1. The same is true for Teacher Id. Solution is through iterating over the elements and instanceOf