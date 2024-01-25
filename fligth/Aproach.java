package fligth;

import java.lang.Math;
import control.*;
//import fligth.*;
import infrastructure.*;
import proce_gen.*;
import utilities.*;

public class Aproach {
    double vitesse0;
    int angle;
    double x0;
    double y0;
    Vol fligth;
    public Aproach(){

    }
    public void setX0(double x0) {
        if(x0 >= 0){
            this.x0 = 0 - x0;
        }else{
            this.x0 = x0;
        }
    }
    public void setAngle(int angle) {
        this.angle = angle;
    }
    public void setVitesse0(double vitesse0) {
        if(vitesse0 != 0){
            this.vitesse0 = Math.abs(vitesse0);
        }
    }
    public void setFligth(Vol fligth) {
        this.fligth = fligth;
    }
    public void setY0(double y0) {
        if(y0 != 0){
            this.y0 = Math.abs(y0);
        }
    }
    public double getVitesse0y(){
        return (this.vitesse0 * Math.sin(this.angle));
    }
    public double getVitesse0x(){
        return (this.vitesse0 * Math.cos(this.angle));
    }
    public int getAngle() {
        return angle;
    }
    public Vol getFligth() {
        return fligth;
    }
    public double getVitesse0() {
        return vitesse0;
    }
    public double getX0() {
        return x0;
    }
    public double getY0() {
        return y0;
    }
    
    public Aproach(double vitesse0, int angle, double x0, double y0, Vol fVol){
        this.setAngle(angle);
        this.setFligth(fVol);
        this.setVitesse0(vitesse0);
        this.setX0(x0);
        this.setY0(y0);
    }
}
