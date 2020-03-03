import java.util.*;
public class SumOrProduct {
	
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int choice=sc.nextInt();
        int num1=num*(num+1)/2;
        int i,fact=1;
        if(choice==1)
            System.out.println(num1);
        else if(choice==2){
            if(num==0 ||num==1)
                System.out.println("1");
            else{
                for(i=1;i<=num;i++)
                    fact=fact*i;
                System.out.println(fact);
            }
            
        }
        else
             System.out.println("-1");
		// Write your code here

	}
}
