package fligth;
import control.*;
import infrastructure.*;
import proce_gen.*;
import utilities.*;

public class Vol {
    double duree_deVol;
    double duree_Volrest;
    Avion plane;
    Aproach aproach;
    Heure arrivee_asa;
    double debarquem;
    Aterrissage aterii;
    Piste_possibilty possibilty;
    public void setArrivee_asa(Heure arrivee_asa) {
        this.arrivee_asa = arrivee_asa;
    }
    public void setAterii(Aterrissage aterii) {
        this.aterii = aterii;
    }
    public void setDebarquem(double debarquem) {
        this.debarquem = debarquem;
    }
    public void setDuree_Volrest(double duree_Volrest) {
        this.duree_Volrest = duree_Volrest;
    }
    public void setDuree_deVol(double duree_deVol) {
        this.duree_deVol = duree_deVol;
    }
    public void setPlane(Avion plane) {
        this.plane = plane;
    }
    public void setPossibilty(Piste_possibilty possibilty) {
        this.possibilty = possibilty;
    }
    public Heure getArrivee_asa() {
        return arrivee_asa;
    }
    public Aterrissage getAterii() {
        return aterii;
    }
    public double getDebarquem() {
        return debarquem;
    }
    public double getDuree_Volrest() {
        return duree_Volrest;
    }
    public double getDuree_deVol() {
        return duree_deVol;
    }
    public Avion getPlane() {
        return plane;
    }
    public Piste_possibilty getPossibilty() {
        return possibilty;
    }
    public Aproach getAproach() {
        return aproach;
    }
    public void setAproach(Aproach aproach) {
        this.aproach = aproach;
    }
    public Vol(){

    }
    public Vol(double duree_deVol_bP, double debarquem, Avion planeAvion, Aproach aproach){
        this.setAproach(aproach);
        this.setAterii(new Aterrissage(aproach.getVitesse0x()));
        this.aterii.setVitesse(this.aproach.vitesse0 * Math.sin(this.aproach.angle));
        this.debarquem = debarquem;
        this.plane = planeAvion;
        this.duree_deVol = duree_deVol_bP;
        this.duree_Volrest = this.plane.getDuree_maxVol() - this.duree_Volrest;
    }
    public Vol(double duree_deVol_bP, double debarquem, Avion planeAvion, Heure ari, Aterrissage aterrissage, Aproach aproach){
        setAproach(aproach);
        this.setAterii(new Aterrissage(aproach.getVitesse0x()));
        this.aterii.setVitesse(this.aproach.vitesse0 * Math.sin(this.aproach.angle));
        this.aterii = aterrissage;
        this.debarquem = debarquem;
        this.arrivee_asa = ari;
        this.plane = planeAvion;
        this.duree_deVol = duree_deVol_bP;
        this.duree_Volrest = this.plane.getDuree_maxVol() - this.duree_Volrest;
    }
    public void simple_insert(double duree_deVol_bP, double debarquem, Avion planeAvion){
        this.debarquem = debarquem;
        this.plane = planeAvion;
        this.duree_deVol = duree_deVol_bP;
        this.duree_Volrest = this.plane.getDuree_maxVol() - this.duree_Volrest;
    }
    public void insert(double duree_deVol_bP, Heure arr_asa, double debarquem, Avion planeAvion, Aterrissage atteri){
        this.arrivee_asa = arr_asa;
        this.debarquem = debarquem;
        this.plane = planeAvion;
        this.duree_deVol = duree_deVol_bP;
        this.duree_Volrest = this.plane.getDuree_maxVol() - this.duree_Volrest;
        this.aterii = atteri;
    }
    public void show_detail(){
        this.plane.show();
        System.out.println("Duree du vol: " + this.duree_deVol);
        System.out.println("Duree de vol restant: " + this.duree_Volrest);
        System.out.println("Duree du debarquement: " + this.debarquem);
        this.aterii.show_detail();   
        System.out.println("---------------------------------");
    }
    public void show_detai(){
        System.out.println();
        this.plane.show();
        System.out.println("Duree du vol: " + this.duree_deVol);
        System.out.println("Duree de vol restant: " + this.duree_Volrest);
        System.out.println("Duree du debarquement: " + this.debarquem);
        System.out.println("Heure d'arrivée : ");
        this.arrivee_asa.show_detail();
        this.aterii.show_detai();   
        System.out.println("---------------------------------");
    }
}