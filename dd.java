package if문;
import java.util.Scanner;
public class dd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		
		int	A = sc.nextInt();
		int B = sc.nextInt();
		int	C = sc.nextInt();
		
		B +=C;
		
		if(B >= 60) {
			A += B / 60;
			B = B % 60;
		}
		// 시간이 24를 넘으면 24를 뺀다.
		if(A >= 24) { 
			A -= 24;
		}
		
		System.out.println(A+" "+B);

	}

}
