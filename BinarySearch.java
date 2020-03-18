import java.util.*;
class function{
	public void sorting(int arr[]){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>=arr[j+1]){
					int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
				}
			}
		}
	}
	public void binarySearch(int arr[],int key){
		int first=0,last=arr.length-1;
		int mid=(first+last)/2;
		while(first<=last){
			if(arr[mid]==key){
				int m=mid+1;
				System.out.println("\n "+key+"found at position"+m);
				break;
			}
			else if(arr[mid]>key){
				last=mid-1;
			}
			else
				first=mid+1;
			mid=(first+last)/2;
		}
	}
}

class BinarySearch{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		function f=new function();
		System.out.println("Enter the size of the array");
		int size=sc.nextInt();
		int arr1[]=new int[size];
		for(int i=0;i<size;i++){
			arr1[i]=sc.nextInt();
		}
		System.out.print("enter the number to be searched");
		int serach=sc.nextInt();
		f.sorting(arr1);
		System.out.println("sorted arrays are");
		for(int i=0;i<size;i++)
			System.out.print(arr1[i]+" ");
		f.binarySearch(arr1,serach);
	}
}
