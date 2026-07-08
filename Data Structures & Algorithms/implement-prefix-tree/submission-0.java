class PrefixTree {

    private static class Node {
        
        private Node[] children;
        
        private boolean isEnd;

        Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }

    }

    private final Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node ptr = root;
        for(char c : word.toCharArray()) {
            c -= 'a';
            if(ptr.children[c] == null) ptr.children[c] = new Node();
            ptr = ptr.children[c];
        }
        ptr.isEnd = true;
    }

    public boolean search(String word) {
        if(find(word) != 2) return false;
        return true;
    }

    public boolean startsWith(String prefix) {
        if(find(prefix) > 0) return true;
        return false;
    }

    public int find(String word) {
        Node ptr = root;
        for(char c : word.toCharArray()) {
            c -= 'a';
            if(ptr.children[c] == null) return 0;
            ptr = ptr.children[c];
        }
        if(ptr.isEnd) return 2;
        return 1; 
    }

}
