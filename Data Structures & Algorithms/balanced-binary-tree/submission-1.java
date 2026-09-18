class Solution {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {

        // Empty tree is balanced
        if (root == null) {
            return 0;
        }

        // Check left subtree
        int leftHeight = height(root.left);

        // Left subtree is unbalanced
        if (leftHeight == -1) {
            return -1;
        }

        // Check right subtree
        int rightHeight = height(root.right);

        // Right subtree is unbalanced
        if (rightHeight == -1) {
            return -1;
        }

        // Current node is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return height of current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}