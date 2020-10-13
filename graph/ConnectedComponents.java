import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// No of connected components
public class ConnectedComponents {
    Map<Integer, List<Integer>> graph;
    
    public ConnectedComponents() {
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
    
   
    
    private void dfsHelper(int node, Map<Integer,Boolean> visited ) {
        System.out.print(node + " ");
        visited.put(node, true);
        List<Integer> neighbours = getNeighbours(node);
        for( int neighbour : neighbours ) {
            if( ! visited.getOrDefault(neighbour,false) ){
                 dfsHelper(neighbour,visited);
            }
        }
    }
    
    public void connectedComponents() {
        Map<Integer,Boolean> visited = new HashMap<>();
        int noOfConnectedComponents = 0;
        for( int node : graph.keySet()) {
            if( ! visited.getOrDefault(node,false) ){
                System.out.print("Connected components " + noOfConnectedComponents + " : ");
                dfsHelper(node,visited);
                noOfConnectedComponents++;
                System.out.println();
            }
        }
    }
    
    
     public static void main(String[] args) {
        ConnectedComponents graph = new ConnectedComponents();
       
         graph.addEdge(0,1);
         graph.addEdge(1,2);
         graph.addEdge(2,3);
         graph.addEdge(3,0);
         graph.addEdge(0,4);
         
         graph.addEdge(5,6);
         graph.addEdge(6,7);
         
         graph.addEdge(8,8);
         
         graph.connectedComponents();
        
    }
}

