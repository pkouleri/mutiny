CREATE TABLE USER
(
    ID                SERIAL NOT NULL,
    USERNAME				  VARCHAR (255) NOT NULL,
    EMAIL             VARCHAR (255) NOT NULL,
    TYPE              VARCHAR (50) NOT NULL,
    CONSTRAINT USER_PK PRIMARY KEY ( ID )
);

-- CREATE TABLE POST
-- (
-- 	ID 		SERIAL NOT NULL
-- );
--
-- CREATE TABLE CATEGORIES
-- (
--     ID           SERIAL NOT NULL
-- );
--
-- CREATE TABLE USER_CATEGORIES
-- (
--     ID            SERIAL NOT NULL
-- );

