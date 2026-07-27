class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        
        int total = nums1.length + nums2.length;
        int half = total / 2; 

        int left = 0, right = nums1.length - 1;
        while(left <= right) {
            int i = left + (right - left) / 2;
            int j = half - i - 2;

            if(nums1[i] < nums2[j + 1]) {
                left = i + 1;
            }
            else if (nums1[i] >= nums2[j + 1]) {
                right = i - 1; 
            }
        }

        int i = right;
        int j = half - i - 2; 

        int al = i < 0 ? Integer.MIN_VALUE : nums1[i];
        int ar = i + 1 >= nums1.length ? Integer.MAX_VALUE : nums1[i + 1];
        int bl = j < 0 ? Integer.MIN_VALUE : nums2[j];
        int br = j + 1 >= nums2.length ? Integer.MAX_VALUE : nums2[j + 1];

        if(total % 2 != 0) return Math.min(ar, br);
        return (Math.max(al, bl) + Math.min(ar, br)) / 2.0;
    }
}



/*
Input: nums1 = [1,3]
                l
                  r
                i

       nums2 = [2,4]
                  j 

Output: 2.5



*/