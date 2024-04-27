CREATE TABLE
    "persons" (
        "id" SERIAL PRIMARY KEY,
        "name" varchar,
        "friends_count" integer DEFAULT 0
    );

CREATE TABLE
    "friendships" (
        "person_id" integer NOT NULL,
        "friend_id" integer NOT NULL,
        "keeps_contact" bool DEFAULT true,
        "miles" integer DEFAULT null,
        FOREIGN KEY ("person_id") REFERENCES "persons" ("id") ON DELETE CASCADE,
        FOREIGN KEY ("friend_id") REFERENCES "persons" ("id") ON DELETE CASCADE,
        CONSTRAINT check_miles CHECK (miles >= 0),
        PRIMARY KEY ("person_id", "friend_id"),
        CONSTRAINT check_friendship_duality CHECK (person_id < friend_id)
    );

CREATE TABLE
    "information" (
        "id" SERIAL PRIMARY KEY,
        "message" text,
        "truthfulness" integer DEFAULT 100,
        "created_at" timestamp DEFAULT CURRENT_TIMESTAMP,
        "original_source" integer DEFAULT null,
        FOREIGN KEY ("original_source") REFERENCES "persons" ("id") ON DELETE SET NULL,
        CONSTRAINT check_truthfulness CHECK (truthfulness BETWEEN 0 and 100)
    );

CREATE TABLE
    "cities" (
        "mayor" integer UNIQUE,
        "id" SERIAL PRIMARY KEY,
        "name" varchar UNIQUE NOT NULL,
        FOREIGN KEY ("mayor") REFERENCES "persons" ("id") ON DELETE RESTRICT
    );

CREATE TABLE
    "info_spread" (
        "id" SERIAL PRIMARY KEY,
        "receiver" integer NOT NULL,
        "source" integer NOT NULL,
        "info_id" integer NOT NULL,
        "source_asked" bool DEFAULT false,
        FOREIGN KEY ("receiver") REFERENCES "persons" ("id"),
        FOREIGN KEY ("source") REFERENCES "persons" ("id"),
        FOREIGN KEY ("info_id") REFERENCES "information" ("id") ON DELETE CASCADE
    );

CREATE TABLE
    "cities_information" (
        "cities_id" integer,
        "information_id" integer,
        PRIMARY KEY ("cities_id", "information_id"),
        FOREIGN KEY ("cities_id") REFERENCES "cities" ("id"),
        FOREIGN KEY ("information_id") REFERENCES "information" ("id")
    );

-- Lab 3
CREATE OR REPLACE PROCEDURE update_friend_count(first_person_id integer, second_person_id integer)
AS $$
DECLARE
    friend_count integer;
BEGIN
    SELECT COUNT(*) INTO friend_count FROM friendships
    WHERE (person_id = first_person_id AND friend_id = second_person_id) OR
          (person_id = second_person_id AND friend_id = first_person_id);

    UPDATE persons
    SET friends_count = friend_count
    WHERE id = first_person_id OR id = second_person_id;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_friend_count_trigger
AFTER INSERT OR DELETE ON friendships FOR EACH ROW EXECUTE FUNCTION update_friend_count(NEW.person_id, NEW.friend_id);

INSERT INTO persons (name) VALUES ('Alice');
INSERT INTO persons (name) VALUES ('Bob');
INSERT INTO friendships (person_id, friend_id) VALUES (1, 2);
SELECT * FROM friendships;
SELECT * FROM persons;
