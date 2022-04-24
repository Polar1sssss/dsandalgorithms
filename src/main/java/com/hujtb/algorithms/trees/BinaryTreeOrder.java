package com.hujtb.algorithms.trees;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历、中序遍历、后序遍历
 */
public class BinaryTreeOrder {

    public List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private List<Integer> preOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preOrder(root.left, res);
            preOrder(root.right, res);
            return res;
        }
        return null;
    }

    private List<Integer> midOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            midOrder(root.left, res);
            res.add(root.val);
            midOrder(root.right, res);
            return res;
        }
        return null;
    }

    private List<Integer> postOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            postOrder(root.left, res);
            postOrder(root.right, res);
            res.add(root.val);
            return res;
        }
        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
