package org.example.textcraft;

public class Result {

    private String result;
    private  Long longueurBinaire ;
    private  Float tauxComp;

    public Result(String result, Float tauxComp, Long longueurBinaire) {
        this.result = result;
        this.tauxComp = tauxComp;
        this.longueurBinaire = longueurBinaire;
    }

    public Result() {

    }

    public String getResult() {
        return result;
    }

    public Float getTauxComp() {
        return tauxComp;
    }

    public Long getLongueurBinaire() {
        return longueurBinaire;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setTauxComp(Float tauxComp) {
        this.tauxComp = tauxComp;
    }

    public void setLongueurBinaire(Long longueurBinaire) {
        this.longueurBinaire = longueurBinaire;
    }
}
