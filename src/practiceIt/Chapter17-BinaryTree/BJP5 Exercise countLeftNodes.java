public int countLeftNodes() {
    return countLeftNodes(overallRoot);
}

public int countLeftNodes(IntTreeNode root) {
    if (root == null) {
        return 0;
    } else if (root.left != null) {
        return 1 + countLeftNodes(root.left) + countLeftNodes(root.right);
    } else {
        return countLeftNodes(root.right);
    }  
}
