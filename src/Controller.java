import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Controller {
	private Trie trie;
	private boolean ord;
	private final String filename = "words.txt";
	
	Controller(boolean ord) {
		this.ord = ord;
		trie = new Trie(ord);
	}
	
	//======================================================================//
	//							Get Final List								//
	//======================================================================//
	
	// I choose to make different methods for ordered and post-ordered Trie
	// for matters of time complexity
	public String getWordListOrd(String prefix) {
		ArrayList<String> list = trie.getAllWords(prefix);
		String words = new String();
		for (int i = 0; i < list.size(); i++) {
			words += list.get(i) + "\n";
		}
		return words;
	}
	
	public String getWordListPostOrd(String prefix) {
		ArrayList<String> list = trie.getAllWords(prefix);
		String words = new String();
		for (int i = 0; i < list.size(); i++) {
			words += new StringBuilder(list.get(i)).reverse().toString() + "\n";
		}
		return words;
	}
	
	public String getWordList(String prefix) {
		if (ord) {
			return getWordListOrd(prefix);
		} else {
			return getWordListPostOrd(prefix);
		}
	}
	
	//======================================================================//
	//								CREATE TRIE								//
	//======================================================================//
	
	// if the selected choice from the JComboBox will be to search in 
	// the beginning of words then we add the words as they are in the Trie
	private void createTrieOrd() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filename));
		while(sc.hasNext()) {
			String word = sc.next();	
			trie.addWord(word);
		}
		sc.close();
	}
	
	// if the selected choice from the JComboBox will be to search in 
	// end of words, the words will be added in Trie reverted
	private void createTriePostOrd() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filename));
		while(sc.hasNext()) {
			String word = sc.next();
			System.out.println(new StringBuilder(word).reverse().toString() + "  " + word);
			
			trie.addWord(new StringBuilder(word).reverse().toString());
		}
		sc.close();
	}

	//read words from file and add them to the Trie
	public void createTrie() throws FileNotFoundException{
		if(ord == true) {
			createTrieOrd();
		} else {
			createTriePostOrd();
		}
	}
}