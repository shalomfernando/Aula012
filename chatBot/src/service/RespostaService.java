package service;

import dao.RespostaDao;
import pacote.PalavraChave;
import pacote.Resposta;

import java.util.*;

public class RespostaService {

    public static RespostaDao dao = new RespostaDao();

    public static  Resposta buscaRespostaApropriada(ArrayList<PalavraChave> palavraChaves) {
        ArrayList<Integer> idsPalavras = getPalvrasIds(palavraChaves);

        ArrayList<Resposta> respostas = dao.buscaRespostaPorPalavrasChaves(idsPalavras);

        ArrayList<Resposta> respostasPontuadas = obtemRespostasPontuadasPorRepeticao(respostas);

        Collections.sort(respostasPontuadas);

        if (respostasPontuadas.size() > 0) {
            return respostasPontuadas.get(0);
        }
        return null;
    }

    public static ArrayList<Integer> getPalvrasIds(ArrayList<PalavraChave> palavraChaves) {
        List<Integer> idsPalavras = new ArrayList<>();
        for (PalavraChave palavraChave : palavraChaves) {
            idsPalavras.add(palavraChave.getId());
        }
        return (ArrayList<Integer>) idsPalavras;
    }

    /**
     * Caso a resposta apareça mais de uma vez, ela terá uma pontuação maior, pois significa que ela estava associada
     * a mais palavras chaves que foram encontradas.
     * @param respostas as respostas a serem pontuadas
     */
    public static ArrayList<Resposta> obtemRespostasPontuadasPorRepeticao(List<Resposta> respostas) {
        Map<Integer, List<Resposta>> respostaMapPorId = new HashMap<>();
        for (Resposta resposta : respostas) {
            Integer id = resposta.getId();
            if (respostaMapPorId.containsKey(id)) {
                List<Resposta> respostaDoId = respostaMapPorId.get(id);
                respostaDoId.add(resposta);
            } else {
                List<Resposta> respostaDoId = new ArrayList<>();
                respostaDoId.add(resposta);
                respostaMapPorId.put(id, respostaDoId);
            }
        }

        List<Resposta> repostasPontuadas = new ArrayList<>();
        for (Map.Entry<Integer, List<Resposta>> entry : respostaMapPorId.entrySet()) {
            List<Resposta> respotasDoId = entry.getValue();
            Resposta resposta = respotasDoId.get(0);
            resposta.setPontuacao(respotasDoId.size());
            repostasPontuadas.add(resposta);
        }
        return (ArrayList<Resposta>) repostasPontuadas;
    }
}