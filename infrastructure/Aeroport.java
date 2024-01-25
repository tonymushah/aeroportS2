package infrastructure;
import control.*;
import fligth.*;
//import infrastructure.*;
import proce_gen.*;
import utilities.*;

public class Aeroport {
    double vola;
    Devis devis;
    Compagnie[] corps;
    String nom;
    Gestionnaire control;
    Piste[] lPistes;
    Meteo meteo;
    public void setControl(Gestionnaire control) {
        this.control = control;
    }
    public void setCorps(Compagnie[] corps) {
        this.corps = corps;
    }
    public void setDevis(Devis devis) {
        this.devis = devis;
    }
    public void setMeteo(Meteo meteo) {
        this.meteo = meteo;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setVola(double vola) {
        this.vola = vola;
    }
    public void setlPistes(Piste[] lPistes) {
        this.lPistes = lPistes;
    }
    public Gestionnaire getControl() {
        return control;
    }
    public Compagnie[] getCorps() {
        return corps;
    }
    public Devis getDevis() {
        return devis;
    }
    public Meteo getMeteo() {
        return meteo;
    }
    public String getNom() {
        return nom;
    }
    public double getVola() {
        return vola;
    }
    int nb_pisteNonNuls(){
        int nb = 0;
        for(int op = 0; op < this.lPistes.length; op++){
            if(this.lPistes[op] != null){
                nb = nb + 1;
            }
        }
        return nb;
    }
    public Piste[] getlPistes() {
        Piste[] mPistes = new Piste[this.nb_pisteNonNuls()];
        int nb = 0;
        for(int op = 0; op < this.lPistes.length; op++){
            if(this.lPistes[op] != null){
                mPistes[nb] = this.lPistes[op];
                nb = nb + 1;   
            }
        }
        return mPistes;
    }
    
    public void insert(Devis devis, double vola, Compagnie[] corps, String nom, Gestionnaire control, Piste[] lPistes){
        this.devis = devis;
        this.control = control;
        this.vola = vola;
        this.corps = corps;
        this.nom = nom;
        this.lPistes = lPistes;
        this.control.setlPistes(lPistes);
        
    }
    public void insert(Devis devis, double vola, Compagnie[] corps, String nom, Gestionnaire control){
        this.devis = devis;
        this.control = control;
        this.vola = vola;
        this.corps = corps;
        this.nom = nom;
    }
    public Aeroport(){}
    public void insert_meteo(Meteo meteo){
       this.meteo = meteo; 
    }
    public Aeroport(Meteo meteo){
        this.meteo = meteo;
    }
    public int nb_avion(){
        int nb = 0;
        for(int op = 0; op < corps.length; op++){
            nb = nb + corps[op].avions.length;
        }
        return nb;
    }
    public Avion[] get_aero_avion(){
        Avion[] avions = new Avion[this.nb_avion()];
        int nb = 0;
        for(int op = 0; op < corps.length; op++){
            for(int pl = 0; pl < corps[op].avions.length; pl++){
                avions[nb] = corps[op].avions[pl];
                nb = nb + 1;
            }
        }
        return avions;
    }
    public void ajouter_piste(Piste adding){
        Piste[] inserted = new Piste[this.lPistes.length + 1];
        int op = 0;
        for(op = 0; op < this.lPistes.length; op++){
            inserted[op] = this.lPistes[op];
        }
        inserted[op] = adding;
        this.lPistes = inserted;
    }
    public void start_gestion(){
        System.out.println("Starting gestion...");
        System.out.println("Nombre de vols en cours : " + this.control.getListVols().length);
        this.control.launch_Smart_gestionnaire();
        System.out.println("Finished...");
    }
    public void show_all_pistes(){
        System.out.println("-------------------");
        for(int op = 0; op < this.lPistes.length; op++){
            this.lPistes[op].show_detail();
        }
        System.out.println("-------------------");
    }
    public void show_data(){
        System.out.println("Nom: " + this.nom);
        System.out.println("Money: " + this.vola + " " + this.devis.getNom());
        System.out.println("Listes des compagnies");
        for(int op = 0; op < this.corps.length; op++){
            this.corps[op].show_all_detail();
        }
        System.out.println("Listes des pistes");
        for(int op = 0; op < this.lPistes.length; op++){
            this.lPistes[op].show_detail();
        }
    }
    public void show_all_compagnies(){
        for(int op = 0; op < corps.length; op++){
            System.out.println("Compagnie N°" + op);
            corps[op].show_detail();
        }
    }
    public void show_all_flight(){
        System.out.println("-------------------------");
        System.out.println("Nombre de vols en cours : " + this.control.getListVols().length);
        for(int op = 0; op < this.control.getListVols().length; op++){
            this.control.getListVols()[op].show_detai();
        }
        System.out.println("-------------------------");
    }
    public void show_ggestionInf(){
        System.out.println("Le nombre de vol au depart est de : " + this.control.getListVols().length);
        System.out.println("Le nombre de piste au depart est de : "+ this.lPistes.length);
        System.out.println("Le nombre d'atterissage en cours est de : " + this.control.getlQuotes().length);
        System.out.println("Le nombre de piste disp : " + (this.control.getlPistes().length - this.control.nb_piste_dispo()));
    }
}
