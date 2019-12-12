import java.util.*;
public class Factorial{
		

		public static void main(String[] args) {
			fac f=new fac();
			
			System.out.println("enter the number");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			int p=f.fact(n);
			System.out.println("Factorial is "+p);


	}
}

class fac{
	public int fact(int n)
		{
		if(n<=0)
			return 1;
		else
			return (n*fact(n-1));
	}
}