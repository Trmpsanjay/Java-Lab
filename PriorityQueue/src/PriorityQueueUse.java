
public class PriorityQueueUse {

	public static void main(String[] args) throws PriorityQueueEmptyException {
		PriorityQueue pq = new PriorityQueue();
		int arr [] = {3,6,2,8};
		for(int i=0;i<arr.length;i++) {
			pq.insert(arr[i]);
		}
		pq.dispaly();
		System.out.println();
		// removing and printing this is also called heapsort
		while(!pq.isEmpty()) {
			System.out.print(pq.removeMin()+" ");
		}

	}

}
