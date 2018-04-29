package pacote;

public class PalavraChave {

    public int id;
    public String palavra;


   
	public PalavraChave() {
    }

    public PalavraChave(int id, String palavra) {
        this.id = id;
        this.palavra = palavra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}