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

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.insert(1);
        tree.insert(2);

        tree.printTree();
        System.out.println();
        
        tree.remove(2);
        tree.printTree();
        System.out.println(tree.find(1));
    }
}
