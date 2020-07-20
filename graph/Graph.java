import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

// BFS and DFS

public class Graph {
    
    Map<Integer, List<Integer>> graph;
    
    public Graph() {
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
    
    public void bfs(int source) {
        Map<Integer,Boolean> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        visited.put(source, true);
        
        while( !queue.isEmpty() ) {
            int node = queue.poll();
            System.out.print( node + " ");
            
            List<Integer> neighbours = getNeighbours(node);
            for( int neighbour : neighbours ) {
                if(! visited.getOrDefault(neighbour,false)) {
                    queue.add(neighbour);
                    visited.put(neighbour, true);
                }
            }
        }
    }
    
     public void dfs(int source) {
        Map<Integer,Boolean> visited = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        stack.push(source);
        visited.put(source, true);
        
        while( !stack.isEmpty() ) {
            int node = stack.pop();
            System.out.print( node + " ");
            
            List<Integer> neighbours = getNeighbours(node);
            for( int neighbour : neighbours ) {
                if(! visited.getOrDefault(neighbour,false)) {
                    stack.push(neighbour);
                    visited.put(neighbour, true);
                }
            }
        }
    }
    
    private void dfsHelper(int node, Map<Integer,Boolean> visited ) {
        System.out.print(node + " ");
        visited.put(node, true);
        List<Integer> neighbours = getNeighbours(node);
        for( int neighbour : neighbours ) {
            if( ! visited.get(neighbour) )
                dfsHelper(neighbour,visited);
        }
        
    }
    
    public void dfsUsingRecursion(int source) {
        Map<Integer,Boolean> visited = new HashMap<>();
        for( int node : graph.keySet()) {
            visited.put(node,false);
        }
        dfsHelper(source,visited);
    }
    
     public static void main(String[] args) {
        Graph graph = new Graph();
       
         graph.addEdge(0,1);
         graph.addEdge(1,2);
         graph.addEdge(2,3);
         graph.addEdge(3,4);
         graph.addEdge(4,5);
         graph.addEdge(0,3);
         
         
         System.out.println("BFS: ");
         graph.bfs(0);
         System.out.println();
         System.out.println("DFS: ");
         graph.dfs(0);
         System.out.println();
         System.out.println("DFS using recursion : ");
         graph.dfsUsingRecursion(0);
    }
}

