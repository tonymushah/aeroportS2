package fligth;
import java.lang.Math;
import control.*;
//import fligth.*;
import infrastructure.*;
import proce_gen.*;
import utilities.*;

public class Aterrissage {
    double vitesse;
    Avion plane;
    Piste pista;
    double duree;
    Heure arriv_piste;
    double dist_frein;
    Physics cqlc;
    public void setArriv_piste(Heure arriv_piste) {
        this.arriv_piste = arriv_piste;
    }
    public void setDist_frein(double dist_frein) {
        this.dist_frein = dist_frein;
    }
    public void setDuree(double duree) {
        this.duree = duree;
    }
    public void setPista(Piste pista) {
        this.pista = pista;
    }
    public void setPlane(Avion plane) {
        this.plane = plane;
    }
    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }
    public Heure getArriv_piste() {
        return arriv_piste;
    }
    public Physics getCqlc() {
        return cqlc;
    }
    public double getDist_frein() {
        return dist_frein;
    }public double getDuree() {
        return duree;
    }
    public Piste getPista() {
        return pista;
    }
    public Avion getPlane() {
        return plane;
    }
    public double getVitesse() {
        return vitesse;
    }
    void calc_duration(){
        /*if(this.plane != void){
            this.duree = ((2 * this.plane.dist_frein) / this.vitesse);
        }*/
    }
    public Aterrissage(double vitesse, Avion plane, Piste piste){
        this.cqlc = new Physics();
        this.vitesse = vitesse;
        this.plane = plane;
        this.pista = piste;
    }
    public Aterrissage(double vitesse, Avion plane){
        this.cqlc = new Physics();
        this.vitesse = vitesse;
        this.plane = plane;
    }
    public Aterrissage(double vitesse){
        this.cqlc = new Physics();
        this.vitesse = vitesse;
    }
    public Aterrissage(Avion plane, Piste piste){
        this.cqlc = new Physics();
        this.plane = plane;
        this.pista = piste;
    }
    public Aterrissage(){
        this.cqlc = new Physics();
    }
    public void simple_insert(Avion plane, Piste pista){
        this.plane = plane;
        this.pista = pista;
    }
    public void insert(double vitesse, Avion plane, Piste pista){
        this.vitesse = vitesse;
        this.plane = plane;
        this.pista = pista;
        this.dist_frein = (Math.pow(cqlc.convert_kmh_ms(this.vitesse), 2) * this.plane.getPoids()) / (2 * (this.plane.getC_decel() - this.pista.getTompony().getMeteo().get_humiditen(this.arriv_piste.getHeure())));
    }
    public void insert_h(Heure hora){
        this.arriv_piste = hora;
    }
    public void insert_speed(double speed){
        this.vitesse = speed;
        //this.duree = ((2 * this.plane.dist_frein) / this.vitesse);
    }
    public Aterrissage insert_get(double vitesse, Avion plane, Piste pista){
        Aterrissage get = new Aterrissage();
        this.vitesse = vitesse;
        this.plane = plane;
        this.pista = pista;
        this.duree = (this.vitesse * this.plane.getPoids()) / (this.plane.getC_decel() - this.pista.getTompony().getMeteo().get_humiditen(this.arriv_piste.getHeure()));
        get.vitesse = this.vitesse;
        get.plane = this.plane;
        get.pista = this.pista ;
        get.duree = this.duree;
        return get;
    }
    public double get_vitesse(){
        return this.vitesse;
    }
    public Piste get_pista(){
        return this.pista;
    }
    public double get_duree(){
        return this.duree;
    }
    public Avion get_Avion(){
        return this.plane;
    }
    public double get_price(){
        return ((this.pista.getCouts() * this.plane.getPoids()) / this.plane.getTompony().getDevis().getTaux());
    }
    public void show_detail(){
        System.out.println("-----------------------");
        System.out.println("Vitesse: " + this.vitesse);
        System.out.println("Cout: " + this.get_price());
        System.out.println("-----------------------");
    }
    public void show_detai(){
        System.out.println("Vitesse: " + this.vitesse);
        //System.out.println("Cout: " + this.get_price());
    }
}
