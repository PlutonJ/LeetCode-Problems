class Solution {
    public int reverse(int x) {
        long y = x % 10, r = x - x % 10;
        while(r / 10 != 0) y += 9 * y + (r /= 10) % 10;
        return y < -2147483648 ? 0 : y > 2147483647 ? 0 : (int)y;
    }
}