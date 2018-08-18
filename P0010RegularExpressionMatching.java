// recursive solution with unholy casework
// good to read: https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation

class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j, c;
        for(j = 0; j < p.length(); j++) {
            if((c = p.charAt(j)) >= 'a' && c <= 'z') {
                if(j + 1 < p.length() && p.charAt(j + 1) == '*' && ++j > 0) {
                    if(isMatch(s.substring(i), p.substring(j + 1))) return true;
                    while(i < s.length() && s.charAt(i) == c) if(isMatch(s.substring(i++ + 1), p.substring(j + 1))) return true;
                    return false;
                } else if(i == s.length() || s.charAt(i++) != c) return false;
            } else if(c == '.') {
                if(j + 1 < p.length() && p.charAt(j + 1) == '*' && ++j > 0) {
                    while(i <= s.length()) if(isMatch(s.substring(i++), p.substring(j + 1))) return true;
                    return false;
                } else if(i == s.length()) return false;
                else i++;
            }
        }
        return i == s.length();
    }
}