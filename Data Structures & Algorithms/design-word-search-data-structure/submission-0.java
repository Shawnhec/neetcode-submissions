class WordDictionary {

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node ptr = root;
        char[] chars = word.toCharArray();
        for(char c : chars) {
            c -= 'a';
            if(ptr.children[c] == null) ptr.children[c] = new Node();
            ptr = ptr.children[c];
        }
        ptr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0 , root);
    }

    public boolean search(String word, int i, Node node) {
        if(i == word.length()) return node.isEnd;

        char c = word.charAt(i);
        if(c == '.') {
            for(int j = 0; j < 26; j++) {
                if(node.children[j] != null && search(word, i + 1, node.children[j])) return true; 
            }
            return false;
        }

       
        if(node.children[c - 'a'] == null) return false;
        return search(word, i + 1, node.children[c - 'a']);
    }

    private static class Node {
        
        Node[] children;
        
        boolean isEnd;

        Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
}
