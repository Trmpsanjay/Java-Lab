public class Intersection{
	
	public static void intersection(int[] arr1, int[] arr2){
        int len1=arr1.length;
        int len2=arr2.length;
        int min=Math.min(len1,len2);
        int max=Math.max(len1,len2);
        int i,j;
        if(max==len1){
            for(i=0;i<len2;i++){
                for(j=0;j<len1;j++){
                    if(arr2[i]==arr1[j]){
                        System.out.println(arr2[i]);
                        break;
                    }
                }
            }
        }
        else{
            for(i=0;i<len1;i++){
                for(j=0;j<len2;j++){
                    if(arr1[i]==arr2[j]){
                        System.out.println(arr1[i]);
                        break;
                    }
                }
            }
        }
        
		/* Your class should be named Intersection
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Print output and don't return it.
	 	 * Taking input is handled automatically.
  		 */

	}
