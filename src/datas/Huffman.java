package datas;

import java.util.*;

public class Huffman {

    private static class Node {
        int frequency;
        char character;
        Node left, right;

        Node(int freq, char ch, Node l, Node r) {
            frequency = freq;
            character = ch;
            left = l;
            right = r;
        }
    }

    private static class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.frequency - b.frequency;
        }
    }

    public static Map<Character, Integer> buildCharacterFrequencyTable(String inputString) {
        Map<Character, Integer> table = new HashMap<>();
        for (char currentCharacter : inputString.toCharArray()) {
            table.put(currentCharacter, table.getOrDefault(currentCharacter, 0) + 1);
        }
        return table;
    }

    public static Node huffmanBuildTree(String inputString) {
        Map<Character, Integer> table = buildCharacterFrequencyTable(inputString);
        PriorityQueue<Node> nodes = new PriorityQueue<>(new NodeComparator());

        for (Map.Entry<Character, Integer> entry : table.entrySet()) {
            nodes.offer(new Node(entry.getValue(), entry.getKey(), null, null));
        }

        while (nodes.size() > 1) {
            Node left = nodes.poll();
            Node right = nodes.poll();
            Node parent = new Node(left.frequency + right.frequency, '\0', left, right);
            nodes.offer(parent);
        }

        return nodes.poll();
    }

    public static Map<Character, String> huffmanGetCodes(Node root) {
        if (root == null)
            return Collections.emptyMap();

        Map<Character, String> output = new HashMap<>();
        huffmanGetCodesHelper(root, "", output);
        return output;
    }

    private static void huffmanGetCodesHelper(Node node, String prefix, Map<Character, String> output) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                output.put(node.character, prefix);
            } else {
                huffmanGetCodesHelper(node.left, prefix + "0", output);
                huffmanGetCodesHelper(node.right, prefix + "1", output);
            }
        }
    }

    public static String huffmanCompress(String inputString) {
        Node root = huffmanBuildTree(inputString);
        Map<Character, String> codes = huffmanGetCodes(root);
        StringBuilder result = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            result.append(codes.get(c));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String inputString = "BANANAS";
        String compressed = huffmanCompress(inputString);
        System.out.println("Compressed Huffman Codes: " + compressed);
    }
}
