CREATE TABLE PERSON(
    ID BIGINT not null AUTO_INCREMENT,
    FIRST_NAME varchar(255) not null ,
    LAST_NAME varchar(255)not null ,
    AGE INTEGER not null ,
    PRIMARY KEY (ID)
);

CREATE TABLE USERS(
   ID BIGINT not null AUTO_INCREMENT,
   USER_NAME varchar(30) not null ,
   PASSWORD text ,
   TOKEN text ,
   PRIMARY KEY (ID)
);