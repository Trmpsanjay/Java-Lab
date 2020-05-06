/***********
Question : Rotate Linked List
URL :https://codezen.codingninjas.com/practice/469/776/rotate-linked-list
 
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

	
	public static ListNode<Integer> changeList(ListNode<Integer> head, int n) {
        if(n==0)
            return head;
         if(head==null)
             return head;
        if(head.next==null){
            return head;
        }
        ListNode<Integer> temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<count-n-1;i++){
            temp=temp.next;
        }
   		ListNode<Integer> tempNew=temp.next;
        temp.next=null;
        temp=tempNew;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        return tempNew;
        
		// Write your code here

	}
}

