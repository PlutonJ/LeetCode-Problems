// O(n), calculate the index for first character each row, then plug each character into their resulting positions

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int m = numRows + numRows - 2, l[] = new int[numRows], p[] = new int[numRows], c[] = new int[numRows];
        char str[] = new char[s.length()];
        for(int i = 0; i < s.length(); l[i % m >= numRows ? m - i % m : i % m]++, i++);
        for(int i = 1; i < numRows; i++) p[i] = p[i - 1] + l[i - 1];
        for(int i = 0, o; i < s.length(); o = i % m >= numRows ? m - i % m : i % m, str[p[o] + c[o]++] = s.charAt(i++));
        return new String(str);
    }
}