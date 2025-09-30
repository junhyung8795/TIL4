USE SSAFY_CORPORATION;

-- 한 줄 주석
# 한 줄 주석
/*
	여러 줄 주석
*/

# Q1. 모든 사원 모든 정보 검색
-- select *
-- from emp;

# Q2-1. 사원이 근무하는 부서 번호
-- select DEPTNO 
-- from emp;

# Q2-2. 사원이 근무하는 부서 번호(중복제거)
-- select DISTINCT ename, deptno 
-- from emp;

# Q3. 사원의 이름, 부서번호, 업무 조회
-- SELECT ename, deptno, JOB
-- from emp;


# Q4. 사원의 이름, 사번, 급여*12 (연봉), 업무 조회
-- SELECT ename, empno, sal * 12 AS "연봉" , job from emp;


# Q5. 사원의 이름, 사번, 커미션, 급여, 커미션 포함 급여 조회
 SELECT ename, empno, comm, sal, sal+comm "커미션 포함 급여1", sal+ifnull(comm, 0)
 from emp;



# Q6. 모든 사원의 사번, 이름, 급여, 급여 등급  조회 (5000 이상 -> 높은연봉, 2000 이상 -> 평균 연봉, 그 외 -> 낮은연봉)
SELECT empno, ename, sal, 
		CASE WHEN sal >= 5000 THEN "높은 연봉"
			WHEN sal >= 2000 THEN "평균연봉"
			 ELSE "낮은 연봉"
		END "연봉 등급"
FROM emp;



# Q7. 부서 번호가 30인 사원중 급여가 1500 이상인 사원의 이름, 급여, 부서번호 조회
SELECT *
FROM EMP
WHERE DEPTNO = 30 AND SAL >= 1500;



# Q8. 부서번호가 20 또는 30인 부서에서 근무하는 사원의 사번, 이름, 부서번호 조회
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO = 20 OR DEPTNO = 30;

# Q9. 부서번호가 20,30이 아닌 부서에서 근무하는 사원의 사번, 이름, 부서번호 조회
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO != 20 AND DEPTNO != 30;

# Q10. 업무가 'MANAGER', 'ANALYST', 'PRESIDENT' 인 사원의 이름, 사번, 업무조회
SELECT ENAME, EMPNO, JOB
FROM EMP
WHERE JOB IN ('MANAGER', 'ANALYST', 'PRESIDENT');



# Q11. 부서번호가 10, 20이 아닌 사원의 사번, 이름, 부서번호 조회
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO NOT IN (10, 20);


# Q12. 급여가 2000이상 3000이하 인 사원의 사번, 이름, 급여조회
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL BETWEEN 2450 AND 3000;


# Q13. 입사일이 1981년인 직원의 사번, 이름, 입사일 조회
SELECT EMPNO, ENAME, HIREDATE
FROM EMP
WHERE HIREDATE BETWEEN '1981-01-01' AND '1981-12-31';

# Q14. 커미션인 NULL 인 사원의 사번, 이름, 커미션 조회
SELECT EMPNO, ENAME, COMM
FROM EMP
WHERE COMM IS NULL;

# Q15. 커미션 NULL이 아닌 사원의 사번, 이름, 업무, 커미션 조회
SELECT EMPNO, ENAME, JOB, COMM
FROM EMP
WHERE COMM IS NOT NULL;
# Q16. 이름이 M으로 시작하는 사원의 사번, 이름 조회
SELECT EMPNO, ENAME 
FROM EMP
WHERE ENAME LIKE 'M%';


# Q17. 이름에 E가 포함된 사원의 사번 이름 조회
SELECT EMPNO, ENAME 
FROM EMP
WHERE ENAME LIKE '%E%';



# Q18. 이름의 세번째 알파벳이 'A'인 사원의 사번, 이름 조회
SELECT EMPNO, ENAME 
FROM EMP
WHERE ENAME LIKE '__A%';
# Q19. 모든 직원의 모든 정보를 이름을 기준으로 내림차순 정렬
SELECT *
FROM EMP
ORDER BY ENAME DESC;
# Q20. 모든 사원의 사번, 이름, 급여를 조회 (급여 내림차순)
SELECT EMPNO, ENAME, SAL
FROM EMP
ORDER BY SAL DESC;


# Q21. 20, 30번 부서에 근무하는 사원의 사번, 이름, 부서번호, 급여 조회 (부서별 오름차순, 급여순 내림차순)
SELECT EMPNO, ENAME, DEPTNO, SAL
FROM EMP
WHERE DEPTNO IN (20, 30)
ORDER BY DEPTNO ASC, SAL DESC;


