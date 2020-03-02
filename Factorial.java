import java.util.*;
class Factorial{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int fact=1;
		int num;
		System.out.println("Enter a Number");
		num=sc.nextInt();
		if(num==0 || num==1)
			System.out.println("1");
		else if(num<0)
			System.out.println("factorial of negarive number is not allowed");
		else{
			for(int i=1;i<=num;i++)
				fact=fact*i;
			System.out.println(fact);
		}

	}
}