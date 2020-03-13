import java.util.*;
class Palindrome{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word or Sentence");
		String name=sc.nextLine();
		char stack[] =new char[name.length()];
		for(int i=0;i<name.length();i++)
			stack[i]=name.charAt(i);
		int j=0,k=0,found=0;
		for(j=0,k=name.length()-1;j<name.length();j++,k--){
			if(stack[j]!=stack[k]){
				found=1;
				break;
			}
			else
				found=0;
		}
		if(found==0)
			System.out.println("Palindrome");
		else
			System.out.println("Not a Palindrome");

	}
}
