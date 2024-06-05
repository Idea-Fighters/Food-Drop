package if문;
import java.util.Scanner;
public class 문제_2480 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A,B,C,reword;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		reword = 0;
		
		if(A==B&&A==C&&B==C) 
			reword = 10000+(A*1000);
		
		else if(A==B||B==C||C==A)
				if(A==B)
					reword = 1000+(A*100);
				else if(B==C)
					reword = 1000+(B*100);
				else if(C==A)
					reword = 1000+(C*100);
		if(A!=B&&B!=C&&C!=A)
			if(A>B&&A>C)
				reword = A*100;
			else if(B>A&&B>C)
				reword = B*100;
			else if(C>A&&C>B)
				reword = C*100;
		
		System.out.println(reword);
	}
}