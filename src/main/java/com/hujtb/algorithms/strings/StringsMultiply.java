package com.hujtb.algorithms.strings;

public class StringsMultiply {
    public static String stringsMultiply(String num1, String num2) {
        // 有一个乘数为0，结果就是0
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        // 定义输出结果
        String result = "0";

        for (int i = num2.length() - 1; i >= 0; i--) {
            int n2 = num2.charAt(i) - '0';
            // 用一个StringBuffer存储乘积
            StringBuffer curResult = new StringBuffer();
            int carry = 0;

            // 因为结果是倒序，所以当前n2对应数位需要补0，应该先写入curResult。
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                curResult.append("0");
            }

            // 从个位开始遍历num1中的每一位，与n2相乘
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(j) - '0';
                int product = n1 * n2 + carry;
                curResult.append(product % 10);
                carry = product / 10;
            }
            result = StringsAdd.stringsAdd(result, curResult.reverse().toString());
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "1234";
        String b = "13";
        System.out.println(StringsMultiply.stringsMultiply(a, b));
    }

}
