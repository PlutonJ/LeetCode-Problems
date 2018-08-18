// https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution

class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> l = new ArrayList<>(); 
        for(int i = 0; i < num.length - 2; i++) {
            if(i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = -num[i];
                while(lo < hi) {
                    if(num[lo] + num[hi] == sum) {
                        l.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while(lo < hi && num[lo] == num[lo + 1]) lo++;
                        while(lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if(num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return l;
    }
}