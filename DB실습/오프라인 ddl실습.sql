-- create
-- db생성
create database 데이터베이스이름;

-- 수정 alter
alter database 데이터베이스이름
	character set 'utf8mb4';
    

-- drop 삭제 db나 테이블 그 자체를 삭제
drop database 데이터베이스이름;


-- 테이블을 생성하려면 데이터베이스를 '사용'해야함. use <- ddl아님/
use ssss;

-- 테이블을 생성 create
create table 테이블명(
	
	컬럼명1 int,
    컬럼명2 int

);

-- 테이블 수정 alter
alter table 테이블명
	add 컬럼명3 int
;

alter table 테이블명
	change 컬럼명3 변경된새이름 int
;


alter table 테이블명
	rename to 새로운테이블명;
    
    
-- 테이블 삭제 drop
drop table 새로운테이블명;