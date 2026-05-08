## Технологический стек проекта

### Языки и платформы
- **Java 25 LTS** — основной язык разработки
- **Gradle 8.x** — система сборки (через Gradle Wrapper)

### Инструменты качества кода
- **Checkstyle** — статический анализ стиля кода
    - Конфигурация: `config/checkstyle/checkstyle.xml`
    - Запуск: `./gradlew checkstyleMain`
- **JUnit 5** — фреймворк тестирования
    - Запуск: `./gradlew test`

### CI/CD
- **GitHub Actions** — автоматическая проверка PR
    - Конфигурация: `.github/workflows/`

### Правила кода
- Стиль: Google Java Style Guide (через Checkstyle)
- Коммиты: осмысленные сообщения на русском
- Ветки: `feature/DVT-X` от актуального `master`
- Pull Request: обязателен для слияния в `master`

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

## Информационный поиск — результаты DVT-11

### Запросы и источники

| № | Запрос | Операторы | Официальный источник | Альтернатива | Статус | Дата проверки |
|---|--------|-----------|----------------------|--------------|--------|---------------|
| 1 |Lombok Gradle Short |site:mvnrepository.com "lombok" |https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.46 | https://search.maven.org/artifact/org.projectlombok/lombok| 200 OK|08.05.2026|
| 2 |Java Stream API документация|site:docs.oracle.com "stream" java|https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/Stream.html|https://baeldung.com/java-8-streams|200 OK|08.05.2026|
| 3 |IntelliJ IDEA keymap|site:www.jetbrains.com/help "keymap" "intellij idea"|https://www.jetbrains.com/help/idea/settings-keymap.html|Help → Keymap Reference в IDE|200 OK|08.05.2026|

### AI-промпты и сравнение ассистентов

#### Промпт 1: План решения

**Задача:**  Добавить метод, который возвращает студентов, отсортированных по фамилии (поле lastName)

**Контекст:** Java 21, Gradle, у меня есть класс StudentList со списком студентов и методами addStudent, getStudentsFromCity, getSize

**Ограничения:** без использования Collections.sort() напрямую, учитывай что студенты могут иметь одинаковые фамилии

**Ожидаемый результат:** без использования Collections.sort() напрямую, учитывай что студенты могут иметь одинаковые фамилии

**Критерии успеха:** метод возвращает новый список, не изменяя исходный; одинаковые фамилии не вызывают ошибок

**AI-1 (Claude):**

## План решения: сортировка студентов по фамилии

**Контекст решения:** запрет на `Collections.sort()` напрямую — значит используем Stream API, который вызывает сортировку внутри себя иначе (через `TimSort` с `Comparator`), это семантически чище и соответствует Java 21 стилю.

---

### Шаг 1 — Определи возвращаемый тип метода

Метод должен возвращать `List<Student>` (не `void`, не оригинальный список).

**Почему:** критерий успеха требует *новый* список — оригинал не должен меняться. Возвращая новую коллекцию, ты соблюдаешь принцип immutability там, где это важно.

---

### Шаг 2 — Получи Stream из внутреннего списка

Создай поток из своего поля-списка через `.stream()`.

**Почему:** Stream API в Java не модифицирует источник — все операции создают новый pipeline. Это даёт тебе гарантию, что исходный список останется нетронутым без явного копирования.

---

### Шаг 3 — Применяй `.sorted()` с `Comparator`

Используй `.sorted(Comparator.comparing(Student::getLastName))`.

**Почему:** `Comparator.comparing()` — это null-safe фабричный метод, который использует `compareTo` строк под капотом. Он корректно обрабатывает одинаковые фамилии — студенты с равными `lastName` просто сохраняют *стабильный* относительный порядок (Stream sort стабилен по спецификации Java).

---

### Шаг 4 — Добавь вторичный критерий сортировки (опционально, но правильно)

Прицепи `.thenComparing(Student::getFirstName)` к компаратору.

