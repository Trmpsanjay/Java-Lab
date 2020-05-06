/*********
Question and Url 
https://codezen.codingninjas.com/practice/469/771/divide-linked-list-in-two





Level MEDIUM
Write a function that takes one list and divides up its nodes to create two smaller lists A and B. The sub lists should be made from alternating elements in the original list.
Nodes should be in the reverse order of which they occurred in the source list.
Print both linked lists in different lines.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Line 1 : Output Linked List 1 elements (separated by space)
Line 2 : Output Linked List 2 elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
 8 2 5 9 1 4 3 7 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 8.
Sample Output :
 3 1 5 8
 7 4 9 2




*///////



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
    private static ListNode<Integer> reverse(ListNode<Integer> node) { 
        ListNode<Integer> prev = null; 
        ListNode<Integer> current = node; 
        ListNode<Integer> next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        node = prev; 
        return node; 
    } 

	public static void make2List(ListNode<Integer> head) {
        if(head==null)
            return;
        if(head.next==null){
            System.out.print(head.data);
            return;
        }
        
        //calculating length
        int length=length(head);
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
        //reversing odd list;
        ListNode<Integer> newOddNode=reverse(oddHead);
        //reversing even list;
        ListNode<Integer> newEvenNode=reverse(evenHead);
        
        
        //printing odd list
        ListNode<Integer> test=newOddNode;
        while(test!=null){
            System.out.print(test.data+" ");
            test=test.next;
        }
        System.out.println();
        
        
      //printing even  list
        test=newEvenNode;
        while(test!=null){
            System.out.print(test.data+" ");
            test=test.next;
        }
		// Write your code here

	}
}

