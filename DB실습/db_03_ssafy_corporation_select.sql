USE SSAFY_CORPORATION;


#LIMIT: 개수를 제한하여 볼 수 있다.
SELECT *
FROM EMP
ORDER BY SAL DESC
LIMIT 5, 5; -- 5명제끼고 이후에 5명 출력 





-- 1) COUNT의 차이: COUNT(*) vs COUNT(col)
--    - COUNT(*) : 모든 행 (NULL 포함) 개수
--    - COUNT(col): 해당 컬럼이 NULL이 아닌 행만
SELECT 
	COUNT(*) AS ROWS_ALL,
    COUNT(SAL), # 카운트 함수는 NULL을 제외한다.
    COUNT(COMM) #SAL은 널이 없고 COMM은 널이 있어서 COMM의 카운트값이 더 작다.
FROM EMP;

-- 2) SUM/AVG의 NULL 무시 특성
--    - SUM/AVG은 기본적으로 NULL을 계산에서 제외함
SELECT SUM(SAL), SUM(COMM), ROUND(AVG(SAL), 2), AVG(COMM)
FROM EMP;

-- 3) '커미션을 0으로 간주한' 평균
--    - IFNULL/COALESCE로 NULL을 0으로 치환해서 평균에 반영
SELECT ROUND(AVG( IFNULL(COMM, 0)), 2) AS IFNULL_AVG,
		ROUND(AVG(SAL + COALESCE(COMM, 0)), 2) AS IFNULL_AVG
FROM EMP;


-- 4) MIN/MAX 기본 사용


-- 5) DISTINCT와 함께: 서로 다른 직무 수
SELECT COUNT(*), COUNT(DISTINCT JOB)
FROM EMP;

-- 6) 한 번에 여러 지표 요약해서 레포트처럼 보기
SELECT 
	COUNT(*) AS EMP_CNT,
    COUNT(DISTINCT JOB) AS JOBS_CNT,
    SUM(SAL) AS TOTAL_SAL,
    ROUND(AVG(SAL), 2) AS AVG_SAL,
    MIN(SAL),
    MAX(SAL),
    ROUND(AVG( IFNULL(COMM, 0)), 2) AS IFNULL_AVG
FROM EMP;

-- 7) 부서별 급여 요약 (DEPTNO 기준)
SELECT
	DEPTNO,
	COUNT(*) AS EMP_CNT,
    SUM(SAL)
FROM EMP
GROUP BY DEPTNO;


-- 8) 직무별 인원/평균 급여
SELECT
	JOB,COUNT(*) AS n,
    ROUND(AVG(SAL), 2)
FROM EMP
GROUP BY JOB;

-- 9) 입사 연도별 인원수
SELECT YEAR(HIREDATE) AS HIRE_YEAR,COUNT(*)
FROM EMP
GROUP BY year(HIREDATE)
ORDER BY HIRE_YEAR;

-- 10) WHERE로 전처리 후 GROUP BY (성능/의미상 권장)
--     예) 1981년 입사자만 대상으로 부서별 인원
SELECT DEPTNO, COUNT(*)
FROM EMP
WHERE YEAR(HIREDATE) = 1987
GROUP BY DEPTNO;

-- 11) 부서별 평균급여 ≥ 2000 AND 인원 ≥ 3
SELECT DEPTNO, COUNT(*), AVG(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000 AND COUNT(*) >= 3;

-- 12) WHERE + HAVING 함께 쓰기 (역할 분리)
--      WHERE: 그룹 전 필터 / HAVING: 그룹 후 집계조건 필터
 -- SAL1000이상 / 전체 커미션 포함 평균 연봉이 2000이상 
SELECT JOB, COUNT(*)
FROM EMP
WHERE SAL >= 1000
GROUP BY JOB
HAVING AVG((SAL + IFNULL(COMM, 0))) >= 2000;

-- 13_ 부서별 서로 다른 직무 수 ≥ 3
select  count(distinct job) 
from emp
group by deptno
having count(distinct job) >= 3;

-- 14) (참고) GROUP BY 없이 HAVING (전체 집계 필터)
SELECT AVG(SAL)
FROM EMP
HAVING AVG(SAL) >= 1000;

-- 15) 부서별 급여 합 + 전체 총계
SELECT IF(GROUPING (DEPTNO), 'ALL SUM', SUM(SAL)) AS DEPT_SUM, SUM(SAL)
FROM EMP
GROUP BY DEPTNO WITH ROLLUP;

-- 16) 부서×직무 합계 + 부서 소계 + 전체 총계 (라벨링)
SELECT IF(GROUPING(DEPTNO), 'ALL_DEPT', DEPTNO) AS DEPT,
IF(GROUPING(JOB), 'SUB_TOTAL', JOB) AS JOB,
SUM(SAL)
FROM EMP
GROUP BY DEPTNO, JOB WITH ROLLUP;

-- 17) 모든 사원에 대하여 사원수, 급여총액, 평균급여, 최고급여, 최저급여 조회


-- 18) 모든 사원에 대하여 부서, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별로 조회하고, 소수점 둘째자리 반올림


-- 19) 모든 사원에 대하여 부서, 업무, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별, 직급별로 조회


-- 20) 급여(커미션포함) 평균이 2000이상인 부서번호, 부서별 사원수, 평균급여(커미션포함) 조회 


