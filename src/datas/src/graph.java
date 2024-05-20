package datas.src;
import java.util.*;
import java.util.Stack;

public class graph {
    private Map<Integer, List<Integer>> adjacentList;

    public graph() {
        adjacentList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacentList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        adjacentList.putIfAbsent(source, new ArrayList<>());
        adjacentList.putIfAbsent(destination, new ArrayList<>());
        adjacentList.get(source).add(destination);
    }

    public List<Integer> depthFirstTraversal(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                result.add(vertex);
                for (int neighbor : adjacentList.get(vertex)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return result;
    }

    public List<Integer> breadthFirstTraversal(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                result.add(vertex);
                for (int neighbor : adjacentList.get(vertex)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        graph graph = new graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("Depth first traversal from vertex 1: " + graph.depthFirstTraversal(1));
        System.out.println("Breadth first traversal from vertex 1: " + graph.breadthFirstTraversal(1));
    }
}
