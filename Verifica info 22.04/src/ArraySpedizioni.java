import java.rmi.server.SocketSecurityException;
import java.util.ArrayList;

public class ArraySpedizioni {
    public ArrayList<Spedizioni> ArraySpedizioni;

    public ArraySpedizioni() {
        this.ArraySpedizioni = new ArrayList<Spedizioni>();
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

    public void cancella(String codice) { // cancella un elemento cercando il codice
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
}