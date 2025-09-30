--  기본 연산 절삭 반올림 최대 최솟값.
SELECT 
	ABS(-1019) AS ABS,
    CEIL(3.14) AS 올림,
    FLOOR(3.14) AS 내림,
    ROUND(3.141592, 2) AS "2자리수까지 표현",
    POW(2, 5) AS "2^5=32",
    MOD(17, 5) AS "MOD",
    GREATEST(10,20,5) AS "MAX";
-- FROM DUAL; 





-- ============================================================
-- 1) Numeric Functions (수치 함수)
-- ============================================================
-- 기본 연산/절삭/반올림/최댓값·최솟값



-- ============================================================
-- 2) String Functions (문자열 함수)
-- ============================================================
-- 대소문자/길이/부분 문자열/검색/치환/패딩/트림/뒤집기
SELECT 
	ENAME,
    UPPER(ENAME),
    LOWER(ENAME),
    LENGTH(ENAME),
    CHAR_LENGTH(ENAME),
    SUBSTRING(ENAME, 1,3),
    LEFT(ENAME, 2),
    RIGHT(ENAME, 2),
    REPLACE(ENAME, 'A', '*')
FROM EMP
LIMIT 5;


-- 공백/문자 패딩 & 트림, 연결
SELECT 
	CONCAT("HELLO. ", ENAME),
    LPAD(ENAME, 10, '*'),
    RPAD(ENAME, 10, '*'),
    TRIM('         SSAFY      '),
    REVERSE(ENAME)
FROM EMP;

-- 멀티바이트 길이 차이(참고)
-- SELECT 
-- 	LENGTH('가'), #길이가 3이 나온다.
--     CHAR_LENGTH('가') # 길이가 1이 나온다.
    

-- ============================================================
-- 3) Date / Time Functions (날짜·시간 함수)
-- ============================================================
-- 현재 시각/날짜 파생/형식화
SELECT 
	curdate(),  -- 오늘 날짜 반환
    NOW(), -- 날짜에서 현재 시간가지 반환
    DATE(NOW()),
	TIME(NOW()),
    YEAR(CURDATE()),
	MONTH(CURDATE()),
    DAY(CURDATE()),
    YEARWEEK(CURDATE()),
    DATE_FORMAT(CURDATE(), '%y-%m-%d (%a)');







-- 입사일 파생 컬럼





-- 날짜 가감/차이
SELECT 
	DATE_ADD(CURDATE(), INTERVAL 10 DAY),
    DATE_ADD(CURDATE(), INTERVAL 2 MONTH),
    datediff(CURDATE(), '2025-07-08');

-- 문자열 → 날짜 파싱 & 다시 포맷




-- 직원별 근속(연/월/일 단위) 예시


-- ============================================================
-- 4) NULL & Conditional (NULL 처리 / 조건 함수)
-- ============================================================
-- NULL 처리: IFNULL, COALESCE, NULLIF





-- 조건식: IF / CASE WHEN
SELECT
	ENAME, SAL,
    IF(SAL >= 3000, 'HIGH', 'NORMAL'),
    CASE
		WHEN SAL >= 3000 THEN '고액연봉'
        WHEN SAL >= 2000 THEN '평균연봉'
        ELSE '낮은 연봉'
	END
FROM EMP;

-- 조건부 합계(그룹 없이 전체 기준)
SELECT 
	sum(if(COMM IS NULL, 1, 0))
FROM EMP;

