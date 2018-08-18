// using an array of preset values is probably much faster

class Solution {
    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        int th = num / 1000, h = (num -= th * 1000) / 100, t = (num -= h * 100) / 10, o = num -= t * 10;
        switch(th) {
            case 3: 
                s.append('M');
            case 2: 
                s.append('M');
            case 1: 
                s.append('M');
        }
        if(h >= 5 && h <= 8) s.append('D');
        switch(h) {
            case 8: case 3: 
                s.append('C');
            case 7: case 2: 
                s.append('C');
            case 6: case 1: 
                s.append('C');
            break;
            case 9: 
                s.append("CM");
            break;
            case 4: 
                s.append("CD");
        }
        if(t >= 5 && t <= 8) s.append('L');
        switch(t) {
            case 8: case 3: 
                s.append('X');
            case 7: case 2: 
                s.append('X');
            case 6: case 1: 
                s.append('X');
            break;
            case 9: 
                s.append("XC");
            break;
            case 4: 
                s.append("XL");
        }
        if(o >= 5 && o <= 8) s.append('V');
        switch(o) {
            case 8: case 3: 
                s.append('I');
            case 7: case 2: 
                s.append('I');
            case 6: case 1: 
                s.append('I');
            break;
            case 9: 
                s.append("IX");
            break;
            case 4: 
                s.append("IV");
        }
        return s.toString();
    }
}