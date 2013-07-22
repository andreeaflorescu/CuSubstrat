import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	private Trie trie;
	private final String filename = "words.txt";
	
	Main() {
		trie = new Trie(true);
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
	public void createTrie() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filename));
		while(sc.hasNext()) {
			String word = sc.next();
			trie.addWord(word);
//			System.out.println(word);
		}
		sc.close();
	}
	
	public static void main(String args[]) throws FileNotFoundException {
//		new MainPanel();
		Main mainAlg = new Main();
		mainAlg.createTrie();
		System.out.println(mainAlg.getWordList("COPAC"));
	}
}