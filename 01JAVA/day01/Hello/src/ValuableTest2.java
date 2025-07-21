
public class ValuableTest2 {
public static void main(String[] args) {
	int a = 10;
	System.out.println(a);
	System.out.println(++a); // 전위증가
	System.out.println(a); 
	
	System.out.println(a);
	System.out.println(a++); // 후위증가
	System.out.println(a); 
	
	a = 10;
	System.out.println(++a + a++);
	System.out.println(a++ + a++); 
	
	String str1 = "sadsad";
	String str2 = new String("sadsad");
	System.out.println(str1 == str2);
}
}
