/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> hm = new HashMap<>();
        process(hm, node);
        return hm.get(node);
    }
    public void process(Map<Node,Node> hm, Node node){
        if(hm.containsKey(node)) return; //1

        Node copy = new Node(node.val); //1'-<>, 2'-<>, 3-<>
        hm.put(node, copy); // 1-1, 2-2', 3-3'

        for(Node nb : node.neighbors){//2, 1,3
            process(hm, nb);
            //im at 2 just finish 1 and return 
            hm.get(node).neighbors.add(hm.get(nb)); //2'-1', 3'-2', 1'-2'
        }

    }
}