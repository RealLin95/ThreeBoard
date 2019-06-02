package bittech.test;

//另一个树的子树 572
//查找二叉树中指定值的节点 --> 判断两颗二叉树是否完全相同
public class Solution2{
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        if(s.val==t.val){
            if(isSameTree(s,t)){
                return true;
            }
        }
        return isSubtree1(s.left,t)||isSubtree1(s.right,t);
    }
    private boolean isSameTree(TreeNode st,TreeNode t){
        if(st==null&&t==null){
            return true;
        }
        if(st==null||t==null){
            return false;
        }
        if(st.val!=t.val){
            return false;
        }
        return isSameTree(st.left,t.left)&&isSameTree(st.right,t.right);
    }
}
