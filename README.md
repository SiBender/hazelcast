# hazelcast
hazelcast example

3 отдельных проекта это 2 ноды с распределенной Map и клиент
Сборку и запуск нужно выполнять отдельно в каждом каталоге

Сборка
    mvn clean compile package

Запуск
    java -jar .\target\hazel-map-1.0-SNAPSHOT.jar


Node 1 создает и инициальзирует Map.

Затем с интервалом в 5 секунд каждая нода добавляет данные

Клиент отображает содержимое Map с интервалом 5 секунд