--2023-09-15
create table comment(
cno int auto_increment,
bno int not null,
wrtier varchar(200) not null default "unknown",
content varchar(1000), 
regdate datetime default now(),
primary key(cno));



--2023-09-19 추가
--이미지 파일 추가
Alter table board add image_File varchar(500);

