package datas;

public class preOrderTraversal {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    preOrderTraversal() {
        root = null;
    }

    void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.key + " "); 
        preOrder(node.left);
        preOrder(node.right); 
    }

    public static void main(String[] args) {
        preOrderTraversal tree = new preOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(10);
        tree.root.right = new Node(39);
        tree.root.left.left = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.preOrder(tree.root);
    }
}
