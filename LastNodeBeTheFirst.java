/***********
Question : Let last be the First
URL: https://codezen.codingninjas.com/practice/469/778/let-last-be-the-first
 
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

	
	public static ListNode<Integer> lastToFront(ListNode<Integer> head) {
        ListNode<Integer> temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        ListNode<Integer> tempNew=temp.next;
        temp.next=null;
        tempNew.next=head;
        return tempNew;
		// Write your code here

	}
}

