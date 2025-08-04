package swea;


	
import java.util.*;
class swea22574 {
	public static void main(String[] args){
   		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            int P = sc.nextInt();
            long answer = 0L;
            int[] numArr = new int[N + 1];
            for(int i = 0; i <= N; i++){
                boolean broken = false;
                for(int index = 1; index <= N; index++){
                    if(index == i){
                        
                        numArr[index] = numArr[index - 1];
                        
                        continue;
                    }
                    
                    numArr[index] = numArr[index - 1] + index;
                    if(numArr[index] == P){
                        broken = true;
                        break;
                    }
                }
                if (!broken){
                    answer = Math.max(answer, numArr[numArr.length - 1]);    
                }   
            }
           
            System.out.println(answer);
        
        }
            
        
    }
}
