package datas;

public class avlRotations {
    
    AVLTreeUpdateHeight(node) {
        leftHeight = -1;
        if (node.left != null)
           leftHeight = node.left.height;
        rightHeight = -1;
        if (node.right != null)
           rightHeight = node.right.height;
        node.height = max(leftHeight, rightHeight) + 1;
     }
     
     
     AVLTreeSetChild(parent, whichChild, child) {
        if (whichChild != "left" && whichChild != "right")
           return false;
     
        if (whichChild == "left")
           parent.left = child;
        else
           parent.right = child;
        if (child != null)
           child.parent = parent;
     
        AVLTreeUpdateHeight(parent);
        return true;
     }
     
     
     AVLTreeReplaceChild(parent, currentChild, newChild) {
        if (parent.left == currentChild)
           return AVLTreeSetChild(parent, "left", newChild);
        else if (parent.right == currentChild)
           return AVLTreeSetChild(parent, "right", newChild);
        return false;
     }
     
     
     AVLTreeGetBalance(node) {
        leftHeight = -1
        if (node.left != null)
           leftHeight = node.left.height;
        rightHeight = -1;
        if (node.right != null)
           rightHeight = node.right.height;
        return leftHeight - rightHeight;
     }

     AVLTreeRotateRight(tree, node) {
        leftRightChild = node.left.right;
        if (node.parent != null)
           AVLTreeReplaceChild(node.parent, node, node.left);
        else { 
           tree.root = node.left;
           tree.root.parent = null;
        }
        AVLTreeSetChild(node.left, "right", node);
        AVLTreeSetChild(node, "left", leftRightChild);
     }

     AVLTreeRebalance(tree, node) {
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


}
