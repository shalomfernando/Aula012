package service;


import pacote.PalavraChave;
import pacote.Resposta;

import java.util.ArrayList;


public class ChatService {

	public PalavraChaveService palavraChaveService = new PalavraChaveService();

	public RespostaService respostaService = new RespostaService();

	public Resposta buscaResposta(String pergunta) {

		
		ArrayList<PalavraChave> palavraChaves =  palavraChaveService.encontraPalavrasChavesPorPergunta(pergunta);
		
		
		return RespostaService.buscaRespostaApropriada(palavraChaves);
	}
}