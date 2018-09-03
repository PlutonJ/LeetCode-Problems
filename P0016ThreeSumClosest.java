// O(N ** 2), fix the smallest element while binary searching for the other 2, updating the best sum throughout
// return target if sum == target to save some time

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, best = nums[0] + nums[1] + nums[n - 1], sum, lo, hi;
        for(int i = 0; i < n - 2; i++) {
            sum = nums[i] + nums[lo = i + 1] + nums[hi = n - 1];
            while(lo < hi) {
                if(Math.abs(target - sum) < Math.abs(target - best)) best = sum;
                if(sum - target != 0) sum = nums[i] + nums[sum - target < 0 ? ++lo : lo] + nums[sum - target > 0 ? --hi : hi];
                else return target;
            }
        }
        return best;
    }
}