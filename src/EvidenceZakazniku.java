import java.util.ArrayList;
import java.util.List;

public class EvidenceZakazniku {
    private List<Zakaznik> evidence = new ArrayList<>();



    public void pridatZakaznika(Zakaznik zakaznik) {
        evidence.add(zakaznik);
    }

    public void odeberZakaznika(Zakaznik zakaznik) {
        evidence.remove(zakaznik);
    }
    public void odeberPoslednihoZakaznika(){
        if(!evidence.isEmpty()){
            evidence.remove(evidence.size() - 1);
        }
    }



    public List<Zakaznik> getZakaznik() {
        return new ArrayList<>(evidence);
    }



    public List<Zakaznik> vyberZakazniky(int minimalniPocetProdeju) {
        List<Zakaznik> vybraniZakaznici = new ArrayList<>();
        for (Zakaznik zakaznik : evidence) {
            if (zakaznik.getPocetProdeju() >= minimalniPocetProdeju) {
                vybraniZakaznici.add(zakaznik);
            }
        }
        return vybraniZakaznici;
    }




    @Override
    public String toString() {
        return "EvidenceZakazniku{" +
                "evidence=" + evidence +
                '}';
    }
}