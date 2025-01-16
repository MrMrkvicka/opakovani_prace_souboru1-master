import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {




        Zakaznik zakaznik1 = new Zakaznik("Jirka", LocalDate.of(2000,12,1), "Praha",50);
        Zakaznik zakaznik2 = new Zakaznik("Tonda", LocalDate.of(2005,10,7), "Brno",75);


        EvidenceZakazniku evidence = new EvidenceZakazniku();
        evidence.pridatZakaznika(zakaznik1);
        evidence.pridatZakaznika(zakaznik2);
        //evidence.odeberPoslednihoZakaznika();
     /*   System.out.println(evidence);*/






        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("src//Soubor.txt")))){
            for(Zakaznik zakaznik: evidence.getZakaznik()){
                writer.println(zakaznik.getJmeno() + ":" + zakaznik.getDatumNarozeni() + ":" + zakaznik.getMesto() + ":" + zakaznik.getPocetProdeju());

            }
        }


        catch (IOException e){
            System.err.println(e.getLocalizedMessage());
        }

        EvidenceZakazniku kolekce = new EvidenceZakazniku();

        final String ODDELOVAC = ":";

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("src//Soubor.txt")))){
            while(scanner.hasNextLine()){
                String radek = scanner.nextLine();
                String[] casti = radek.split(ODDELOVAC);
                String jmeno = casti[0];
                LocalDate datum = LocalDate.parse(casti[1]);
                String mesto = casti[2];
                int pocetProdeju = Integer.parseInt(casti[3]);
                kolekce.pridatZakaznika(new Zakaznik(jmeno,datum,mesto,pocetProdeju));
            }
        }

        catch(FileNotFoundException e){
            System.err.println(e.getLocalizedMessage());
        }



        //System.out.println(kolekce);

       // System.out.println(kolekce.vyberZakazniky(4));

        int vsechnyProdeje = 0;
        int pocet = 0;
        for (Zakaznik zakaznik : evidence.vyberZakazniky(4)){
            if ("Praha".equals(zakaznik.getMesto())){
                vsechnyProdeje += zakaznik.getPocetProdeju();
                pocet++;
            }
        }
        System.out.println("Průměrný počet prodejů: " + (double)vsechnyProdeje/pocet);



    }
}