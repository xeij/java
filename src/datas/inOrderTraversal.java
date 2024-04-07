package datas;

public class inOrderTraversal {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    inOrderTraversal() {
        root = null;
    }

    void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left); 
        System.out.print(node.key + " "); 
        inOrder(node.right); 
    }

    public static void main(String[] args) {
        inOrderTraversal tree = new inOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(10);
        tree.root.right = new Node(39);
        tree.root.left.left = new Node(5);

        System.out.println("Inorder traversal of binary tree is ");
        tree.inOrder(tree.root);
    }
}
