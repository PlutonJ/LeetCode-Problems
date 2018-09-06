class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>(target + 1);
        for(int i = 0; i <= target; i++) dp.add(new ArrayList<>());
        dp.get(0).add(new ArrayList<>());
        for(int x : candidates) for(int i = x; i <= target; i++) for(List<Integer> l : dp.get(i - x)) {
            List<Integer> buf  = new ArrayList<>(l);
            buf.add(x);
            dp.get(i).add(buf);
        }
        return dp.get(target);
    }
}