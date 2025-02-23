import java.util.ArrayList;
import java.util.List;

class TreeUtils {
    public int[] inorderTraversal(TreeNode root) {
        List<Integer> resultListTreeNode = new ArrayList<>();
        this.inorderHelper(root, resultListTreeNode);
        return resultListTreeNode.stream().mapToInt(i -> i).toArray();
    }

    private void inorderHelper(TreeNode treeNode, List<Integer> resultListTreeNode) {
        if (treeNode == null) {
            return;
        }

        inorderHelper(treeNode.left, resultListTreeNode);
        resultListTreeNode.add(treeNode.val);
        inorderHelper(treeNode.right, resultListTreeNode);
    }
}