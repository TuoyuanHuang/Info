import java.rmi.server.SocketSecurityException;
import java.security.PublicKey;
import java.util.*;
import java.util.Map.Entry;

public class ArraySpedizioni {
    public ArrayList<Spedizioni> ArraySpedizioni;
    public HashMap<String, String > datiClienti;

    public ArraySpedizioni(HashMap< String,String> datiClienti) {
        this.ArraySpedizioni = new ArrayList<Spedizioni>();
        this.datiClienti = datiClienti;
    }

    public int ricerca(String codice) {
        if (ArraySpedizioni.isEmpty()) { // controllo se l'array è vuoto
            System.out.println("l'array è vuoto");
            return -1;
        } else {
            for (int i = 0; i < ArraySpedizioni.size(); i++) { // giro per tutti gli elemti
                if (ArraySpedizioni.get(i).getCodice().equals(codice)) {
                    return i;
                }
            }
        }
        System.out.println("il codice non è stato trovato");
        return -1;
    }

    public void inserisci(Spedizioni s1) throws ErroreSpedizioneGiaPresente{ // inserisci una nuova spedizione
        if(ArraySpedizioni.contains(s1)){
            throw new ErroreSpedizioneGiaPresente();
        }else{
            ArraySpedizioni.add(s1);
        }
    }

    public boolean cancellaSpedizione(String codice) { // cancella un elemento cercando il codice
        if (ArraySpedizioni.isEmpty()) {
            return false;
        } else {
            ArraySpedizioni.remove(ricerca(codice));
            return true;
        }

    }

    public String toString() { // stampa tutti gli elementi
        String s = "";
        if (ArraySpedizioni.isEmpty()) {
            System.out.println("Nessuna spedizione");
        } else {
            for (int i = 0; i != ArraySpedizioni.size(); i++) {
                Spedizioni p = ArraySpedizioni.get(i);
                s += p.toString() + "\n";
            }
        }
        return s;
    }


    public String ricezione(String codice) {// stampa un singolo elemento con il codice
        if (ArraySpedizioni.isEmpty()) {
            return "Nessuna spedizione";
        } else {
            String c = "";
            int s = ricerca(codice);
            Spedizioni p = ArraySpedizioni.get(s);
            c += p.toString() + "\n";
            return c;
        }
    }

    public boolean aggiungi(Clienti c) {
        if (datiClienti.containsKey(c.getCodice())) { // check se è gia presente il
            return false;
        } else {
            datiClienti.put( c.getCodice(),c.getNome());
            return true;
        }
    }

    public void cancellaCliente(Clienti c) throws ErroreClienteNonTrovato{
        if (datiClienti.containsKey(c.getCodice())) { // check se è gia presente il
            datiClienti.remove(c.getCodice());
        } else {
            throw new ErroreClienteNonTrovato();
        }
    }

    public static Set<String> getCodice(HashMap<String, String> map, String string) {
        Set<String> chiave = new HashSet<>();
        if (map.containsValue(string)) {
            for (Entry<String, String> entry : map.entrySet()) {
                if (Objects.equals(entry.getValue(), string)) {
                    chiave.add(entry.getKey());
                }
            }
        }
        return chiave;
    }

    public static String getNome(HashMap<String, String> map, String string) {
        return map.get(string);
    }
}