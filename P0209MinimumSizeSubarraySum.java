// O(n), 2 pointers

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length, i = 0, j = -1, sum = 0, min = n + 1;
        while(i < n) {
            while(sum < s && j < n - 1) sum += nums[++j];
            while(sum - nums[i] >= s) sum -= nums[i++];
            min = sum >= s ? Math.min(min, j - i + 1) : min;
            sum -= ++i < n ? nums[i - 1] : sum;
        }
        return min > n ? 0 : min;
    }
}