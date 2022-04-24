package com.hujtb.algorithms.strings;

public class StringsAdd {
    public static String stringsAdd(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // 保存进位
        int carry = 0;
        // 以下三种情况需要继续做运算
        while (i >= 0 || j >= 0 || carry != 0) {
            // i = 0时j有可能不等于0，所以num1要补0
            // 需要将ascii转换为数字
            int numi = i >= 0 ? num1.charAt(i) - '0' : 0;
            int numj = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = numi + numj + carry;

            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "12345";
        String b = "56";
        String s = stringsAdd(a, b);
        System.out.println(s);
    }
}
