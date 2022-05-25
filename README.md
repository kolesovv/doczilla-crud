# Задание

Для выполнения задания выбери любую реляционную базу данных (oracle, sql server, mysql, postgresql, sqlite и т.д.).

1. Заведи в БД таблицу данных о студентах, которая будет содержать: имя, фамилия, отчество, дата рождения, группа,
   уникальный номер.
2. Создай веб-приложение (клиентскую и серверную части), с помощью которого можно добавить студента, удалить студента по
   уникальному номеру, вывести список студентов.

## Решение

Стек: Java 11, Spring, JDBC, PostgreSQL, Thymeleaf.

Реализован паттерн проектирования веб-приложений MVC.
В качестве БД используется PostgreSQL. Запросы к БД посредством JDBC.

Отображение посредством HTML + Thymeleaf.

Cписок студентов:
![image_text](https://github.com/kolesovv/doczilla-crud/blob/3ffe906891416a52ef1b54bd3e7f43bf844960da/src/main/resources/img.png)
Форма добавления:
![image_text](https://github.com/kolesovv/doczilla-crud/blob/3ffe906891416a52ef1b54bd3e7f43bf844960da/src/main/resources/img_1.png)

API:
* GET api/v2/student/all - получнение списка студентов
* GET api/v2/student/find/{id} - получение студента по id
* POST api/v2/student/add - добавление нового студента
* POST api/v2/student/update - обновление данных о студенте
* DELETE api/v2/student/delete/{id} - удаление студента по id
