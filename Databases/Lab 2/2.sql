-- Task N2
-- Сделать запрос для получения атрибутов из указанных таблиц, применив фильтры по указанным условиям:
-- Таблицы: Н_ЛЮДИ, Н_ВЕДОМОСТИ, Н_СЕССИЯ.
-- Вывести атрибуты: Н_ЛЮДИ.ИД, Н_ВЕДОМОСТИ.ЧЛВК_ИД, Н_СЕССИЯ.ИД.
-- Фильтры (AND):
-- a) Н_ЛЮДИ.ИМЯ > Александр.
-- b) Н_ВЕДОМОСТИ.ИД < 1250981.
-- c) Н_СЕССИЯ.ЧЛВК_ИД < 106059.
-- Вид соединения: LEFT JOIN.
SELECT
    Н_ЛЮДИ.ИД,
    Н_ВЕДОМОСТИ.ЧЛВК_ИД,
    Н_СЕССИЯ.ИД
FROM
    Н_ЛЮДИ
    LEFT JOIN Н_ВЕДОМОСТИ ON Н_ЛЮДИ.ИД = Н_ВЕДОМОСТИ.ЧЛВК_ИД
    LEFT JOIN Н_СЕССИЯ ON Н_ЛЮДИ.ИД = Н_СЕССИЯ.ЧЛВК_ИД
WHERE
    Н_ЛЮДИ.ИМЯ > 'Александр'
    AND Н_ВЕДОМОСТИ.ИД < 1250981
    AND Н_СЕССИЯ.ЧЛВК_ИД < 106059;