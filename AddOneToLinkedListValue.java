/***********

Question : Add one to linked list value 
URL : https://codezen.codingninjas.com/practice/469/770/add-one-to-linked-list


 
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

	
	public static ListNode<Integer>  changelist(ListNode<Integer> head) {
        if(head==null){
            ListNode<Integer> n= new ListNode(1);
            return n;
        }
        if(head.next==null){
            if(head.data==9){
                head.data=1;
                ListNode<Integer> n= new ListNode<Integer>(0);
                head.next=n;
                return head;
            }
            head.data++;
            return head;
        }
        if(head.next.next==null){
            if(head.next.data==9){
                head.data++;
                head.next.data=0;
                return head;
            }else{
                head.next.data++;
                return head;
            }
        }
       ListNode<Integer> temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
            
        }
        if(temp.next.data==9){
            temp.data++;
            temp.next.data=0;
        }
        else{
            temp.next.data++;
        }
        return head;
		// Write your code here

	}
}

