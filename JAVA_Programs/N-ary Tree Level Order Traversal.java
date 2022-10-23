// Problem Link : https://leetcode.com/problems/n-ary-tree-level-order-traversal/

class Solution {
    
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> level= new ArrayList<>();
        if (root == null)
            return level;
        
        Queue<Node> queue= new LinkedList<Node> ();
        List<Integer> arr;
		queue.add(root);
        int nodeCount;
        
        while (!queue.isEmpty())
        {
            nodeCount= queue.size();
            if(nodeCount == 0)
                break;
            
            arr= new ArrayList<>();
            
            while(nodeCount > 0)
            {
            	Node front= queue.poll();
                arr.add(front.val);
                
                for (Node child: front.children)
                    queue.add(child);
                
                nodeCount--;  
            }
            level.add(arr);
        }
        
        return level;
    }
}
