// two pointers: keep track of count of each character from i to j
//               if count goes up to 2 while increasing j, 
//               s.substring(i, j - 1) is a locally maximal substring with no repeating characters
//               increase i until the count of the doubled character goes down to 1
//
//               there are 2 possible cases at j = l: the last character increases its count to either 1 or 2
//               if the count is 1, then the locally maximal substring with no repeating characters is s.substring(i, j) instead of s.substring(i, j - 1), 
//               hence the unpleasant conditional operator
//
// optimization: instead of sliding i, keep track of the last index of each character using a map

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, l = s.length(), max = 0, n[] = new int[128];
        while(j < l) {
            while(j < l && ++n[s.charAt(j++)] <= 1);
            if(j - i - (j == l && n[s.charAt(l - 1)] <= 1 ? 0 : 1) > max) max = j - i - (j == l && n[s.charAt(l - 1)] <= 1 ? 0 : 1);
            while(i < l && --n[s.charAt(i++)] <= 0);
        }
        return max;
    }
}