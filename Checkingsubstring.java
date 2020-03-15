import java.util.*;
class Solution {

	
	public static void twoSubstrings(String str)
	{
        int ab=str.indexOf("AB");
        int ba=str.indexOf("BA");
        System.out.println(ab);
        System.out.println(ba);
        if(ba==ab+1 || ab==ba+1)
            System.out.println("no");
        else if(ab==-1 ||ba==-1 || ab==-1 && ba==-1)
        	System.out.println("no");
        else
            System.out.print("yes");
		// Write your code here
	}
}

class Checkingsubstring{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Solution s=new Solution();
        s.twoSubstrings(str);
    }
}

        /* You are given a string s. Your task is to determine,
         if the given string s contains two non-overlapping substrings "AB" and "BA" 
         (the substrings can go in any order). Print "yes" or "no".
        The string s contains uppercase Latin letters only.*/
    
