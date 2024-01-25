package control;
import fligth.*;
import infrastructure.*;
import proce_gen.*;
import utilities.*;

public class Gestionnaire{
    Aeroport tompony;
    Vol[] listVols;
    Piste[] lPistes;
    Quote[] lQuotes;
    Physics calc;
    public Gestionnaire(){
        this.calc = new Physics();
    }
    public void setListVols(Vol[] listVols) {
        this.listVols = listVols;
    }
    public void setTompony(Aeroport tompony) {
        this.tompony = tompony;
    }
    public void setlPistes(Piste[] lPistes) {
        this.lPistes = lPistes;
    }
    public void setlQuotes(Quote[] lQuotes) {
        this.lQuotes = lQuotes;
    }
    public Vol[] getListVols() {
        return listVols;
    }
    public Aeroport getTompony() {
        return tompony;
    }
    public Piste[] getlPistes() {
        return lPistes;
    }
    public Aeroport get_tompony(){
        return this.tompony;
    }
    public Vol[] get_Vols(){
        return this.listVols;
    }
    public Piste[] get_lPistes(){
        return this.lPistes;
    }
    public Quote[] getlQuotes() {
        return this.lQuotes;
    }

    Piste[] duplicate_Pistes(){
        Piste[] returns = new Piste[lPistes.length];
        for(int op = 0; op < lPistes.length; op++){
            returns[op] = new Piste(lPistes[op].getNom(), lPistes[op].getMaxPoids(), lPistes[op].getLong_Piste(), lPistes[op].getCouts(), lPistes[op].getLargeur(), lPistes[op].getDispo());
            returns[op].setTompony(lPistes[op].getTompony());
        }
        return returns;
    }
    Vol[] duplicate_Vols(){
        Vol[] returns = new Vol[listVols.length];
        for(int op = 0; op < listVols.length; op++){
            returns[op] = new Vol(listVols[op].getDuree_deVol(), listVols[op].getDebarquem(), listVols[op].getPlane(), listVols[op].getAproach());
            returns[op].setAterii(listVols[op].getAterii());
            returns[op].setArrivee_asa(listVols[op].getArrivee_asa());
        }
        return returns;
    }
    public void insert(Aeroport tompony, Vol[] lisVols, Piste[] lPistes){
        this.lPistes = lPistes;
        this.listVols = lisVols;
        this.tompony = tompony;
    }
    
    public int Vol_condtionPrix(Vol fVol, Piste pista){
        if(fVol.getPlane().getPoids() < pista.getMaxPoids() && 
            pista.getLong_Piste() >= calc.get_distfrein(fVol, pista) &&
            fVol.getPlane().getLargeur() < pista.getLargeur() &&
            pista.getDispo() == 1 &&
            ((pista.getCouts() * fVol.getPlane().getPoids()) / fVol.getPlane().getTompony().getDevis().getTaux()) < fVol.getPlane().getTompony().getVola()
            ){
                //System.out.println("L'avion : " + fVol.plane.Nom + " peut atterir sur la piste : " + pista.Nom);
                return 1;
            }else{
                //System.err.println("L'avion : " + fVol.plane.Nom + " peut atterir sur la piste : " + pista.Nom);
                return 0;
            }
    }
    public int Vol_condtion(Vol fVol, Piste pista){
        if(fVol.getPlane().getPoids() < pista.getMaxPoids() && 
            pista.getLong_Piste() >= calc.get_distfrein(fVol, pista) && 
            fVol.getPlane().getLargeur() < pista.getLargeur() &&
            pista.getDispo() == 1 &&
            calc.x_impact(fVol) > 0 &&
            calc.x_impact(fVol) < pista.getLong_Piste()
            ){
                //System.out.println("L'avion : " + fVol.plane.Nom + " peut atterir sur la piste : " + pista.Nom);
                return 1;
            }else{
                //System.err.println("L'avion : " + fVol.plane.Nom + " peut atterir sur la piste : " + pista.Nom);
                return 0;
            }
    }
    double cheap_PistPR(Vol fVol){
        double min = ((this.lPistes[0].getCouts() * fVol.getPlane().getPoids()) / fVol.getPlane().getTompony().getDevis().getTaux());
        for(int pm = 0; pm < this.lPistes.length; pm++){
            if(min > ((this.lPistes[pm].getCouts() * fVol.getPlane().getPoids()) / fVol.getPlane().getTompony().getDevis().getTaux())){
                min = (this.lPistes[pm].getCouts() * fVol.getPlane().getPoids()) / fVol.getPlane().getTompony().getDevis().getTaux();
            }
        }
        return min;
    }
    int nb_cheapP(Vol fVol){
        int nb = 0;
        double min = cheap_PistPR(fVol);
        for(int pm = 0; pm < this.lPistes.length; pm++){
            if(min == ((this.lPistes[pm].getCouts() * fVol.getPlane().getPoids()) / fVol.getPlane().getTompony().getDevis().getTaux())){
                nb = nb + 1;
            }
        }
        return nb;
    }

