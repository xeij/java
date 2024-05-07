package datas.src;

public class postOrderTraversal {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    postOrderTraversal() {
        root = null;
    }

    void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " "); 
    }

    public static void main(String[] args) {
        postOrderTraversal tree = new postOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(10);
        tree.root.right = new Node(39);
        tree.root.left.left = new Node(5);

        System.out.println("Postorder traversal of binary tree is ");
        tree.postOrder(tree.root);
    }
}
