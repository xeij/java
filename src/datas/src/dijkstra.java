package com.example;
import java.util.*;

public class Graph {
    private Map<Integer, Map<Integer, Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void Vertex(int vertex) {
        adjList.putIfAbsent(vertex, new HashMap<>());
    }

    public void Edge(int source, int destination, int weight) {
        adjList.get(source).put(destination, weight);
        adjList.get(destination).put(source, weight); 
    }

    public Map<Integer, Integer> dijkstraAlgo(int vert_Beginning) {
        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Integer> previous = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int vertex : adjList.keySet()) {
            dist.put(vertex, Integer.MAX_VALUE);
        }
        dist.put(vert_Beginning, 0);
        pq.add(new Node(vert_Beginning, 0));

        while (!pq.isEmpty()) {
            Node curr_Node = pq.poll();
            int curr_Vert = curr_Node.vertex;

            if (!nodes.contains(curr_Vert)) {
                nodes.add(curr_Vert);

                for (Map.Entry<Integer, Integer> neighbor_Entry : adjList.get(curr_Vert).entrySet()) {
                    int neighbor = neighbor_Entry.getKey();
                    int weight = neighbor_Entry.getValue();

                    if (!nodes.contains(neighbor)) {
                        int newDist = dist.get(curr_Vert) + weight;
                        if (newDist < dist.get(neighbor)) {
                            dist.put(neighbor, newDist);
                            previous.put(neighbor, curr_Vert);
                            pq.add(new Node(neighbor, newDist));
                        }
                    }
                }
            }
        }

        printDistanceWithPath(vert_Beginning, dist, previous);
        return previous;
    }

    private static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    private void printDistanceWithPath(int vert_Beginning, Map<Integer, Integer> dist, Map<Integer, Integer> previous) {
        if (vert_Beginning == 1) {
            printPath(1, 37, dist, previous);
        } else if (vert_Beginning == 14) {
            printPath(14, 23, dist, previous);
        }
    }

    private void printPath(int vert_Beginning, int vert_End, Map<Integer, Integer> dist, Map<Integer, Integer> previous) {
        List<Integer> path = new ArrayList<>();
        for (Integer at = vert_End; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        final String GREEN = "\u001B[32m";
        final String RESET = "\u001B[0m";

        System.out.println("The path from " + vert_Beginning + " to " + vert_End + " is : " + GREEN + path + RESET);
        System.out.println("The distance is : " + GREEN +  dist.get(vert_End) + RESET);
    }
}