**Почему:** одинаковые фамилии не вызовут ошибок и без этого, но результат будет недетерминирован при повторных вызовах. Вторичный ключ делает порядок предсказуемым — это важно для тестируемости и ожиданий пользователя метода.

---

### Шаг 5 — Собери результат через `.collect()`

Заверши цепочку через `.collect(Collectors.toList())` или `toUnmodifiableList()`.

**Почему:** `toUnmodifiableList()` — более явный сигнал вызывающему коду, что возвращённый список не предназначен для изменения. Это защищает контракт метода и документирует намерение без дополнительных комментариев.

---

### Итоговая структура метода (словами, без кода)

> Метод берёт внутренний список → создаёт Stream → сортирует по фамилии (и по имени как вторичный ключ) → собирает в новый неизменяемый список → возвращает его.

**Критерии выполнены:** исходный список не тронут ✓ · одинаковые фамилии обрабатываются стабильно ✓ · Java 21 стиль ✓ · `Collections.sort()` не используется ✓

**AI-2 (Deepseek):**

## План решения: сортировка студентов по фамилии

### Шаг 1: **Создать защитную копию текущего списка студентов**
**Почему именно так:** Исходный список должен оставаться неизменным (принцип неизменяемости данных). Возвращая новый список, мы избегаем побочных эффектов — вызывающий код может сортировать, фильтровать или модифицировать результат, не влияя на внутреннее состояние объекта `StudentList`. Это также соответствует ожиданию из критериев успеха.

### Шаг 2: **Реализовать сравнение студентов по полю lastName с использованием компаратора**
**Почему именно так:** Поскольку `Collections.sort()` использовать нельзя, нужно самостоятельно реализовать логику сравнения. Компаратор позволяет чётко определить критерий сортировки (поле `lastName`) и даёт контроль над обработкой одинаковых фамилий. Без компаратора пришлось бы реализовывать `Comparable` в классе `Student`, что жёстко привязало бы один способ сортировки и нарушило бы принцип единственной ответственности.

### Шаг 3: **Добавить вторичный критерий сортировки для студентов с одинаковыми фамилиями**
**Почему именно так:** Если ограничиться только сравнением по фамилии, студенты с одинаковой фамилией будут считаться равными, и их относительный порядок станет неопределённым (зависит от конкретной реализации сортировки). Добавление вторичного критерия (например, поле `firstName` или `id`) гарантирует детерминированный, стабильный и предсказуемый порядок, а также предотвращает ошибки, когда алгоритм сортировки ожидает строгого порядка.

### Шаг 4: **Применить алгоритм сортировки (например, пузырьком, вставками или быструю сортировку) к созданной копии**
**Почему именно так:** Без внешних утилит нужен собственный алгоритм. Выбор алгоритма зависит от ожидаемого размера данных: для небольших списков подойдут простые алгоритмы (вставками или пузырьком), для больших — эффективные (быстрая сортировка, слиянием). Главное — реализовать стабильную сортировку (если нужно сохранить исходный порядок равных элементов) и использовать компаратор из шагов 2-3 для сравнения.

### Шаг 5: **Вернуть отсортированную копию списка**
**Почему именно так:** Метод должен возвращать результат своей работы. Возвращая новый, отсортированный список (а не `void` и не модифицируя исходный), мы делаем API функциональным и предсказуемым. Вызывающий код может сразу использовать результат в цикле, передать в другой метод или сохранить, при этом оригинальные данные в `StudentList` остаются нетронутыми для других операций (например, для фильтрации по городу без повторной сортировки).

---

**Ключевое замечание:** На шаге 3 вторичный критерий критически важен для устойчивости — без него при одинаковых фамилиях некоторые алгоритмы сортировки могут работать некорректно или выдавать нестабильный результат.

**Сравнение:**

Что совпало в ответах обоих ассистентов

