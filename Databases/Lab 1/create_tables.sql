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
        PRIMARY KEY ("person_id", "friend_id")
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
    SET friends_count = friend_count / 2
    WHERE id = first_person_id OR id = second_person_id;
END;
$$ LANGUAGE plpgsql;

-- Create trigger that would automatically create mutual friendship
-- When friendship (a, b) is created, friendship (b, a) should be created as well and vice versa
CREATE OR REPLACE FUNCTION create_mutual_friendship()
RETURNS TRIGGER AS $$
BEGIN
    -- If operation is DELETE, we should delete mutual friendship as well
    IF TG_OP = 'DELETE' THEN
        DELETE FROM friendships
        WHERE person_id = NEW.friend_id AND friend_id = NEW.person_id;
        CALL update_friend_count(NEW.person_id, NEW.friend_id);
        RETURN OLD;
    END IF;

    -- If operation is INSERT, we should create mutual friendship
    IF TG_OP = 'INSERT' THEN
        INSERT INTO friendships (person_id, friend_id)
        VALUES (NEW.friend_id, NEW.person_id);
        CALL update_friend_count(NEW.person_id, NEW.friend_id);
        RETURN NEW;
    END IF;

    -- If operation is UPDATE, we should update mutual friendship
    IF TG_OP = 'UPDATE' THEN
        UPDATE friendships
        SET keeps_contact = NEW.keeps_contact, miles = NEW.miles
        WHERE person_id = NEW.friend_id AND friend_id = NEW.person_id;
        CALL update_friend_count(NEW.person_id, NEW.friend_id);
        RETURN NEW;
    END IF;

    IF TG_OP = 'TRUNCATE' THEN
        update_friend_count(NEW.person_id, NEW.friend_id);
        RETURN OLD;
    END IF;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER create_mutual_friendship_trigger AFTER INSERT, UPDATE, DELETE ON friendships
FOR EACH ROW EXECUTE FUNCTION create_mutual_friendship();


INSERT INTO persons (name) VALUES ('Alice');
INSERT INTO persons (name) VALUES ('Bob');
INSERT INTO friendships (person_id, friend_id) VALUES (1, 2);
SELECT * FROM friendships;
SELECT * FROM persons;
