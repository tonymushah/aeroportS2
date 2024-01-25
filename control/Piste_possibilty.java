package control;
import java.lang.Math;
import fligth.*;
import infrastructure.*;
import proce_gen.*;
import utilities.*;

public class Piste_possibilty {
    Piste[] all;
    Piste[] possible;
    Piste[] impossible;
    double[] req_speed;
    Vol fVol;
    Gestionnaire lib1;
    Physics lPhysics;
    public void setAll(Piste[] all) {
        this.all = all;
    }
    public void setImpossible(Piste[] impossible) {
        this.impossible = impossible;
    }
    public void setLib1(Gestionnaire lib1) {
        this.lib1 = lib1;
    }
    public void setPossible(Piste[] possible) {
        this.possible = possible;
    }
    public void setReq_speed(double[] req_speed) {
        this.req_speed = req_speed;
    }
    public void setfVol(Vol fVol) {
        this.fVol = fVol;
    }
    public void setlPhysics(Physics lPhysics) {
        this.lPhysics = lPhysics;
    }
    public Piste[] getAll() {
        return this.all;
    }
    public Vol getfVol() {
        return this.fVol;
    }
    public Piste[] getImpossible() {
        return this.impossible;
    }
    public double[] getReq_speed() {
        return this.req_speed;
    }
    public Gestionnaire getLib1() {
        return this.lib1;
    }
    public Piste[] getPossible() {
        return this.possible;
    }
    public Physics getlPhysics() {
        return lPhysics;
    }
    public int get_nb_possible(){
        int nb = 0;
        for(int op = 0; op < this.all.length; op++){
            if(this.lib1.Vol_condtionPrix(this.fVol, all[op]) == 1){
                nb = nb + 1;
            }
        } 
        return nb;        
    }
    
    public int get_nb_impossible(){
        return (this.all.length - get_nb_possible());
    }
    public void generate_(){
        this.impossible = new Piste[get_nb_impossible()];
        this.req_speed = new double[get_nb_impossible()];
        this.possible = new Piste[get_nb_possible()];
        int impossible = 0;
        int possible = 0;
        for(int op = 0; op < this.all.length; op++){
            if(lib1.Vol_condtionPrix(this.fVol, all[op]) == 0){
                this.impossible[impossible] = this.all[op];
                this.req_speed[impossible] = lPhysics.maximum_speed_piste(this.fVol, this.all[op]);
                impossible = impossible + 1;
            }else{
                this.possible[possible] = this.all[op];
                possible = possible + 1;
            }
        }
    }
    public Piste_possibilty(Piste[] lPistes, Vol fVol){
        this.all = lPistes;
        this.fVol = fVol;
        this.lPhysics = new Physics();
        this.lib1 = new Gestionnaire();
        generate_();
    }
    public void show_all_possible(){
        System.out.println("Il y a " + this.possible.length + " pistes possibles");
        for(int op = 0; op < this.possible.length; op++){
            System.out.println("--- " + this.possible[op].getNom());
        }
    }
    public void show_all_impossible(){
        System.out.println("Il y a " + this.impossible.length + " pistes impossibles");
        for(int op = 0; op < this.impossible.length; op++){
            System.out.println("--- " + this.impossible[op].getNom() );
            System.out.println("    Vitesse maximum pour la piste (en m/s) : " + this.lPhysics.maximum_speed_piste(this.fVol, this.impossible[op]));
            System.out.println("    Vitesse de l'avion (à l'atterissage et en m/s) : " + this.lPhysics.convert_kmh_ms(this.fVol.getAterii().getVitesse()));
            System.out.println("    Vitesse a enlever (m/s) : " + Math.abs(this.lPhysics.maximum_speed_piste(this.fVol, this.impossible[op]) - this.lPhysics.convert_kmh_ms(this.fVol.getAterii().getVitesse())));
        }
    }
    public void show_all(){
        System.out.println("Avion : " + this.fVol.getPlane().getNom());
        show_all_impossible();
        show_all_possible();
    }
}