Подход к решению задачи от обоих ассисентов был похож

Что различалось (разные шаги, подходы, детали)

Разница в подробности объяснения и обосновании выбронного решения

Что выбрал и почему

Выбрал Claude, т.к. его объяснение было подробный и более аргументированным

#### Промпт 2: Проверка кода

**Код для проверки:**

**Что проверить:**
1. Логические ошибки
2. Соответствие Code Conventions
3. Производительность

**AI-1 (Claude):**

## Проверка кода

### 1. Логические ошибки и граничные случаи

**🔴 Критично: отсутствие null-проверок**

- `city` может быть `null` → `equals(city)` не выбросит исключение, но `s.city().equals(city)` выбросит `NullPointerException`, если `s.city()` вернёт `null`.
- Сам `studentList` может быть `null` → `.stream()` выбросит `NullPointerException`.

**Как исправить:**
- Использовать `Objects.equals(s.city(), city)` — он корректно обрабатывает `null` с обеих сторон.
- В начале метода добавить guard-clause: `if (studentList == null) return List.of();`
- Либо гарантировать инициализацию `studentList` в конструкторе как `new ArrayList<>()`.

---

### 2. Соответствие Java Code Conventions

**🟡 Незначительно: имя параметра лямбды**

`s` — слишком короткое и неинформативное имя. По конвенциям Java (и общим best practices для читаемости) лямбда-параметр должен отражать тип: `student`.

```java
//.filter(student -> Objects.equals(student.city(), city))
```

В остальном код соответствует конвенциям: именование метода в camelCase, возвращаемый тип явный, структура чистая.

---

### 3. Производительность

**O-нотация:** `O(n)` — линейный проход по списку, это оптимально для данной задачи без индексирования.

**🟡 Потенциально: повторные вызовы метода**

Если `getStudentsFromCity` вызывается часто с разными городами, каждый раз выполняется полный проход по списку.

**Как улучшить (если актуально):**
- Построить `Map<String, List<Student>>` один раз при инициализации через `Collectors.groupingBy(Student::city)` — тогда поиск станет `O(1)`.

**🟢 Хорошо:** использование `.toList()` (Java 16+) возвращает неизменяемый список — это правильное решение, защищающее внутреннее состояние.

---

### Итог

| # | Проблема | Приоритет |
|---|----------|-----------|
| 1 | `NullPointerException` при `null`-городе или `null`-поле | 🔴 Критично |
| 2 | `NullPointerException` если `studentList == null` | 🔴 Критично |
| 3 | Имя параметра `s` вместо `student` | 🟡 Минор |
| 4 | Нет кэширования при частых вызовах | 🟡 По ситуации |

**AI-2 (deepseek):**

## Анализ кода

### 1. Логические ошибки

**Проблема с null-значениями:**
- Если `city` (входной параметр) равен `null`, метод выбросит `NullPointerException` при вызове `s.city().equals(city)`
- Если `s.city()` для какого-то студента вернет `null`, то вызов `equals(city)` выбросит `NullPointerException`

**Граничные случаи:**
- При пустом `studentList` метод вернет пустой список (это корректно)
- Поиск чувствителен к регистру — `"Moscow"` и `"moscow"` считаются разными городами (может быть как логикой, так и ошибкой в зависимости от требований)

### 2. Соответствие Java Code Conventions

- Использование record/getter-style (`s.city()`) — нормально для Java 14+
- Отсутствие пробела после точки в лямбде: `s -> s.city()` — должно быть `s -> s.city().equals(city)` (формально допустимо, но лучше добавить пробелы: `s -> s.city().equals(city)`)
- Метод публичный, тип возвращаемого значения — `List<Student>` (Generic с raw type? Нет, параметризован правильно)
- Имя метода соответствует стилю camelCase

### 3. Производительность

- **O(n)** — каждый вызов проходит по всем элементам списка (n = размер studentList)
- При частых вызовах для разных городов — неэффективно. Без кеширования или индексации сложность не улучшить

