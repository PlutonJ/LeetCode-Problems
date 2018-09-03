// british museum recursion, left = # of leftover left parantheses, free = # of left parantheses to be closed

class Solution {
    public List<String> generateParenthesis(int n) {
        return n == 0 ? new ArrayList<>() : dfs(0, 0, n, new StringBuilder(), n + n, new ArrayList<>());
    }
    
    private List<String> dfs(int depth, int free, int left, StringBuilder buf, int n, List<String> l) {
        if(depth == n) {
            l.add(buf.toString());
            return l;
        }
        if(left > 0) {
            dfs(depth + 1, free + 1, left - 1, buf.append('('), n, l);
            buf.setLength(depth);
        }
        if(free > 0) {
            dfs(depth + 1, free - 1, left, buf.append(')'), n, l);
            buf.setLength(depth);
        }
        return l;
    }
}