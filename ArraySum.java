import java.util.*;
class ArraySum{
	public static void main(String[] args) {
		
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter limit of the array");

	int size=sc.nextInt();
	int arr[]=new int[size];

	System.out.println("Enter the elements");
	for(int i=0;i<size;i++)
		arr[i]=sc.nextInt();
	int sum=0;
	for(int i=0;i<size;i++)
		sum=sum+arr[i];
	System.out.println("Sum of the array is "+sum);


}
}