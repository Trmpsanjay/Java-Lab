package Tree;
import java.util.Scanner;

public class TreeNodeUse {
	public static TreeNode<Integer> takeInput(Scanner sc){
		System.out.println("Enter Data for next node");
		int data=sc.nextInt();
		TreeNode<Integer> root= new TreeNode<>(data);
		System.out.println("Enter the number of children of thie node");
		int nodes=sc.nextInt();
		for(int i=0;i<nodes;i++) {
			TreeNode<Integer> child=takeInput(sc);
			root.children.add(child);
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		String s =root.data+":"+"";
		for(int i=0;i<root.children.size();i++)
			s = s + root.children.get(i).data + ",";
		System.out.println(s);
		for(int i=0;i<root.children.size();i++) {
			print(root.children.get(i));
		}
		
	}
	
	public static TreeNode<Integer> takeInputLevelWise() throws QueueEmptyException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the data of root data");
		int rootData=sc.nextInt();
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		TreeNode<Integer> root= new TreeNode<>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode =pendingNodes.dequeue();
			System.out.println("Enter num of children of " + frontNode.data);
			int numChildren=sc.nextInt(); 
			for(int i=0;i<numChildren;i++) {
				System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);
				int child = sc.nextInt();
				TreeNode<Integer> childNode = new TreeNode<>(child);
				frontNode.children.add(childNode);
				pendingNodes.enqueue(childNode);
			}
		}
		return root;
		
		
	}
	
	public static void printLevelWiseMine(TreeNode<Integer> root) throws QueueEmptyException {
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> frontNode = pendingNodes.dequeue();
			System.out.print(frontNode.data);
			for(int i=0;i<frontNode.children.size();i++) {
				pendingNodes.enqueue(frontNode.children.get(i));
			}
			
		} 
	}
	
	public static void printLevelWise(TreeNode<Integer> root) throws QueueEmptyException{
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer> nullnode=new TreeNode<Integer>(0);
		pendingNodes.enqueue(root);
        	pendingNodes.enqueue(nullnode);
        
        System.out.println(root.data);
        
		while(pendingNodes.size()!=1){
            TreeNode<Integer> frontNode=null;
            try{
				frontNode = pendingNodes.dequeue();
            }
            catch (QueueEmptyException e){
                //shouldnot came here
            }
            
            if(frontNode==nullnode){
                System.out.println();
                	pendingNodes.enqueue(nullnode);
                continue;
            }
			
			for(int i=0;i<frontNode.children.size();i++) {
				pendingNodes.enqueue(frontNode.children.get(i));
                System.out.print(frontNode.children.get(i).data+" ");
			}
			
		}
	}
	
	public static int numOfNodes(TreeNode<Integer> root) {
		// Remember this is not a base case this is edge case
		if(root==null)
			return 0;
		
		int count=1;  // corresponding to root node
		// now recursive call for each children of root that will tell us their number of nodes in which we will add 1 correspunding to root node
		for(int i=0;i<root.children.size();i++)
			count=count+numOfNodes(root.children.get(i));
		return count;
				
	}
	
	public static int sumOfNodes(TreeNode<Integer> root) throws QueueEmptyException {
		int sum=root.data;
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode= pendingNodes.dequeue();
			for(int i=0;i<frontNode.children.size();i++) {
				pendingNodes.enqueue(frontNode.children.get(i));
				sum=sum+frontNode.children.get(i).data;
			}
		}
		return sum;
	}
	
	public static int largestNode(TreeNode<Integer> root) {
		//this is not a base case it is a edge case
		if(root==null)
			return Integer.MIN_VALUE;
		int ans=root.data;     // let assume that max number is root data
		//finding max number among their children using recursion
		
		// ***************Note here i=0 acts as a base case for the recursion*************
		//beacuse if i=0 it will enter in the loop so recursion will be not called
		for(int i=0;i<root.children.size();i++) {
			// finding max value among children
			int smallans=largestNode(root.children.get(i));
			//updating our ans if smallans > ans
			if(smallans>ans)
				ans=smallans;
		}
		return ans;
	}
	
	public static int numNodeGreater(TreeNode<Integer> root,int x) throws QueueEmptyException {
		//edge case
		if(root==null)
			return 0;
		// initial count
		int count=0;
		// creating a queue to store nodes
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		// enqueueing first node so that by dequeueing it we can enqueue its child
		pendingNodes.enqueue(root);
		//first loop for checking queue is empty or not
		while(!pendingNodes.isEmpty()) {
			// dequeuing node to enqueue its child
			TreeNode<Integer> frontNode = pendingNodes.dequeue();
			// checking if Dequeued Data is greater than given data then we increment count by 1
			if(frontNode.data>x)
				count++;
			// loop for enqueuing all its children
			for(int i=0;i<frontNode.children.size();i++) {
				pendingNodes.enqueue(frontNode.children.get(i));
			}
		}
		return count;
	}
	
	public static int height(TreeNode<Integer> root) {
		// edge case
		if(root==null)
			return 0;
		// initially height=1 for root so we will add 1 to our ans
		int ans=0;
		// finding height of each children by recursion
		
		// base case act as i=0; beacuse if i=0 it will enter in the loop so recursion will be not called
		for(int i=0;i<root.children.size();i++) {
			// it will tell us height of the sub tree
			int smallans=height(root.children.get(i));
			// assigning max height of all children
			if(smallans>ans)
				ans=smallans;
		}
		// initially height=1 for root so we will add 1 to our ans
		return ans+1;
	}
	
	public static void printAtKdepth(TreeNode<Integer> root , int k) {
		//checking if k is negative just return
		if(k<0)
			return;
		//base case
		if(k==0) {
			System.out.print(root.data+" ");
			return;
		}
		// recursive call on their children
		for(int i=0;i<root.children.size();i++)
			printAtKdepth(root.children.get(i),k-1);  // here k-1 because  converting in smaller problem and saying them to print nodes of k=k-1;
		
	}
	
	public static int countLeafNodes(TreeNode<Integer> root) {
		//edge case 
		if(root==null)
			return 0;
		//base case
		if(root.children.size()==0)
			return 1;
		int ans=0;
		// recursive call on all children of root
		for(int i=0;i<root.children.size();i++) {
			 ans =ans+countLeafNodes(root.children.get(i));
		}
		return ans;
	
	}
	
	public static void preOrderTraversal(TreeNode<Integer> root) {
		//checking edge case
		if(root==null)
			return;
		//printing first root data as defined by preorder
		System.out.print(root.data+" ");
		//  recursive calling on their children for printing the rest data
		for(int i=0;i<root.children.size();i++){
			preOrderTraversal(root.children.get(i));
		}
	}
	
	public static void postOrderTraversal(TreeNode<Integer> root) {
		//checking edge case
		if(root==null)
			return;
		// recursive call to root children
		for(int i=0;i<root.children.size();i++)
			postOrderTraversal(root.children.get(i));
		
		// printing root data in last as per defination
		System.out.print(root.data+" ");
	}

	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
