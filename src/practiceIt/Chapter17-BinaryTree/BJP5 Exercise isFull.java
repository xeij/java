public boolean isFull() {
    return isFull(overallRoot);
}

public boolean isFull(IntTreeNode root) {
    if (root == null) {
        return true;
    } else if (root.left == null && root.right != null) {
        return false;
    } else if (root.right == null && root.left != null) {
        return false;
    } else {
        return isFull(root.left) && isFull(root.right);
    }
}
