CREATE TABLE
    IF NOT EXISTS users (
        id SERIAL NOT NULL,
        username VARCHAR(155) NOT NULL,
        passHash VARCHAR(1000) NOT NULL,
        email VARCHAR(155) NOT NULL UNIQUE,
        age INTEGER NOT NULL,
        country VARCHAR(155) NOT NULL,
        gender VARCHAR(100)
    )