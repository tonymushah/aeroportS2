package infrastructure;
import control.*;
import fligth.*;
import infrastructure.*;
import proce_gen.*;
import utilities.*;

public class Compagnie {
    double vola; 
    Devis devis;
    Avion[] avions;
    String nom;
    
    public Avion[] getAvions() {
        return avions;
    }
    public Devis getDevis() {
        return devis;
    }
    public String getNom() {
        return nom;
    }
    public double getVola() {
        return vola;
    }
    public void setAvions(Avion[] avions) {
        this.avions = avions;
    }
    public void setDevis(Devis devis) {
        this.devis = devis;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setVola(double vola) {
        this.vola = vola;
    }
    
    public void insert(String nom, double vola, Devis devis, Avion[] avions){
        this.nom = nom;
        this.vola = vola;
        this.avions = avions;
        this.devis = devis;
    }
    public void payerFD(Aeroport a_payer, double entree){
        this.vola = this.vola - entree;
        a_payer.vola = a_payer.vola + entree;
    }
    public void show_all_detail(){
        System.out.println("---------Compagnie----------");
        System.out.println("Nom: " + this.nom);
        System.out.println("Money: " + this.vola + " " + this.devis.getNom());
        System.out.println("Listes des avions");
        for(int op = 0; op < this.avions.length; op++){
            this.avions[op].show_detail();
        }
        System.out.println("----------------------------");
    }
    public void show_detail(){
        System.out.println("---------Compagnie----------");
        System.out.println("Nom: " + this.nom);
        System.out.println("Money: " + this.vola + " " + this.devis.getNom());
        System.out.println("----------------------------");
    }
}
