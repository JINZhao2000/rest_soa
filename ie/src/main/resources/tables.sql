create table client2 (
    cid int AUTO_INCREMENT,
    email varchar(40),
    name varchar(40),
    address varchar(60),
    tel varchar(20),
    amount int,
    duration int,
    descr varchar(200),
    income double,
    spent double,
    primary key (cid)
)