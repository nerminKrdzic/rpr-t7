package ba.unsa.etf.rpr;

public class Grad {
    private String naziv = null;
    private int brojStanovnika = 0;
    private Double[] temperature = new Double[1000];

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public Double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(Double[] temperature) {
        this.temperature = temperature;
    }
}
