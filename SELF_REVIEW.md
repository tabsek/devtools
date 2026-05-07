## Результаты само-ревью DVT-9

### Найденные проблемы

#### 1. Отладочный вывод в Main.java
**Файл:** `src/main/java/ru/ilya/power/ProgressTracker.java`  
**Проблема:** Файл по смыслу не подходящий проекту.  
**Почему важно:** Засоряет проект.
**Исправление:** Удалить `src/main/java/ru/ilya/power/ProgressTracker.java`.

#### 2. Опечатка в имени поля Student.java
**Файл:** `src/test/java/ru/ilya/power/ProgressTrackerTest.java`  
**Проблема:** тест к лишнему файлу   
**Почему важно:** Засоряет проект.  
**Исправление:** Удалить `src/test/java/ru/ilya/power/ProgressTrackerTest.java`.

#### 3. Дублирующий класс Student в двух пакетах
**Файл:** `src/main/java/ru/ilya/power/Student.java` и `src/main/java/ru/ilya/power/student/Student.java`  
**Проблема:** Два класса с именем `Student` в разных пакетах — неполный (`name`, `city`) и полный (все поля).  
**Почему важно:** Создаёт путаницу: непонятно какой `Student` использовать. Нарушает принцип единственного источника истины.  
**Исправление:** Удалить `ru.ilya.power.Student`, везде использовать `ru.ilya.power.student.Student`.