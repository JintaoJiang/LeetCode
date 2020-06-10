class Solution(object):
    def delNodes(self, root, to_delete):
        """
        :type root: TreeNode
        :type to_delete: List[int]
        :rtype: List[TreeNode]
        """
        res = []
        
        def helper(root, par_del):
            if root == None:
                return None
            to_del = root.val in to_delete
            if par_del and not to_del:
                res.append(root)            
            root.left = helper(root.left, to_del)
            root.right = helper(root.right, to_del)
            return root if not to_del else None
        
        helper(root, True)
        
        return res
