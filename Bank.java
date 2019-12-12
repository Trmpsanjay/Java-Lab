import java.util.*;


class Banking{
Scanner sc=new Scanner(System.in);
	int balance;
	Banking(){
		balance=500;
	}
	


	int withdrawl,deposit;
public void debit()
{
	System.out.println("enter the amount to be withdrawl");
	withdrawl=sc.nextInt();
	if(balance<withdrawl)
		System.out.println("Insufficient Balance and balance is "+balance);
	else
	{
		balance=balance-withdrawl;
		System.out.println("Your account has been debitted successfully with "+withdrawl);
		System.out.println("Your Available Balance is "+balance);
	}


}

public void credit()
{
	System.out.println("Enter the amount to be creditted");
	deposit=sc.nextInt();
	balance=balance+deposit;
	System.out.println("Your account has been successfully deposited with"+deposit);
	System.out.println("Your available balance is "+balance);

}
}

public class Bank{
	public static void main(String[] args) {
		
			
			Banking b1=new Banking();
			b1.credit();
			b1.debit();
		}
	}
