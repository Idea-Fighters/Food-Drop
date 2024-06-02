package _1차원배열;
import java.util.Scanner;
public class 문제_10871 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int ar[] = new int[N];
		//int minar[];
		int count = 0;
		for(int i=0; i<N;i++) {
			int num = sc.nextInt();
			ar[i] = num;
			if(ar[i]<X)
				System.out.print(ar[i]+" ");
		}
		
	}
}