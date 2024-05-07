package datas.src;

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

    private void rotateLeft(Node node) {
      Node rightLeftChild = node.right.left;
      if (node.parent != null)
          replaceChild(node.parent, node, node.right);
      else {
          root = node.right;
          root.parent = null;
      }
      setChild(node.right, "left", node);
      setChild(node, "right", rightLeftChild);
  }

  private Node rebalance(Node node) {
      updateHeight(node);
      int balance = getBalance(node);

      if (balance == -2) { 
          if (getBalance(node.right) == 1) { 
              rotateRight(node.right);
          }
          rotateLeft(node); 
      } else if (balance == 2) { 
          if (getBalance(node.left) == -1) { 
              rotateLeft(node.left);
          }
          rotateRight(node); 
      }
      return node;
  }

  public void insert(int key) {
      Node newNode = new Node(key);
      if (root == null) {
          root = newNode;
      } else {
          Node current = root;
          while (true) {
              if (key < current.key) {
                  if (current.left == null) {
                      current.left = newNode;
                      newNode.parent = current;
                      break;
                  }
                  current = current.left;
              } else if (key > current.key) {
                  if (current.right == null) {
                      current.right = newNode;
                      newNode.parent = current;
                      break;
                  }
                  current = current.right;
              } else {
                  return;
              }
          }
          current = newNode.parent;
          while (current != null) {
              rebalance(current);
              current = current.parent;
          }
      }
  }

  public void remove(int key) {
   root = remove(root, key);
}

   private Node remove(Node node, int key) {
      if (node == null) {
         return null;
      }
      if (key < node.key) {
         node.left = remove(node.left, key);
      } else if (key > node.key) {
         node.right = remove(node.right, key);
      } else {
         if (node.left == null || node.right == null) {
            Node temp = (node.left != null) ? node.left : node.right;
            if (temp == null) {
                  temp = node;
                  node = null;
            } else {
                  node = temp;
            }
         } else {
            Node temp = minValueNode(node.right);
            node.key = temp.key;
            node.right = remove(node.right, temp.key);
         }
      }
      if (node == null) return node;
      return rebalance(node);
   }

   private Node minValueNode(Node node) {
      Node current = node;
      while (current.left != null) {
         current = current.left;
      }
      return current;
   }

  public static void main(String[] args) {
      avlRotations tree = new avlRotations();
      tree.insert(10);
      tree.insert(20);
     
  }
}