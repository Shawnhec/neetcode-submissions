// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int n = numbers.length;
//         for(int i = 0; i < n; i++) {
//             int complement = target - numbers[i];
//             int res = lowerBound(numbers, complement);
//             if(res >= n || numbers[res] != complement) continue;
//             if(numbers[res] == complement) return new int[]{i + 1, res + 1};
//         }
//         return new int[]{};
//     }

//     public int lowerBound(int[] nums, int target) {
//         int left = 0, right = nums.length - 1;
//         while(left <= right) {
//             int mid = left + (right - left) / 2;
//             if (target <= nums[mid]) right = mid - 1;
//             else left = mid + 1;
//         }
//         return left;
//     }
// }


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left <= right) {
            int currSum = numbers[left] + numbers[right]; 
            if(currSum == target) return new int[]{left + 1, right + 1};
            if(target > currSum) {
                left++;
            }
            else if (target < currSum) {
                right--;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}