## Предложения по исправлению

### Исправление null-проблем:
```java
// Вариант 1: защита от null в параметре и в city студента
//if (city == null) return List.of();
//return studentList.stream()
//    .filter(s -> city.equals(s.city())) // безопасно, если s.city() == null
//    .toList();
//
// Вариант 2: нужна ли поддержка null как валидного города?
//Objects.requireNonNull(city, "city must not be null");
//return studentList.stream()
//    .filter(s -> city.equals(s.city()))
//    .toList();
```

### Улучшение читаемости:
```java
// Добавить пробелы в лямбде
//.filter(s -> city.equals(s.city()))
```

### Оптимизация производительности (если методы вызываются часто):
```java
// Предварительно построить Map: город -> список студентов
//private Map<String, List<Student>> studentsByCity;
//
//public List<Student> getStudentsFromCity(String city) {
//    if (city == null) return List.of();
//    return studentsByCity.getOrDefault(city, List.of());
//}
```

### Дополнительные улучшения (по требованиям):
- Добавить `@NotNull` параметру (если null не должен быть допустим)
- Добавить обработку регистра: `city.equalsIgnoreCase(s.city())` или использовать нормализованные строки (например, `toLowerCase()` при добавлении в коллекцию)

**Сравнение:**

Что совпало в ответах обоих ассистентов

Замечания

Что различалось (разные шаги, подходы, детали)

Дипсик предложил исправленное решение, что некорректно 

Что выбрал и почему

Клауд, т.к. лучше понял, что мне нужно 

## DVT-12 — глоссарий терминов

## Личный глоссарий терминов Dev Tools

### Категория: Java-экосистема

#### JDK — Java Development Kit

**Определение:** Development environment for building applications using the Java programming language. Includes compiler (javac), archiver (jar), documentation generator (javadoc), and other tools.

**Контекст использования:** JDK необходим для компиляции Java-кода в байт-код и создания исполняемых JAR-файлов. Без JDK невозможно собрать Java-проект.

**Пример:** После установки JDK выполняем `java -version` для проверки версии. В IntelliJ IDEA настраиваем Project SDK: File → Project Structure → Project → SDK → выбираем JDK 25.

**Источник:** https://docs.oracle.com/en/java/javase/21/docs/

---

#### JRE — Java Runtime Environment

**Определение:** JRE provides the libraries, Java Virtual Machine, and other components to run applications written in Java. It does not contain development tools like compiler or debugger.

**Контекст использования:** JRE используется на машинах пользователя или в production-окружении, где нужно только запускать Java-приложения, но не компилировать их.

**Пример:** Если наш проект собран в JAR-файл, для его запуска на сервере нужна только JRE (или JDK, который включает JRE). Команда `java -jar app.jar` использует среду выполнения из JRE.

**Источник:** https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/package-summary.html

---

#### JVM — Java Virtual Machine

**Определение:** The Java Virtual Machine is the cornerstone of the Java platform. It is the component responsible for executing the compiled bytecode, providing runtime environment and memory management.

**Контекст использования:** JVM запускает байт-код, делает Java кроссплатформенной (Write Once, Run Anywhere). Управляет памятью (GC, Heap) и потоками.

**Пример:** Наша программа HelloWorld.class (байт-код) не запускается напрямую ОС. Команда `java HelloWorld` запускает JVM, которая интерпретирует байт-код в машинный код под текущую ОС (Windows, Linux, macOS).

**Источник:** https://docs.oracle.com/javase/specs/jvms/se21/html/

---

#### Gradle Wrapper — Gradle Wrapper

**Определение:** The Wrapper is a script that invokes a declared version of Gradle, downloading it if necessary. It allows to run a Gradle build without needing a prior Gradle installation.

