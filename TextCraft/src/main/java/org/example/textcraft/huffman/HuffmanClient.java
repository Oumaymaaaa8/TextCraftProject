package org.example.textcraft.huffman;


import java.util.Map;

public class HuffmanClient {

    private String input;

    private Arbre abr;
    private Map<Character, Integer> hufmanAbr;

    HuffmanClient(Arbre abr, String input, Map<Character, Integer> hufmanAbr) {
        this.abr = abr;
        this.hufmanAbr = hufmanAbr;
        this.input = input;
    }

    public Map<Character, Integer> genererMap(String texte) {
      Map<Character, Integer> map = Map.of(); 
        for (int i = 0; i < texte.length(); i++) {
            if (map.containsKey(texte.charAt(i))) {
                map.put(texte.charAt(i), 1);
            } else {
                increment(texte.charAt(i), map);
            }
        }
        return  map ;
    }
    public void increment(char element, Map<Character, Integer> map) {
     Integer oldOcc = map.get(element) +1 ;
     map.put(element , oldOcc  );
    }


    public  Arbre genererArbre (Map<Character, Integer> map){
        Map.Entry<Character, Integer> min1 = null;
        Map.Entry<Character, Integer> min2 = null;
        Integer x;
        Arbre a = new Arbre() ;

        x = min1.getValue() + min2.getValue() ;
        TreeNode node = a.createNode(x) ;
        node.setdroit(min1);
        node.setgauche(min2);

      while (map.size()>=1){
          min1 = getMin(map);
          map.remove(min1.getKey());
          min2 = getMin(map);
          map.remove(min2.getKey());

      }

      return  abr ;
    }

    public static Map.Entry<Character, Integer> getMin(Map<Character, Integer> map) {
        return null ;
    }
}
