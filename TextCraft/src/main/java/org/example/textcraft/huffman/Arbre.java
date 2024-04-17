package org.example.textcraft.huffman;

class Arbre {
    private  Integer val ;
    private  Noeud root ;
    public Arbre() {
        this.root = null;
        this.val = 0 ;

    }

    public TreeNode createNode(int val) {
        return new TreeNode(val);
    }


}