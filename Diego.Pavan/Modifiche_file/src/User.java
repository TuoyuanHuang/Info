import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.border.EmptyBorder;

public class User {
    
    
    String nome;
    String cognome;
    String indirizzo;
    private int nomeLenght=20;
    private int cognomeLenght=20;
    private int indirizzoLenght=30;

    
    public User(String nome, String cognome, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int nextEmpty() throws IOException {
        RandomAccessFile f = new RandomAccessFile("..\\record.dat","rw");
        int s = 0;
        int c = 0;
        byte[]b=new byte[nomeLenght+cognomeLenght+indirizzoLenght];
        f.seek(0);
        s = f.read(b);
        while (s>=0){	
            s= f.read(b);			
            if(b.toString().equals(" ")){
                return c*(nomeLenght+cognomeLenght+indirizzoLenght);
            }
            c++;
         }
         return -1;
    }
}
