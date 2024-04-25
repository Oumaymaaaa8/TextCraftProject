package org.example.textcraft;



import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ShannonCoder {
    private  String inputText ;
  private   Node[] symbols ;

    public ShannonCoder(String inputText) {
        this.inputText = inputText;
        this.symbols = null ;
    }


    // Node class to store each symbol along with its probability and code
    static class Node {
        char sym; // symbol
        double pro; // probability
        StringBuilder code; // code
    }

    // Function to calculate Shannon code
    static void shannon(int l, int h, Node[] p) {
        if ((l + 1) == h || l == h || l > h) {
            if (l == h || l > h) return;
            p[h].code.append('0');
            p[l].code.append('1');
            return;
        } else {
            double pack1 = 0, pack2 = 0, diff1 = 0, diff2 = 0;
            int i, d, k = 0, j; // Initialize k here
            for (i = l; i <= h - 1; i++) pack1 += p[i].pro;
            pack2 += p[h].pro;
            diff1 = pack1 - pack2;
            if (diff1 < 0) diff1 = -diff1;
            j = 2;
            while (j != h - l + 1) {
                k = h - j;
                pack1 = pack2 = 0;
                for (i = l; i <= k; i++) pack1 += p[i].pro;
                for (i = h; i > k; i--) pack2 += p[i].pro;
                diff2 = pack1 - pack2;
                if (diff2 < 0) diff2 = -diff2;
                if (diff2 >= diff1) break;
                diff1 = diff2;
                j++;
            }
            k++;
            for (i = l; i <= k; i++) p[i].code.append('1');
            for (i = k + 1; i <= h; i++) p[i].code.append('0');
            shannon(l, k, p);
            shannon(k + 1, h, p);
        }
    }

    // Function to sort the symbols based on their probability
    static void sortByProbability(PriorityQueue<Node> pq, Node[] p) {
        int i = 0;
        while (!pq.isEmpty()) {
            p[i++] = pq.poll();
        }
    }


    // Function to display the symbols along with their probability and code
    static void display(Node[] p) {
        System.out.println("\nSymbol  Probability Code");
        for (Node node : p) {
            System.out.println(node.sym + "       " + node.pro + "       " + node.code);
        }
    }



     public  String ShannonCoder(){
         Map<Character, Integer> frequencyMap = new HashMap<>();
         int totalSymbols = 0;

         // Count frequencies of each symbol in the input text
         for (char c : inputText.toCharArray()) {
             if (frequencyMap.containsKey(c)) {
                 frequencyMap.put(c, frequencyMap.get(c) + 1);
             } else {
                 frequencyMap.put(c, 1);
             }
             totalSymbols++;
         }
         // Create nodes for each symbol
         PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.pro, a.pro));
         for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
             Node node = new Node();
             node.sym = entry.getKey();
             node.pro = (double) entry.getValue() / totalSymbols;
             node.code = new StringBuilder();
             pq.offer(node);
         }

         Node[] symbols = new Node[pq.size()];
         sortByProbability(pq, symbols);
         for (Node symbol : symbols) {
             symbol.code = new StringBuilder();
         }

         shannon(0, symbols.length - 1, symbols);
         display(symbols);

         return coder(inputText);
     }

    public static String getBinaryCode(char c , Node[] symbols) {
        for (Node symbol : symbols) {
            if (symbol.sym == c) {
                return symbol.code.toString();
            }
        }
        return ""; // Return empty string if character not found
    }

    public String coder(String inputText) {
        StringBuilder resultat = new StringBuilder();
      for(int i = 0; i < this.inputText.length() ; i++){
          String c =getBinaryCode(this.inputText.charAt(i), symbols);
          resultat.append(c);
          resultat.append(" ");

      }
      return resultat.toString() ;

    }
    public float tauxCompCodage(){
        String texteRes = coder(inputText);
        float taux = inputText.getBytes().length/ texteRes.length();
        return taux ;
    }

    public long longBinaire(){
        String texteRes = coder(inputText);
        return  texteRes.length();
    }

}
