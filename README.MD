## springDiscovery

Учебный проект Spring Cloud Service Discovery

Проект для ознакомления с client-side service discovery от Spring. В проекте запускаются два тестовых сервиса и 
service discovery (определение сервисов). Каждый сервис при запуске регистрируется в service discovery, который хранит 
и автоматически обновляет их url. 

## Запуск
Для запуска используются maven, git, jdk 11-ой версии или выше. Примеры запросов к сервисам показаны с помощью curl. 
1. Используем команду, чтобы склонировать исходный код. 
````
git clone https://github.com/KarnaukhovKirill/discovery
````
2. Переходим в корневую папку проекта и выполняем команду
````
mvn spring-boot:run
````
3. Открываем новую консоль. Переходим в корневую папку проекта из консоли. Создаём jar файлы для запуска тестовы клиентов.
````
cd client
mvn install
````
4. Создаём тестовые версии сервисов client 
````
java -jar target/app.jar --spring.config.location=file:cfg/client1.properties
java -jar target/app.jar --spring.config.location=file:cfg/client2.properties
````
В консоли сервера должны появиться информационные сообщения о регистрации сервисов в service discovery.
![alt text](https://github.com/KarnaukhovKirill/discovery/blob/main/img/spring-server.png)

### Примеры запросов 
#### Получение списка сервисов
Запрос для получения всех сервисов, зарегистрированных в service discovery
````
curl --request GET localhost:8081/services
````
![alt text](https://github.com/KarnaukhovKirill/discovery/blob/main/img/getServices.png)
#### Подробная информация о сервисе
````
curl --request GET localhost:8082/services/client1
````

#### Запрос на отправку и принятия сообщений

````
curl --request POST --header 'Content-Type: application/json' localhost:8082/messages/send/client1 --data-raw '{"message": "Recieve message for client"}'
````
````
curl --request POST --header 'Content-Type: application/json' localhost:8082/messages/receive --data-raw '{"message": "Recieve message for client"}'
````

#### Запрос получения всех сообщений от какого-либо сервиса (зависит от порта)
````
curl --request GET localhost:8081/messages
````
![alt text](https://github.com/KarnaukhovKirill/discovery/blob/main/img/messages.png)
# TODO
- [ ] tests
- [ ] load balancer
- [ ] docker install

[![Java CI with Maven](https://github.com/KarnaukhovKirill/discovery/actions/workflows/github-actions-demo.yml/badge.svg)](https://github.com/KarnaukhovKirill/discovery/actions/workflows/github-actions-demo.yml)
