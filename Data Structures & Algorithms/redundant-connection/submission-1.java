class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        for(int[] edge : edges) {
            if(!uf.union(edge[0], edge[1])) return edge;
        }
        return new int[]{};
    }


    private static class UnionFind{
        
        int[] parent;
        
        int[] size;

        UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(this.size, 1);
            for(int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public boolean union(int i, int j) {
            int rootI = findRoot(i);
            int rootJ = findRoot(j);
            if(rootI == rootJ) return false;

            if(size[rootI] >= size[rootJ]) {
                size[rootI] += size[rootJ];
                size[rootJ] = 0;
                parent[rootJ] = rootI;
            }
            else {
                size[rootJ] += size[rootI];
                size[rootI] = 0;
                parent[rootI] = rootJ;
            }
            return true;
        }

        public int findRoot(int i) {
            if(i == parent[i]) return i;
            return parent[i] = findRoot(parent[i]);
        }
    }
}
