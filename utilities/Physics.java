package utilities;

import control.*;
import fligth.*;
import infrastructure.*;
import proce_gen.*;
//import utilities.*;
public class Physics{
    int g;
    public Physics(){
        this.g = 10;
    }
    public double convert_kmh_ms(double kmh){
        return ((kmh * 1000) / 3600);
    }
    public double convert_ms_kmh(double ms){
        return (ms * 3.6);
    }
    public double impact_time(Vol fVol){
        double a = fVol.getAproach().getVitesse0y();
        double b = (Math.pow(fVol.getAproach().getVitesse0y(), 2) + (2 * this.g * fVol.getAproach().getY0()));
        return (a + Math.sqrt(b)) / 2;
    }
    public double x_impact(Vol fVol){
        return (fVol.getAproach().getVitesse0x() * this.impact_time(fVol) + fVol.getDuree_deVol());
    }
    public double getImpact_speedX(Vol fVol){
        return (fVol.getAproach().getVitesse0x());
    }
    public double getImpact_speedY(Vol fVol){
        return (((-g * this.impact_time(fVol))) + fVol.getAproach().getVitesse0y());
    }
    public double get_distfrein(Vol fVol, Piste pista){
        /*System.out.println("------------------------------------");
        fVol.plane.show();
        System.out.println("vitesse en km/h = " + fVol.aterii.vitesse);
        System.out.println("vitesse en m/s = " + this.convert_kmh_ms(fVol.aterii.vitesse));
        System.out.println("dist frein nesc = " + (Math.pow(this.convert_kmh_ms(fVol.aterii.vitesse), 2) * fVol.plane.poids) / (2 * (fVol.plane.c_decel - pista.tompony.meteo.humidite[fVol.arrivee_asa.heure])));
        System.out.println("------------------------------------");
        System.out.println();*/
        return ((Math.pow(this.convert_kmh_ms(fVol.getAterii().getVitesse()), 2) * fVol.getPlane().getPoids()) / (2 * (fVol.getPlane().getC_decel() - pista.getTompony().getMeteo().get_humiditen(fVol.getArrivee_asa().getHeure()))) + this.x_impact(fVol));
    }
    public double maximum_speed_piste(Vol fVol, Piste piste){
        return Math.sqrt(Math.abs((2 * piste.getLong_Piste() * (fVol.getPlane().getC_decel() - piste.getTompony().getMeteo().get_humiditen(fVol.getArrivee_asa().heure))) / fVol.getPlane().getPoids()));
    }
    
}