package ba.unsa.rpr.tutorijal7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {

    public static void ucitajGradove(){
        ArrayList<Grad> gradovi  =  new ArrayList<>();
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileReader("mjerenja.txt"));
            while(ulaz.hasNextLine()){ // citamo liniju po liniju
                String grad = ulaz.nextLine();
                String naziv = null;
                Double[] temperature = new Double[1000];
                int index = 0;
                for(; index < grad.length(); index++){ // ucitamo naziv grada
                    if(grad.charAt(index) == ','){
                        naziv = grad.substring(0, index);
                        break;
                    }
                }
                index++;
                int poc = -1;
                for(int i = 0; i < temperature.length && index < grad.length(); index++){ // prelazimo na prepisivanje temperatura
                    if(poc == -1) poc = index;
                    if(grad.charAt(index) == ',') {
                        temperature[i] = Double.parseDouble(grad.substring(poc, index));
                        i++;
                        poc = -1;
                    } else if(index == grad.length() - 1){
                        temperature[i] = Double.parseDouble(grad.substring(poc, index + 1));
                        break;
                    }
                }
                gradovi.add(new Grad(naziv, temperature));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka ulaz.txt ne postoji ili se ne može otvoriti");
        } finally{
            ulaz.close();
        }

    }

    public static void main(String[] args) {
        ucitajGradove();
    }
}
