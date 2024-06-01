package _1차원배열;
import java.util.Scanner;
public class 문제_5597 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ar[] = new int[30];
		int min = 0;
		int max = 0;
		for(int i = 0; i<30; i++) {
			ar[i] = i+1;
		}
		int arr[] = new int[30];
		for(int j = 0; j<28;j++) {
			int N = sc.nextInt();
			arr[N-1] = N;
		}
		for(int k=0; k<30; k++) {
			if(ar[k]!=arr[k]) {
				min = ar[k];
				
				System.out.println(min);
							
			}
		}
	}
}