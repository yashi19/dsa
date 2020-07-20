import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Single source shortest path with BFS
public class SSSP {
    Map<Integer, List<Integer>> graph;
    
    public SSSP() {
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
        graph.get(destination).add(source); 
    }
    
    public List<Integer> getNeighbours(int node) {
        return graph.getOrDefault(node, new ArrayList<>());
    }
    
    public void shortestPath(int source) {
        Map<Integer,Integer> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        visited.put(source, 0);
        
        while( !queue.isEmpty() ) {
            int node = queue.poll();
            System.out.println( source + " -> " + node + " = " + visited.get(node));
            
            List<Integer> neighbours = getNeighbours(node);
            for( int neighbour : neighbours ) {
                if( visited.getOrDefault(neighbour,Integer.MAX_VALUE) ==  Integer.MAX_VALUE ) {
                    queue.add(neighbour);
                    visited.put(neighbour, visited.get(node) + 1);
                }
            }
        }
    }
    

    
   
    
     public static void main(String[] args) {
        SSSP graph = new SSSP();
       
         graph.addEdge(0,1);
         graph.addEdge(1,2);
         graph.addEdge(2,3);
         graph.addEdge(3,4);
         graph.addEdge(4,5);
         graph.addEdge(0,3);
         
         
         System.out.println("BFS: ");
         graph.shortestPath(0);
        
    }
}

