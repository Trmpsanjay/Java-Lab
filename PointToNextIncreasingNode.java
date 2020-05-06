/***********
Question URL
https://codezen.codingninjas.com/practice/469/763/point-to-next-increasing-node
Point to next increasing node
Level MEDIUM
Given singly linked list with every node having an additional “arbitrary” pointer. This arbitrary pointer is currently pointing to NULL. You need to make this arbitrary pointer of each node point to the next higher value node in the input list.
You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Updated list elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
 12 5 2 8 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 4.
Sample Output :
 2 5 8 12 



************/
/***********
 
Following is the Linked list node structure already written 
 
class ListNode<t> {
	public t data;
	 public ListNode<t> next;
	 public ListNode<t> arbitrary;
	 public ListNode(t data)
	 {
		 this.data=data;
	 }
}

************/


// it is a simple sorting problem. we have to points its arbitrary to its next node and then sort;


public class solution {
    private static ListNode<Integer> findMid(ListNode<Integer> head){
        ListNode<Integer> fast=head;
        ListNode<Integer> slow=head;
        if(head==null || head.arbitrary==null)
            return head;
        while(fast.arbitrary!=null && fast.arbitrary.arbitrary!=null){
            slow=slow.arbitrary;
            fast=fast.arbitrary.arbitrary;
        }
        return slow;
    }
    private static ListNode<Integer> merge(ListNode<Integer> head1, ListNode<Integer> head2){
               
       ListNode<Integer> t1 = head1;
        ListNode<Integer> t2 = head2;
        ListNode<Integer> headNew = null;
        ListNode<Integer> tailNew = null;
        int count = 0;
        while( t1 != null && t2 != null){
            count++;
            if( t1.data < t2.data ){
                if(count==1){
                    headNew=t1;
                	tailNew = t1;
                	t1 = t1.arbitrary;
                }
                else{
                    tailNew.arbitrary = t1;
                    tailNew = t1;
                    t1=t1.arbitrary;
                }
            }
            else{
                if(count==1){
                    headNew=t2;
                	tailNew=t2;
                	t2= t2.arbitrary;
                }
                else{
                    tailNew.arbitrary = t2;
                    tailNew = t2;
                    t2 = t2.arbitrary;
                }
            }
        }
        if( t1 != null){
            tailNew.arbitrary = t1;
        }
        if( t2 != null){
            tailNew.arbitrary = t2;
        }
        return headNew;
    }
    public static ListNode<Integer> mergeSort(ListNode<Integer> head ){
        if(head==null)
            return head;
        if(head.arbitrary==null)
            return head;
        ListNode<Integer> mid=findMid(head);
        ListNode<Integer> temp=mid.arbitrary;
        mid.arbitrary=null;
        ListNode<Integer> part1=mergeSort(head);
        ListNode<Integer> part2=mergeSort(temp);
        ListNode<Integer> ans= merge(part1,part2);
        return ans;
    }
        

	public static ListNode<Integer> changeList(ListNode<Integer> head) {
        ListNode<Integer> temp=head;
        while(temp!=null){
            temp.arbitrary=temp.next;
            temp=temp.next;
        }
        ListNode<Integer> myans=mergeSort(head);
        return myans;
		// Write your code here

	}
}

