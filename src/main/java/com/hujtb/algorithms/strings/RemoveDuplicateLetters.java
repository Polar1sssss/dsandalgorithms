package com.hujtb.algorithms.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * 给定一个字符串s，去除字符串中的重复字母，使得每个字母只出现一次，需保证，返回结果的字典序最小
 */
public class RemoveDuplicateLetters {

    // 递归调用
    public static String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return "";
        }
        // 保存最左字母的索引位置
        int position = 0;

        // 定义一个保存26个字母个数的数组
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            // 如果i位置的字母小于position位置字母，交换
            if (s.charAt(i) < s.charAt(position)) {
                position = i;
            }
            // 每遇到一个字母，对应位置的值就要减1
            // 如果遇到count减为0，直接跳出循环
            if (--count[s.charAt(i) - 'a'] == 0)
                break;
        }
        return s.charAt(position) + removeDuplicateLetters(
                s.substring(position + 1).replaceAll(s.charAt(position) + "", ""));
    }

    // 使用栈进行优化
    public static String removeDuplicateLetters1(String s) {
        // 定义一个栈，用来保存去重之后的结果
        Stack<Character> stack = new Stack<>();
        // 为了判断一个字符是否出现过，用一个set进行保存
        HashSet<Character> seenSet = new HashSet<>();
        // 为了快速判断一个字符是否在某个位置之后重复出现，用一个HashMap保存字母出现在字符串的最后位置
        HashMap<Character, Integer> lastOccur = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccur.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seenSet.contains(c)) {
                // 如果栈不为空 并且 当前字符小于栈顶字符 并且 栈顶字符在后续字符串中至少还会出现一次，那么把栈和set里的字符移除
                // 因为要保证字典序，所以小字符要在前面，同时要保证被移除的字符在后面还会出现
                while (!stack.isEmpty() && c < stack.peek() && lastOccur.get(stack.peek()) > i) {
                    seenSet.remove(stack.pop());
                }
                stack.push(c);
                seenSet.add(c);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Character c : stack) {
            stringBuffer.append(c.charValue());
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "bcabcd";
        String s1 = removeDuplicateLetters1(s);
        System.out.printf(s1);
    }
}
