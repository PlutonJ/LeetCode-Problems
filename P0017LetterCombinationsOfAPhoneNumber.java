// british museum recursion
// also using only 1 StringBuilder should have saved a lot of memory

class Solution {
    public List<String> letterCombinations(String digits) {
        return britishMuseum(0, new StringBuilder(), digits, new ArrayList<>(), new char[][] {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}});
    }
    
    private List<String> britishMuseum(int depth, StringBuilder buf, String str, List<String> list, char[][] map) {
        if(depth == str.length()) {
            list.add(buf.toString());
            return list.size() == 1 ? new ArrayList<>() : list;
        }
        for(char c : map[str.charAt(depth) - '2']) {
            britishMuseum(depth + 1, buf.append(c), str, list, map);
            buf.setLength(depth);
        }
        return list;
    }
}