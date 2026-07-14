class KthLargest {

    Queue<Integer> right; 
    
    int k;


    public KthLargest(int k, int[] nums) {
        this.right = new PriorityQueue<>((a, b) -> a - b);
        this.k = k;
        for(int num : nums) {
            right.offer(num);
        }
        while(right.size() > k) {
            right.poll();
        }
    }
    
    public int add(int val) {
        right.offer(val);
        if(right.size() > k) right.poll();
        return right.peek();
    }
}
