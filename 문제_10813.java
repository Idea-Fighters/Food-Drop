package _1차원배열;
import java.util.Scanner;
public class 문제_10813 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ar[] = new int[N];
		for(int k=0;k<N;k++) {
			ar[k] = k+1;
		}

		for(int p=0; p<M; p++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			int ind = ar[i-1];
			ar[i-1] = ar[j-1];
			ar[j-1] = ind;

		}
		for(int arry : ar) {
			System.out.print(arry+" ");
		}
	}
}