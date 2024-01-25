package proce_gen;
import java.util.Random;

public class Word_generator {
    char[] char_list;
    Random rand;
    void insert_all_char(){
        this.char_list = new char[52];
        char_list[0] = 'a';     char_list[26] = 'A'; 
        char_list[1] = 'e';     char_list[27] = 'E'; 
        char_list[2] = 'i';     char_list[28] = 'I'; 
        char_list[3] = 'o';     char_list[29] = 'O';  
        char_list[4] = 'u';     char_list[30] = 'U'; 
        char_list[5] = 'y';     char_list[31] = 'Y'; 
        char_list[6] = 'b';     char_list[32] = 'B'; 
        char_list[7] = 'c';     char_list[33] = 'C'; 
        char_list[8] = 'd';     char_list[34] = 'D'; 
        char_list[9] = 'f';     char_list[35] = 'F'; 
        char_list[10] = 'g';    char_list[36] = 'G'; 
        char_list[11] = 'h';    char_list[37] = 'H'; 
        char_list[12] = 'j';    char_list[38] = 'J'; 
        char_list[13] = 'k';    char_list[39] = 'K'; 
        char_list[14] = 'l';    char_list[40] = 'L'; 
        char_list[15] = 'm';    char_list[41] = 'M'; 
        char_list[16] = 'n';    char_list[42] = 'N'; 
        char_list[17] = 'p';    char_list[43] = 'P'; 
        char_list[18] = 'q';    char_list[44] = 'Q'; 
        char_list[19] = 'r';    char_list[45] = 'R'; 
        char_list[20] = 's';    char_list[46] = 'S'; 
        char_list[21] = 't';    char_list[47] = 'U'; 
        char_list[22] = 'v';    char_list[48] = 'V'; 
        char_list[23] = 'w';    char_list[49] = 'W'; 
        char_list[24] = 'x';    char_list[50] = 'X'; 
        char_list[25] = 'z';    char_list[51] = 'Z'; 
    }
    public Word_generator(){
        this.insert_all_char();
        this.rand = new Random();
    }
    char get_n_char(int n){
        if(n >= this.char_list.length){
            return ' ';
        }else{
            return this.char_list[n];
        }
    }    
    public String generate_alea_Noun(int length){
        String retrString = "";
        int[] dds = new int[3];
        dds[0] = 2;
        dds[1] = 3;
        dds[2] = 5;
        for(int op = 0; op < length; op++){
            if(op == 0){
                retrString = retrString + get_n_char((rand.nextInt(51) % 26) + 26);
            }else{
                if((op % dds[rand.nextInt(2)]) == 0){
                    retrString = retrString + get_n_char(rand.nextInt(5));
                }else{
                    retrString = retrString + get_n_char(rand.nextInt(26));
                }
            }
        }
        return retrString;
    }
    public String generate_alea_NounNC(int length){
        String retrString = "";
        int[] dds = new int[3];
        dds[0] = 2;
        dds[1] = 3;
        dds[2] = 5;
        for(int op = 0; op < length; op++){
            if((op % dds[rand.nextInt(2)]) == 0){
                retrString = retrString + get_n_char(rand.nextInt(5));
            }else{
                retrString = retrString + get_n_char(rand.nextInt(26));                
            }
        }
        return retrString;
    }
    public String generate_a_nouns_groups(int nb_nouns, int max_N_length){
        String returns = "";
        for(int op = 0; op < nb_nouns; op++){
            if(op == 0){
                returns = returns + generate_alea_Noun(rand.nextInt(max_N_length));
                returns = returns + " ";
            }else{
                returns = returns + generate_alea_NounNC(rand.nextInt(max_N_length));
                returns = returns + " ";
            }
        }
        return returns;   
    }
}
