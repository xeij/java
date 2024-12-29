public void trim(int min, int max) {
    overallRoot = trim(overallRoot, min, max);
}

public IntTreeNode trim(IntTreeNode root, int min, int max) {
    if (root == null) {
        return null;
    } else if (root.data < min) {
        return trim(root.right, min, max);
    } else if (root.data > max) {
        return trim(root.left, min, max);
    } else {
        root.left  = trim(root.left, min, max);
        root.right = trim(root.right, min, max);
        return root;
    }
}
