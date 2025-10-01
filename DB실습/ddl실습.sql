#데이터베이스 생성하기.
-- CREATE database SSAFY;

#SSAFY DB 를 사용해보자
USE SSAFY;

#DB목록을 조회해보자
SHOW DATABASES;

#문자집합을 설정해보자 -> 기존의 데이터베이스를 변경해서
alter database ssafy 
default character set utf8mb4 COLLATE utf8mb4_general_ci;

#데이터베이스를 삭제해보자ㅣ
-- DROP DATABASE SSAFY;

-- DROP DATABASE IF EXISTS SSAFY;

#SSAFY_USER 테이블 작성해보자
-- CREATE TABLE SSAFY_USER (
-- 	`user_num` INT  auto_increment primary key,
--     `user_id` varchar(20) not null,
--     `user_name` varchar(30) not null,
--     `user_password` varchar(20) not null,
--     `user_email` varchar(30),
--     `signup_date` timestamp not null default current_timestamp
-- );

describe ssafy_user;
desc ssafy_user;


#insert구문으로 데이터 삽입
-- insert into ssafy_user  -- (컬럼명)
-- values (35	, "t22tan", "박준형", "0000", "junhyung8795@naver.com", now());

insert into ssafy_user (user_id,user_name, user_password)
values ("KimId", "Kim", "1111");


insert into ssafy_user (user_id,user_name, user_password)
values ("KimId", "Kim", "2"),("KimId", "Kim", "3"),("KimId", "Kim", "4") ;


select * from ssafy_user;


#데이터 수정 update: safe mode가 기본적으로 동작하고 있어서 안된다. 
-- update ssafy_user
-- set user_name = 'anonymous';

update ssafy_user
set user_password = '1234'
where user_num = 10;

#delete로 데이터 삭제
-- delete from ssafy_user; -- where안걸면 모든 레코드 다 날아간다.
 delete from ssafy_user
 where user_num = 1;

select* from ssafy_user;
-- delete from ssafy_user;


#mysql은 기본적으로 autocommit상태이다.
set autocommit = 0; -- autocommit 껐다.

-- create table test_table(
-- 	val varchar(5)

-- );

start transaction; -- 해당 sql을 실행한 이후의 모든 sql은 하나의 작업 단위로 본다.
insert into test_table values("s");
insert into test_table values("s");
insert into test_table values("a");
insert into test_table values("f");
insert into test_table values("y");
rollback;


insert into test_table values("s");
insert into test_table values("s");
insert into test_table values("a");
insert into test_table values("f");
insert into test_table values("y");
commit;

select * from test_table;