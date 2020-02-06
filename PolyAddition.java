import java.util.*;

public class PolyAddition{
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int highest,loop,flag,p,q;
		int poly_array_coeff[]= new int[100];
		int poly_array[]=new int[100];
		System.out.println("enter highest degree of first polynomial");
		int degree_first=sc.nextInt();
		int degree_first_array[]=new int[degree_first+1];
		int degree_first_array_coeff[]=new int[degree_first+1];
		for(int i=0;i<=degree_first;i++){
			System.out.println("Enter coefficient of polynomial");
			degree_first_array_coeff[i]=sc.nextInt();
		}
		for(int i=0;i<=degree_first;i++){
			System.out.println("enter degree of polynomial");
			degree_first_array[i]=sc.nextInt();
		}
		System.out.println("enter highest degree of second polynomial");
		int degree_second=sc.nextInt();
		int degree_second_array[]=new int[degree_second+1];
		int degree_second_array_coeff[]=new int[degree_second+1];
		for(int i=0;i<=degree_second;i++){
			System.out.println("Enter coefficient of polynomial");
			degree_second_array_coeff[i]=sc.nextInt();
		}
		for(int i=0;i<=degree_second;i++){
			System.out.println("enter degree of polynomial");
			degree_second_array[i]=sc.nextInt();
		}
		if(degree_first>degree_second){
			loop=degree_first;
			flag=5;
			highest=degree_first-degree_second;
			for(int i=0;i<=highest-1;i++){
				poly_array_coeff[i]=degree_first_array_coeff[i];
				poly_array[i]=degree_first_array[i];

			}
			
		}
		else{
			highest=degree_second-degree_first;
			loop=degree_second;
			flag=6;
			for (int i=0;i<=highest-1 ;i++ ) {
				poly_array_coeff[i]=degree_first_array_coeff[i];
				poly_array[i]=degree_second_array[i];
				
			}
		}
		if(flag==5){
			for(p=highest,q=0;p<=loop-highest && q<degree_second+1;p++,q++){
				poly_array_coeff[highest]=degree_first_array_coeff[highest]+degree_second_array_coeff[q];
				poly_array[highest]=degree_second_array[q];
			}
		}
		if(flag==6){
			for(p=highest,q=0;p<=loop-highest && q<degree_first+1;p++,q++){
				poly_array_coeff[highest]=degree_second_array_coeff[highest]+degree_first_array_coeff[q];
				poly_array[highest]=degree_first_array[q];
			}

		}

		for(int i=0;i<=loop;i++){
			System.out.print(poly_array[i]);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=0;i<loop;i++)
		{
			System.out.print(poly_array_coeff[i]);
			System.out.print(" ");
		}
	}

}