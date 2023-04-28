public class Spedizioni {
    public String denominazione;
    public String indirizzo;
    public String citta;
    public String nazione;
    public String numero;
    public String codice;


    public Spedizioni(String codice, String denominazione, String indirizzo, String citta, String nazione, String numero) {
        this.denominazione = denominazione;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.nazione = nazione;
        this.numero = numero;
        this.codice = codice;
    }


    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String  getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }



    @Override
    public String toString() {
        return "Spedizioni{" +
                ", codice='" + codice + '\'' +
                "denominazione='" + denominazione + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                ", nazione='" + nazione + '\'' +
                ", numero=" + numero +
                '}';
    }
}
