package datas.src;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;

    HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}

public class HuffmanCoding {
    private static Map<Character, String> huffmanCodeMap = new HashMap<>();
    private static HuffmanNode root;

    private static void buildHuffmanTree(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
            pq.add(parent);
        }

        root = pq.poll();
    }

    private static void generateHuffmanCodes(HuffmanNode node, String code) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            huffmanCodeMap.put(node.character, code);
        }

        generateHuffmanCodes(node.left, code + "0");
        generateHuffmanCodes(node.right, code + "1");
    }

    public static String encode(String text) {
        buildHuffmanTree(text);
        generateHuffmanCodes(root, "");

        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(huffmanCodeMap.get(ch));
        }
        return encodedText.toString();
    }

    public static String decode(String encodedText) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode currentNode = root;
        for (int i = 0; i < encodedText.length(); i++) {
            char bit = encodedText.charAt(i);
            if (bit == '0') {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }

            if (currentNode.left == null && currentNode.right == null) {
                decodedText.append(currentNode.character);
                currentNode = root;
            }
        }
        return decodedText.toString();
    }

    public static void main(String[] args) {
        String text = "huffman";
        System.out.println("Original " + text);

        String encodedText = encode(text);
        System.out.println("Encoded: " + encodedText);

        String decodedText = decode(encodedText);
        System.out.println("Decoded: " + decodedText);
    }
}
