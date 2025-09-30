### SQL 연습 문제

-- - 조건 : users 테이블을 기준으로 조회합니다.
USE SSAFY_CORPORATION;
-- 1. 전체 데이터 조회하기
-- 2. 이름과 나이 조회하기
-- 4. 이름과 나이를 나이가 어린 순서대로 조회하기
-- 5. 이름과 나이를 나이가 많은 순서대로 조회하기
-- 6. 이름, 나이, 계좌 잔고를 나이가 어린순으로, 만약 같은 나이라면 계좌 잔고가 많은 순으로 정렬해서 조회하기
-- 7. 중복없이 모든 지역 조회하기 (=중복되는 레코드(행)은 제거)
-- 8. 지역 순으로 오름차순 정렬하여 중복없이 모든 지역 조회하기
-- 9. 이름과 지역이 중복 없이 모든 이름과 지역 조회하기
SELECT DISTINCT FIRST_NAME  , COUNTRY 
FROM USERS;
-- 10. 이름과 지역 중복 없이 지역 순으로 오름차순 정렬하여 모든 이름과 지역 조회하기
SELECT DISTINCT `FIRST_NAME` AS `이름` , `COUNTRY` AS `지+역`
FROM USERS 
ORDER BY `지+역`;
-- 11. 나이가 30살 이상인 사람들의 이름, 나이, 계좌 잔고 조회하기
SELECT FIRST_NAME, AGE, BALANCE
FROM USERS
WHERE AGE >= 30;
-- 12. 나이가 30살 이상인 계좌 잔고가 50만원 초과인 사람들의 이름, 나이, 계좌 잔고 조회하기
SELECT FIRST_NAME, AGE,  BALANCE
FROM USERS
WHERE AGE >= 30 AND BALANCE > 500000;
-- 13. 이름에 ‘호’가 포함되는 사람들의 이름과 성 조회하기
-- LIKE: 연산자 해당되는 문자열이 해당 패턴과 일치하는지 확인하는 조건 연산자 
-- animal_type LIKE 'cat' : 내용물이 해당 컬럼에 실제로 존재하는지 아닌지를 확인
-- animal_type = 'cat' OR animal_type = Cat'...
-- LIKE는 대소문자 구분을 안하고 cat가 들어있으면 조건으로 인식한다.
-- WILD CARD : 내가 특정된 문자열을 만들어주는 키워드
------ '%': 해당 위치에 어떤 글자가 오더라도 상관이 없이 매칭. 아예 글자길이가 0이여도됨.
------ '_': 해당 위치에 1개의 글자가 어떤게 오더라도 상관없이 매칭시켜주는 키워드    

-- WHERE FISRT_NAME LIKE '동%'; -- 사용자의 이름이 동으로 시작하는 사람들 필터링 '동', '동그라미'...동이 맨앞이면 전부 매칭
-- WHERE FISRT_NAME LIKE '동_'; -- 사용자의 이름이 동으로 시작하는 두글자의 이름만 필터링하겠다. '동민', '동호'....

SELECT FIRST_NAME, LAST_NAME
FROM USERS
WHERE FIRST_NAME LIKE '%호%';

-- 14. 이름이 ‘준’으로 끝나는 사람들의 이름 조회하기
SELECT FIRST_NAME
FROM USERS 
WHERE FIRST_NAME LIKE '%준';	

-- 15. 서울 지역 전화번호를 가진 사람들의 이름과 전화번호 조회하기
SELECT * 
FROM USERS
-- WHERE PHONE LIKE '02-%' -- 02-050-1023-1204도 포함될 수 있다.
 WHERE PHONE LIKE '02-%-%';
