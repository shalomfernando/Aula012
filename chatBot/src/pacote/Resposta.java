package pacote;

public class Resposta implements Comparable<Resposta> {

	public Integer id;

	public String valor;

	public Integer pontuacao = 0;

	public Resposta() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	@Override
	public int compareTo(Resposta r) {
		if (this.pontuacao < r.pontuacao)
			return -1;
		else if (this.pontuacao == r.pontuacao)
			return 0;
		else
			return -1;
	}
}