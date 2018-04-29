package service;

import dao.PalavraChaveDao;
import pacote.PalavraChave;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 15/04/18.
 */
public class PalavraChaveService {

	public PalavraChaveDao dao = new PalavraChaveDao();

	public ArrayList<PalavraChave> encontraPalavrasChavesPorPergunta(String pergunta) {

		ArrayList<PalavraChave> palavraChaves = dao.buscaTodasPalavraChaves();
		ArrayList<PalavraChave> palavrasNaPergunta = new ArrayList<>();

		for (PalavraChave palavraChave : palavraChaves) {
			if (pergunta.equals(palavraChave.getPalavra())) {
				palavrasNaPergunta.add(palavraChave);

			}
		}
		return palavrasNaPergunta;
	}
}