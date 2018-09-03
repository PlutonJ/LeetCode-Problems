// O(n ** 2)

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), i = 0, j, x = 0, max = 0;
        while(i < n - 1) {
            for(j = i, x = 0; j < n; j++) if(s.charAt(j) == '(') x++;
            else if(x > 0) max = --x == 0 ? Math.max(max, j - i + 1) : max;
            else break;
            while(++i < n - 1 && s.charAt(i) == ')');
        }
        return max;
    }
}