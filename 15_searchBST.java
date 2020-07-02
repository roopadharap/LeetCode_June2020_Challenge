public TreeNode searchBST(TreeNode root, int val) ]
{
	if(root == null)
		return root;
	
	TreeNode t = root;
	
	while(t != null)
	{
		if(t.val == val)
			return t;
		else if(t.val < val)
			t = t.right;
		else
			t = t.left;
	}
	
	return null;
}

/*
****** Recursive Solution

public TreeNode searchBST(TreeNode root, int val) 
{
	if(root == null || root.val == val)
		return root;
	
	TreeNode left = searchBST(root.left, val);
	
	if(left != null)
		return left;
	
	return searchBST(root.right, val);
}
*/