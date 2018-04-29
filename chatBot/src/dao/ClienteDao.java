package dao;

import pacote.Cliente;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {

	public int cadastroCliente(Cliente cli) {

		String sqlInsert = "INSERT INTO Cliente( Nome_Cliente, Email_Cliente) VALUES (?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, cli.getNome());
			stm.setString(2, cli.getEmail());
			
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					cli.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli.getId();
	}
	
	public Cliente carregarCliente(int id) {
		Cliente cli = new Cliente();
		cli.setId(id);
		String sqlSelect = "SELECT  Nome_Cliente, Email_Cliente FROM Cliente WHERE Cliente.ID_Cliente = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cli.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cli.setId(rs.getInt("id_cliente"));
					cli.setNome(rs.getString("nome_cliente"));
					cli.setEmail(rs.getString("email_cliente"));
				} else {
					cli.setId(-1);
					cli.setNome(null);
					cli.setEmail(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cli;
	}
}