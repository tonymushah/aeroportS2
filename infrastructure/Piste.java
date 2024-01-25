package infrastructure;

public class Piste {
    double maxPoids;
    double long_Piste;
    double couts;
    String Nom;
    double largeur;
    int dispo;
    Aeroport tompony;
    public double getCouts() {
        return couts;
    }
    public int getDispo() {
        return dispo;
    }
    public double getLargeur() {
        return largeur;
    }
    public double getLong_Piste() {
        return long_Piste;
    }
    public double getMaxPoids() {
        return maxPoids;
    }
    public String getNom() {
        return Nom;
    }
    public Aeroport getTompony() {
        return tompony;
    }
    public void setCouts(double couts) {
        this.couts = couts;
    }
    public void setDispo(int dispo) {
        this.dispo = dispo;
    }   
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setLong_Piste(double long_Piste) {
        this.long_Piste = long_Piste;
    }
    public void setMaxPoids(double maxPoids) {
        this.maxPoids = maxPoids;
    }
    public void setNom(String nom) {
        this.Nom = nom;
    }
    public void setTompony(Aeroport tompony) {
        this.tompony = tompony;
    }
    public void insert(String Nom, double maxPoids, double long_Piste, double couts, double largeur, int dispo){
        this.Nom = Nom;
        this.couts = couts;
        this.dispo = dispo;
        this.largeur = largeur;
        this.long_Piste = long_Piste;
        this.maxPoids = maxPoids;
    }
    public Piste(){}
    public Piste(String Nom, double maxPoids, double long_Piste, double couts, double largeur, int dispo){
        this.Nom = Nom;
        this.couts = couts;
        this.dispo = dispo;
        this.largeur = largeur;
        this.long_Piste = long_Piste;
        this.maxPoids = maxPoids;
    }
    void show_detail(){
        System.out.println("----------------------");
        System.out.println("Nom: " + this.Nom);
        System.out.println("Longeur de la piste: " + this.long_Piste);
        System.out.println("Couts par atterissage (par tonne) : " + this.couts);
        System.out.println("Largeur: " + this.largeur);
        System.out.println("Maximum de poix en tonne: " + this.maxPoids);
        System.out.println("Disponibilité: " + this.dispo);
        System.out.println("----------------------");
    }
}