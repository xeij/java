public void removeLeaves() {
    overallRoot = removeLeaves(overallRoot);
}

public IntTreeNode removeLeaves(IntTreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
        return null;
    } else {
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }
} Define the command to run your script
