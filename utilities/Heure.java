package utilities;
import java.util.Random;

public class Heure {
    int second;
    int minutes;
    int heure;
    public Heure(){

    }
    public int getHeure(){
        return this.heure;
    }
    public int getHinute(){
        return this.minutes;
    }
    public int getSeconde(){
        return this.second;
    }
    void dynamise(){

        //pour les secondes
        
        int pr_s = this.second;
        this.second = this.second % 60;
        if(this.second < 0){
            this.second = 60 + this.second;
        }
        int i_m;
        int ml = 0;
        if(this.second != 0){
            for(i_m = -60; ml != pr_s; i_m++){
                ml = this.second + (60 * i_m);
            }
            i_m--;
        }else{
            i_m = 0;
        }
        // pour les minutes

        ml = 0;
        int pr_m = this.minutes + i_m;
        this.minutes = pr_m % 60;
        if(this.minutes < 0){
            this.minutes = 60 + this.minutes;
        }
        int i_h;
        if(this.minutes != 0){
            for(i_h = -60; ml != pr_m; i_h++){
                ml = this.minutes + (60 * i_h);
            }
            i_h--;
        }else{
            i_h = 0;
        }
        // pour les heures
        /* FIXME this.heure 
        ** si this.heure est superieur ou égal a 24 alors this.heure sera corrigé 
        ** en bref, 24 = 0, 25 = 1 mettre en base 24
        */
        this.heure = this.heure + i_h;
    }    
    public void insert(int heure, int minutes, int secondes){
        this.heure = heure;
        this.minutes = minutes;
        this.second = secondes;
        this.dynamise();
    }
    public Heure(int heure, int minutes, int secondes){
        this.heure = heure;
        this.minutes = minutes;
        this.second = secondes;
        this.dynamise();
    }
    public Heure insert_get(int heure, int minutes, int secondes){
        this.heure = heure;
        this.minutes = minutes;
        this.second = secondes;
        this.dynamise();
        Heure send = new Heure();
        send.heure = this.heure;
        send.minutes = this.minutes;
        send.second = this.second;
        return send;
    }
    public void insert_noDyn(int heure, int minutes, int secondes){
        this.heure = heure;
        this.minutes = minutes;
        this.second = secondes;
    }
    public void show_detail(){
        System.out.println(this.heure + ":" + this.minutes + ":" + this.second);
    }
    public Heure addition(Heure to_use){
        Heure to_return = new Heure();
        to_return.heure = this.heure + to_use.heure;
        to_return.minutes = this.minutes + to_use.minutes;
        to_return.second = this.second + to_use.second;
        to_return.dynamise();
       return to_return;
    }
    public Heure addition_noDym(Heure to_use){
        Heure to_return = new Heure();
        to_return.heure = this.heure + to_use.heure;
        to_return.minutes = this.minutes + to_use.minutes;
        to_return.second = this.second + to_use.second;
       return to_return;
    }
    public Heure difference(Heure to_use){
        Heure to_return = new Heure();
        to_return.heure = this.heure - to_use.heure;
        to_return.minutes = this.minutes - to_use.minutes;
        to_return.second = this.second - to_use.second;
        to_return.dynamise();
       return to_return;
    }
    public Heure difference_noDym(Heure to_use){
        Heure to_return = new Heure();
        to_return.heure = this.heure - to_use.heure;
        to_return.minutes = this.minutes - to_use.minutes;
        to_return.second = this.second - to_use.second;
       return to_return;
    }
    public void add(Heure to_use){
        this.heure = this.heure + to_use.heure;
        this.minutes = this.minutes + to_use.minutes;
        this.second = this.second + to_use.second;
        this.dynamise();
    }
    public void remove(Heure to_use){
        this.heure = this.heure - to_use.heure;
        this.minutes = this.minutes - to_use.minutes;
        this.second = this.second - to_use.second;
        this.dynamise();
    }
    public void multiply(int value){
        this.heure = this.heure * value;
        this.minutes = this.minutes * value;
        this.second = this.second * value;
        this.dynamise();
    }
    /* TODO fonction Heure_double
    ** une fontion qui va donc transformer une variable de type heure en type double
    BUG a ne pas oublier que la decimale de la division de deux int puis mise dans une variable double est nule
    */
    public void double_to_heure(double heure_double){
        Double hDouble = heure_double;
        this.heure = hDouble.intValue();
        Double hDouble2 = (hDouble - hDouble.intValue()) * 60;
        this.minutes = hDouble2.intValue();
        Double hDouble3 = (hDouble2 - hDouble2.intValue()) * 60;
        this.second = hDouble3.intValue();
    }
    public double Heure_double(){
        double tout = (this.heure * 3600) + (this.minutes * 60) + this.second;
        return (tout / 3600);
    }
    public Heure insert_rand_get(){
        Random random = new Random();
        int heure = random.nextInt(23);
        int minutes = random.nextInt(59);
        int secondes = random.nextInt(59);
        this.heure = heure;
        this.minutes = minutes;
        this.second = secondes;
        this.dynamise();
        Heure send = new Heure();
        send.heure = this.heure;
        send.minutes = this.minutes;
        send.second = this.second;
        return send;
    }
}
