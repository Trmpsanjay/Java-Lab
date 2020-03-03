import java.util.*;
public class TermsOfAp {
	
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i,j,num=0;
        for(i=0,j=1;i<n;i++,j++){
            num=3*j+2;
            if(num%4!=0)
                System.out.print(num+" ");
            else
            	i=i-1;
        }
		// Write your code here

	}
}
