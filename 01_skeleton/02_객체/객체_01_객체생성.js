// 객체 만들기 

/* 자유롭게 코드를 작성해보세요. */
let student = {
    name : "Kim",
    age: 45,
    hobby : ["공부" , 게임],
    pl : {
        name: "Java"
    },
    favorite singer: "Yohan";

}
// student[age] --> student["age"]대괄호로 접근하고싶으면 프로퍼티를 문자열로 바꾸고
// student."favorite singer"로 처럼 .으로 할때는 문자열로하면 안된다.
// 프로퍼티가 공백을 포함하거나해서 문자열로 표현해버렸다면 []안에 해당 문자열을 넣어서 접근해야한다.