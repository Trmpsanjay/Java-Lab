// note for capital word remove 'a' with 'A'



class TrieNode{
	// data to be stored in node
	private char data;
	// arrays to keep their children
	TrieNode[] children;
	// to check weather the charecter is terminating or not
	boolean isTerminating;
	// to keep track ChildCount
	int childCount;
	// making constructor to initialize members
	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount =0;
	}
}


public class Trie {
	// making root and assigning it to null charecter
	TrieNode root ;
	// making constructor to initialize members
	public Trie(){
		root= new TrieNode('\0');
	}
	// add function which will add the 
	
	// making add helper function
	private void add(TrieNode root , String word) {
		// base case
		if(word.length()==0) {
			root.isTerminating = true;
			return;
		}
		// find childIndex
		int childIndex = word.charAt(0)-'a'; // it gives index of children
		// storing reference of childIndex
		TrieNode child = root.children[childIndex];
		// if null create a TrieNode and update the array reference at childIndex
		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		// now recursive calling
		add(child,word.substring(1));
	}

	public void add(String word) {
		add(root,word);
	}
	
	private boolean search(TrieNode root , String word) {
		// base case
		if(word.length()==0 && root.isTerminating==true) {
			return true;
		}
		if(word.length()==0 && root.isTerminating==false) {
			return false;
		}
		// getting index of child
		int childIndex = word.charAt(0)-'a';
		// storing reference of child
		TrieNode child = root.children[childIndex];
		// if no child then return false as word is not there
		if(child==null)
			return false;
		return search(child,word.substring(1));
		
	}
	public boolean search(String word) {
		return search(root,word);
	}
	
	private void delete(TrieNode root , String word) {
		// base case 
		if(word.length()==0) {
			root.isTerminating=false; // make non terminating so that it will not ending character
			return;
		}
		// getting child index of word
		int childIndex = word.charAt(0)-'a';
		// getting reference of child
		TrieNode child = root.children[childIndex];
		// if child index is null that means the word is allready not present in the trie so return
		if(child == null)
			return;
		
		// for rest part call the recursion if child is not null
		delete(child,word.substring(1));
		
		// now we can delete the node only and only if if it is not terminating word of any other word and it doesn't have any child
		
//		if(root.isTerminating==false) {
//			// now check the number of child
//			int count=0;
//			for(int i=0;i<root.children.length;i++) {
//				if(root.children[i]!=null)
//					count++;
//			}
//			// if no child then delete that chatecter
//			if(count==0)
//				root.children[childIndex]=null;
//		}
		
		//above can be replaced by following code
		if(root.isTerminating==false && root.childCount==0) {
			root.children[childIndex] = null;
		}
		
		
	}
	
	public void delete(String word) {
		delete(root,word);
	}
	

}





























/*
/*************8
 * Main function - 
 
public static void main(String[] args) {
		Trie t = new Trie();
		int choice = s.nextInt();
		
		while(choice != -1) {
			String word;
			switch(choice) {
				case 1 : // insert
					word = s.next();
					t.add(word);
					break;
				case 2 : // search
					word = s.next();
					System.out.println(t.search(word));
					break;
				case 3 : 
					word = s.next();
					t.remove(word);
					break;
				case 4 : 
					System.out.println(t.countWords());
					break;
				default :
						return;
			}
			choice = s.nextInt();
		}
	}
*******************/


// TA Soln

/*
class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


public class Trie {

	private TrieNode root;
	private int numWords;

	public Trie() {
		root = new TrieNode('\0');
		numWords = 0;
	}
	
	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return root.isTerminating;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}
	
	
	public void remove(String word){
		if(remove(root, word)) {
			numWords--;
		}
	}
	

	private boolean remove(TrieNode root, String word) {
		if(word.length() == 0){
			if(root.isTerminating) {
				root.isTerminating = false;
				return true;
			}
			else {
				return false;
			}
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		boolean ans = remove(child, word.substring(1));
		// We can remove child node only if it is non terminating and its number of children are 0	

		if(!child.isTerminating && child.childCount == 0){
			root.children[childIndex] = null;
			child = null;
			root.childCount--;
		}
		return ans;
	}

	private boolean add(TrieNode root, String word){
		if(word.length() == 0){
			if(root.isTerminating) {
				return false;
			}
			else {
				root.isTerminating = true;
				return true;
			}
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		return add(child, word.substring(1));
	}

	public void add(String word){
		if(add(root, word)) {
			numWords++;
		}
	}
	
	public int countWords() {
        return numWords;
		// Write your code here
		
	}
	
}

*////////