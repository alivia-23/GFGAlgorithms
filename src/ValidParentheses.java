import java.util.HashMap;
import java.util.*;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Example 1:
 * Input: s = "()"
 * Output: true
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * Example 4:
 * Input: s = "([])"
 * Output: true
 *
 *
 * Constraints :-
 * opening brackets should be followed by a closing bracket
 *
 * s = "}(){}"
 *
 * Time Complexity - O(n) as we are traversing each character from the string and n represents the number of characters in the string
 *                   and performing push and pop operation in the stack takes O(1) time
 * Space Complexity - O(n) we are taking an extra space i.e stack to put all the opeing brackets and in the worst case the stack might end up
 *                      pushing all the opening brackets in the stack
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        // Map keeps the matching parentheses
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[' );

        // keeps track of the opening brackets
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // if the current character is a closing bracket
            if (map.containsKey(c)) { // found a closing bracket e.g -> c = '}'
                if (stack.isEmpty()) return false;
                if (stack.peek() == map.get(c)) {    // check if stack.peek() = '{' which is the value of map's key i.e '{'
                    stack.pop();
                } else {      // stack.peek() = '(' and map's value is '{'
                    return false;
                }
            } else { // the current character is a opening bracket
                stack.push(c);
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s = "()[]{}";
        String s1 = "(]";
        String s2 = "}()";
        System.out.println(isValid(s));
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
    }
}
