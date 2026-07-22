/*
T : O(n + klogn)
S : O(n)
*/
// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//        Queue<double[]> que = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));
//        int[][] ans = new int[k][2];
//        for (int i = 0; i < points.length; i++) {                                    // T : O(n)
//         que.add(new double[] {distance(points[i][0], points[i][1]), i});
//        }


//         for (int i = 0; i < k; i++) {                                               // T : O(klogn)
//             ans[i] = points[(int) que.poll()[1]];
//         }
//         return ans;
//     }



//     public double distance(int x, int y) {
//         return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
//     }
// }


/*
Max Heap (Even better solution when k is little)
T : O(n * logk)
S : O(k)
*/
// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//        Queue<double[]> que = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
//        int[][] ans = new int[k][2];
//        for (int i = 0; i < points.length; i++) {                                    
//         que.add(new double[] {distance(points[i][0], points[i][1]), i});
//         if(que.size() > k) {
//             que.poll();
//         }
//        }


//         for (int i = 0; i < k; i++) {                                              
//             ans[i] = points[(int) que.poll()[1]];
//         }
//         return ans;
//     }



//     public double distance(int x, int y) {
//         return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
//     }
// }


/*
Sorting by Distance
T : O(nlogn)
Arrays.sort(Object[])   -> TimSort              -> O(n)
並非一般的quick sort with O(logn)
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
       int[][] ans = new int[k][2];
       Arrays.sort(points, (a, b) -> Double.compare(distance(a[0], a[1]), distance(b[0], b[1])));
       for(int i = 0; i < k; i++) {
        ans[i] = points[i];
       }
        return ans;
    }



    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}