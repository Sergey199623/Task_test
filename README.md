# Test_Task

Тестовое задание для андроид разработчика.
1. Получить анонимный сертификат поадресу https://authan-test.izibook.ru:13302/api/anonymous
методом POST, без параметров, при этом должна быть включена проверка подлинности сертификата
Ответ:
нормальное завершение
{
"result":"ok"
"data":{
"public": "string", // публичная часть
"private": "string", // приватная часть
"expire" : "timestamp", // срок действия сертификат "pkcs12": "string" // сертификат в формате PKCS12
} }
сбой
"result":"error", "code": 0000, "reason": "STRING"
       {
}
- Если анонимный сертификат не получен - выдать сообщение "Нет связи с серве- ром"
2. Запросить каталог, подписав запрос анонимным сертификатом
, полученным на
предыдущем шаге.
Для запросов использовать адрес
https://rest-test.izibook.ru:10001/api/globcat/list
метод получения POST, в заголовок включить параметр x-lang = «ru-RU», проверка
подлинности — выключена.
В качестве параметров передаем объект JSON
{
}, "view": [
{"code": "icon"}, {"code": "id"}, {"code": "title"}, {"code": "popularity"}, {
"code": "items", "view": [
{"code": "id"}, {"code": "title"}, {"code": "items",
"view": [ {"code": "id"}, {"code": "title"}
] }
] }
] }
"filter": { "parent": 1
:
,
В ответ на запрос должен быть получен ответ в виде объекта JSON формата
{
}
"data": [элемент каталога1, ..., элемент каталога9], "result": "ok",
"results": 9
 элемент каталога
 — объект JSON формата
, где
{
"icon": "18",
"id": 1131, "items": [
{
"id": 1138, "title": "Визаж"
}, {
"id": 1139,
"title": "Пирсинг и тату" },
{
"id": 1140,
"title": "Термальные услуги"
}, {
"id": 1133,
"title": "Массаж" },
{
"id": 1137,
"title": "Парикмахерские услуги"
}, {
"id": 1136,
"title": "Ногтевой сервис" },
{
"id": 1132,
"title": "Эпиляция"
}, {
"id": 1135,
"title": "Косметология тела" },
{
"id": 1134,
"title": "Косметология лица"
} ],
"popularity": true,
"title": "Красота и здоровье" }
Значение icon используется для получения изображения раздела с помощью запроса, &w=(width)
&w=75
  http://mi-test.izibook.ru/imagemanager/manager/singleget?&image=(imageId)&h=
(height), 
например:
 http://mi-test.izibook.ru/imagemanager/manager/singleget?&image=18&h=75
 
 
