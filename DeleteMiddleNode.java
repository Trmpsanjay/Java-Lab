/***********
Question URL
https://codezen.codingninjas.com/practice/469/767/delete-middle-node



 
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
    private static ListNode<Integer> findmid(ListNode<Integer> head){
        if(head==null)
            return head;
        ListNode<Integer> slow=head;
        ListNode<Integer> fast=head;
        ListNode<Integer> prev=null;;
        while(fast.next != null && fast.next.next !=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return prev;
        
    }

	
	public static ListNode<Integer> deleteMid(ListNode<Integer> head) {
        ListNode<Integer> mid = findmid(head);
        mid.next=mid.next.next;
       // System.out.println(mid.data);
        return head;
		/* Your class should be named solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/

	}
}