**Контекст использования:** Гарантирует, что все члены команды и CI-сервер используют строго одну версию Gradle для сборки проекта. Файлы (`gradlew`, `gradle-wrapper.properties`) хранятся в репозитории.

**Пример:** Вместо установки Gradle глобально, мы запускаем `./gradlew build` из корня проекта. Wrapper сам скачает Gradle 8.5 (как указано в `gradle-wrapper.properties`) и выполнит сборку.

**Источник:** https://docs.gradle.org/current/userguide/gradle_wrapper.html

---

#### Build Tool — Build Tool

**Определение:** A software tool that automates the process of compiling source code, managing dependencies, running tests, and packaging applications into executable artifacts.

**Контекст использования:** Используется ежедневно разработчиком и CI/CD для сборки проекта. Автоматизирует рутинные шаги (компиляция → тесты → упаковка).

**Пример:** В нашем проекте `devtools` Build Tool — Gradle. Мы запускаем `./gradlew clean test` для очистки, компиляции и выполнения тестов одной командой.

**Источник:** https://docs.gradle.org/current/userguide/what_is_gradle.html

---

#### Dependency — Dependency

**Определение:** An external library or module that a project requires to compile, run, or test. In Gradle, dependencies are declared in `build.gradle` using configurations like `implementation`, `testImplementation`.

**Контекст использования:** Gradle скачивает зависимости из репозиториев (Maven Central, JCenter). Управление версиями критично — разные версии библиотек могут конфликтовать.

**Пример:** В `build.gradle` добавляем `implementation 'org.projectlombok:lombok:1.18.30'`. Lombok становится зависимостью — его классы доступны в коде, а Gradle автоматически подхватит JAR-файл этой библиотеки.

**Источник:** https://docs.gradle.org/current/userguide/dependency_management.html

---

### Категория: Инструменты разработки

#### IDE — Integrated Development Environment

**Определение:** A software application that provides comprehensive facilities to programmers for software development. Typically includes code editor, build tools, and debugger in one interface.

**Контекст использования:** IDE объединяет редактор кода, компилятор, отладчик и терминал в одном окне, повышая скорость разработки и удобство рефакторинга.

**Пример:** В нашем проекте используется IntelliJ IDEA. Она подсвечивает синтаксис, показывает ошибки компиляции на лету, позволяет ставить Breakpoint и запускать Debug как часть интерфейса.

**Источник:** https://www.jetbrains.com/help/idea/meet-intellij-idea.html

---

#### Commit — Commit

**Определение:** A commit is a snapshot of the tracked files in a Git repository at a specific point in time. It contains a unique SHA-1 hash, author, date, and message describing the changes.

**Контекст использования:** Фиксация изменений перед созданием Pull Request или переключением на другую ветку. Каждый коммит — атомарная единица изменений, которую можно откатить, сравнить или слить.

**Пример:** После добавления глоссария в README выполняем в терминале: `git add README.md` → `git commit -m "docs: add dev tools glossary"`. В Git Log появится этот коммит с хешем `abc123`.

**Источник:** https://git-scm.com/docs/git-commit

---

#### Branch — Branch

**Определение:** A branch is a movable pointer to a commit, allowing development work to diverge from the main line. Branches enable parallel development and isolation of experimental features.

**Контекст использования:** Ветки изолируют новую разработку от стабильного кода в master. Каждая задача (фича или багфикс) получает свою ветку, что упрощает Code Review и тестирование.

**Пример:** Мы создали ветку `feature/DVT-12` от `master`. Все коммиты по задаче DVT-12 идут в эту ветку, не затрагивая стабильный `master`. После слияния ветка удаляется.

**Источник:** https://git-scm.com/book/en/v2/Git-Branching-Branches-in-a-Nutshell

---

#### Pull Request — Pull Request

**Определение:** A method of submitting contributions to a project. A developer requests that changes from one branch (feature) be merged into another (main), enabling code review and automated checks before merge.

