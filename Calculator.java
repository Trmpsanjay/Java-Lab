import java.util.*;
class Calculator{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a,b;
		int choice;


		do{
			System.out.println("\n \n \n 1.Add \n 2.Substract");
			System.out.println("3.Multiply \n 4. Divide");
			a=sc.nextInt();
			b=sc.nextInt();
			choice=sc.nextInt();

			switch(choice){
				case 1: System.out.println(a+b);
						break;
				case 2:	System.out.println(a-b);
						break;
				case 3: System.out.println(a*b);
						break;
				case 4: System.out.println(a/b);
						break;
				default :System.out.println("Invalid option");
			}
		}
		while(choice<5);
	}
}