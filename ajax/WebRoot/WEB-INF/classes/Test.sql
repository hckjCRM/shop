select * from room;
select rid,rtype,rstate,rprice,place from room where rstate ='��'
insert into room values(1003,'���˼�','�ǿ�',168,'ʮ¥3�ŷ�')
update room set rstate='��' where rid=1001

create business_sq start with 00001

select * from emp;
select * from (select empno,ename,job,sal,comm from EMP order by sal desc) where rownum<4
select * from (select empno,ename,job,sal,comm from EMP order by sal desc) where rownum<4
select *from emp

select * from(select * from emp) where rownum <5 