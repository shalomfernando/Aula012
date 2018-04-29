package dao;

import pacote.Resposta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 15/04/18.
 */
public class RespostaDao {

	/**
	 * A resposta que tiver mais de uma palavra chave associa e que está na lista de
	 * palavrasChavesIds, será retorna mais de uma vez
	 */
	public ArrayList<Resposta> buscaRespostaPorPalavrasChaves(List<Integer> palavrasChavesIds) {
		Resposta resp;
		ArrayList<Resposta> respostas = new ArrayList<>();
		String sql = "select r.ID_Respostas, r.respostas from respostas r join respostapalavrachave rp on (r.ID_Respostas = rp.ID_Respostas) where rp.ID_PalavraChave in (?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);) {
			for(int i = 0; i< palavrasChavesIds.size();i++) {
			stm.setInt(1, palavrasChavesIds.get(i));
			}
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					resp = new Resposta();
					resp.setId(rs.getInt("id_respostas"));
					resp.setValor(rs.getString("respostas"));
					respostas.add(resp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return respostas;
	}
	
}
