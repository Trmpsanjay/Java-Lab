import java.util.ArrayList;

// note this is mean heap

public class PriorityQueue {
	
	public ArrayList<Integer> heap;
	
	public PriorityQueue() {
		heap = new ArrayList<Integer>();
	}
	
	public boolean isEmpty() {
		return heap.size()==0;
	}
	
	void dispaly() {
		for(int i=0;i<heap.size();i++) {
			System.out.print(heap.get(i)+" ");
		}
	}

	public int getMin() throws PriorityQueueEmptyException {
		if(isEmpty()) {
			// throw exception
			throw new PriorityQueueEmptyException();
		}
		return heap.get(0);
	}
	
	public int size() {
		//the size of arraylist will be the size of heap
		return heap.size();
	}
	
	public void insert(int element) {
		// insert it to end and then heapify
		heap.add(element);
		
		//foloowing are steps for upward hipyfy
		
		// get index  where we inserted inserted
		int childIndex = heap.size()-1;
		//find index of parent
		int parentIndex = (childIndex - 1)/2;
		// repeat the below statement untill childindex>0 or childindex data > prentIndex data
		while(childIndex>0) {
			if(heap.get(childIndex)<heap.get(parentIndex)) {
				// swap them
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				//  now update childindex and parentindex
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
			else {
				// everything is ok now we need to return
				return;
			}
		}
	}
	
	int removeMin() throws PriorityQueueEmptyException{
		/* in min heap we have to remove the element at index 0 so we will not directly remove
		index 0 element we will copy the element which is in last at 0th index and  will remove last 
		element and heapify it so that it satisfied complete binary tree property and heap order property
		*/
		
		// if heap is empty throw empty exception
		if(isEmpty()){
			// Throw an exception
			throw new PriorityQueueEmptyException();
		}
		
		
		int temp = heap.get(0);
		// copying last element at 0th index;
		heap.set(0, heap.get(heap.size() - 1));
		// removing last element 
		heap.remove(heap.size() - 1);
		// declaring indexes for heapyfying
		int index = 0;
		int minIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;

		while(leftChildIndex < heap.size()){
			// if leftchildata is less than parentdata(minindex) update minIndex
			if(heap.get(leftChildIndex) < heap.get(minIndex)){
				minIndex = leftChildIndex;
			}
			// if rightChild data is less than parentdata(minindex) update minIndex
			if(rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)){
				minIndex = rightChildIndex;
			}
			if(minIndex == index){
				// if above will not execute then it is at right position
				break;
			}else{
				// if not right position swap it to bring it on right position
				int temp1 = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp1);
				// update indexes of child and parent
				index = minIndex;
				leftChildIndex = 2 * index + 1;
				rightChildIndex = 2 * index + 2;
			}
		}
		return temp;

	}

	
	
}
