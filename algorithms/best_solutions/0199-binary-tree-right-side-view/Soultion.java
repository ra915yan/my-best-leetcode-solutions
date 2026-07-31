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
    public List<Integer> rightSideView(TreeNode root) {
        return DFS(root);
        // return BFS(root);

    }

    public List<Integer> BFS(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(! queue.isEmpty()){
            int level = queue.size();

            for(int i = 0 ; i < level ; i++){
                TreeNode node = queue.poll();
                if(i == level - 1){
                    result.add(node.val);
                }

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

    public List<Integer> DFS(TreeNode root){
        List<Integer> result = new ArrayList<>();
        DFSRec(root, 0, result);
        return result;
    }

    public void DFSRec(TreeNode node, int level, List<Integer> result){

        if(node == null)
            return;

        if(result.size() == level){
            result.add(node.val);
        }

        DFSRec(node.right, level + 1, result);
        DFSRec(node.left, level + 1, result);
    }
}