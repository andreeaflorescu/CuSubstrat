public class Trie {
	private class Node {
		private char letter;
		//marks the end of one word
		private boolean wordEnd;
		private Node child_list[];
		int nr;
		public Node() {
			letter = ' ';
			//any node can have maximum 26 descendes (26 letters in the dictionary)
			child_list = new Node[26];
			wordEnd = false;
			nr = 0;
		}
		public int getNrOfChild() {
			return nr;
		}
		public void setValue(char letter) {
			this.letter = letter;
		}
		public char getValue() {
			return this.letter;
		}
		public Node addChild(char letter, boolean end) {
			int index = getNrOfChild();
			Node new_node = new Node();
			new_node.letter = letter;
			new_node.wordEnd = end;
			child_list[index] = new_node;
			nr ++;
			return child_list[getNrOfChild() - 1];
		}
		public Node[] getChildList() {
			return this.child_list;
		}
		//binary search for the node with the given value
		private Node searchValue(char value) {
			//get the list of children from the current root
			Node list[] = new Node[26];
			list = this.getChildList();
			//set the left side, right side and middle for the binary search
			int l = 0;
			int r = getNrOfChild() - 1;
			//if there is more then one element
			//binary search for the 
			if (r >= 0) {
				while(l <= r) {
					int m = l + (r - l)/2;
					if (list[m].getValue() == value) {
						return list[m];
					} else if (list[m].getValue() < value) {
						r = m - 1;
					} else {
						l = m + 1;
					}
					m = l + (r - l)/2;
				}
			}
			return null;
		}
	}	
	private Node root;
	private boolean ordered;
	public Trie() {
		root = new Node();
	}
	
	public Trie(boolean ordered) {
		root = new Node();
		this.ordered = ordered;
	}

	public void addWord(String word) {
		/*Search for every letter in the word starting from root
		 * if the letter is not found, add letter to root child list
		 * the root is now the new added letter
		 * if the letter is found, set the new root and move on to the next letter
		 * of the word
		 * */
		Node parent = root;
		Node child;
		for (int i = 0; i < word.length(); i++) {
			
			child = parent.searchValue(word.charAt(i));
			if (child == null) {
				//if it's the last letter of the word end will be set true
				boolean end = (i == word.length() - 1)? true : false; 
				parent = parent.addChild(word.charAt(i), end);
			} else {
				//moving to the next level in the trie
				parent = child;
			}
		}		
	}
	
	public Node getRoot() {
		return root;
	}
	public void showTrie(int level, Node root) {
//		System.out.println("level: " + level);
		Node[] list = new Node[26];
		list = root.getChildList();
		for (int i = 0; i < root.getNrOfChild(); i++) {
			System.out.println(list[i].getValue() + " " + level + " " + list[i].wordEnd);
			showTrie(level + 1, list[i]);
		}
	}
}