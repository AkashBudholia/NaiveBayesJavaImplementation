 database bayes


create table info(rid int,age varchar(50),income varchar(50), student varchar(50), c_rating varchar(50),class varchar(50))
insert into info values(1,'youth','high','no','fair','no')
insert into info values(2,'youth','high','no','excellent','no')
insert into info values(3,'middle','high','no','fair','yes')
insert into info values(4,'senior','medium','no','fair','yes')
insert into info values(5,'senior','low','yes','fair','yes')
insert into info values(6,'senior','low','yes','excellent','no')
insert into info values(7,'middle','low','yes','excellent','yes')
insert into info values(8,'youth','medium','no','fair','no')
insert into info values(9,'youth','low','yes','fair','yes')
insert into info values(10,'senior','medium','yes','fair','yes')
insert into info values(11,'youth','medium','yes','excellent','yes')
insert into info values(12,'middle','medium','no','excellent','yes')
insert into info values(13,'middle','high','yes','fair','yes')
insert into info values(14,'senior','medium','no','excellent','no')

select * from info

rid	age	income	student	c_rating	class
-----	------	------	-------	-----------	-----
1	youth	high	no	fair		no
2	youth	high	no	excellent	no
3	middle	high	no	fair		yes
4	senior	medium	no	fair		yes
5	senior	low	yes	fair		yes
6	senior	low	yes	excellent	no
7	middle	low	yes	excellent	yes
8	youth	medium	no	fair		no
9	youth	low	yes	fair		yes
10	senior	medium	yes	fair		yes
11	youth	medium	yes	excellent	yes
12	middle	medium	no	excellent	yes
13	middle	high	yes	fair		yes
14	senior	medium	no	excellent	no
