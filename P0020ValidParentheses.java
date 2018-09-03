class Solution {
    public boolean isValid(String s) {
        int p = 0, st[] = new int[s.length()];
        for(char c : s.toCharArray()) if(c == '(' || c == '[' || c == '{') st[p++] = c;
        else if(p > 0 && st[p - 1] == c - (c == ')' ? 1 : 2)) p--;
        else return false;
        return p < 1;
    }
}