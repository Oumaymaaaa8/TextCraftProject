package org.example.textcraft;

import java.util.*;

public class Huffman {
    private String text;
    private HuffmanNode root;
  private   Huffman huffmanClient ;
    public Huffman(String text) {
        this.text = text;
    }

    // Define the HuffmanNode class
    static class HuffmanNode {
        char data;
        int frequency;
        HuffmanNode left, right;

        HuffmanNode(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            left = right = null;
        }
    }

    // Comparator for HuffmanNode
    static class MyComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.frequency - y.frequency;
        }
    }

    // Function to build Huffman tree and return root
    private HuffmanNode buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(freqMap.size(), new MyComparator());

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode f = new HuffmanNode('$', left.frequency + right.frequency);
            f.left = left;
            f.right = right;
            root = f;
            pq.add(f);
        }
        return pq.poll();
    }

    // Function to generate Huffman codes and store them in a map
    private void generateHuffmanCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.data, code);
        }

        generateHuffmanCodes(root.left, code + "0", huffmanCodes);
        generateHuffmanCodes(root.right, code + "1", huffmanCodes);
    }

    // Function to encode text using Huffman codes
    public String encode() {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        root = buildHuffmanTree(freqMap);

        Map<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodes);

        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(huffmanCodes.get(c));
        }
        return encodedText.toString();
    }

    // Function to decode text using Huffman codes
    public String decode(String encodedText) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode current = root;

        for (int i = 0; i < encodedText.length(); i++) {
            char bit = encodedText.charAt(i);
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.left == null && current.right == null) {
                decodedText.append(current.data);
                current = root;
            }
        }
        return decodedText.toString();
    }
    public float tauxCompCodage(){
        String texteRes = huffmanClient.encode();
        float taux = (float) text.getBytes().length / texteRes.length();
        return taux ;
    }

    public long longBinaire(){
        huffmanClient =new Huffman(text);
        String texteRes = huffmanClient.encode();
        return  texteRes.length();
    }
    public float tauxCompDecodage(){
        huffmanClient =new Huffman(text);
        String texteRes = huffmanClient.decode(huffmanClient.encode());
        float taux = (float) huffmanClient.encode().getBytes().length / texteRes.length();
        return taux ;
    }

    public long longBinaireDecodage(){
        huffmanClient =new Huffman(text);
        String texteRes = huffmanClient.decode(huffmanClient.encode()); ;
        return  texteRes.length();
    }

}


