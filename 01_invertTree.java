public TreeNode invertTree(TreeNode root) 
{
	if (root == null)
		return root;
	
	if(root.left != null)
		invertTree(root.left);
	
	if(root.right != null)
		invertTree(root.right);
	
	TreeNode temp = root.left;
	root.left = root.right;
	root.right = temp;
	
	return root;
}