import java.util.*;

public class Tester {
    public static void main(String[] args) {
        Spedizioni s1 = new Spedizioni("23133434", "panino", "via baglioni 33", "Venezia", "Italia", "32325335");
        Spedizioni s2 = new Spedizioni("231323", "panino2", "via baglioni 323", "Venezia", "Italia", "32323135");
        Spedizioni s3 = new Spedizioni("2313343", "panino3", "via baglioni 353", "Venezia", "Italia", "32324335");
        Spedizioni s4 = new Spedizioni("231313", "panino4", "via baglioni 343", "Venezia", "Italia", "323233435");
        Clienti c1 = new Clienti("1", "banana1");
        Clienti c2 = new Clienti("2", "banana2");
        Clienti c3 = new Clienti("3", "banana3");
        Clienti c4 = new Clienti("4", "banana4");
        HashMap<String, String> map = new HashMap<>();
        ArraySpedizioni ar = new ArraySpedizioni(map);
        ar.aggiungi(c1);
        ar.aggiungi(c4);
        ar.aggiungi(c3);
        ar.aggiungi(c2);
        for (String chiave : ar.getCodice(map, "banana2")) {
            System.out.println(chiave);
        }
        ar.inserisci(s1);
        ar.inserisci(s2);
        ar.inserisci(s3);
        ar.inserisci(s4);
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (i != 0) {
            System.out.println("Premi 1 per inserire una spedizione");
            System.out.println("Premi 2 per ricezione");
            System.out.println("Premi 3 per stampare tutte le spedizioni");
            System.out.println("Premi 4 per cancellare una spedizione");
            System.out.println("Premi 5 per aggiungere un cliente");
            System.out.println("Premi 6 per rimuovere un cliente");
            System.out.println("Premi 7 per stampare il nome di un cliente dal codice");
            System.out.println("Premi 8 per stampare il codice di un cliente dal nome");
            System.out.println("Premi 0 per uscire");
            i = sc.nextInt();
            switch (i) {
                case 1:
                    Spedizioni tempSpedizioni = new Spedizioni(sc.next(), sc.next(), sc.next(), sc.next(),
                            sc.next(), sc.next());
                    ar.inserisci(tempSpedizioni);
                    break;
                case 2:
                    System.out.println("inserisci codice");
                    System.out.println(ar.ricezione(sc.next()));
                    break;
                case 3:
                    System.out.println(ar.toString());
                    break;
                case 4:
                    System.out.println("inserisci il codice della spedizione da cancellare");
                    ar.cancellaSpedizione(sc.next());
                    break;
                case 5:
                    System.out.println("inserisci il codice e nome del cliente");
                    Clienti tempClienti = new Clienti(sc.next(), sc.next());
                    break;
                case 6:
                    System.out.println("inserisci il codice e nome del cliente da cancellare");
                    Clienti tempCancellaClienti = new Clienti(sc.next(), sc.next());
                    ar.cancellaCliente(tempCancellaClienti);
                    break;
                case 7:
                    System.out.println("inserisci il codice del cliente");
                    ar.getNome(map, sc.next());
                    break;
                case 8:
                    System.out.println("inserisci la chiave del cliente");
                    System.out.println(ar.getCodice(map, sc.next()));
                    break;
            }
        }

    }
}