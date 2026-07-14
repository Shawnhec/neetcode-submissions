class MedianFinder {
    
    Queue<Integer> left;
    Queue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>((a, b) -> b - a);
        this.right = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        if(right.size() >= left.size()) {
            right.offer(num);
            left.offer(right.poll());
        }
        else if(left.size() > right.size()) {
            left.offer(num);
            right.offer(left.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() != right.size()) return (double) left.peek();
        else return (double) (left.peek() + right.peek()) / 2;
    }
}
