package com.example.collab;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertRecursive(root.right, val);
        }

        return root;
    }

    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (val == root.val) {
            return true;
        } else if (val < root.val) {
            return searchRecursive(root.left, val);
        } else {
            return searchRecursive(root.right, val);
        }
    }

    public void delete(int val) {
        root = deleteRecursive(root, val);
    }

    private TreeNode deleteRecursive(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val == root.val) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = findMinValue(root.right);
                root.right = deleteRecursive(root.right, root.val);
            }
        } else if (val < root.val) {
            root.left = deleteRecursive(root.left, val);
        } else {
            root.right = deleteRecursive(root.right, val);
        }

        return root;
    }

    private int findMinValue(TreeNode root) {
        return root.left == null ? root.val : findMinValue(root.left);
    }

    public int height() {
        return heightRecursive(root);
    }

    public int heightRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightRecursive(root.left);
        int rightHeight = heightRecursive(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public String visualize() {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("Tree is empty.");
        } else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sb.append(node.val);
                    if (node.left != null || node.right != null) {
                        sb.append(" -> ");
                        if (node.left != null) {
                            queue.offer(node.left);
                            sb.append(node.left.val);
                        }
                        if (node.right != null) {
                            if (node.left != null) {
                                sb.append(", ");
                            }
                            queue.offer(node.right);
                            sb.append(node.right.val);
                        }
                    }
                    sb.append("   ");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
}
