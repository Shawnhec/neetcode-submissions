class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        if(n == 1) return words[0].charAt(0) + "";
        Map<Character, Set<Character>> g = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();

        for(int i = 0; i < n - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int shorterWordLength = Math.min(curr.length(), next.length());
            int j = 0;
            int firstDiff = -1;
            while(j < shorterWordLength) {
                char currChar = curr.charAt(j);
                char nextChar = next.charAt(j);
                if(!g.containsKey(currChar)) {
                    g.put(currChar, new HashSet<>());
                    indegrees.put(currChar, 0);
                }
                if(!g.containsKey(nextChar)) {
                    g.put(nextChar, new HashSet<>());
                    indegrees.put(nextChar, 0);
                }
                
                if(currChar != nextChar && firstDiff == -1) firstDiff = j;
                j++;
            }
            if(firstDiff == -1 && curr.length() > next.length()) return "";
            if(firstDiff == -1 && curr.length() <= next.length()) continue;

            char currChar = curr.charAt(firstDiff);
            char nextChar = next.charAt(firstDiff);
            if(!g.get(currChar).contains(nextChar)) {
                g.get(currChar).add(nextChar);
                indegrees.put(nextChar, indegrees.getOrDefault(nextChar, 0) + 1);
            }
        }

        Queue<Character> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int visitCnt = 0;

        for(char c : indegrees.keySet()) {
            if(indegrees.get(c) == 0)  {
                que.offer(c);
                sb.append(c);
                visitCnt++;
            }
        }

        while(!que.isEmpty()) {
            char node = que.poll();
            for(char nextNode : g.get(node)) {
                indegrees.put(nextNode, indegrees.getOrDefault(nextNode, 0) - 1);
                if(indegrees.get(nextNode) == 0) {
                    que.offer(nextNode);
                    sb.append(nextNode);
                    visitCnt++;
                }
            }
        }
        if(visitCnt == g.size()) {
            return sb.toString();
        }
        return "";
    }
}


/*
ae
aee

*/