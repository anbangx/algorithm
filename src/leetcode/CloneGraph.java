package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


public class CloneGraph {
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(node == null)
            return null;
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> real2Clone = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        real2Clone.put(node, clone);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.removeFirst();
            UndirectedGraphNode cloneNode;
            if(visited.contains(cur))
                continue;
            else{
                visited.add(cur);
                if(real2Clone.containsKey(cur))
                    cloneNode = real2Clone.get(cur);
                else{
                    cloneNode = new UndirectedGraphNode(cur.label);
                    real2Clone.put(cur, cloneNode);
                }
            }
            ArrayList<UndirectedGraphNode> cloneNeighbors = new ArrayList<UndirectedGraphNode>();
            for(UndirectedGraphNode neighbor : cur.neighbors){
                UndirectedGraphNode cloneNeighbor;
                if(real2Clone.containsKey(neighbor))
                    cloneNeighbor = real2Clone.get(neighbor);
                else{
                    cloneNeighbor = new UndirectedGraphNode(neighbor.label);
                    real2Clone.put(neighbor, cloneNeighbor);
                }
                cloneNeighbors.add(cloneNeighbor);
                queue.add(neighbor);
            }
            cloneNode.neighbors = cloneNeighbors;
        }
        
        return clone;
    }   
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
