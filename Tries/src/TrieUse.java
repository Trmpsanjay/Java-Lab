
public class TrieUse {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("hello");
		t.add("hi");
		t.add("hum");
		t.add("sanjay");
//		System.out.println(t.search("hi"));
//		System.out.println(t.search("hello"));
//		System.out.println(t.search("sanjay"));
//		System.out.println(t.search("hum"));
//		System.out.println(t.search("h"));
//		System.out.println(t.search("hiii"));
		System.out.println(t.search("hello"));
		System.out.println(t.search("sanjay"));
		t.delete("sanjay");
		System.out.println(t.search("sanjay"));
		
		


	}

}
