import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Cycle Detection in directed graph DFS
public class CycleDetectionDFS {
    Map<Integer, List<Integer>> graph;
    
    public CycleDetectionDFS() {
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
    
  public boolean cycleExists() {
        int nodes = graph.size();
        int[] visited = new int[nodes];
      
        
        for( int node = 0; node < nodes; node++ ) {
            if( visited[node] == 0 && cycleHelper(node, visited) ){
                return true;
            }
        }
        
        return false;
}

    private boolean cycleHelper(int node, int[] visited) {
        
        visited[node] = 1;
      
        
        for( int neighbour : getNeighbours(node) ) {
            if( visited[neighbour] == 1 ) {
                return true;
            }
            
            if( visited[neighbour] == 0 ) {
                boolean cycleExist = cycleHelper(neighbour, visited);
                if( cycleExist ) {
                    return true;
                }
            }
            
        }
        
       
        visited[node] = 2;

        return false;
    }
    
    
     public static void main(String[] args) {
        CycleDetectionDFS graph = new CycleDetectionDFS();
       
         // True
         // graph.addEdge(0,1);
         // graph.addEdge(1,2);
         // graph.addEdge(2,3);
         // graph.addEdge(3,4);
         // graph.addEdge(4,5);
         // graph.addEdge(5,6);
         // graph.addEdge(1,5);
         // graph.addEdge(4,2);
         
         // False
         graph.addEdge(0,1);
         graph.addEdge(0,2);
         graph.addEdge(2,3);
      
         
         System.out.println("Cycle Detection directed graph DFS: ");
         //System.out.println(graph.cycleExistsUsingPathStack());
         System.out.println(graph.cycleExists());
        
    }
}

