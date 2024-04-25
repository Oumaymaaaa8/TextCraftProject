package org.example.textcraft;

import java.util.*;

public class Huffman {
    private  String text;
    private HuffmanNode root;

    public Huffman(String text) {
        this.text = text;
    }

    public Long longBinaire() {
        return 2L;
    }

    public Float tauxCompCodage() {
        return 2.5F;
    }

    // Define the HuffmanNode class
    static class HuffmanNode {
        int data;
        char c;
        HuffmanNode left;
        HuffmanNode right;
    }

    // Comparator for HuffmanNode
    static class MyComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.data - y.data;
        }
    }

    // Function to print Huffman codes for characters
    public  void printCodes(HuffmanNode root, String s, Map<Character, String> huffmanCodes) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            huffmanCodes.put(root.c, s);
            return;
        }
        if (root.left != null)
            printCodes(root.left, s + "0", huffmanCodes);
        if (root.right != null)
            printCodes(root.right, s + "1", huffmanCodes);
    }

    public  Map<Character, String> huffmanCoder(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(charFreq.size(), new MyComparator());


        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = entry.getKey();
            hn.data = entry.getValue();
            hn.left = null;
            hn.right = null;
            pq.add(hn);
        }

        // Build Huffman tree
        while (pq.size() > 1) {
            HuffmanNode x = pq.poll();
            HuffmanNode y = pq.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            pq.add(f);
        }

        // Generate Huffman codes
        Map<Character, String> huffmanCodes = new HashMap<>();
        if (!pq.isEmpty())
            printCodes(pq.peek(), "", huffmanCodes);
        return huffmanCodes;
    }

   /* public static String huffmanDecoder(String encodedText, Map<Character, String> huffmanCodes) {
        StringBuilder decodedText = new StringBuilder();
        StringBuilder codeBuilder = new StringBuilder();

        for (char bit : encodedText.toCharArray()) {
            codeBuilder.append(bit);
            for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
                if (entry.getValue().contentEquals(codeBuilder)) {
                    decodedText.append(entry.getKey());
                    codeBuilder.setLength(0);
                    break;
                }
            }
        }
        return decodedText.toString();
    }*/

    public  String coder() {
        StringBuilder res = new StringBuilder();
        Map<Character, String> huffmanCodes = huffmanCoder(text );
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
          res.append(entry.getValue());
        }
        return res.toString();
    }

    }
