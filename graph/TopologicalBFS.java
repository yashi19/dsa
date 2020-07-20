import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Topological Sort using BFS
public class TopologicalBFS {
    Map<Integer, List<Integer>> graph;
    
    public TopologicalBFS() {
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
    
    private int[] setInDegree(int nodes){
        int[] indegrees = new int[nodes];
        
        for( int node : graph.keySet() ) {
            for( int neighbour :  getNeighbours(node) ) {
                indegrees[neighbour]++;
            }
        }
        return indegrees;
    }
    
    public void topologicalSortBFS() {
        int nodes = graph.size();
        int[] indegrees = setInDegree(nodes);
        Queue<Integer> queue = new LinkedList<>();
        
        for( int node = 0; node < nodes; node++ ) {
            if( indegrees[node] == 0 ) {
                queue.add(node);
            } 
        }
        
        while( !queue.isEmpty() ) {
           int node = queue.remove();
           System.out.print(node + " ");
            
            for( int neighbour : getNeighbours(node) ) {
                indegrees[neighbour]--;
                if( indegrees[neighbour] == 0 ) {
                    queue.add(neighbour);
                } 
            }
        }
     
    }
    
    
     public static void main(String[] args) {
        TopologicalBFS graph = new TopologicalBFS();
       
         graph.addEdge(0,2);
         graph.addEdge(1,2);
         graph.addEdge(2,5);
         graph.addEdge(2,3);
         graph.addEdge(3,5);
         graph.addEdge(1,4);
         graph.addEdge(4,5);
         
      
         
         System.out.println("Topological Sort : ");
         graph.topologicalSortBFS();
        
    }
}

