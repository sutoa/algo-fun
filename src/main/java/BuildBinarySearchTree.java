public class BuildBinarySearchTree {
    int pos = 0;

    private TreeNode addValues(int[] preorder, int limit) {
        if (pos == preorder.length || preorder[pos] > limit)
            return null;

        int val = preorder[pos];
        TreeNode node = new TreeNode(preorder[pos]);
        pos++;
        node.left = addValues(preorder, val);
        node.right = addValues(preorder, limit);


        return node;
    }


    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return null;

        return addValues(preorder, Integer.MAX_VALUE);


        /* solution 2 O(N*logN)
        for(int i = 1; i<preorder.length; i++){
            int nextVal = preorder[i];
            TreeNode node = root;

            while(node != null){
                if(nextVal < node.val){
                    if(node.left != null)
                        node = node.left;
                    else{
                        TreeNode leaf = new TreeNode(nextVal);
                        node.left = leaf;
                        break;
                    }
                }
                else{
                    if(node.right != null)
                        node = node.right;
                    else {
                        TreeNode leaf = new TreeNode(nextVal);
                        node.right = leaf;
                        break;
                    }
                }
            }
        }
        return root;
        */

        /* solution 1 O(N^2)
        int nodeVal = preorder[0];
        int[] leftColl = Arrays.stream(preorder).filter(v->v<nodeVal).toArray();
        int[] rightColl = Arrays.stream(preorder).filter(v->v>nodeVal).toArray();

        TreeNode node = new TreeNode(nodeVal);
        node.left = bstFromPreorder(leftColl);
        node.right = bstFromPreorder(rightColl);
        return node;
        */

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}