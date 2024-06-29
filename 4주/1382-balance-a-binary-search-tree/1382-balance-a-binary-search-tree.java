import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);
        return sortedArrayToBST(sortedList, 0, sortedList.size() - 1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> sortedList) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, sortedList);
        
        sortedList.add(node.val);
        inOrderTraversal(node.right, sortedList);
    }

    
    private TreeNode sortedArrayToBST(List<Integer> sortedList, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        
        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = sortedArrayToBST(sortedList, left, mid - 1);
        node.right = sortedArrayToBST(sortedList, mid + 1, right);
        
        return node;
    }
}
