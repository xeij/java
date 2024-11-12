public String toString2() {
    return toString2(overallRoot);
}

public String toString2(IntTreeNode root) {
    if (root == null) {
        return "empty";
    } else if (root.left == null && root.right == null) {
        return "" + root.data;
    } else {
        return "(" + root.data + ", " + toString2(root.left) + ", " + toString2(root.right) + ")";
    }
}
