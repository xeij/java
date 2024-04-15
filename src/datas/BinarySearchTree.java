package datas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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

    Node findMin(Node node) {
        Node current = node;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    Node findMax(Node node) {
        Node current = node;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return current;
    }

    void remove(int key) {
        root = removeIteratively(root, key);
    }

    Node removeIteratively(Node root, int key) {
        Node parent = null;
        Node current = root;
        
        while (current != null && current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        
        if (current == null) return root;
        
        if (current.left == null || current.right == null) {
            Node newCurrent;
            if (current.left == null)
                newCurrent = current.right;
            else
                newCurrent = current.left;
            
            if (parent == null) return newCurrent; 
            
            if (current == parent.left)
                parent.left = newCurrent;
            else
                parent.right = newCurrent;
        } else {
            Node successor = findMin(current.right);
            
            int successorKey = successor.key;
            remove(successorKey);
            
            current.key = successorKey;
        }
        
        return root;
    }

    boolean isBST() {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTHelper(Node node, int min, int max) {
        if (node == null) return true;
        if (node.key <= min || node.key >= max) return false;
        return isBSTHelper(node.left, min, node.key) && isBSTHelper(node.right, node.key, max);
    }

    void convertToBST() {
        ArrayList<Integer> keys = new ArrayList<>();
        storeInorderKeys(root, keys);
        Collections.sort(keys);
        Iterator<Integer> it = keys.iterator();
        setInorderKeys(root, it);
    }

    void storeInorderKeys(Node root, ArrayList<Integer> keys) {
        if (root != null) {
            storeInorderKeys(root.left, keys);
            keys.add(root.key);
            storeInorderKeys(root.right, keys);
        }
    }

    void setInorderKeys(Node root, Iterator<Integer> it) {
        if (root != null) {
            setInorderKeys(root.left, it);
            root.key = it.next();
            setInorderKeys(root.right, it);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(44);
        tree.insert(5);
        tree.insert(28);
        tree.insert(13);
        tree.insert(39);
        tree.insert(6);
        tree.insert(18);

        tree.printTree();
        System.out.println("\nIs it a binary search tree? " + tree.isBST());

        BinarySearchTree nonBST = new BinarySearchTree();
        nonBST.root = new Node(10);
        nonBST.root.left = new Node(30);
        nonBST.root.right = new Node(20);
        nonBST.root.left.left = new Node(5);
        nonBST.root.left.right = new Node(15);

        System.out.println("\nOriginal non-BST:");
        nonBST.printTree();
        System.out.println("\nIs it a binary search tree? " + nonBST.isBST());

        nonBST.convertToBST();
        System.out.println("\nConverted to BST:");
        nonBST.printTree();
        System.out.println("\nIs it now a BST? " + nonBST.isBST());
    }
}
