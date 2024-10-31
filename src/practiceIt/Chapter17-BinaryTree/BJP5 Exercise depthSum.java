public int depthSum() {
    return depthSum(overallRoot, 1);
}

public int depthSum(IntTreeNode root, int depth) {
    if (root == null) {
        return 0;
    } else {
        return root.data * depth + depthSum(root.left, depth + 1) + depthSum(root.right, depth + 1);
    }
}
