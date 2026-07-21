class Solution {
    public int[][] kClosest(int[][] points, int k) {
       Queue<double[]> que = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));
       int[][] ans = new int[k][2];
       for (int i = 0; i < points.length; i++) {
        que.add(new double[] {distance(points[i][0], points[i][1]), i});
       }


        for (int i = 0; i < k; i++) {
            ans[i] = points[(int) que.poll()[1]];
        }
        return ans;
    }



    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}