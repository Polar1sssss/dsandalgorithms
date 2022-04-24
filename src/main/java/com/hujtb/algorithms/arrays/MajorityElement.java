package com.hujtb.algorithms.arrays;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLFault;

/**
 *
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素
 */
public class MajorityElement {

    public int solution(int[] nums) {
        int count = 0;
        int major = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count = 1;
            } else {
                count += (major == num ? 1 : -1);
            }
        }
        return major;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread("t1");
        t1.start();
        t1.interrupt();
        System.out.println(t1.isInterrupted());
        System.out.println(t1.isInterrupted());
    }
}
