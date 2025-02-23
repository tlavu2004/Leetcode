/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int preIndex = 0;
    int postIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return this.constructTree(preorder, postorder);
    }

    private TreeNode constructTree(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (root.val != postorder[postIndex]) {
            root.left = this.constructTree(preorder, postorder);
        }
        if (root.val != postorder[postIndex]) {
            root.right = this.constructTree(preorder, postorder);
        }
        
        ++postIndex;
        return root;
    }
}

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        Solution solution = new Solution();
        TreeUtils treeUtils = new TreeUtils();
        
        TreeNode resultTreeNode = solution.constructFromPrePost(preorder, postorder);
        int[] result = treeUtils.inorderTraversal(resultTreeNode);

        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append("[");

        for (int i = 0; i < result.length; ++i) {
            resultStringBuilder.append(result[i]).append(i < result.length - 1 ? ", " : "].");
        }

        System.out.println(resultStringBuilder.toString());
    }
}