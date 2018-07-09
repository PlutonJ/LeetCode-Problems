class Solution {
    public int myAtoi(String str) {
        int i = -1, c = ' ', s = 1, n = 0;
        while(++i < str.length() && (c = str.charAt(i)) == ' ');
        if(c == '-') s = -1;
        else if(c >= '0' && c <= '9') n = c - '0';
        else if(c != '+') return 0;
        while(++i < str.length() && (c = str.charAt(i)) >= '0' && c <= '9') if(n > 214748364 || n == 214748364 && c >= '8') return 2147483647;
            else if(n < -214748364 || n == -214748364 && c == '9') return -2147483648;
            else n += 9 * n + s * (c - '0');
        return n;
    }
}