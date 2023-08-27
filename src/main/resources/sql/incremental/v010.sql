create database travelgram;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(25) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    description VARCHAR(1000),
    created DATETIME NOT NULL,
    imgUrl VARCHAR(500) NOT NULL,
    FOREIGN KEY (userId) REFERENCES user(id)
);

create table authority (
id int auto_increment,
userId int not null,
authority varchar(50) not null,
primary key(id),
foreign key (userId) references user (id)
);