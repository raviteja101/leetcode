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



    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // int lheight = heightOfTree(root.left);
        // int rheight = heightOfTree(root.right);
        // int ldiameter = diameterOfBinaryTree(root.left);
        // int rdiameter = diameterOfBinaryTree(root.right);
        // return Math.max(Math.max(ldiameter, rdiameter), lheight+rheight);
        
        NodeInfo result = getDiamaterOfTree(root);
        return result.diameter;
    }

    public NodeInfo getDiamaterOfTree(TreeNode root) {

        if(root == null) {
            return new NodeInfo();
        }

        NodeInfo left = getDiamaterOfTree(root.left);
        NodeInfo right = getDiamaterOfTree(root.right);

        int diameter = Math.max(Math.max(left.diameter, right.diameter), left.height+right.height);
        int height = 1 + Math.max(left.height, right.height);

        return new NodeInfo(height, diameter);

    }

    int heightOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }
}


class NodeInfo {
    int height;
    int diameter;

    NodeInfo() {
        height = 0;
        diameter = 0;
    }

    NodeInfo(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}