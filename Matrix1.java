import java.util.*;
public class Matrix1{
	public static void main(String[] args) {
		System.out.println("Enter the order of the matrix");
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int arr[][]=new int[m][n];
		System.out.println("Enter the elements");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				arr[i][j]=sc.nextInt();
		}
		System.out.println("Matrix");

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println("Transpose");

		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(arr[j][i]+" ");
			}
			System.out.println();
				
			}
			System.out.print("\n");
		}
	}
