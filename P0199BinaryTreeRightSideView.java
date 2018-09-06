/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        return solve(0, root, new ArrayList<>());
    }
    
    private List<Integer> solve(int depth, TreeNode node, List<Integer> l) {
        if(node == null) return l;
        if(depth == l.size()) l.add(node.val);
        solve(depth + 1, node.right, l);
        solve(depth + 1, node.left, l);
        return l;
    }
}