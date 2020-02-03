package org.abc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SwapNodes {

    public static void main(String[] args) {
        Util.printMatrix(swapNodes(new int[][]{{2,3},{-1,-1},{-1,-1}},new int[]{1,1}));
        Util.printMatrix(swapNodes(new int[][]{{2,3},{-1,4},{-1,5},{-1,-1},{-1,-1}},new int[]{2}));
        Util.printMatrix(swapNodes(new int[][]{{2,3},{4,-1},{5,-1},{6,-1},{7,8},{-1,9},{-1,-1},{10,11},{-1,-1},{-1,-1},{-1,-1}},new int[]{2,4}));
    }

    static class TreeNode {
        int index;
        TreeNode left;
        TreeNode right;

        TreeNode(int index) {
            this.index = index;
        }

        public void swapNodes() {
            TreeNode temp = this.left;
            this.left = this.right;
            this.right = temp;
        }
    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
      TreeNode treeNode = new TreeNode(1);
      int count = buildTree(indexes,treeNode);
      int[][] result = new int[queries.length][];
      for(int i=0;i<queries.length;i++) {
          performQuery(treeNode,queries[i]);
          List<Integer> inorderIndexes = new ArrayList<>();
          doInOrder(treeNode,inorderIndexes);
          result[i] = convertListToArray(inorderIndexes);
      }

      return result;
    }

    private static int[] convertListToArray(List<Integer> inorderIndexes) {
        int[] result = new int[inorderIndexes.size()];
        int i=0;
        for(int inorderIndex : inorderIndexes) {
            result[i++] = inorderIndex;
        }

        return result;
    }

    private static void doInOrder(TreeNode treeNode, List<Integer> inorderIndexes) {
        if(treeNode == null) {
            return;
        }
        doInOrder(treeNode.left,inorderIndexes);
        inorderIndexes.add(treeNode.index);
        doInOrder(treeNode.right,inorderIndexes);
    }

    private static void performQuery(TreeNode rootNode, int k) {
        int depth = 1;
        Queue<TreeNode> currLevel = new ArrayDeque<>();
        Queue<TreeNode> nextLevel = new ArrayDeque<>();

        currLevel.add(rootNode);

        while(!currLevel.isEmpty()) {
            TreeNode node = currLevel.poll();
            if(depth%k == 0) {
                node.swapNodes();
            }
            if(node.left != null) {
                nextLevel.add(node.left);
            }
            if(node.right != null) {
                nextLevel.add(node.right);
            }
            if(currLevel.isEmpty()) {
                depth++;
                Queue<TreeNode> tmp = currLevel;
                currLevel = nextLevel;
                nextLevel = tmp;
            }
        }
    }

    private static int buildTree(int[][] indexes, TreeNode rootNode) {
        int count = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(rootNode);

        for(int[] levelNodes: indexes) {
            TreeNode node = queue.poll();
            if(levelNodes[0] != -1) {
                node.left = new TreeNode(levelNodes[0]);
                queue.add(node.left);
                count++;
            }
            if(levelNodes[1] != -1) {
                node.right = new TreeNode(levelNodes[1]);
                queue.add(node.right);
                count++;
            }
        }

        return count;
    }
}
