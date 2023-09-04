create table comment (
id int auto_increment,
post_id int not null,
text text not null,
created datetime not null,
primary key(id),
foreign key(post_id) references post(id)
);