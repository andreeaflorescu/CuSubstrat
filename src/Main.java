import java.util.Scanner;

class Main {
	private Trie trie;
	private final String filename = "words.txt";
	
	Main() {
		trie = new Trie(false);
		trie.addWord("ana");
		trie.addWord("ananas");
		trie.addWord("analiza");
	}
	
	public String getWordList(String prefix) {
		ArrayList<String> list = trie.getAllWords(prefix);
		String words = new String();
		for (int i = 0; i < list.size(); i++) {
			words += list.get(i) + "\n";
		}
		return words;
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
		Main mainAlg = new Main();
		System.out.println(mainAlg.getWordList("ana"));		
	}
}