public int numberNodes() {
    return numberNodes(overallRoot, 1);
}

public int numberNodes(IntTreeNode root, int num) {
    if (root == null) {
        return 0;
    } else {
        root.data = num;
        int countLeft = numberNodes(root.left, num + 1);
        int countRight = numberNodes(root.right, num + countLeft + 1);
        return 1 + countLeft + countRight;
    }
}
