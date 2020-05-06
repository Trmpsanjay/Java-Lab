/***********
 
Following is the Linked list node structure already written 
 
class ListNode<t> {
	public t data;
	 public ListNode<t> forw;
	 public ListNode<t> backw;
	 public ListNode(t data)
	 {
		 this.data=data;
	 }
}

************/


public class solution {
    public static int findLength(ListNode<Integer> head){
        int length=0;
        while(head!=null){
            length++;
            head=head.forw;
        }
        return length;
    }

	public static void findPairs(ListNode<Integer> head,int n) {
        ListNode<Integer> temp=head;
        ListNode<Integer> prev=null;
         //ListNode<Integer> find=null;
        //finding length for running 1st loop
        int length=findLength(head);
        
        for(int i=0;i<length && temp!=null;i++){
            prev=temp;
            while(temp!=null){
                if(prev.data+temp.data==n){
                    System.out.println(prev.data+" "+temp.data); 
                    break;
                }
               temp=temp.forw;
            }
             temp=prev.forw;
        }
        
		
	}
}

