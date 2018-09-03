// derived from 3sum solution, essentially adding an outer j-loop

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<>();
        for(int j = nums.length - 1; j >= 3; j--) {
            if(j == nums.length - 1 || nums[j] != nums[j + 1]) for(int i = 0; i < j - 2; i++) if(i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = j - 1, sum = target - nums[i] - nums[j];
                while(lo < hi) if(nums[lo] + nums[hi] == sum) {
                    l.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]));
                    while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if(nums[lo] + nums[hi] < sum) lo++;
                else hi--;
            }
        }
        return l;
    }
}