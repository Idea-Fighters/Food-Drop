package if문;
import java.util.Scanner;
public class 문제_2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();

		// 1. 60분이 max치고 0뒤에 60이 와야함
		if(H<=23 && H>=1)
			if(M>=45 && M<=59) {
				System.out.println(H + " " + (M-45));
				//System.out.println(M-45);
			}
			else {
				M = (60+M-45);
				H -= 1;
				System.out.println(H + " " + M);
				//System.out.println(M);
					
				}
		
		if(H==0) 
			if(M>=45 && M<=59) 
				System.out.println(H + " " + (M-45));
				//System.out.println(M-45);
			else {
			M = (60+M-45);
			H = 23;
			System.out.println(H + " " + (M));
			//System.out.println(M);		
			}
		
	}
}