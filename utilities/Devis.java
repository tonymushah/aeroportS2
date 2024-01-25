package utilities;

public class Devis {
    String nom;
    double taux; // Taux par rapport en ariary
    public void insert(String nom, double taux){
        this.nom = nom;
        this.taux = taux;
    }
    public String getNom(){
        return this.nom;
    }
    public double getTaux(){
        return this.taux;
    }
    public double _ariary_(double montants){
        return (this.taux * montants);
    }
}