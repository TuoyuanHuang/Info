import java.io.*;
import java.util.*;
import java.util.Collection;

public class HashMapSort {
    static HashMap<String, String> dati = new HashMap<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Dati.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    if (!dati.containsKey(parts[0])) {
                        dati.put(parts[0], parts[1]);
                    }
                }

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
            return;
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("dati.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dati);
            out.close();
            fileOut.close();
            System.out.println("Dati serializzati salvati in dati.ser");
        } catch (IOException e) {
            System.out.println("Errore durante la serializzazione dei dati: " + e.getMessage());
        }

        ricerca("3667890123");
        ricerca("3665432190");
        ricerca("3330123456");
        ricerca("3209876543");
        ricerca("3897654321");
        ricerca("3770123456");
        ricerca("3490123456");
        ricerca("3387654321");
        ricerca("3778901234");
        ricerca("3498765432");

        ricercaDaNome(" Gabriele Damico");
        ricercaDaNome(" Valentina De Angelis");
        ricercaDaNome(" Gabriele Damico");
        ricercaDaNome(" Martina Marchetti");
        ricercaDaNome(" Marco Costa");
        ricercaDaNome(" Chiara Damico");
        ricercaDaNome(" Sofia Greco");
        ricercaDaNome(" Davide Ruggiero");
        stampaHashMapConIteratore();
        stampaHashMapConValues();
        String[] stringhe = estraiStringhe(dati);
        System.out.println(Arrays.toString(stringhe));

        HashMapStringExtractor extractor = new HashMapStringExtractor();
        System.out.println(extractor.extractStrings(dati));

    }

    public static void ricerca(String chiave) {
        if (dati.containsKey(chiave)) {
            long startTime = System.nanoTime();
            Object result = dati.get(chiave);
            long endTime = System.nanoTime();
            System.out.println(
                    "Ricerca della chiave " + chiave + " ha impiegato " + (endTime - startTime) + " nanosecondi");
        } else {
            System.out.println("La chiave " + chiave + " non esiste nella mappa dati.");
        }
    }

    public static void ricercaDaNome(String nome) {
        String key = null;
        for (Map.Entry<String, String> entry : dati.entrySet()) {
            if (entry.getValue().equals(nome)) {
                key = entry.getKey();
                break;
            }
        }
        if (key != null) {
            long startTime = System.nanoTime();
            String result = dati.get(key);
            long endTime = System.nanoTime();
            System.out.println("Il numero di telefono corrispondente al nome " + nome + " è " + result
                    + " e la ricerca ha impiegato " + (endTime - startTime) + " nanosecondi.");
        } else {
            System.out.println("Non è stato trovato un numero di telefono corrispondente al nome " + nome + ".");
        }
    }

    public static void stampaHashMapConIteratore() {
        Iterator<Map.Entry<String, String>> iterator = dati.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("Chiave: " + entry.getKey() + ", Valore: " + entry.getValue());
        }
    }

    public static void stampaHashMapConValues() {
        for (String valore : dati.values()) {
            System.out.println("Valore: " + valore);
        }

    }

    public static String[] estraiStringhe(HashMap<String, String> hashMap) {
        // creazione di un array di stringhe della stessa dimensione della HashMap
        String[] stringhe = new String[hashMap.size()];

        // estrazione delle stringhe dalla HashMap utilizzando il metodo values() e
        // toArray(T[] a)
        stringhe = hashMap.values().toArray(stringhe);

        return stringhe;
    }

    public static class HashMapStringExtractor {

        public static Collection<String> extractStrings(HashMap<String, String> hashMap) {
            return hashMap.values();
        }
    }
}