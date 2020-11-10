package com.oliver.algorithm.pattern;

import java.util.*;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/9
 * @since
 */
public class AlgorithmTools {
    public static boolean isValid(String s) {
        if (s == null || "".equals(s)){
            return false;
        }
        if ((s.length()&1) == 1){
            return false;
        }
        Set<Character> left = new HashSet<>();
        left.add('(');
        left.add('[');
        left.add('{');
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');
        Stack<Character> stringStack = new Stack<>();
        for (int i = 0;i < s.length();i++){
            if (left.contains(s.charAt(i))){
                stringStack.push(s.charAt(i));
                continue;
            }
            if(stringStack.isEmpty() || !pairs.get(s.charAt(i)).equals(stringStack.pop())){
                return false;
            }
        }
        return stringStack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isValid("(("));
    }
}
