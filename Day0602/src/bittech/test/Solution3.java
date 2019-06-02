package bittech.test;

//二叉树的最大深度 104
public class Solution3{
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max = Math.max(maxDepth(root.left),maxDepth(root.right));
        return max+1;
    }
}