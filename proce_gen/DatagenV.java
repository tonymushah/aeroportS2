package proce_gen;
import control.*;
import fligth.*;
import infrastructure.*;
import utilities.*;

import java.util.Random;

public class DatagenV{
    Vol[] data;
    Piste[] daPistes;
    Random rand;
    Heure plo;
    Word_generator wgen;
    
    public Piste[] getDaPistes() {
        return daPistes;
    }
    public Vol[] getData() {
        return data;
    }
    public Heure getPlo() {
        return plo;
    }
    public Random getRand() {
        return rand;
    }
    public Word_generator getWgen() {
        return wgen;
    }
    public void generate_Pistes(int lengthP, Aeroport tompony){
        //System.out.println("generate Pistes ++--");
        this.daPistes = new Piste[lengthP];
        for(int op = 0; op < this.daPistes.length; op++){
            //System.out.println(((op * 100) / lengthP) + " %");
            this.daPistes[op] = new Piste("N° " + op, rand.nextInt(250), rand.nextInt(10000), rand.nextInt(1000), rand.nextInt(250), 1);
            this.daPistes[op].setTompony(tompony);
        }
    }
    public Piste generate_Piste(Aeroport tompony){
        Piste returns = new Piste(wgen.generate_a_nouns_groups(2 , 6) , rand.nextInt(250), rand.nextInt(10000), rand.nextInt(1000), rand.nextInt(250), 1);
        returns.setTompony(tompony);
        return returns;
    }
    public Avion generAvion(){
        Avion returns = new Avion();
        returns.insert(wgen.generate_alea_Noun(5) + " " , rand.nextInt(250), rand.nextInt(75), rand.nextInt(24),rand.nextInt(150), rand.nextInt(25));
        return returns;
    }
    public Compagnie generate_a_compagnie(int name_length, int nb_avion){
        Compagnie returns = new Compagnie();
        Avion[] lAvions = new Avion[nb_avion];
        for(int op = 0; op < lAvions.length; op++){
            lAvions[op] = generAvion();
            lAvions[op].setTompony(returns);
        }
        //Compagnie
        return returns;
    }
    /*public Vol generate_aVol(Avion[] lAvions){
        Vol returns = new Vol(rand.nextInt(24), 
            rand.nextInt(10), 
            lAvions[rand.nextInt(lAvions.length)], 
            plo.insert_rand_get(), 
            new Aterrissage(rand.nextInt(300)));
        returns.getAterii().setPlane(returns.getPlane());
        return returns;
    }*/
    public void generate_dataV(Avion[] lAvions){
        System.out.println("");
        for(int op = 0 ; op < this.data.length; op++){
        //    data[op] = generate_aVol(lAvions); 
            System.out.println(((op * 100 )/ this.data.length) + " %");
        }
    }
    public DatagenV(int lengthV, Avion[] lAvions){
        this.plo = new Heure();
        this.rand = new Random();
        this.data = new Vol[lengthV];
        this.generate_dataV(lAvions);
        this.wgen = new Word_generator();
    }
    public DatagenV(){
        this.rand = new Random();
        this.wgen = new Word_generator();
    }
}
