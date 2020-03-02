import java.util.*;
public class SumOfOddEvenPlace {
	
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int even=0;
        int odd=0;
        int length=0;
        int i;
        int num=n;
        int num1=n;
        int rev=0;
        while(num1!=0){
            rev = (rev * 10) + (num1 % 10); 
            num1=num1/10;
        }
        System.out.println(rev);
        int rem=0;
        while(n!=0){
            length=length+1;
            n=n/10;
        }
        for(i=1;i<=length && rev!=0;i++){
            rem=rev%10;
            if(i%2==0)
                even=even+rem;
            else
                odd=odd+rem;
            rev=rev/10;
                
        }
        System.out.print(even+"   ");
        System.out.print(odd);
        // Write your code here

	}
}
