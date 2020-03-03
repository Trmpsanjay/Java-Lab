import java.util.*;
public class DecimalToBinary {
	
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int rem=0;
        int arr[]=new int[20];
        int i=0;
        while(num!=0){
            rem=num%2;
            arr[i]=rem;
            num=num/2;
            i++;
        }
        for(int j=i-1;j>=0;j--)
            System.out.print(arr[j]);
		// Write your code here

	}
}
