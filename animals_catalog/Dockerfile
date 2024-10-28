# Используйте официальный образ OpenJDK
FROM openjdk:22

# Установите рабочую директорию
WORKDIR /app

# Скопируйте все Java файлы в контейнер
COPY src/ ./src/

# Компилируйте все Java файлы
# Компилируйте все Java файлы
RUN javac src/**/*.java

# Запустите ваше приложение (замените YourMainClass на имя вашего основного класса)
CMD ["java", "-cp", "src", "Main.java"]