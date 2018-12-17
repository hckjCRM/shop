select * from room;
select rid,rtype,rstate,rprice,place from room where rstate ='空'
insert into room values(1003,'单人间','非空',168,'十楼3号房')
update room set rstate='空' where rid=1001

create business_sq start with 00001

select * from emp;
select * from (select empno,ename,job,sal,comm from EMP order by sal desc) where rownum<4
select * from (select empno,ename,job,sal,comm from EMP order by sal desc) where rownum<4
select *from emp

select * from(select * from emp) where rownum <5 