class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for(String word : wordList) words.add(word);
        if(!words.contains(endWord)) return 0;

        Map<String, Integer> transCnt = new HashMap<>();
        transCnt.put(beginWord, 1);
        
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);

        while(!que.isEmpty()) {
            String curr = que.poll();
            int step = transCnt.get(curr);
            for(int i = 0; i < curr.length(); i++) {
                for(int j = 0; j < 26; j++) {
                    char[] currChar = curr.toCharArray();
                    if(currChar[i] == (char) ('a' + j)) continue;
                    currChar[i] = (char) ('a' + j); 
                    String str = new String(currChar);
                    if(str.equals(endWord)) return step + 1;
                    if(!words.contains(str)) continue;
                    if(transCnt.containsKey(str)) continue;
                    que.offer(str);
                    transCnt.put(str, step + 1);
                }
            }
        }
        return 0;
    }
}



/*          
            cbt

            aat

            bat

            bag
 cat                 cbb 
            sag

            dag 

            dot

*/