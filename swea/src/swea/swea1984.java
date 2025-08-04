package swea;

import java.util.Arrays;
import java.util.Scanner;

public class swea1984 {
	public static void main(String[] args){
        //입력
    	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        
        //로직
        for(int t = 0 ; t < T; t++){
        	int minNumber = Integer.MAX_VALUE;
            int maxNumber = 0;
            int[] numArr = new int[10];
            for(int i = 0 ; i < 10; i++){
            	int num = sc.nextInt();
                if(minNumber > num){
                	minNumber = num;
                }
                if(maxNumber < num){
                    maxNumber = num;
                }
                numArr[i] = num;
            }
            Arrays.sort(numArr);
            double sizeOfArr = 0;
            double total = 0;
            for(int i = 0; i < 10; i++){
            	if (numArr[i] != minNumber && numArr[i] != maxNumber){
                	sizeOfArr++;
                    total += numArr[i];
                }
            }
            int answer =(int) Math.round
            		( total / sizeOfArr);
            
            
            System.out.printf("#%d %d", t + 1, answer);
            System.out.println();
        }
        
        
        
    }}
