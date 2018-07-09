// one-pass hash table

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> c = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(c.get(nums[i]) != null) return new int[] {c.get(nums[i]), i};
            c.put(target - nums[i], i);
        }
        return null;
    }
}