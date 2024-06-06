package _1차원배열;
import java.util.Scanner;
public class 문제_10807 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ar[] = new int[N];
		int count = 0;
		
		for(int i=0; i<N;i++) {
			int num = sc.nextInt();
			ar[i] = num;
			
		}
		int v = sc.nextInt();
		for(int i=0;i<ar.length;i++)
			if(ar[i]==v)
				count++;
		
		System.out.println(count);
	}
}