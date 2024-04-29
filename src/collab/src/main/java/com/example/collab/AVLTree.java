package com.example.collab;

public class AVLTree {
    Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (value < node.value)
            node.left = insertRec(node.left, value);
        else if (value > node.value)
            node.right = insertRec(node.right, value);
        else 
            return node;

       
        node.height = 1 + Math.max(height(node.left), height(node.right));

        
        int balance = getBalance(node);

        
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public boolean delete(int value) {
        root = deleteRec(root, value);
        return root != null;
    }

    private Node deleteRec(Node node, int value) {
        if (node == null)
            return node;

        if (value < node.value)
            node.left = deleteRec(node.left, value);
        else if (value > node.value)
            node.right = deleteRec(node.right, value);
        else {
            if (node.left == null || node.right == null) {
                Node temp = null;
                if (temp == node.left)
                    temp = node.right;
                else
                    temp = node.left;

                if (temp == null) {
                    temp = node;
                    node = null;
                } else
                    node = temp;
            } else {
                Node temp = minValueNode(node.right);
                node.value = temp.value;
                node.right = deleteRec(node.right, temp.value);
            }
        }

        if (node == null)
            return node;

        
        node.height = 1 + Math.max(height(node.left), height(node.right));

        
        int balance = getBalance(node);

       
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node minValueNode(Node node) {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(Node root, int val) {
        if (root == null) {
            return false;
        }

        if (val == root.value) {
            return true;
        } else if (val < root.value) {
            return searchRecursive(root.left, val);
        } else {
            return searchRecursive(root.right, val);
        }
    }

    public int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        
        x.right = y;
        y.left = T2;

       
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

       
        y.left = x;
        x.right = T2;

        
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        
        return y;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        inorderTraversal(root, builder);
        return builder.toString();
    }

    private void inorderTraversal(Node node, StringBuilder builder) {
        if (node != null) {
            inorderTraversal(node.left, builder);
            builder.append(node.value).append(" ");
            inorderTraversal(node.right, builder);
        }
    }

	public int height() {
		return heightRecursive(root);
	}
	private int heightRecursive(Node root2) {
        if (root2 == null) {
            return 0;
        }
        int leftHeight = heightRecursive(root2.left);
        int rightHeight = heightRecursive(root2.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
