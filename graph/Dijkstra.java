import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import javafx.util.Pair;


// You need to add javafx base jar in your dependencies
//Dijkstra's SSSP for weighted graph
public class Dijkstra {
    Map<Integer, List<Pair<Integer, Integer>>> graph;
    
    public Dijkstra() {
        graph = new HashMap<>();   
    }
    
    public void addVertex(int vertex) {
        graph.put(vertex, new LinkedList<Pair<Integer, Integer>>());
    }
    
    public void addEdge(int source, int destination, int distance) {
        
        if( !graph.containsKey(source)) {
            addVertex(source);
        }
        
        if( !graph.containsKey(destination)) {
            addVertex(destination);
        }
        
        graph.get(source).add(new Pair(destination,distance));
        graph.get(destination).add(new Pair(source,distance)); 
    }
    

    
        
    public List<Pair<Integer, Integer>> getNeighbours(int node) {
        return graph.getOrDefault(node, new ArrayList<>());
    }
    

    public int[] dijkstra(int source) {
        int nodes = graph.size();
        int[] dist = new int[nodes];
        boolean[] settled = new boolean[nodes];
        
        // Pair<Node, Distance>
        PriorityQueue<Pair<Integer, Integer>> set = new PriorityQueue<>((n1, n2) -> n1.getValue() - n2.getValue());
        
        for( int i = 0; i < nodes; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
       
        set.add(new Pair(source, dist[source]));
        dist[source] = 0;
       
        
        while( !set.isEmpty() ) {
            // Extract Node with Min distance
            Pair<Integer, Integer> nodePair = set.remove();
            int node = nodePair.getKey();
            int nodeDistance = nodePair.getValue();
            settled[node] = true;
            
            for( Pair<Integer, Integer> nodeDistacePair : getNeighbours(node) ) {
                int distance = nodeDistacePair.getValue();
                int neighbour = nodeDistacePair.getKey();
                if( !settled[neighbour] && dist[neighbour] > dist[node] + distance ) {
                    dist[neighbour] = dist[node] + distance;
                    set.add(new Pair(neighbour, dist[neighbour]));
                }
            }
            
        } 
        
        return dist;
    }

    
    
     public static void main(String[] args) {
        Dijkstra graph = new Dijkstra();
       
         // graph.addEdge(0,1,4);
         // graph.addEdge(1,2,2);
         // graph.addEdge(2,3,5);
         // graph.addEdge(3,4,3);
         // graph.addEdge(4,5,4);
         // graph.addEdge(5,6,9);
         // graph.addEdge(1,5,2);
         // graph.addEdge(4,2,4);
         graph.addEdge(0,1,4);
         graph.addEdge(0,2,1);
         graph.addEdge(2,1,1);
        
         
         System.out.println("Dijkstra's SSSP : ");
         int[] dist = graph.dijkstra(0);
         
         for( int node = 0 ; node < dist.length; node++ ) {
             System.out.println("Node " + node + " is located at distance: " + dist[node]  );
         }
        
    }
}

