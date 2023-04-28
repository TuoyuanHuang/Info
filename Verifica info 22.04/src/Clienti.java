import java.util.HashMap;

public class Clienti {
    public String nome;
    public String codice;
    static HashMap<String, String> datiClienti = new HashMap<>();
    public Clienti(String nome, String codice) {
        this.nome = nome;
        this.codice = codice;
    }

    public void aggiungi(Clienti c){
        datiClienti.put(c.getCodice(),c.getNome());
    }

    public void cancella(Clienti c){
        datiClienti.remove(c.getCodice());
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
