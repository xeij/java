public int countEvenBranches() {
    return countEvenBranches(overallRoot);
}

public int countEvenBranches(IntTreeNode root) {
    if (root == null) {
        return 0;
    } else if (root.left == null && root.right == null) {
        return 0;
    } else {
    
        if (root.data % 2 == 0) {
            return 1 + countEvenBranches(root.left) + countEvenBranches(root.right);
        } else {
            return countEvenBranches(root.left) + countEvenBranches(root.right);
        }  
        
    }
}
