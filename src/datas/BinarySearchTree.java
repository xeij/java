package datas;

public class BinarySearchTree {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRecursively(root, key);
    }

    Node insertRecursively(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRecursively(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursively(root.right, key);
        }

        return root;
    }

    void printTree() {
        inOrderRecursively(root);
    }

    void inOrderRecursively(Node root) {
        if (root != null) {
            inOrderRecursively(root.left);
            System.out.print(root.key + " ");
            inOrderRecursively(root.right);
        }
    }

    boolean find(int key) {
        return findRecursively(root, key);
    }

    boolean findRecursively(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;

            if (root.key < key)
            return findRecursively(root.right, key);

            return findRecursively(root.left, key);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.insert(1);
        tree.printTree();
        System.out.println(tree.find(1));

    }
}
