/*
Question : Change Start Node
URL: URL: https://codezen.codingninjas.com/practice/469/1932/change-start-node
2nd test cases got failed due to hidden case not able to identify the problem

 class ListNode<t> {
	public t data;
	public ListNode<t> next;
	public ListNode(t data){
 this.data=data;
	}
 }
 */
public class solution {
    public static ListNode<Integer> ChangeHead(ListNode<Integer> head, int n){
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode<Integer> temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
       // System.out.println(size);
        int count=0;
        temp=head;
        ListNode<Integer> newHead=null;
        while(count!=size-n-1){
            count++;
            temp=temp.next;
        }
        if(temp==null)
            return head;
       // System.out.println(temp.data);
        newHead=temp.next;
        temp.next=temp.next.next;
        newHead.next=head;
        return newHead;
        /*Your class should be named solution.
         *Don't write main().
         *Don't take input, it is passed as function argument.
         *Don't print output.
         *Taking input and printing output is handled automatically.
         */ 
        //return null;
    }
}
