package datas;

public class avlRotations {

    private class Node {
        int key;
        int height;
        Node left;
        Node right;
        Node parent; 

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;

    private void updateHeight(Node node) {
        int leftHeight = -1;
        if (node.left != null)
            leftHeight = node.left.height;
        int rightHeight = -1;
        if (node.right != null)
            rightHeight = node.right.height;
        node.height = Math.max(leftHeight, rightHeight) + 1;
    }

    private boolean setChild(Node parent, String whichChild, Node child) {
        if (!whichChild.equals("left") && !whichChild.equals("right"))
            return false;

        if (whichChild.equals("left"))
            parent.left = child;
        else
            parent.right = child;
        if (child != null)
            child.parent = parent;

        updateHeight(parent);
        return true;
    }

    private boolean replaceChild(Node parent, Node currentChild, Node newChild) {
        if (parent.left == currentChild)
            return setChild(parent, "left", newChild);
        else if (parent.right == currentChild)
            return setChild(parent, "right", newChild);
        return false;
    }

    private int getBalance(Node node) {
        int leftHeight = -1;
        if (node.left != null)
            leftHeight = node.left.height;
        int rightHeight = -1;
        if (node.right != null)
            rightHeight = node.right.height;
        return leftHeight - rightHeight;
    }

    private void rotateRight(Node node) {
        Node leftRightChild = node.left.right;
        if (node.parent != null)
            replaceChild(node.parent, node, node.left);
        else {
            root = node.left;
            root.parent = null;
        }
        setChild(node.left, "right", node);
        setChild(node, "left", leftRightChild);
    }

     AVLTreeRebalance(tree, node){
        AVLTreeUpdateHeight(node);
        if (AVLTreeGetBalance(node) == -2) {
           if (AVLTreeGetBalance(node.right) == 1) {
              
              AVLTreeRotateRight(tree, node.right);
           }
           return AVLTreeRotateLeft(tree, node);
        }
        else if (AVLTreeGetBalance(node) == 2) {
           if (AVLTreeGetBalance(node.left) == -1) {
              
              AVLTreeRotateLeft(tree, node.left);
           }
           return AVLTreeRotateRight(tree, node);
        }        
        return node;
      }

        AVLTreeInsert(tree, node) {
         if (tree.root == null) {
            tree.root = node;
            node.parent = null;
            return;
         }
      
         cur = tree.root;
         while (cur != null) {
            if (node.key < cur.key) {
               if (cur.left == null) {
                  cur.left = node;
                  node.parent = cur;
                  cur = null;
               }
               else {
                  cur = cur.left;
               }
            }
            else {
               if (cur.right == null) {
                  cur.right = node;
                  node.parent = cur;
                  cur = null;
               }
               else
                  cur = cur.right;
            }
         }
      
         node = node.parent;
         while (node != null) {
            AVLTreeRebalance(tree, node);
            node = node.parent;
         }
      }

      AVLTreeRemoveNode(tree, node) {
         if (node == null) {
            return false;
         }
         parent = node.parent;
              
         if (node.left != null && node.right != null) {
            succNode = node.right;
            while (succNode.left != null) {
               succNode = succNode.left;
            }
      
            node.key = succNode.key;
            AVLTreeRemoveNode(tree, succNode);
            return true;
         }
      
         else if (node == tree.root) {
            if (node.left != null) {
               tree.root = node.left;
            }
            else {
               tree.root = node.right;
            }
            if (tree.root != null) {
               tree.root.parent = null;
            }
            return true;
         }
      
         else if (node.left != null) {
            AVLTreeReplaceChild(parent, node, node.left);
         }
         else {
            AVLTreeReplaceChild(parent, node, node.right);
         }
      
         node = parent;
         while (node != null) {
            AVLTreeRebalance(tree, node);
            node = node.parent;
         }
         return true;
      }

      public static void main(String[] args) {
      }
}
