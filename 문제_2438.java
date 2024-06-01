package 반복문;
import java.util.Scanner;
public class 문제_2438 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for(int i=1;i<=N;i++) {
			String star = "*";
			System.out.println(star.repeat(i));
		}	
	}
}