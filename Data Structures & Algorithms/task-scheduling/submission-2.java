class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            c -= 'A';
            freq[c]++;
        }
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) pq.offer(freq[i]);
        }

        Queue<int[]> que = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !que.isEmpty()) {
            time++;
            
            if(pq.isEmpty()) {
                time = que.peek()[1];
            }
            else {
                int taskRemain = pq.poll() - 1;
                if(taskRemain != 0) que.offer(new int[]{taskRemain, time + n});
            }
            
            if(!que.isEmpty() && time == que.peek()[1]) {
                pq.add(que.poll()[0]);
            }
        }
        return time;
    }
}


/*


Input: tasks = ["A","A","A","B","C"], n = 3

Output: 9

A -> Idle -> Idle -> Idle -> A -> Idle -> Idle -> Idle -> A ->B -> C 

*/