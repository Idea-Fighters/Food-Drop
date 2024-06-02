package _1차원배열;
import java.util.Scanner;
public class 문제_10810 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ar[] = new int[N];
		for(int p=1;p<=M;p++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			if(i<=N&&j<=N&&k<=N){
				for(int C = i;C<=j;C++) {
					ar[C-1] = k;
				}
			}
		
		}
		for(int AA:ar) {
			System.out.print(AA+" ");
		}
	}
}