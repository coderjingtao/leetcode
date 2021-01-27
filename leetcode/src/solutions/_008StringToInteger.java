package solutions;

import java.math.BigDecimal;

/**
 * NO.8 String to Integer (atoi)
 * Keywords:   Array
 * Difficulty: Medium
 * Company:    Microsoft, Amazon, Uber, Bloomberg
 */
public class _008StringToInteger {

    /**
     * 没啥难度就是需要判断一些特点的转换条件
     */
    public int myAtoi(String str) {
        String newStr = str.trim();
        if(newStr.length() == 0)
            return 0;
        char c = newStr.charAt(0);
        StringBuilder sb = new StringBuilder();
        if(!Character.isDigit(c) && c !='+' && c != '-'){
            return 0;
        }
        if( c=='+' || c == '-'){
            sb.append(c);
            newStr = newStr.substring(1);
        }
        char[] chars = newStr.toCharArray();
        for(int i=0; i< chars.length; i++){
            if(Character.isDigit(chars[i])){
                sb.append(chars[i]);
            }else{
                break;
            }
        }
        if(sb.toString().equals("+") || sb.toString().equals("-"))
            return 0;
        BigDecimal x = new BigDecimal(sb.toString());
        if(x.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 1)
            return Integer.MAX_VALUE;
        if(x.compareTo(new BigDecimal(Integer.MIN_VALUE)) == -1)
            return Integer.MIN_VALUE;
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        _008StringToInteger s = new _008StringToInteger();
        System.out.println(s.myAtoi(".1"));
    }

}
