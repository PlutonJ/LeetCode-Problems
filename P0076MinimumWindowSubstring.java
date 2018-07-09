// https://www.cnblogs.com/lichen782/p/leetcode_minimum_window_substring_3.html

class Solution {
    public String minWindow(String s, String t) {
        int v = 0, map[] = new int[128];
        java.util.Arrays.fill(map, -1);
        for(char c : t.toCharArray()) map[c] = map[c] < 0 ? v++ : map[c];
        int i = 0, min = Integer.MAX_VALUE, ind = -1, l = 0, n[] = new int[v], m[] = new int[v];
        for(char c : t.toCharArray()) n[map[c]]++;
        for(int j = 0, c = s.charAt(j), x; j < s.length(); c = ++j < s.length() ? s.charAt(j) : ' ') if(map[c] >= 0 && ++m[map[c]] <= n[map[c]] && ++l == t.length()) {
            while(i <= j && ((x = map[s.charAt(i++)]) < 0 || m[x]-- > n[x]));
            if(l-- > 0 && j - i + 2 < min) min = j - (ind = i - 1) + 1;
        }
        return ind < 0 ? "" : s.substring(ind, ind + min);
    }
}