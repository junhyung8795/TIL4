// let 함수명 = function() { 함수 내용 }

// 익명함수로 정의가능
// 매개 변수
// 내용

/* 자유롭게 코드를 작성해보세요. */
let greeting3 = function(name){
    return `Welcome, ${name}`
}

console.log(greeting3('KANK'))

console.log(greeting4('park'))
//선언식은 호이스팅의 영향을 받지만
//아래와같은 표현식은 호이스팅의 영향을 안받는다.
let greeting4 = function(name){
    return `Welcome, ${name}`
}