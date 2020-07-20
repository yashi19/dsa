import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Topological Sort using DFS
public class TopologicalDFS {
    Map<Integer, List<Integer>> graph;
    
    public TopologicalDFS() {
        graph = new HashMap<>();   
    }
    
    public void addVertex(int vertex) {
        graph.put(vertex, new LinkedList<Integer>());
    }
    
    public void addEdge(int source, int destination) {
        
        if( !graph.containsKey(source)) {
            addVertex(source);
        }
        
        if( !graph.containsKey(destination)) {
            addVertex(destination);
        }
        
        graph.get(source).add(destination); 
    }
    
    public List<Integer> getNeighbours(int node) {
        return graph.getOrDefault(node, new ArrayList<>());
    }
    
   
    
    private void dfsHelper(int node, Map<Integer,Boolean> visited, LinkedList<Integer> ordering ) {
        visited.put(node, true);
        List<Integer> neighbours = getNeighbours(node);
        for( int neighbour : neighbours ) {
            if( !visited.getOrDefault(neighbour,false) ){
                 dfsHelper(neighbour, visited, ordering);
            }
        }
         ordering.addFirst(node);
    }
    
    public void topologicalSort() {
        Map<Integer,Boolean> visited = new HashMap<>();
        LinkedList<Integer> ordering = new LinkedList<>();
        for( int node : graph.keySet()) {
            if( !visited.getOrDefault(node,false) ){
                dfsHelper(node, visited, ordering);
            }
        }
        
        for( int node : ordering ) {
             System.out.print(node + " ");
        }
    }
    
    
     public static void main(String[] args) {
        TopologicalDFS graph = new TopologicalDFS();
       
         graph.addEdge(0,1);
         graph.addEdge(1,2);
         graph.addEdge(1,3);
         graph.addEdge(2,4);
         graph.addEdge(3,4);
      
         
         System.out.println("Topological Sort : ");
         graph.topologicalSort();
        
    }
}

