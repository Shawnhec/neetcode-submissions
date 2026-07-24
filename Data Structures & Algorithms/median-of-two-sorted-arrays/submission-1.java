class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1, b = nums2;
        int total = a.length + b.length;
        int half = total / 2; 
        
        if(b.length < a.length) {
            int[] tmp = a;
            a = b;
            b = tmp;
        }


        /*
        i 是 al 下標
        j 是 bl 下標
        */
        int l = 0, r = a.length - 1;
        while(l <= r) {
            int i = l + (r - l) / 2;
            int j = half - i - 2; 
            if(a[i] >= b[j + 1]) {
                r = i - 1;
            }
            
            else if(a[i] < b[j + 1]) {
                l = i + 1;
            }
        }

        int i = r; 
        int j = half - i - 2; 
        int al = (i >= 0) ? a[i] : Integer.MIN_VALUE;
        int ar = (i + 1 >= a.length) ? Integer.MAX_VALUE : a[i + 1];
        int bl = (j >= 0) ? b[j] : Integer.MIN_VALUE;
        int br = (j + 1 >= b.length) ? Integer.MAX_VALUE : b[j + 1];
        
        if(total % 2 != 0) return (double) Math.min(ar, br);
        return (Math.max(al, bl) + Math.min(ar, br)) / 2.0;
    



    }
}


/*
half = 6

a: 1 3 4 6 6 inf 
         l 
       r
         i 

b: 1 2 5 5 5 5 
       j 
       
aSize = 2
bSize = 3 



    if(al <= br && bl <= ar) {
                if(total % 2 == 0) {
                    return (double) Math.max(al, bl) + Math.min(ar, br) / 2; 
                }
                else return (double) Math.max(al, bl);
            }

*/