    Piste[] cheap_Pistes(Vol fVol){
        Piste[] returns = new Piste[nb_cheapP(fVol)];
        double min = cheap_PistPR(fVol);
        int nb = 0;
        for(int op = 0; op < this.lPistes.length; op++){
            if(min > ((this.lPistes[op].getCouts() * fVol.getPlane().getPoids()) / fVol.getPlane().getTompony().getDevis().getTaux())){
                returns[nb] = this.lPistes[op];   
                nb = nb + 1;
            }
        }
        return returns;
    }
    void generate_lQuote(int np){
        this.lQuotes = new Quote[np];
    }
    Quote cheap_atteri(Vol fVol){
        Piste[] cheaPistes = cheap_Pistes(fVol);
        for(int op = 0; op < cheaPistes.length; op++){
            if(Vol_condtion(fVol, cheaPistes[op]) == 1){
                return atteri_simp(fVol, cheaPistes[op]);   
            }
        }
        return new Quote();
    }
    Quote atteri_simp(Vol flight, Piste pista){
        Quote returns = new Quote(pista, flight);
        pista.setDispo(0);
        flight.getAterii().simple_insert(flight.getPlane(), pista);
        flight.getPlane().getTompony().payerFD(this.tompony, flight.getAterii().get_price());
        flight.getAterii().setArriv_piste(flight.getArrivee_asa());
        pista.setDispo(1);
        return returns;
    }
    Quote viratteri_simp(Vol flight, Piste pista){
        pista.setDispo(0);
        flight.getAterii().simple_insert(flight.getPlane(), pista);
        flight.getAterii().setArriv_piste(flight.getArrivee_asa());
        pista.setDispo(1);
        Quote returns = new Quote(pista, flight, 2);
        return returns;
    }
    int find_all_PossQuote(){
        int nb = 0;
        for(int op1 = 0; op1 < this.listVols.length; op1++){
            for(int op2 = 0; op2 < this.lPistes.length; op2++){
                if(Vol_condtion(this.listVols[op1], this.lPistes[op2]) == 1){
                    nb = nb + 1;
                    break;
                }
            }
        }
        return nb;
    }
    int find_nb_PossQuote(){
        Piste[] virtPistes = duplicate_Pistes();
        Vol[] virtVols = duplicate_Vols();
        int nb = 0;
        Quote virtQuote = new Quote();
        for(int op1 = 0; op1 < virtVols.length; op1++){
            for(int op2 = 0; op2 < virtPistes.length; op2++){
                if(Vol_condtionPrix(virtVols[op1], virtPistes[op2]) == 1){
                    virtQuote = viratteri_simp(virtVols[op1], virtPistes[op2]);
                    nb = nb + 1;
                    break;
                }
            }
        }
        return nb;
    }

    public void launch_Smart_gestionnaire(){
        this.generate_lQuote(find_nb_PossQuote());
        int op = 0;
        for(int op1 = 0; op1 < this.listVols.length; op1++){
            this.listVols[op1].setPossibilty(new Piste_possibilty(this.lPistes, this.listVols[op1]));
            for(int op2 = 0; op2 < this.lPistes.length; op2++){
                if(Vol_condtionPrix(this.listVols[op1], this.lPistes[op2]) == 1){
                    System.out.println(((op * 100) / this.find_nb_PossQuote()) + " %");
                    this.lQuotes[op] = atteri_simp(this.listVols[op1], this.lPistes[op2]);
                    op = op + 1;
                    break;
                }
            }    
        }
        System.out.println(((op * 100) / this.find_nb_PossQuote()) + " %");
    }
    public void launch_gestionnaire(){
        this.generate_lQuote(this.listVols.length);
        int op = 0;
        for(int op1 = 0; op1 < this.listVols.length; op1++){
            int aterii = 0;
            for(int op2 = 0; op2 < this.lPistes.length; op2++){
                if(Vol_condtionPrix(this.listVols[op1], this.lPistes[op2]) == 1){
                    this.lQuotes[op] = atteri_simp(this.listVols[op1], this.lPistes[op2]);
                    op = op + 1;
                    aterii = 1;
                }
            }
            if(aterii == 0){
                this.lQuotes[op] = cheap_atteri(this.listVols[op1]);
                op = op + 1;
            }
        }
    }
    public int nb_piste_dispo(){
        int nb = 0;
        for(int op = 0; op < this.lPistes.length ; op++){
            if(this.lPistes[op].getDispo() == 0){
                nb = nb + 1;
            }
        }
        return nb;
    }
    public void show_allpossible_quote(){
        System.out.println("\n-----------------------------");
        System.out.println("Liste des atterissage possibles");
        System.out.println("Il y a" + lQuotes.length);
        for(int op = 0; op < lQuotes.length; op++){
            System.out.println("N°" + (op + 1));
            lQuotes[op].show_quotes();
        }
    }
    public void show_all_possibility(){
        for(int op = 0; op < this.listVols.length; op++){
            this.listVols[op].getPossibilty().show_all();
        }
    }
}
