class CountSquares {

    private Map<List<Integer>, Integer> ptsCnt;

    private List<List<Integer>> pts; 

    public CountSquares() {
        ptsCnt = new HashMap<>();
        pts = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> pt = Arrays.asList(point[0], point[1]);
        ptsCnt.merge(pt, 1, Integer::sum);
        pts.add(pt);
    }
    
    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];
        for(List<Integer> pt : pts) {
            int x = pt.get(0), y = pt.get(1);
            if(Math.abs(px - x) != Math.abs(py - y) || px == x || py == y) continue;
            
            if(ptsCnt.containsKey(List.of(px, y)) && ptsCnt.containsKey(List.of(x, py))) {
                res += ptsCnt.get(List.of(px, y)) * ptsCnt.get(List.of(x, py));
            }

        }
        return res; 
    }
}


/*


            (x, py)          (px, py)



            (x, y)           (px, y)




*/