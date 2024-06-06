package 반복문;
import java.util.Scanner;
public class 문제_8393 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int result = 0;
		for(int i=0;i<=num;i++)
			result +=i;
		
		System.out.println(result);
	}

}
