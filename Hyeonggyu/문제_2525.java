package if문;
import java.util.Scanner;
public class 문제_2525 {

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int H,M,C,sum;
        H = sc.nextInt();
        M = sc.nextInt();
        C = sc.nextInt();
        sum = M+C;
        if(0<=H&&H<=23&&0<=M&&M<=59&&0<=C&&C<=1000)
	        if(sum>=60){
	            H +=sum/60;
	            sum  = sum%60;
	            }
	       	if(H>=24)
	       		H -=24;
	       	
		System.out.println(H + " " + sum);
	}	
}