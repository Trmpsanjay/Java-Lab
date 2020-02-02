import java.util.*;

public class ArrayOperationWithoutMerge
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int loc,val,pos;

		functions f=new functions();
		int array[]=new int[100];
		int n;
		System.out.println("Enter the no elements to be inserted");
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			array[i]=sc.nextInt();
		}
		System.out.print("press \n 1.display \n 2.insert \n 3.Delete ");
		
		int choice=sc.nextInt();
		switch(choice)
		{
			case 1: {f.display(array,n);
			break;}
			case 2: {System.out.println("Enter Location and value to be inserted");
			loc=sc.nextInt();
			val=sc.nextInt();
			f.insert(array,n,loc,val);
			n++;
			f.display(array,n);
			break;}
			case 3: {
				System.out.println("Enter The position to be deleted");
				pos=sc.nextInt();
				f.delete(array,n,pos);
				n--;
				f.display(array,n);
				break;
			}


		}

		
	}

}



class functions
{
	public void insert(int arr[],int size,int location,int value)
	{
		//System.out.println("Please enter the elements to be inserted");
		for(int i=size;i>=location-1;i--)
		{
			arr[i+1]=arr[i];
		}
		//size++;
		arr[location-1]=value;
	}

	public void delete(int arr[],int size,int location2)
	{
//out.println("Enter the element position to be deleted");
		for(int i=location2;i<size;i++)
		{
			arr[i]=arr[i+1];
		}
		//size--;
	}

	public void display(int arr[],int size)
	{
		//System.out.println("Array Elements are");
		for(int i=0;i<size;i++)
		{
			System.out.println(arr[i]);
		}
	}
}
