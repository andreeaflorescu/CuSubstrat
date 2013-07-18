import java.util.Scanner;

class Main {
	private Trie trie;
	private final String filename = "words.txt";
	
	Main() {
		trie = new Trie(false);
	}
	//read words from file and add them to the Trie
	public void createTrie() {
		Scanner sc = new Scanner(filename);
		while(sc.hasNext()) {
			String word = sc.next();
			trie.addWord(word);
		}
		sc.close();
	}
	
	public static void main(String args[]) {
//		new MainPanel();
		new Main();
	}
}