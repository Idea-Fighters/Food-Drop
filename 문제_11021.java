package 반복문;
import java.util.Scanner;
public class 문제_11021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int A,B;
		for(int i =1; i<=T; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			System.out.println("Case #"+i+": "+(A+B));
		}
	}
}