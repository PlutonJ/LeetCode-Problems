class Solution {
    public int romanToInt(String s) {
        int min = 1000, n = 0;
        char[] str = s.toCharArray();
        for(char c : str) {
            int v = 0;
            switch(c) {
                case 'I': 
                    v = 1;
                break;
                case 'V': 
                    v = 5;
                break;
                case 'X': 
                    v = 10;
                break;
                case 'L': 
                    v = 50;
                break;
                case 'C': 
                    v = 100;
                break;
                case 'D': 
                    v = 500;
                break;
                case 'M': 
                    v = 1000;
                break;
            }
            if(v > min) n += v - min - min;
            else n += min = v;
        }
        return n;
    }
}