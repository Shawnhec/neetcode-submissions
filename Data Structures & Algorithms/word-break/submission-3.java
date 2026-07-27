// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Trie trie = new Trie();
//         for(String word : wordDict) {
//             trie.insert(word);
//         }
//         int n = s.length();
//         boolean[] visited = new boolean[n];
//         Queue<Integer> que = new LinkedList<>();
//         que.offer(0);
//         char[] str = s.toCharArray();
//         while(!que.isEmpty()) {
//             int curr = que.poll(); 
//             if(curr == n) return true;
//             if(visited[curr]) continue;
//             visited[curr] = true;
//             List<Integer> endPos = trie.findPrefixEndPos(str, curr);
//             for(int idx : endPos) {
//                 que.offer(idx + 1);
//             }   
//         }
//         return false;
        
//     }

//     private static class Trie {

//         private static class Node {
            
//             Node[] children;
//             boolean isEnd;
            
//             Node() {
//                 this.children = new Node[26];
//                 this.isEnd = false;
//             }
//         }

//         private final Node root;

//         Trie() {
//             this.root = new Node();
//         }

//         public void insert(String word) {
//             Node ptr = root;
//             for(char c : word.toCharArray()) {
//                 c -= 'a';
//                 if(ptr.children[c] == null) ptr.children[c] = new Node();
//                 ptr = ptr.children[c];
//             }
//             ptr.isEnd = true;
//         }

//         public boolean find(String word) {
//             Node ptr = root;
//             for(char c : word.toCharArray()) {
//                 c -= 'a';
//                 if(ptr.children[c] == null) return false;
//                 ptr = ptr.children[c];
//             }
//             return ptr.isEnd;
//         }

//         public List<Integer> findPrefixEndPos(char[] word, int strt) {
//             List<Integer> res = new ArrayList<>();
//             Node ptr = root;
//             for(int i = strt; i < word.length; i++) {
//                 char c = word[i];
//                 c -= 'a';
//                 if(ptr.children[c] == null) break;
//                 ptr = ptr.children[c];
//                 if(ptr.isEnd) res.add(i);
//             }
//             return res;
//         }
//     }
// }




class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int maxLen = 0;
        Set<String> words = new HashSet<>();
        for(String word : wordDict) {
            words.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        Boolean[] memo = new Boolean[n];
        return dp(s, words, n, memo, maxLen);
    }

    public boolean dp(String s, Set<String> words, int i, Boolean[] memo, int maxLen) {
        if(i == 0) return true;
        
        if(memo[i - 1] != null) return memo[i - 1];

        boolean res = false;
        for(int j = 1; j <= maxLen; j++) {
            if(i - j >= 0) {
                res = res || words.contains(s.substring(i - j, i)) && dp(s, words, i - j, memo, maxLen);
            }
        }
        return memo[i - 1] = res;
        
    }
}

