// O(n log n): sort by height, traverse the heights from the highest to the lowest
//             keep track of min index and max index of the heights already seen
//             the maximum area a height can yield is the max of: 
//                 height * abs(index - max) and
//                 height * abs(index - min)

class Solution {
    public int maxArea(int[] height) {
        int[][] s = new int[height.length][2];
        for(int i = 0; i < s.length; s[i][0] = height[i], s[i][1] = i++);
        java.util.Arrays.sort(s, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int min = s[s.length - 1][1], max = min, a = 0;
        for(int i = s.length - 2; i >= 0; a = Math.max(a, Math.max(Math.abs(s[i][1] - max) * s[i][0], Math.abs(s[i][1] - min) * s[i][0])), min = Math.min(min, s[i][1]), max = Math.max(max, s[i--][1]));
        return a;
    }
}