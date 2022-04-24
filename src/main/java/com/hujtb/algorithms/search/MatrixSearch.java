package com.hujtb.algorithms.search;

/**
 * 看某个数在一个有序的二维数组中是否存在
 * 把二维数组转成一维数组
 */
public class MatrixSearch {

    public static boolean matrixSearch(int[][] matrix, int key) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + high / 2;
            // 计算对应的行列号，取出对应二维数组中元素
            int midElement = matrix[mid / n][mid % n];
            if (midElement < key) {
                low = mid + 1;
            } else if (midElement > key) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {30, 32, 36, 50}};
        int target = 4;
        boolean b = matrixSearch(matrix, target);
        System.out.println(b);
    }
}
