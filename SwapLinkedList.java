


/*
class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.setData(data);
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
* */
public class Solution {
	public static  LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head,int i,int j){
        LinkedListNode<Integer> prev1 = null;
        LinkedListNode<Integer> prev2 = null;
        LinkedListNode<Integer> curr1 = null;
        LinkedListNode<Integer> curr2 = null;
        LinkedListNode<Integer> temp = head;
        int count = -1;
        
           /* 
        case 1 : two subsequent element to be swapped exp 1->2->3->4->5->null
         when either one of i and j is zero and absolute difference is zero; 
         */
        if( (i == 0 || j == 0 ) && (j-i == 1 || i-j == 1)){
            //LinkedListNode<Integer> newTemp=null;
            prev2 = head;
            curr1 = head;
            curr2 = head.next;
            //if(head.next.next !=null)
            	//newTemp = head.next.next;
            //curr1.next = null;
            //curr2.next = null;
            //curr1.next = newTemp;
            curr1.next=null;
            curr1.next=curr2.next;
            curr2.next=curr1;
            head=curr2;
            return head;
        }
       
         /* 
        case 2 :  when two  element to be swapped exp 1->2->3->4->5->null
         and 1 is index 0  i.e either i==0 or j==0;. 
         */
        else if( (i == 0 || j == 0) && ( i-j !=1 || j-i != 1)){
            //int x = Math.min(i,j);
            int max =Math.max(i,j);
            curr1 = head;
            head = head.next;
            while(count<max && temp != null){
                count++;
               if(count == max-1){
                   prev2 = temp;
                   curr2 = temp.next;
               } 
                temp = temp.next;
            }
            LinkedListNode<Integer> newTemp = curr2.next;
            curr2.next =null;
            curr2.next=head;
            head = curr2;
            curr1.next=null;
            prev2.next=curr1;
            curr1.next=newTemp;
            return head;
            
            }
        
        
        
        
        /* 
        case 3 :  when two subsequent element to be swapped exp 1->2->3->4->5->null
         exp index 1 onwards. 
         */
        
        else if( j-i == 1 || i-j == 1 ){
             int x = Math.min(i,j);
            while( count <= i && temp != null){
                count++;
                if(count == x-1){
                    prev1 = temp;
                    curr1 = temp.next;   
                }
                if( count == x){
                    prev2 = temp;
                    curr2 = temp.next;
                }
                temp = temp.next;
            }
            prev1.next = curr2;
            LinkedListNode<Integer> newTemp = curr2.next;
            curr2.next = curr1;
            curr1.next = newTemp;
            return head;
            
        }
        
        /* 
        case 4 :  General Case. 
         */
        
        else{
            int min = Math.min(i,j);
            int max = Math.max(i,j);
            while(count<max && temp != null){
                count++;
                if(count==min-1){
                    prev1 = temp;
                    curr1 = temp.next;
                }
                if(count == max-1){
                    prev2 = temp;
                    curr2 = temp.next;
                }
                temp = temp.next;
            }
             prev2.next = prev2.next.next;
            LinkedListNode<Integer> newTemp = curr1.next;
            curr1.next = null;
            prev2.next = curr1;
            curr1.next = curr2.next;
            prev1.next = prev1.next.next;
            curr2.next = null;
            prev1.next = curr2;
            curr2.next = newTemp;
            return head;
            
            
            
        }
    	
      
        
        
        
		
	}
}
