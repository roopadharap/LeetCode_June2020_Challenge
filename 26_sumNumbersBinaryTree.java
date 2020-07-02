class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode root, int n) 
    {
        if(root == null)
            return 0;
        
        n = (n*10 + root.val);
        
        if(root.left == null && root.right == null)
            return n;
        
        return sumNumbers(root.left, n) + sumNumbers(root.right, n);
    }
}