package org.example.textcraft.huffman;

public class TreeNode {

    Integer val ;
    TreeNode gauche;
    TreeNode droit;

    public TreeNode(int val) {

    }
    public void setgauche(TreeNode gauche) {
        this.gauche = gauche;
    }

    public void setdroit(TreeNode droit) {
        this.droit = droit;
    }
}
