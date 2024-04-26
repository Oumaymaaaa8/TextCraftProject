package org.example.textcraft;

public class Result {

    private String text;
    private  Long longueurBinaire ;
    private  Float tauxComp;
    private String  algorithm ;

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Result(String result, Float tauxComp, Long longueurBinaire) {
        this.text = result;
        this.tauxComp = tauxComp;
        this.longueurBinaire = longueurBinaire;
    }

    public Result() {

    }

    public String getText() {
        return text;
    }

    public Float getTauxComp() {
        return tauxComp;
    }

    public Long getLongueurBinaire() {
        return longueurBinaire;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTauxComp(Float tauxComp) {
        this.tauxComp = tauxComp;
    }

    public void setLongueurBinaire(Long longueurBinaire) {
        this.longueurBinaire = longueurBinaire;
    }

    public String getAlgorithm() {
        return algorithm;
    }
}