**Контекст использования:** Ключевая практика командной разработки. PR запускает CI (проверки, тесты), позволяет коллегам оставлять комментарии к коду, обсудить изменения и только затем влить в основную ветку.

**Пример:** В GitHub после пуша ветки `feature/DVT-12` мы создаём PR `feature/DVT-12 → master`. CI запускает Checkstyle и тесты. Тимлид смотрит изменения, комментирует. После аппрува жмём "Merge".

**Источник:** https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests

---

#### Checkstyle — Checkstyle

**Определение:** A static code analysis tool used to check if Java source code complies with a set of coding style rules and standards (e.g., naming conventions, indentation, import order).

**Контекст использования:** Автоматически проверяет стиль кода при сборке, предотвращая попадание плохо отформатированного кода в репозиторий.

**Пример:** В `build.gradle` подключён плагин Checkstyle. При запуске `./gradlew checkstyleMain` инструмент проверяет, все ли поля private, есть ли Javadoc, правильные ли отступы. Если нарушений нет — BUILD SUCCESSFUL.

**Источник:** https://checkstyle.org/

---

#### Debug — Debug

**Определение:** The process of identifying and removing errors (bugs) from a program. Debugging involves running the program step-by-step, inspecting variables, and controlling execution flow.

**Контекст использования:** Используется, когда код компилируется, но работает не так, как ожидается (логическая ошибка). Debug позволяет "заморозить" программу в нужной точке и посмотреть значения всех переменных.

**Пример:** Программа падает с NullPointerException. Ставим Breakpoint на строке с вызовом метода. Запускаем Debug. Когда выполнение остановится, смотрим в Evaluate: `person.getName()` → `null`. Понимаем, что person не инициализирован.

**Источник:** https://www.jetbrains.com/help/idea/debugging-code.html

---

#### Breakpoint — Breakpoint

**Определение:** A marker set in the source code that tells the debugger to suspend program execution at that specific line. Allows inspection of program state (variables, call stack) at that moment.

**Контекст использования:** При отладке ставится на строке кода, где предполагается проблема. Программа дойдёт до этой строки и остановится, не выполняя её. Затем можно смотреть переменные и продолжать выполнение по шагам.

**Пример:** Кликаем слева от номера строки в IDEA: красный кружок. Запускаем Debug. Программа останавливается на `System.out.println(data);`. До выполнения этой строки мы проверяем в окне Debug, что `data != null`.

**Источник:** https://www.jetbrains.com/help/idea/using-breakpoints.html

---

### Категория: Процессы и практики

#### Code Review — Code Review

**Определение:** A systematic examination of source code by developers other than the author, intended to find defects, improve code quality, and ensure adherence to team standards before merging.

**Контекст использования:** Обязательный этап перед слиянием Pull Request в основную ветку. Улучшает качество кода, распространяет знания о проекте в команде, снижает количество багов.

**Пример:** Мы создали PR. Тимлид оставляет комментарий: "Метод слишком длинный, разбей на три". Исправляем, пушим, получаем апрув. CI зелёный — сливаем. Без Code Review этот код сразу попал бы в master.

**Источник:** https://www.agilealliance.org/glossary/code-review/

---

#### CI/CD — Continuous Integration / Continuous Delivery

**Определение:** CI automatically builds and tests every commit. CD automatically deploys the tested code to staging/production environments. Together, they provide fast feedback and reliable releases.

**Контекст использования:** Автоматизация сборки и тестирования (CI) при каждом push в репозиторий, а также автоматическое развёртывание (CD) при успешных проверках.

**Пример:** В репозитории лежит `.github/workflows/gradle.yml`. При создании PR GitHub Actions запускает `./gradlew build`. Если статус красный (компиляция не прошла), PR нельзя влить без исправлений. Это CI.

**Источник:** https://www.thoughtworks.com/radar


Вопросы отсутсвуют. Все прояснил самостоятельно.