//      //checking edge case 
//      if(root==null)
//          return false;
//      //creating queue to enqueue root and their children
//      QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
//      // queueing root so that we can dequeue root and enqueue their children
//      pendingNodes.enqueue(root);
     
//      //looping for dequeueing and checking data
//      while(!pendingNodes.isEmpty()){
//          TreeNode<Integer> frontNode=null;
//          try{
//              // dequeuing the element and will check the condition
//              frontNode=pendingNodes.dequeue();
//              if(frontNode.data==x)
//                  return true;
//              //enqueuing their children
//              for(int  i=0;i<frontNode.children.size();i++){
//                  pendingNodes.enqueue(frontNode.children.get(i));
//              }
//          }
//              catch(QueueEmptyException e){
//                  //never comes here
//              }
         
//      }
//      return false;
     
     
     
     // another method to reduce time complexity
       //checking edge case 
     if(root==null)
         return false;
     // checking if root data is equal to x or not
     if(root.data==x)
         return true;
     //creating queue to enqueue root and their children
     QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
     // queueing root so that we can dequeue root and enqueue their children
     pendingNodes.enqueue(root);
     
     //looping for dequeueing and checking data
     while(!pendingNodes.isEmpty()){
         TreeNode<Integer> frontNode=null;
         try{
             // dequeuing the element and will check the condition
             frontNode=pendingNodes.dequeue();
             //enqueuing their children
             for(int  i=0;i<frontNode.children.size();i++){
                 pendingNodes.enqueue(frontNode.children.get(i));
                 if(frontNode.children.get(i).data==x)
                 	return true;
             }
         }
             catch(QueueEmptyException e){
                 //never comes here
             }
         
     }
     return false;

}
	

	
	public static void main(String[] args) throws QueueEmptyException {
//		Scanner sc=new Scanner(System.in);
//		TreeNode<Integer> root =takeInput(sc);
//		print(root);
		TreeNode<Integer> newRoot=takeInputLevelWise();
		//print(newRoot);
		printLevelWise(newRoot);
		System.out.println();
		System.out.println("No of nodes are : "+numOfNodes(newRoot));
		System.out.println("Sum of nodes are : "+sumOfNodes(newRoot));
		System.out.println("Largest Node is : "+largestNode(newRoot));
		int noOfLargest=numNodeGreater(newRoot,6);
		System.out.println("No of greater nodes than 6 is :" +noOfLargest);
		System.out.println("Height of Tree is  :" +height(newRoot));
		System.out.print("Nodes at depth k Are  :");
		printAtKdepth(newRoot,2);
		System.out.println("\n No of leaf nodes are  :" +countLeafNodes(newRoot));
		preOrderTraversal(newRoot);
		System.out.println();
		postOrderTraversal(newRoot);
		System.out.println();
		System.out.println(checkIfContainsX(newRoot,9));
		
		
		
		

	}

}
