package dao;

public class ChatBDao {

	private static final String INSERT_ATENDENTE = "INSERT INTO atendente(Nome_Atendente, Email_Atendente, CPF_Atendente,"
            + " RG_Atendente, Telefone_Atendente, Status_Atendente, Senha_Atendente ) VALUES (?, ?, ?,?, ?, ?, ?)";

//	public int cadastroAtendente(Atendente at) {
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//			 PreparedStatement stm = conn.prepareStatement(INSERT_ATENDENTE)) {
//
//			stm.setString(1, at.getNome());
//			stm.setString(2, at.getEmail());
//			stm.setString(3, at.getCpf());
//			stm.setString(4, at.getRg());
//			stm.setString(5, at.getTelefone());
//			stm.setString(6, at.getStatus());
//			stm.setString(7, at.getSenha());
//			stm.execute();
//			String sqlQuery = "SELECT LAST_INSERT_ID()";
//			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
//					ResultSet rs = stm2.executeQuery();) {
//				if (rs.next()) {
//					at.setId(rs.getInt(1));
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return at.getId();
//	}
//	/*
//	public int cadastroAtendimento(ChatB chat) {
//		String sqlInsert = "INSERT INTO Atendimento( Status_Atendimento) VALUES (?)";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
//			stm.setString(1, chat.getStatus());
//			stm.execute();
//			String sqlQuery = "SELECT LAST_INSERT_ID()";
//			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
//					ResultSet rs = stm2.executeQuery();) {
//				if (rs.next()) {
//					chat.setId(rs.getInt(1));
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return chat.getId();
//	}
//	*/
//	public int cadastroCliente(Cliente cli) {
//		String sqlInsert = "INSERT INTO Cliente( Nome_Cliente, Email_Cliente) VALUES (?,?)";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
//			stm.setString(1, cli.getNome());
//			stm.setString(2, cli.getEmail());
//			stm.execute();
//			String sqlQuery = "SELECT LAST_INSERT_ID()";
//			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
//					ResultSet rs = stm2.executeQuery();) {
//				if (rs.next()) {
//					cli.setId(rs.getInt(1));
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return cli.getId();
//	}
//
//	public int cadastroMenssagem(Menssagem msg) {
//		String sqlInsert = "INSERT INTO message ( username, message) VALUES (?,?)";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
//			stm.setString(1, msg.getNome());
//			stm.setString(2, msg.getMenssagem());
//			stm.execute();
//			String sqlQuery = "SELECT LAST_INSERT_ID()";
//			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
//					ResultSet rs = stm2.executeQuery();) {
//				if (rs.next()) {
//					msg.setId(rs.getInt(1));
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return msg.getId();
//	}
//
///*
//	public void atualizarCliente(ChatB chat) {
//		String sqlUpdate = "UPDATE Cliente SET Nome_Cliente=?, Email_Cliente=? WHERE id=?";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
//			stm.setString(1, chat.getNome());
//			stm.setString(2, chat.getEmail());
//			stm.execute();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
///*
//	public void excluirAtendente(int id) {
//		String sqlDelete = "DELETE FROM Atendente  WHERE idAtendente = ?";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
//			stm.setInt(1, id);
//			stm.execute();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//*/
//	public Cliente carregarCliente(int id) {
//		Cliente cli = new Cliente();
//		cli.setId(id);
//		String sqlSelect = "SELECT  Nome_Cliente, Email_Cliente FROM Cliente WHERE Cliente.ID_Cliente = ?";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
//			stm.setInt(1, cli.getId());
//			try (ResultSet rs = stm.executeQuery();) {
//				if (rs.next()) {
//					cli.setNome(rs.getString("nome_cliente"));
//					cli.setEmail(rs.getString("email_cliente"));
//				} else {
//					cli.setId(-1);
//					cli.setNome(null);
//					cli.setEmail(null);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e1) {
//			System.out.print(e1.getStackTrace());
//		}
//		return cli;
//	}
//
//	/*
//	public ChatB carregarRespotas(int id) {
//		ChatB chat = new ChatB();
//		chat.setId(id);
//		String sqlSelect = "SELECT Respostas FROM Respotas WHERE Respotas.ID_Respostas = ?";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
//			stm.setInt(1, chat.getId());
//			try (ResultSet rs = stm.executeQuery();) {
//				if (rs.next()) {
//					chat.setRespostas(rs.getString("Respostas"));
//				} else {
//					chat.setRespostas(null);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e1) {
//			System.out.print(e1.getStackTrace());
//		}
//		return chat;
//	}
//
//	public ChatB carregarAtendente(int id) {
//		ChatB chat = new ChatB();
//		chat.setId(id);
//		String sqlSelect = "SELECT Nome_Atendente, Email_Atendente, CPF_Atendente,RG_Atendente, "
//				+ "Telefone_Atendente, Status_Atendente, Senha_Atendente FROM Atendente  WHERE Atendente .idAtendente = ?";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
//			stm.setInt(1, chat.getId());
//			try (ResultSet rs = stm.executeQuery();) {
//				if (rs.next()) {
//					chat.setNome(rs.getString("nome"));
//					chat.setEmail(rs.getString("Email"));
//					chat.setCPF(rs.getString("CPF"));
//					chat.setRG(rs.getString("RG"));
//					chat.setTelefone(rs.getString("Telefone"));
//					chat.setStatus(rs.getString("status"));
//					chat.setSenha(rs.getString("senha"));
//				} else {
//					chat.setNome(null);
//					chat.setEmail(null);
//					chat.setCPF(null);
//					chat.setRG(null);
//					chat.setTelefone(null);
//					chat.setStatus(null);
//					chat.setSenha(null);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e1) {
//			System.out.print(e1.getStackTrace());
//		}
//		return chat;
//	}
//
//	public ChatB carregarRespotas2(int id) {
//		ChatB chat = new ChatB();
//		chat.setId(id);
//		String sqlSelect = "SELECT Respostas FROM Respotas WHERE Respotas.ID_Respostas = ?";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
//			stm.setInt(1, chat.getId());
//			try (ResultSet rs = stm.executeQuery();) {
//				if (rs.next()) {
//					chat.setRespostas(rs.getString("Respostas"));
//				} else {
//					chat.setRespostas(null);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e1) {
//			System.out.print(e1.getStackTrace());
//		}
//		return chat;
//	}
//*/
//	public PalavraChave chamarPalavra(PalavraChave frase) {
//		PalavraChave pl = new PalavraChave();
//		pl.setPalavra(frase);
//		String sqlSelect = "SELECT  ID_PalavraChave, PalavraChave FROM Cliente WHERE Cliente.ID_PalavraChave = ?";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
//			stm.setInt(1, pl.getId());
//			try (ResultSet rs = stm.executeQuery();) {
//				if (rs.next()) {
//					pl.setId(rs.getInt("id"));
//					pl.setPalavra(rs.getString("PalavraChave"));
//				} else {
//					pl.setId(-1);
//					pl.setPalavra(null);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e1) {
//			System.out.print(e1.getStackTrace());
//		}
//		return pl;
//	}
}