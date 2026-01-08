# PetClinic REST API Testing

Проект содержит автоматизированные тесты для **Spring PetClinic REST API**.
API основан на официальном репозитории: [spring-petclinic-rest](https://github.com/spring-petclinic/spring-petclinic-rest).

---

<a id="annotation"></a>
## Описание
Тестовый проект состоит из веб-тестов.
Содержание проекта:
- [x] `POJO` проектирование
- [x] Возможность локального запуска тестов
- [x] Использование `Faker` для генерации данных
- [x] Использование `Lombok` для моделей в API тестах
- [x] Использование request/response спецификаций для API тестов
- [x] Автотесты оформлены как тестовая документация посредством аннотаций `Allure`

Spring PetClinic — демонстрационное приложение для управления клиникой для питомцев.
В этом проекте реализованы тесты для **REST API** с использованием:
<a id="tools"></a>
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/logo/IntelliJ_IDEA.png" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/logo/GitHub.png" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/logo/Java_logo.png" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/logo/Gradle.png" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/logo/JUnit5.png" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="images/logo/RestAssured.png" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/logo/AllureReports.png" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/logo/Telegram.png" width="50"/></a>


Тесты покрывают все ключевые сущности приложения:

* **Owners** — владельцы животных
* **Pets** — питомцы
* **Pet Types** — типы животных
* **Visits** — визиты к врачу
* **Vets** — врачи
* **Specialties** — специализации врачей

---

## Поднятие API локально

Для запуска тестов необходимо, чтобы API работал локально.
Самый простой способ — через Docker:

```bash
docker run -p 9966:9966 springcommunity/spring-petclinic-rest
```

После запуска API будет доступен по адресу:

```
http://localhost:9966/petclinic/api
```

---

## Структура проекта

```
src/test/java/
 ├── assertions      # Методы для валидации ответов API
 ├── base            # Общие настройки для тестов
 ├── dto             # Модели запросов и ответов (Request/Response)
 ├── helpers         # Вспомогательные утилиты (папка пуста)
 ├── specs           # Спецификации запросов и проверок для каждой сущности
 └── tests            # Тестовые сценарии
      ├── e2e        # End-to-End тесты
      ├── owners     # CRUD тесты для Owners
      └── pets       # CRUD тесты для Pets
```

---

## Запуск тестов

Тесты можно запускать через Gradle:

```bash
gradle clean test
gradle clean e2e
gradle clean owner
gradle clean pet
```

Или через IDE (IntelliJ IDEA, Eclipse):

* Открой нужный тестовый класс
* Правый клик → **Run**

---

## Примеры эндпоинтов API и запросов

### Owners

**GET /owners** — получить список владельцев

```bash
GET http://localhost:9966/petclinic/api/owners
```

**POST /owners** — создать нового владельца

```json
POST http://localhost:9966/petclinic/api/owners
{
  "firstName": "Jane",
  "lastName": "Smith",
  "address": "456 Avenue",
  "city": "Los Angeles",
  "telephone": "0987654321"
}
```

### Pets

**GET /pets** — список питомцев

```bash
GET http://localhost:9966/petclinic/api/pets
```

**POST /pets** — добавить питомца

```json
POST http://localhost:9966/petclinic/api/pets
{
  "name": "Buddy",
  "birthDate": "2020-01-01",
  "type": { "id": 1 }
}
```

### Pet Types

**GET /pettypes** — список типов животных

```bash
GET http://localhost:9966/petclinic/api/pettypes
```

**POST /pettypes** — добавить новый тип

```json
POST http://localhost:9966/petclinic/api/pettypes
{
  "name": "Dog"
}
```

### Visits

**POST /visits** — добавить визит

```json
POST http://localhost:9966/petclinic/api/visits
{
  "petId": 1,
  "date": "2026-01-08",
  "description": "Annual checkup"
}
```

### Vets

**GET /vets** — список врачей

```bash
GET http://localhost:9966/petclinic/api/vets
```

### Specialties

**GET /specialties** — список специализаций

```bash
GET http://localhost:9966/petclinic/api/specialties
```

**POST /specialties** — добавить новую специализацию

```json
POST http://localhost:9966/petclinic/api/specialties
{
  "name": "surgery"
}
```

---

## E2E сценарий

Пример полного пользовательского сценария, покрытого тестом `OwnerPetVisitE2ETest.java`:

1. Создание нового владельца (`POST /owners`)
2. Добавление питомца к владельцу (`POST /pets`)
3. Создание визита для питомца (`POST /visits`)
4. Проверка, что все данные корректно сохранились (`GET /owners/{id}` и `GET /pets/{id}`)

---

## Контакты

📧 [solovev02@ya.ru](mailto:solovev02@ya.ru)
💬 @mikeysoll
