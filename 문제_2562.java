package _1차원배열;
import java.util.Scanner;
public class 문제_2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		int array[] = new int[9];
		int index = 0;
		int max = 0;
		
		
		for(int i =0; i <array.length;i++) {
			N = sc.nextInt();
			array[i] = N;
			if(array[i]>max) {
				max = array[i];
			}
		}
		for(int j=0;j<array.length; j++) {
			if(max==array[j]) {
				index = j+1;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}