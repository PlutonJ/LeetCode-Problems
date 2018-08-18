class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";                         // seriously, this trivial test case is completely and utterly pointless
        char[] pre = strs[0].toCharArray();
        int max = pre.length;
        next: for(int i = 1, j = 0; i < strs.length; i++, j = 0) for(max = Math.min(max, strs[i].length()); j < max; j++) if(pre[j] != strs[i].charAt(j)) {
            if((max = j) == 0) return "";
            continue next;
        }
        return strs[0].substring(0, max);
    }
}