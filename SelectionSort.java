import java.util.*;
class functions{
	void sort(int arr[]){
		int i,j,temp=0,min;
        for(i=0;i<arr.length-1;i++){
        	min=i;
            for(j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min])
                	min=j;
            }
                 temp=arr[min];
                 arr[min]=arr[i];
                 arr[i]=temp;
            
        }
	}
}

class SelectionSort{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		functions f=new functions();
		System.out.println("Enter the Array size");
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++){
			System.out.println("enter the element");
			arr[i]=sc.nextInt();
		}
		System.out.println("************The sorted Array Element is**********");
		f.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
