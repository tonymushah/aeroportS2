package infrastructure;

public class Avion {
    double poids;
    double c_decel;
    double dist_freinH;
    double largeur; 
    double duree_maxVol;
    String Nom;
    Compagnie tompony;
    public double getC_decel() {
        return c_decel;
    }
    public double getDist_freinH() {
        return dist_freinH;
    }
    public double getDuree_maxVol() {
        return duree_maxVol;
    }
    public double getLargeur() {
        return largeur;
    }
    public String getNom() {
        return Nom;
    }
    public double getPoids() {
        return poids;
    }
    public Compagnie getTompony() {
        return tompony;
    }
    public void setTompony(Compagnie tompony) {
        this.tompony = tompony;
    }
    public void setC_decel(double c_decel) {
        this.c_decel = c_decel;
    }
    public void setDist_freinH(double dist_freinH) {
        this.dist_freinH = dist_freinH;
    }
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setDuree_maxVol(double duree_maxVol) {
        this.duree_maxVol = duree_maxVol;
    }
    public void setNom(String nom) {
        Nom = nom;
    }
    public void setPoids(double poids) {
        this.poids = poids;
    }
    
    public void insert(String nom, double poids, double largeur, double duree_maxVol, double c_decel, Compagnie tompony, int adherance){
        this.Nom = nom;
        this.tompony = tompony;
        this.c_decel = c_decel;
        this.duree_maxVol = duree_maxVol;
        this.largeur = largeur;
        this.poids = poids;
    }
    public void insert(String nom, double poids, double largeur, double duree_maxVol, double c_decel, int adherance){
        this.Nom = nom;
        this.c_decel = c_decel;
        this.duree_maxVol = duree_maxVol;
        this.largeur = largeur;
        this.poids = poids;
    }
    public void show(){
        System.out.println("--------------------------------------");
        System.out.println("Nom : " + this.Nom);
        System.out.println("--------------------------------------");
    }
    public void show_detail(){
        System.out.println("--------------------------------------");
        System.out.println("Nom : " + this.Nom);
        System.out.println("Largeur : " + this.largeur);
        System.out.println("Capacité décéleration: " + this.c_decel);
        System.out.println("Distance de : " + this.largeur);
        System.out.println("--------------------------------------");
    }
}
