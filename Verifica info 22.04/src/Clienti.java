import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Clienti {
    public String nome;
    public String codice;

    public Clienti(String codice, String nome) {
        this.nome = nome;
        this.codice = codice;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

}
