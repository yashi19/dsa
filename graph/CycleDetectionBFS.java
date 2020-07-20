import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Undirected graph is a tree or not BFS
public class CycleDetectionBFS {
    Map<Integer, List<Integer>> graph;
    
    public CycleDetectionBFS() {
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
    
    
    
    public boolean cycleExists() {
        int nodes = graph.size();
        int[] visited = new int[nodes];
        Queue<Integer> queue = new LinkedList<>();
        int source = 0;
        queue.add(source);
        visited[source] = 1;
        
        while( !queue.isEmpty() ) {
           int node = queue.remove();
            
            for( int neighbour : getNeighbours(node) ) {
                
                if( visited[neighbour] == 1 ){
                    return true;
                }
                if( visited[neighbour] == 0 ) {
                    queue.add(neighbour);
                    visited[neighbour] = 1;
                } 
            }
            
            visited[node] = 2;
        }
        return false;
    }
    
     public boolean cycleExistsUsingParentArray() {
        int nodes = graph.size();
        int[] visited = new int[nodes];
        int[] parent = new int[nodes];
        for( int i = 0; i < nodes; i++) {
            parent[i] = i;
        } 
        
        Queue<Integer> queue = new LinkedList<>();
        int source = 0;
        queue.add(source);
        visited[source] = 1;
        
        while( !queue.isEmpty() ) {
           int node = queue.remove();
            
            for( int neighbour : getNeighbours(node) ) {
                
                if( visited[neighbour] == 1 && parent[node] != neighbour ){
                    return true;
                }
                if( visited[neighbour] == 0 ) {
                    queue.add(neighbour);
                    visited[neighbour] = 1;
                    parent[neighbour] = node;
                } 
            }
        }
        return false;
    }
    
    
     public static void main(String[] args) {
        CycleDetectionBFS graph = new CycleDetectionBFS();
       
         // True
         // graph.addEdge(0,2);
         // graph.addEdge(1,2);
         // graph.addEdge(2,5);
         // graph.addEdge(2,3);
         // graph.addEdge(3,5);
         // graph.addEdge(1,4);
         // graph.addEdge(4,5);
         
         
         graph.addEdge(0,1);
         graph.addEdge(1,2);
         graph.addEdge(2,3);
         // graph.addEdge(3,1);
      
         
         System.out.println("Cycle Detection in undirected graph : ");
         System.out.println(graph.cycleExistsUsingParentArray());
         //System.out.println(graph.cycleExists());
        
    }
}

