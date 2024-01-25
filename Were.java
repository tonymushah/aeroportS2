import java.util.Random;
import control.*;
import fligth.*;
import infrastructure.*;
import proce_gen.*;
import utilities.*;
class Were{
    public static void main(String[] args) {
        // TODO declaration des variable
            // duree de toute les debarquements, vitesse, adherence
                Random adherence = new Random();
                int debarquem = 3;
                double[] vitesses = new double[3];
                vitesses[0] = 180;
                vitesses[1] = 200;
                vitesses[2] = 250;
                
            
            // Liste des devises
                Devis[] devises = new Devis[5];
                for(int op = 0; op < devises.length; op++){
                    devises[op] = new Devis();
                }
                //Ariary
                    devises[0].insert("Ariary", 1);
                //Euro
                    devises[1].insert("Euro", 11);
                //Francs
                    devises[2].insert("Francs", 5);
                //Yen
                    devises[3].insert("Yen", 2);
                //Dollar
                    devises[4].insert("Dollar", 10);

            
            // creation d'une liste d'une compagine Aerienne lol "Air Serenity"
                Compagnie[] listCompagnies = new Compagnie[3];
                for(int op = 0; op < listCompagnies.length; op++){
                    listCompagnies[op] = new Compagnie();
                }
                
                // Premiere compagnie aerienne "Air Serenity"
                    // declarations des avions    
                    Avion[] planes1 = new Avion[3];
                    for(int op = 0; op < planes1.length; op++){
                        planes1[op] = new Avion();
                    }
                listCompagnies[0].insert("Air Serenity", 789000, devises[1], planes1);
                    planes1[0].insert("AirBus C2001", 125, 60, 75, 10, listCompagnies[0], adherence.nextInt(30));
                    planes1[1].insert("Boeing 625A", 120, 55, 35, 50, listCompagnies[0], adherence.nextInt(30));
                    planes1[2].insert("AirBus A360", 125, 25, 54, 60, listCompagnies[0], adherence.nextInt(30));

                // Deuxieme compagnie Aerienne "Loud Travel"
                    // declarations des avions
                    Avion[] planes2 = new Avion[2];
                    for(int op = 0; op < planes2.length; op++){
                        planes2[op] = new Avion();
                    }
                listCompagnies[1].insert("Loud Travel", 800000, devises[4], planes2);
                    planes2[0].insert("MARKOV S789", 200, 80, 120, 36, listCompagnies[1], adherence.nextInt(30));
                    planes2[1].insert("AirBus C2001", 125, 60, 72, 30, listCompagnies[1], adherence.nextInt(30));

                // Troisieme compagnie Arienne "Mr Beast Airlines"
                    // declarations des avions 
                    Avion[] planes3 = new Avion[4];
                    for(int op = 0; op < planes3.length; op++){
                        planes3[op] = new Avion();
                    }
                listCompagnies[2].insert("Mr Beast Airlines", (10e10), devises[4], planes3);
                    planes3[0].insert("Boeing 777", 210, 100, 72, 45, listCompagnies[2], adherence.nextInt(30));
                    planes3[1].insert("Spitfire", 15, 10, 24, 15, listCompagnies[2], adherence.nextInt(30));
                    planes3[2].insert("Boeing 777", 210, 100, 72, 70, listCompagnies[2], adherence.nextInt(30));
                    planes3[3].insert("AirBus C2001", 125, 60, 72, 75, listCompagnies[2], adherence.nextInt(30));                   

            // declaration de l'aeroport
                // declaration du gestionnaire
                    Gestionnaire ivato_Gestionnaire = new Gestionnaire();
                Aeroport ivato = new Aeroport();
            Random rand = new Random();
                ivato.insert(devises[0], 45000, listCompagnies, "Ivato", ivato_Gestionnaire);
                DatagenV gen = new DatagenV();
                gen.generate_Pistes(rand.nextInt(24), ivato);
                ivato.setlPistes(gen.getDaPistes());
                ivato.ajouter_piste(gen.generate_Piste(ivato));
                
            // declaration des vols existantes 
                
                //Vol[] flights = gen.getData();
                
                // [x] Just all of the old data before i made the flight generator
                    /*Vol[] flights = new Vol[1];   
                    for(int op = 0; op < flights.length; op++){
                        flights[op] = new Vol();
                        flights[op].aterii = new Aterrissage();
                    } 

                    flights[0].simple_insert(5, debarquem, ivato.corps[0].avions[0]);
                        flights[0].arrivee_asa = new Heure(15, 30, 00);
                        flights[0].aterii.insert_speed(vitesses[0]);
                    flights[1].simple_insert(12, debarquem, ivato.corps[2].avions[1]);
                        flights[1].arrivee_asa = new Heure(06, 04, 00);
                        flights[1].aterii.insert_speed(vitesses[2]);
                    flights[2].simple_insert(6, debarquem, ivato.corps[1].avions[0]);
                        flights[2].arrivee_asa = new Heure(16, 45, 00);
                        flights[2].aterii.insert_speed(vitesses[1]);
                    flights[3].simple_insert(20, debarquem, ivato.corps[2].avions[3]);
                        flights[3].arrivee_asa = new Heure(15, 45, 00);
                        flights[3].aterii.insert_speed(vitesses[2]);
                    flights[4].simple_insert(15, debarquem, ivato.corps[1].avions[1]);
                        flights[4].arrivee_asa = new Heure(17, 8, 00);
                        flights[4].aterii.insert_speed(vitesses[0]);
                    flights[5].simple_insert(3, debarquem, ivato.corps[0].avions[1]);
                        flights[5].arrivee_asa = new Heure(14, 30, 00);
                        flights[5].aterii.insert_speed(vitesses[1]);*/

        // TODO utilisation des fonctions
            // test de la génération alétoire
                Meteo temps = new Meteo(1);
                ivato.setMeteo(temps);
            
            // utilisation du gestionnaire
                //ivato.getControl().insert(ivato, flights, ivato.getlPistes());
                //ivato.start_gestion();

        // TODO Affichage WERE
            //ivato.control.listVols[0].show_detail();
            //System.out.println("Nombre de piste : " + ivato.getlPistes().length);
            ivato.show_all_pistes(); 
            //ivato.show_data();
            //ivato.getControl().show_allpossible_quote();
            //ivato.show_ggestionInf();
            //ivato.show_all_compagnies();
            //ivato.getControl().show_all_possibility();
            System.out.println();
            Word_generator gned = new Word_generator();
            System.out.println(gned.generate_a_nouns_groups(6, 7));
    }
}