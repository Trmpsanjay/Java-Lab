import java.util.*;
public classBinaryToDecimal {
	
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
       double rem=0,i=0,ans=0;
        while(n!=0){
            ans=n%10;
            rem=rem+ans*Math.pow(2,i);
            i++;
            n=n/10;
        }
       System.out.print(Math.round(rem));
		// Write your code here

	}
}
