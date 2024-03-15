INSERT INTO
    "persons" ("name")
VALUES
    ('Alice'),
    ('Bob'),
    ('Charlie'),
    ('David');

INSERT INTO
    "cities" ("mayor", "name")
VALUES
    (1, 'New York'),
    (3, 'Los Angeles');

INSERT INTO
    "friendships" (
        "person_id",
        "friend_id",
        "keeps_contact",
        "miles"
    )
VALUES
    (1, 2, true, 10),
    (2, 3, true, 20),
    (3, 4, false, NULL);

INSERT INTO
    "information" ("message", "truthfulness", "original_source")
VALUES
    ('Important news', 90, 1),
    ('Latest research findings', 95, NULL),
    ('Rumor about upcoming event', 70, 2);

INSERT INTO
    "info_spread" ("receiver", "source", "info_id", "source_asked")
VALUES
    (2, 1, 1, false),
    (3, 2, 2, true),
    (4, 3, 3, false);

INSERT INTO
    "cities_information" ("cities_id", "information_id")
VALUES
    (1, 1),
    (2, 2);

SELECT
    *
FROM
    "persons";

SELECT
    *
FROM
    "cities";

SELECT
    *
FROM
    "friendships";

SELECT
    *
FROM
    "information";

SELECT
    *
FROM
    "info_spread";

SELECT
    *
FROM
    "cities_information";