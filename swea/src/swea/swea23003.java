package swea;
import java.util.Scanner;

public class swea23003 {
	public static void main(String[] args){
   		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] colors = new String[]{"red", "orange", "yellow", "green", "blue", "purple", "red", "orange", "yellow", "green", "blue", "purple"};
        for(int t = 0 ; t < T; t++){
        	String first = sc.next();
            String second = sc.next();
            int firstIndex = 0;
          
            for(int i = 0; i < 6; i++) {
            	if (first.equals(colors[i])) {
            		firstIndex = i;
            		break;
            	}
            }
            
            
            if(first.equals(second)){
            	System.out.println("E");
            } else {
            	if(colors[firstIndex+ 3].equals(second)){
                	System.out.println("C");
                } else if(colors[firstIndex + 1].equals(second) || colors[firstIndex + 5].equals(second)){
                	System.out.println("A");
                } else{
                	System.out.println("X");
                }
            }

        }
        sc.close();
    }
}
