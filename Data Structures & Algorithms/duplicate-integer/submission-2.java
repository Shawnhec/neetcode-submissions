class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            if(!freq.containsKey(num)) {
                freq.put(num, 1);
            }
            else return true;
        }
        return false;
    }
}


/*


*/