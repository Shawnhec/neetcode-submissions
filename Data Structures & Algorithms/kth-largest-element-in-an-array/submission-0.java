class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        for(int num : nums) arr.add(num);
        return quickSelect(arr, k);
    }

    public int quickSelect(List<Integer> arr, int k) {
        Random rand = new Random();
        int pivot = arr.get(rand.nextInt(arr.size()));
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for(int num : arr) {
            if(num < pivot) less.add(num);
            if(num > pivot) greater.add(num);
            if(num == pivot) equal.add(num);
        }
        
        if(greater.size() >= k) return quickSelect(greater, k);
        if(k > greater.size() + equal.size()) return quickSelect(less, k - greater.size() - equal.size());


        return pivot;
    }
}
