package utilities;
import java.util.Random;

public class Meteo {
    double[] humidite;
    public double[] getHumidite() {
        return humidite;
    }
    public double get_humiditen(int heure){
        return this.humidite[(heure % 24)];
    }
    public void gnrt_humidite_tab(){
        this.humidite = new double[23];
    }
    public void affectate_randomly(){
        this.gnrt_humidite_tab();
        Random value = new Random();
        for(int op = 0; this.humidite.length > op; op++){
            this.humidite[op] = value.nextInt(100);
        }
    }
    public Meteo(int alea){
        this.gnrt_humidite_tab();
        if(alea != 0){
            this.affectate_randomly();
        }
    }
    public void show_meteo(){
        System.out.println("Le taux d'humidité de la journée");
        for(int op = 0; op < this.humidite.length; op++){
            System.out.println(op + " h : " + this.humidite[op]);
        }
    }
}
