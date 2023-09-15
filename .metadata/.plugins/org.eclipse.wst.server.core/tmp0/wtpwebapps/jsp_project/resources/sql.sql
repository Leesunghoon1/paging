2023-09-15
create table comment(
cno int auto_increment,
bno int not null,
wrtier varchar(200) not null default "unknown",
content varchar(1000), 
regdate datetime default now(),
primary key(cno));
