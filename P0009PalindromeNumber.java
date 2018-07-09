// cheap solution: return new StringBuilder("" + x).reverse().toString().equals("" + x);
// use a stack

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = x, p = 1, st[] = {x % 10, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        while((y /= 10) > 0) st[p++] = y % 10;
        while(x > 0) if(st[--p] != x % 10 || (x /= 10) < 0) return false;
        return true;
    }
}