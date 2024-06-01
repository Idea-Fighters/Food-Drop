package 반복문;
import java.util.Scanner;
public class 문제_25314 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String L = "long ";
		String S = "";
		//int A = N/4;
		
		for(int i=1; i <= N/4; i++)
			S +=L; 
		
		System.out.print(S + "int");

	}

}
