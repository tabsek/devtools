## DVT-8 — GitHub Actions CI-пайплайн для автоматической проверки кода

[![Java CI](https://github.com/tabsek/devtools/actions/workflows/ci.yml/badge.svg)](https://github.com/tabsek/devtools/actions/workflows/ci.yml)

## Git локальный цикл
init → status → add → commit → branch → log

## Правило веток: feature/DVT-X
- master — всегда чистый
- feature/DVT-3 — работа по задаче №3

## DVT-4 — GitHub и первый Pull Request
## DVT-7 — Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: `./gradlew checkstyleMain`

### 1. Именование методов: camelCase

До:    `public void add_student(Student s) { }`
После: `public void addStudent(Student student) { }`

Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while

До:    `if(condition) {`
После: `if (condition) {`

Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: https://www.oracle.com/java/technologies/javase/codeconventions-statements.html

### 3. Длина строки: максимум 120 символов

До:    `public List getStudentsFromSpecificCityWithVeryLongMethodName(...`
После: `public List getStudentsByCity(String city) {`

Почему: длинные строки затрудняют чтение при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов: алфавитный

До:    `import java.util.List; import java.util.ArrayList;`
После: `import java.util.ArrayList; import java.util.List;`

Почему: алфавитный порядок упрощает поиск импортов.
Источник: https://www.jetbrains.com/help/idea/optimizing-imports.html

### 5. Обязательные фигурные скобки

До:    `if (condition) doSomething();`
После: `if (condition) { doSomething(); }`

Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used

## DVT-9 - Code Review

### Примеры Code Review комментариев

### Хорошие комментарии (конструктивные)

**Пример 1:**

**Проблема:** Метод `calculateDiscount` (строка 45) имеет 3 вложенных if-else и 40 строк.  
**Почему это важно:** Сложная вложенная логика плохо тестируется и тяжело поддерживается при изменениях.  
**Предложение:** Вынести каждое условие в отдельный метод (например, `isEligibleForBonusDiscount()`)
и использовать паттерн Strategy для разных типов скидок.

---

**Пример 2:**

**Проблема:** Тест `testProcessOrder` (строка 78) проверяет только успешный сценарий.  
**Почему это важно:** Не проверена обработка ошибок при недостаточном балансе — регрессия может остаться незамеченной.  
**Предложение:** Добавить тест `testProcessOrder_InsufficientBalance_ThrowsException()`
с использованием `assertThatThrownBy()`.

---

### Плохие комментарии (неконструктивные)

**Пример 1:**

> Этот код ужасен, полностью переписать.

**Почему плохо:** Нет конкретики (что именно плохо), нет предложения (как исправить), токсичный тон демотивирует автора.

---

**Пример 2:**

> Здесь лучше использовать Stream API.

**Почему плохо:** Нет объяснения почему лучше, нет примера как переписать, неясно какую проблему это решает.
