/*********
Question and URL
https://codezen.codingninjas.com/practice/469/766/rearrange-odd-and-even-places


Rearrange odd and even places
Level MEDIUM
Rearrange and return a linked list in such a way that all odd position nodes are together and all even positions node are together
You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Updated list elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
 1 2 3 4 5 6 7 8 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 4.
Sample Output :
 1 3 5 7 2 4 6 8





************/



/***********
 
Following is the Linked list node structure already written 
 
class ListNode<t> {
	public t data;
	 public ListNode<t> next;
	 public ListNode(t data)
	 {
		 this.data=data;
	 }
}

************/


public class solution {
    
	private static int length(ListNode<Integer> head){
        int length=0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
	
	public static ListNode<Integer> changelist(ListNode<Integer> head) {
         
        if(head.next==null || head==null)
            return head;
        
        //calculating length
        int length=length(head);
//         //checking correctness of length
//         System.out.println(length);
        ListNode<Integer> evenHead = null;
        ListNode<Integer> evenTail = null;
        ListNode<Integer> oddHead = null;
        ListNode<Integer> oddTail = null;
        ListNode<Integer> temp=head;
    //separating both lists
        
        for(int i=1;i<=length && temp != null;i++){
            //separating even list
            if(i%2==0){
                if(evenHead==null){
                    evenHead=temp;
                    evenTail=temp;
                }else{
                    evenTail.next=temp;
                    evenTail=temp;
                }
            }
            //separating odd list
            else{
                if(oddHead==null){
                    oddHead=temp;
                    oddTail=temp;
                }else{
                    oddTail.next=temp;
                    oddTail=temp;
                }
            }
            temp=temp.next;
            
        }
         if(oddTail.next!=null)
             oddTail.next=null;
        if(evenTail.next!=null){
            evenTail.next=null;
        }
        oddTail.next=evenHead;
        
        //checking odd list
//         ListNode<Integer> test=oddHead;
//         while(test!=null){
//             System.out.print(test.data+" ");
//             test=test.next;
//         }
//         System.out.println();
        
        
//         //checking even list
//         test=evenHead;
//         while(test!=null){
//             System.out.print(test.data+" ");
//             test=test.next;
//         }
//         System.out.println();
// //         evenTail.next=null;
// //         oddTail.next=null;
// //         oddTail.next=evenTail;
// //         return oddHead;
//         return null;
        
        //linking oddlist with even
        
        
        
        
        
        
        
        
        
        
        
        
        
        
     // i should check it carefully.   
        
        
  //here last odd element is missing don't know why even dry run is ok          
//         while(temp!=null && temp.next!=null && temp.next.next!=null){
//             if(oddHead == null){
//                     oddHead = temp;
//                     oddTail = temp;
//                 }
//                 else{
//                     oddTail.next = temp;
//                     oddTail =temp;
//                 }
//             temp=temp.next.next;
//         }
//        // checking odd list is correct or not;
//         //oddTail.next.next=null;
// //         ListNode<Integer> check=oddHead;
// //         while(check!=null){
// //             System.out.print(check.data+" ");
// //             check=check.next;
// //         }
// //         System.out.println();
        
//         temp=head.next;
//         while(temp!=null && temp.next!=null && temp.next.next!=null){
//             if(evenHead==null){
//                 evenHead=temp;
//                 evenTail=temp;
//             }else{
//                 evenTail.next=temp;
//                 evenTail=temp;
//             }
//             temp=temp.next.next;
//         }
//         //evenTail.next=null;
//         oddTail.next=evenHead;
 	      
        
        
        
        
        
        
        
        
        
        return oddHead;
        
            
            
            
            
       
	}
}

