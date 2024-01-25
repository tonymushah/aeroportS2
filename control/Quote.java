package control;
import fligth.*;
import infrastructure.*;
import proce_gen.*;
import utilities.*;

public class Quote {
    Vol flight;
    Piste approach;
    double duree;
    Heure arivee_final;
    public Piste getApproach() {
        return approach;
    }
    public Heure getArivee_final() {
        return arivee_final;
    }
    public double getDuree() {
        return duree;
    }
    public Vol getFlight() {
        return flight;
    }
    public void setApproach(Piste approach) {
        this.approach = approach;
    }
    public void setArivee_final(Heure arivee_final) {
        this.arivee_final = arivee_final;
    }
    public void setDuree(double duree) {
        this.duree = duree;
    }
    public void setFlight(Vol flight) {
        this.flight = flight;
    }
    void insert(Vol flight, Piste approach){
        this.flight = flight;
        this.approach = approach;
        this.duree = this.flight.getDebarquem() + this.flight.getAterii().getDuree();
    }
    Quote(Piste aPiste, Vol fVol){
        this.flight = fVol;
        this.approach = aPiste;
        this.duree = this.flight.getDebarquem() + this.flight.getAterii().getDuree();
    }
    Quote(Piste aPiste, Vol fVol, int op){
        this.flight = fVol;
        this.approach = aPiste;
    }
    Quote(){

    }
    void show_quotes(){
        System.out.println("------------------");
        System.out.println(this.flight.getPlane().getNom());
        System.out.println("Piste: " + this.approach.getNom());
        System.out.println("Prix = " + this.flight.getAterii().get_price() + " Ariary");
        System.out.println("Heure d'arrivee sur la piste : " );
        this.flight.getAterii().getArriv_piste().show_detail();
        System.out.println("------------------");
    }
}
