package org.example.textcraft;

public class TextDecoder {
private static String input;
private static Node root ;

    public TextDecoder(String input) {
        this.input = input;
        this.root=null;
    }

    // Node class to represent a node in the binary search tree
    static class Node {
        char sym; // symbol
        StringBuilder code; // code
        Node left; // left child
        Node right; // right child

        Node(char sym, StringBuilder code) {
            this.sym = sym;
            this.code = code;
            this.left = null;
            this.right = null;
        }
    }

    // Function to build the binary search tree using Shannon codes
    static Node buildTree(Node root, char sym, StringBuilder code) {
        if (root == null) {
            root = new Node(sym, code);
        } else if (code.charAt(0) == '0') {
            root.left = buildTree(root.left, sym, new StringBuilder(code.substring(1)));
        } else if (code.charAt(0) == '1') {
            root.right = buildTree(root.right, sym, new StringBuilder(code.substring(1)));
        }
        return root;
    }

    // Function to decode a binary string back to its corresponding character
    static char decodeBinary() {
        Node current = root;  // Line 46
        for (char bit : input.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else if (bit == '1') {
                current = current.right;
            }
            if (current.left == null && current.right == null) {
                return current.sym;
            }
        }
        return '\0'; // Return null character if binary code not found
    }


  /*  public float tauxCompCodage(){
        String texteRes = de(inputText);
        float taux = inputText.getBytes().length/ texteRes.length();
        return taux ;
    }

    public long longBinaire(){
        String texteRes = coder(inputText);
        return  texteRes.length();
    }*/


    public static void main(String[] args) {
        // Example Shannon codes
        String[] symbols = {"A", "B", "C", "D", "E"};
        String[] codes = {"00", "01", "10", "110", "111"};

        // Build the binary search tree

        for (int i = 0; i < symbols.length; i++) {
            root = buildTree(root, symbols[i].charAt(0), new StringBuilder(codes[i]));
        }

        // Example binary code
        String binaryCode = "110";

        // Create a TextDecoder instance with the binary code
        TextDecoder textDecoder = new TextDecoder(binaryCode);

        // Set the root node for the TextDecoder instance
        textDecoder.root = root;

        // Decode the binary string
        char decodedChar = textDecoder.decodeBinary();
        System.out.println("Decoded character of binary code '" + binaryCode + "' is: " + decodedChar);
    }

}
