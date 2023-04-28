import java.util.HashMap;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Spedizioni s1= new Spedizioni("23133434","panino","via baglioni 33","Venezia","Italia","32325335");
        Spedizioni s2= new Spedizioni("231323","panino2","via baglioni 323","Venezia","Italia","32323135");
        Spedizioni s3= new Spedizioni("2313343","panino3","via baglioni 353","Venezia","Italia","32324335");
        Spedizioni s4= new Spedizioni("231313","panino4","via baglioni 343","Venezia","Italia","323233435");
        ArraySpedizioni ar = new ArraySpedizioni();
        ar.inserisci(s1);
        ar.inserisci(s2);
        ar.inserisci(s3);
        ar.inserisci(s4);
        System.out.println(ar.ricerca("231313"));
        System.out.println(ar.toString());
        System.out.println(ar.ricezione("2313343"));
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (i!=0){
            System.out.println("Premi 1 per inserire");
            System.out.println("Premi 2 per ricezione");
            System.out.println("Premi 3 per stampare tutti");
            System.out.println("Premi 4 per cancellare");
            System.out.println("Premi 0 per uscire");
            i=sc.nextInt();
            switch(i){
                case 1:
                    Spedizioni temp = new Spedizioni(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
                    ar.inserisci(temp);
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
                    ar.cancella(sc.next());
                    break;
            }
        }
    }
}