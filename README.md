# Spring Solar Position Calculator

## Описание
Консольное приложение для определения положения солнца с помощью алгоритма SPA.

### Стек технологий

- Java 11
- Spring Boot 
- Spring Events
- Spring Web (Console mode)
- Паттерны Command и Strategy
- Lombok
- [SPA library](https://github.com/KlausBrunner/solarpositioning)
- Gradle
- Launch4j (сборка исполняемого exe-файла)

## Сборка приложения
**Необходимо:**
1. Java 8+
2. Git

```shell script
mkdir "solar-position"
cd solar-position
git clone git clone https://github.com/devalurum/solar-position.git
git remote add origin https://github.com/devalurum/solar-position.git

./gradlew wrapper
# сборка проекта
./gradlew clean build 
# запуск 
java -jar build/libs/solar-position.jar 
```

## Сборка exe-файла

```shell script
./gradlew launch4j
cd build/launch4j/
# run Solar Position Calculator.exe
```

### Конфигурация

Для использования, необходимо внести статические данные для автоматического определения даты и геолокации.

```yaml
#...
app:
  timezone: 8
  geolocation:
    latitude: 52.*** # ввести полностью
    longitude: 104.***
    altitude: 544 # Высота (в метрах) над уровнем моря
    side-of-the-world-azimuth: 90 # Север: 360, Восток: 90, Юг: 180, Запад: 270 (в градусах °).
  filename: solar_position.txt
```