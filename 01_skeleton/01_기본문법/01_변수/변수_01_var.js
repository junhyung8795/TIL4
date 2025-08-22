// var
// 함수 스코프 //
// - 재 선언 가능, 재 할당 가능
// - 호이스팅(Hoisting) 특성이 있음

/* 코드를 작성해보세요. */
//분명 name이 선언안된시점에도 호이스팅으로인해 변수가 싹다위로 올라온다음 그다음에 함수를 실행해서
//없는게 당연한 시점에도 name이 작동한다. 아래경우는 10이뜬다 KIm Park이 안뜬다.
console.log(name)
var name = "Kim"
// console.log(name)
name = "Park";
// console.log(name)
var name = 10
