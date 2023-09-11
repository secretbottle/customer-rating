## Требования

Для запуска приложения требуется:

* Java 8

## Запуск приложения

* Следует перейти в корень приложения

* `docker-compose up -d`

* `./mvnw clean package`

* `./mvnw spring-boot:run`

Тестовый запрос: 
`curl -X POST http://localhost:8080/customer/rate/ -H 'Content-Type: application/json' -d '{"inn": "990911223344", "capital": "6000000.0", "region": 24}'`

Должен вернуть ответ:
`{ "finalRating": false, "detailRating": { "capital": false, "region": true, "type": true, "resident": true} }`
