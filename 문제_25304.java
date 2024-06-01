package 반복문;
import java.util.Scanner;
public class 문제_25304 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X,N,a,b,i,hap;
		X = sc.nextInt();
		N = sc.nextInt();
		i = 1;
		hap = 0;
		do {
			a = sc.nextInt();
			b = sc.nextInt();
			hap +=a*b;
			i++;
		}while(i<=N);
		
		if(X==hap)
			System.out.println("Yes");
		else if(X!=hap){
			System.out.println("No");
		}
	}
}