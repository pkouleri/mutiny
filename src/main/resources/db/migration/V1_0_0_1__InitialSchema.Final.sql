CREATE TABLE USER
(
    ID                BIGSERIAL NOT NULL,
    USERNAME				  VARCHAR (255) NOT NULL,
    EMAIL             VARCHAR (255) NOT NULL,
    TYPE              VARCHAR (50) NOT NULL,
    CREATED_AT		    TIMESTAMP WITH TIME ZONE NOT NULL,
    UPDATED_AT		    TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT USER_PK PRIMARY KEY ( ID )
);

CREATE TABLE POST
(
    ID                BIGSERIAL NOT NULL,
    USER_ID				    BIGINT NOT NULL,
    CATEGORY_ID       BIGINT NOT NULL,
    CONTENT           VARCHAR (1024) NOT NULL,
    CREATED_AT		    TIMESTAMP WITH TIME ZONE NOT NULL,
    UPDATED_AT		    TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT POST_PK PRIMARY KEY ( ID )
);

CREATE TABLE CATEGORY
(
    ID                BIGSERIAL NOT NULL,
    NAME              VARCHAR (255) NOT NULL,
    CREATED_AT		    TIMESTAMP WITH TIME ZONE NOT NULL,
    UPDATED_AT		    TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT CATEGORY_PK PRIMARY KEY ( ID )
);

CREATE TABLE USER_CATEGORY
(
    USER_ID     BIGINT NOT NULL,
    CATEGORY_ID BIGINT NOT NULL
);

ALTER TABLE POST ADD CONSTRAINT POST_FK01 FOREIGN KEY ( USER_ID ) REFERENCES USER ( ID ) ;
ALTER TABLE POST ADD CONSTRAINT POST_FK02 FOREIGN KEY ( CATEGORY_ID ) REFERENCES CATEGORY ( ID ) ;

ALTER TABLE USER_CATEGORY ADD CONSTRAINT USER_CATEGORY_FK01 FOREIGN KEY ( USER_ID ) REFERENCES USER ( ID ) ;
ALTER TABLE USER_CATEGORY ADD CONSTRAINT USER_CATEGORY_FK02 FOREIGN KEY ( CATEGORY_ID ) REFERENCES CATEGORY ( ID ) ;
