package solutions;
import java.util.Stack;

/**
 * NO.20 Valid Parentheses
 * Keywords:   Stack
 * Difficulty: Easy
 * Company:    Google, Facebook, Microsoft, Amazon, Bloomberg, Airbnb
 */
public class _020ValidParentheses {

    /**
     * Idea:利用栈的后进先出性质，来判断字符串中的括号是否对称
     * 如果字符串的括号是对称的，那么最后栈的大小一定是0
     */
    public boolean isValid(String s) {
        if(s == null || s.trim().isEmpty())
            return true;
        if(s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length;i++){
            if( chars[i]=='(' || chars[i]=='[' || chars[i]=='{' ){
                stack.push(chars[i]);
            }
            else{
                if(stack.size() == 0)
                    return false;
                if(!isPair(stack.pop() , chars[i]) )
                    return false;
            }
        }
        return stack.size() == 0;
    }

    private boolean isPair(char leftBracket, char rightBracket){
        if(leftBracket == '(' && rightBracket == ')')
            return true;
        if(leftBracket == '[' && rightBracket == ']')
            return true;
        if(leftBracket == '{' && rightBracket == '}')
            return true;
        return false;
    }

    public static void main(String[] args) {
        _020ValidParentheses v = new _020ValidParentheses();
        String test1 = "(()("; //false
        System.out.println(v.isValid(test1));
        String test2 = "()[]{}"; //true
        System.out.println(v.isValid(test2));
        String test3 = "(("; //false
        System.out.println(v.isValid(test3));
        String test4 = "["; //false
        System.out.println(v.isValid(test4));
        String test5 = "}{"; //false
        System.out.println(v.isValid(test5));
    }
}