-- 16. 나이가 20대인 사람들의 이름과 나이 조회하기
SELECT FIRST_NAME, AGE
FROM USERS
WHERE AGE LIKE '2_' ; 
-- 1. 혹은  WHERE AGE >= 20 AND AGE < 30 ;
-- 2. 혹은 WHERE AGE BETWEEN 20 AND 29 ;
-- 3. 나이가 2로 시작하는 사람은 위처럼. WHERE AGE LIKE '2_' ; 
-- 4. 나이가 십의 자리가 2로 되어 있는 사람 조회 WHERE FLOOR(AGE / 10) = 2

  
-- 17. 전화번호 중간 4자리가 ’51’로 시작하는 사람들의 이름과 전화번호 조회하기
SELECT FIRST_NAME, PHONE FROM USERS WHERE PHONE LIKE "%-51__-%";
-- 18. 경기도 혹은 강원도에 사는 사람들의 이름과 지역 조회하기
select first_name, country
from users
where country in("경기도", "강원도");
-- 19. 경기도 혹은 강원도에 살지 않는 사람들의 이름과 지역 조회하기
select first_name, country
from users
where country NOT in("경기도", "강원도");
-- 20. 나이가 20살 이상, 30살 이하인 사람들의 이름과 나이 조회하기
select FIRST_NAME, AGE
FROM USERS
WHERE AGE >= 20 AND AGE <= 30;


-- 21. 첫 번째 부터 열 번째 데이터까지 이름 조회하기

SELECT FIRST_NAME
FROM USERS
LIMIT 10;
-- 22. 계좌 잔고가 가장 많은 10명의 이름과 계좌 잔고 조회하기
SELECT FIRST_NAME, BALANCE
FROM USERS
ORDER BY BALANCE DESC
LIMIT 10
;

-- 23. 나이가 가장 어린 5명의 이름과 나이 조회하기
SELECT FIRST_NAME, AGE
FROM USERS
ORDER BY AGE
LIMIT 5;
-- 24. 11번째 부터 20번째 데이터의 이름 조회하기

SELECT FIRST_NAME
FROM USERS
-- LIMIT 10 OFFSET 10;
LIMIT 10, 10;

-- 25. user 테이블의 전체 행 수 조회하기
SELECT COUNT(FIRST_NAME)
FROM USERS;


-- 26. 전체 유저의 평균 계좌 잔고 조회하기
SELECT AVG(BALANCE) 
FROM USERS;


-- 27. 지역별 각각 계좌 잔고 평균 조회하기
SELECT ANY_VALUE(first_name), country, AVG(BALANCE)
FROM USERS
group by country
;

-- 28. 지역별 각각 계좌 잔고 평균을 잔고 평균 오름차순으로 조회하기
SELECT AVG(BALANCE)
FROM USERS
GROUP BY COUNTRY
ORDER BY  AVG(BALANCE);



-- 29. 나이가 30살 이상인 사람들의 평균 나이를 조회하기
SELECT AVG(AGE)
FROM USERS
WHERE AGE >= 30;

-- 29. 지역별 나이가 30살 이상인 사람들의 평균 나이를 조회하기
SELECT country, AVG(AGE)
FROM USERS
WHERE AGE >= 30
group by country;


-- 30. 각 지역별로 몇 명씩 살고 있는지 조회하기
SELECT COUNTRY, COUNT(*)
FROM USERS
GROUP BY COUNTRY;


-- 31. 각 성씨가 몇 명씩 살고 있는지 조회하기
SELECT LAST_NAME, COUNT(*)
FROM USERS
GROUP BY LAST_NAME;

-- 32. 인원이 가장 많은 성씨 순으로 조회하기
SELECT LAST_NAME, COUNT(*)
FROM USERS
GROUP BY LAST_NAME
ORDER BY COUNT(*) DESC;

-- 33. 각 지역별 평균 나이 조회하기
SELECT COUNTRY, AVG(AGE)
FROM USERS
GROUP BY COUNTRY;


-- INSERT
-- 1. 단일 행 삽입하기
-- 2. 여러 행 삽입하기

-- UPDATE
-- 1. 두번째 행의 이름을 ‘김철수한무두루미’로, 주소를 ‘제주도’로 수정하기

-- DELETE
-- 1. 다섯번째 행의 데이터를 삭제하기
-- 2. 이름에 ‘영’이 포함되는 데이터 삭제하기
-- 3. 테이블의 모든 데이터 삭제하기

-- *따로 제공된 DB가 없습니다. SQL문을 어떻게 작성할지를 구상해보시면 됩니다.
-- JOIN
-- 1. 게시글과 작성된 유저의 이름 정보를 같이 가져오기
-- 2. 게시글과 작성된 유저가 일부 삭제된 테이블에서 이름 정보를 같이 가져오기 (이 때에 모든 게시글 레코드는 출력 결과에 포함되어 있어야함)