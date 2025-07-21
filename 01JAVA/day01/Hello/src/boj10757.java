import java.io.*;
import java.util.*;
import java.math.BigInteger;


class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        //a+b는 합하면 long으로도 다 못담는다. 가변적인 크기를 갖는 참조자료형을 사용해보자
        //BigInteger를 사용해보자!
        //long a = scanner.nextLong();
        //long b = scanner.nextLong();
        
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        
        //BigInteger는 별도로 + - 할 수가없고 메서드 써야한다.
        System.out.println(a.add(b));
    }
}