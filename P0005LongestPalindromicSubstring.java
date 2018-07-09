// Manacher's algorithm

class Solution {
    public String longestPalindrome(String s) {
        char[] t = p(s).toCharArray();
        int i, i_ = -1, n = t.length, p[] = new int[n], c = 0, r = 0, max = 0, cen = 0;
        for(i = 1; i < n - 1; i_ = 2 * c - (++i), p[i] = r > i ? Math.min(r - i, p[i_]) : 0) {
            while(t[i + 1 + p[i]] == t[i - 1 - p[i]]) p[i]++;
            if(i + p[i] > r && (c = i) > 0) r = i + p[i];
            if(p[i] > max && (cen = i) > 0) max = p[i];
        }
        return s.substring((cen - 1 - max) / 2, (cen - 1 - max) / 2 + max);
    }
    
    String p(String s) {
        int n = s.length();
        if(n == 0) return "^$";
        StringBuilder ret = new StringBuilder("^");
        for(char c : s.toCharArray()) ret.append("#" + c);
        return ret.append("#$").toString();
    }
}