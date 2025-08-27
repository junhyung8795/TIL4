// function 함수명() { 함수 내용 }

// 함수의 이름과 함께 정의하는 방식
// 함수의 이름
// 매개 변수
// 내용
// 호이스팅 됨

/* 자유롭게 코드를 작성해보세요. */
function greeting(name){
    //백틱은 템플릿 리터러 방식
    // "Welcome, " + name
    return `Welcome, ${name}`
}

console.log(greeting('Kim'))


//호이스팅 체크
console.log(greeting2('Lee'))

function greeting2(name){
     //백틱은 템플릿 리터러 방식
    // "Welcome, " + name
    return `Welcome, ${name}`
}
