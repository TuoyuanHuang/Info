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

    public void inserisci(Spedizioni s1) { // inserisci una nuova spedizione
        ArraySpedizioni.add(s1);
        System.out.println("è stato aggiunto una nuova spedizione ");
    }

    public void cancellaSpedizione(String codice) { // cancella un elemento cercando il codice
        if (ArraySpedizioni.isEmpty()) {
            System.out.println("l'array è vuoto");
        } else {
            ArraySpedizioni.remove(ricerca(codice));
            System.out.println("rimmosso l'elemento: " + codice);
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

    public void aggiungi(Clienti c) {
        if (datiClienti.containsKey(c.getCodice())) { // check se è gia presente il
            System.out.println("c'e un elemento con lo stesso codice");
        } else {
            datiClienti.put( c.getCodice(),c.getNome());
            System.out.println("aggiunto il cliente");
        }
    }

    public void cancellaCliente(Clienti c) {
        if (datiClienti.containsKey(c.getCodice())) { // check se è gia presente il
            datiClienti.remove(c.getCodice());
            System.out.println("Il cliente è stato eliminato");
        } else {
            System.out.println("il cliente non esiste");
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

    public static void getNome(HashMap<String, String> map, String string) {
        String nome = map.get(string);
        System.out.println(nome);
    }
}