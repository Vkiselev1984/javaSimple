** Продумайте структуру класса Кот. Какие поля и методы будут актуальны для
приложения, которое является
* информационной системой ветеринарной клиники
* архивом выставки котов
* информационной системой Театра кошек Ю. Д. Куклачёва **

## Информационная система ветеринарной клиники:

### Поля:
* Имя кота
* Возраст кота
* Порода кота
* Информация о вакцинации
* Информация о последнем посещении ветеринара

### Методы
* Запись на прием к ветеринару
* Обновление информации о вакцинации
* Получение информации о состоянии здоровья кота

setAge, setName, setBreed, setVaccinationInfo, setLastVisitInfo
getName, getAge, getBreed, getVaccinationInfo, getLastVisitInfo, getHealthStatus
scheduleVetAppointment, updateVaccinationInfo, updateLastVisitInfo, getHealthStatus

## Архив выставки котов:

### Поля
* Имя кота
* Порода кота
* Достижения на выставках
* Фотографии кота

### Методы
* Добавление новых достижений на выставках
* Просмотр фотографий кота
* Поиск кота по имени или породе

setName, setBreed, setAchievements, setPhotos, setNameOrBreed, setBreedOrAchievements, setNameOrBreedAndPhotos
getBreed, getAchievements, getPhotos, getNameOrBreed, getBreedOrAchievements, getBreedOrAchievementsAndPhotos
addAchievements, viewPhotos, searchCat, searchCatByNameOrBreed, searchCatByNameOrBreedAndPhotos

## Информационная система Театра кошек Ю. Д. Куклачёва:

### Поля
* Имя кота
* Роль кота в представлении
* График выступлений
* Оценки и отзывы зрителей

### Методы
* Управление графиком выступлений кота
* Получение оценок и отзывов о выступлении
* Обновление информации о роли кота

setName, setRole, setSchedule, setRatings
getName, getRole, getSchedule, getRatings, getPerformanceRatingsAndReviews
managePerformanceSchedule, updateRoleInformation