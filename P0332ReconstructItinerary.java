// simple dfs after sorting alphabetically

class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[0].compareTo(b[0]) == 0 ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        return solve(new boolean[tickets.length], tickets, new ArrayList<>());
    }
    
    private List<String> solve(boolean[] used, String[][] tickets, List<String> l) {
        if(l.size() == 0) l.add("JFK");
        else if(l.size() == tickets.length + 1) return l;
        for(int i = 0; i < tickets.length; i++) if(!used[i] && tickets[i][0].equals(l.get(l.size() - 1))) {
            l.add(tickets[i][1]);
            used[i] = true;
            if(solve(used, tickets, l) != null) {
                return l;
            }
            used[i] = false;
            l.remove(l.size() - 1);
        }
        return null;
    }
}