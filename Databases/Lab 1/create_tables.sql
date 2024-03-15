CREATE TABLE
    "persons" ("id" SERIAL PRIMARY KEY, "name" varchar);

CREATE TABLE
    "friendships" (
        "person_id" integer NOT NULL,
        "friend_id" integer NOT NULL,
        "keeps_contact" bool DEFAULT true,
        "miles" integer DEFAULT null
    );

CREATE TABLE
    "information" (
        "id" SERIAL PRIMARY KEY,
        "message" text,
        "truthfulness" integer DEFAULT 100,
        "created_at" timestamp DEFAULT CURRENT_TIMESTAMP,
        "original_source" integer DEFAULT null
    );

CREATE TABLE
    "cities" (
        "mayor" integer UNIQUE,
        "id" SERIAL PRIMARY KEY,
        "name" varchar UNIQUE NOT NULL
    );

CREATE TABLE
    "info_spread" (
        "id" SERIAL PRIMARY KEY,
        "receiver" integer NOT NULL,
        "source" integer NOT NULL,
        "info_id" integer NOT NULL,
        "source_asked" bool DEFAULT false
    );

ALTER TABLE "info_spread" ADD FOREIGN KEY ("receiver") REFERENCES "persons" ("id");

ALTER TABLE "info_spread" ADD FOREIGN KEY ("source") REFERENCES "persons" ("id");

CREATE TABLE
    "cities_information" (
        "cities_id" integer,
        "information_id" integer,
        PRIMARY KEY ("cities_id", "information_id")
    );

ALTER TABLE "cities_information" ADD FOREIGN KEY ("cities_id") REFERENCES "cities" ("id");

ALTER TABLE "cities_information" ADD FOREIGN KEY ("information_id") REFERENCES "information" ("id");

ALTER TABLE "info_spread" ADD FOREIGN KEY ("info_id") REFERENCES "information" ("id") ON DELETE CASCADE;

ALTER TABLE "friendships" ADD FOREIGN KEY ("person_id") REFERENCES "persons" ("id") ON DELETE CASCADE;

ALTER TABLE "friendships" ADD FOREIGN KEY ("friend_id") REFERENCES "persons" ("id") ON DELETE CASCADE;

ALTER TABLE "information" ADD FOREIGN KEY ("original_source") REFERENCES "persons" ("id") ON DELETE SET NULL;

ALTER TABLE "persons" ADD FOREIGN KEY ("id") REFERENCES "cities" ("mayor") ON DELETE RESTRICT;

ALTER TABLE "information" ADD CONSTRAINT check_truthfulness CHECK (truthfulness BETWEEN 0 and 100);

ALTER TABLE "friendships" ADD CONSTRAINT check_miles CHECK (miles >= 0);
