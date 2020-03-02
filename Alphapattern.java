import java.util.*;
public class Alphapattern {

	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=64;
        int i,j;
       int n=sc.nextInt();
        for(i=0;i<=n;i++){
            for(j=0;j<i;j++)
                System.out.print((char)a);
            System.out.println();
            a++;
        }
        
		
		/* Your class should be named Solution.
	 	* Read input as specified in the question.
	 	* Print output as specified in the question.
		*/

		
	}

}
