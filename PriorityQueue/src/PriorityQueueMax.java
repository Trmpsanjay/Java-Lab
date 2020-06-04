import java.util.ArrayList;
public class PriorityQueueMax {
    // declaring heap
    ArrayList<Integer> heap;
    // making default constructor
    public PriorityQueueMax(){
        heap = new ArrayList<>();
    }
    
    public int getSize(){
        // this will return the siz of arraylist 
        return heap.size();
    }
	void dispaly() {
		for(int i=0;i<heap.size();i++) {
			System.out.print(heap.get(i)+" ");
		}
	}

    
    public boolean isEmpty(){
        return heap.size()==0;
    }
    
    public void insert(int element){
        // insert it at last and then heapify
        heap.add(element);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;
        
        // hepify unttill the elemnt reaches its own position
        while(childIndex>0){
            if(heap.get(childIndex)>heap.get(parentIndex)){
                // swap
                int temp = heap.get(parentIndex);
                heap.set(parentIndex,heap.get(childIndex));
                heap.set(childIndex,temp);
                childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
                
            }
            else
                return;
        }
    }
    
    public int getMax() throws PriorityQueueEmptyException{
        // it will give us 0th index element
        if(isEmpty()){
            throw new PriorityQueueEmptyException();
        }
        return heap.get(0);
    }
    
    public int removeMax(){
        /*
        The idea behind remove max is that we need to copy the element of last index at
        0th index and remove the last element. after doing that the element will be not in proper
        order so we will heapify it to set it in proper order
        */
        
        int remove = heap.get(0);
        // copying last element to 0th index
        heap.set(0,heap.get(heap.size()-1));
        // removing last element
        heap.remove(heap.size()-1);
        
        // now we have to heapify
        int index = 0;
        int minIndex = index;
        int leftChild = 1;
        int rightChild = 2;
        
        // repeating the below statement untill it heapifies
        while(leftChild<heap.size()) {// agar left child bda hoga to right to definately hoga
            if(heap.get(leftChild)>heap.get(minIndex)){
                // agar leftchild data bda hai  to update minindex 
                minIndex = leftChild;
            }
            if(rightChild<heap.size() && heap.get(rightChild)>heap.get(minIndex)){
                // agar leftchild data bda hai  to update minindex 
                minIndex = rightChild;
                
            }
            if(minIndex==index)
                // agar dono me se koi nahi hai to apne sahi position par hai to break kar denge
                break;
            else{
                // agar minindex != index hai matlab minindex change hua hai to swap kar denge
                int temp = heap.get(minIndex);
                heap.set(minIndex,heap.get(index));
                heap.set(index,temp);
                // update leftchild and index;
                index = minIndex;
                leftChild = 2*index+1;
                rightChild = 2*index+2;
                
            }
        }
            return remove;
    }
            
 }

/*
 * 
 * 
 * public class PriorityQueue {

	private ArrayList<Integer> heap;
	
	public PriorityQueue(){
		heap=new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return heap.size()==0;
	}
  
  	public int getSize(){
      return heap.size();
    }
  
  	public void insert(int element) {
		heap.add(element);
		int childInd=heap.size()-1;
		int parentInd=(childInd-1)/2;
		while(childInd>0) {
			
          if(heap.get(childInd)>heap.get(parentInd)) {
				int temp=heap.get(childInd);
				heap.set(childInd, heap.get(parentInd));
				heap.set(parentInd, temp);
				childInd=parentInd;
				parentInd=(childInd-1)/2;
			}
          
          	else {
				break;
			}
		}
	}
	
	public int getMax() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
        }
		
        else  
			return heap.get(0);
	}
	
	public int removeMax(){
		
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		int rv=heap.get(0);
		heap.set(0,heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		if(heap.size()>1) {
			downHeapify(0);
		}
		
		return rv;
		
	}

	private void downHeapify(int i){
		int leftInd=2*i+1;
		int rightInd=2*i+2;
		if(leftInd>=heap.size()) {
			return;
		}
		int maxInd=i;
		if(heap.get(leftInd)>heap.get(maxInd)) {
			maxInd=leftInd;
					
		}
		if(rightInd<heap.size() && heap.get(rightInd)>heap.get(maxInd)) {
			maxInd=rightInd;
		}
		if(maxInd!=i) {
			int temp=heap.get(i);
			heap.set(i,heap.get(maxInd));
			heap.set(maxInd, temp);
			downHeapify(maxInd);
		}
		
		
	}
    
    }
 */
    
	// Complete this class


