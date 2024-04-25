package org.example.textcraft;

public class RLEClient {
    private  String text ;

    public RLEClient(String text) {
        this.text = text;
    }

    public  String LREcoder(){
        StringBuilder test = new StringBuilder();
        int count = 1;
        char[] chars = text.toCharArray();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            while( i+1<chars.length && c == chars[i+1]){
                count++;
                i++;

            }

            test.append(count).append(c);
            count = 1;
        }

        return test.toString();

    }

    public  String deCompression(){
        StringBuilder test =new StringBuilder();
        char[] chars = text.toCharArray();
        int n = chars.length;
        for(int i = 0;i<n;i=i+2){

            char d =chars[i];
            int a = Character.getNumericValue(d);
            char b = chars[i+1];

            for(int j=0;j<a;j++){
                test.append(b);
            }
        }
        return test.toString();

    }
    public float tauxCompCodage(){
        String texteRes = LREcoder();
        float taux = text.getBytes().length/ texteRes.length();
        return taux;
    }
    public float tauxCompDecodage(){
        String texteRes = deCompression();
        float taux = text.getBytes().length/ texteRes.length();
        return taux;
    }


    public Long longBinaire() {
        return 2L;
    }
}
