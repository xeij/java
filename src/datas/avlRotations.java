package datas;

public class avlRotations {
    
    AVLTreeUpdateHeight(node) {
        leftHeight = -1
        if (node⇢left != null)
           leftHeight = node⇢left⇢height
        rightHeight = -1
        if (node⇢right != null)
           rightHeight = node⇢right⇢height
        node⇢height = max(leftHeight, rightHeight) + 1
     }
     
     
     AVLTreeSetChild(parent, whichChild, child) {
        if (whichChild != "left" && whichChild != "right")
           return false
     
        if (whichChild == "left")
           parent⇢left = child
        else
           parent⇢right = child
        if (child != null)
           child⇢parent = parent
     
        AVLTreeUpdateHeight(parent)
        return true
     }
     
     
     AVLTreeReplaceChild(parent, currentChild, newChild) {
        if (parent⇢left == currentChild)
           return AVLTreeSetChild(parent, "left", newChild)
        else if (parent⇢right == currentChild)
           return AVLTreeSetChild(parent, "right", newChild)
        return false
     }
     
     
     AVLTreeGetBalance(node) {
        leftHeight = -1
        if (node⇢left != null)
           leftHeight = node⇢left⇢height
        rightHeight = -1
        if (node⇢right != null)
           rightHeight = node⇢right⇢height
        return leftHeight - rightHeight
     }


}
