package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Pais {
	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Pais (){
	
	}
	public Pais(int id, String nome, long populacao, double area ) {
		
		this.id= id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
		
		
	}
	public static Connection obtemConexao() throws SQLException {
		  String servidor = "localhost";
	      String porta = "3306";
	      String database = "pais";
	      String usuario = "root";
	      String senha = "alunos";

		return DriverManager
				.getConnection("jdbc:mysql://"+servidor+":"+porta+"/"+database+"?user="+usuario+"&password="+senha);
	}
	public void criar(){
		
		String SqlInsert ="INSERT INTO pais(id, nome, populacao, area) VALUE (?, ?, ?, ?)";
		try (Connection conn = obtemConexao(); 
				PreparedStatement stm = conn.prepareStatement(SqlInsert);) {
			stm.setInt(1 , getId());
			stm.setString(2 , getNome());
			stm.setLong(3 , getPopulacao());
			stm.setDouble(4 , getArea());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizar() {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.setInt(4, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir() {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregar() {
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
				
				}else {
					setId(-1);
					setNome(null);
					setPopulacao(-1);
					setArea(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
	
	public Pais maiorPopulacao() {
		Pais populacao = new Pais();
		String sqlSelect = "SELECT MAX(populacao) FROM Pais";
		
		try(Connection conn = obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try(ResultSet rs = stm.executeQuery()) {
				if(rs.next()) {
					populacao.setPopulacao(rs.getLong("populacao"));
				}
				else {
					populacao.setPopulacao(-1);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return populacao;
	}
	
	public Pais menorArea() {
		Pais area = new Pais();
		String sqlSelect = "SELECT MIN(area) FROM Pais";
		
		try(Connection conn = obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try(ResultSet rs = stm.executeQuery()) {
				if(rs.next()) {
					area.setArea(rs.getDouble("area"));
				}
				else {
					area.setArea(-1);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return area;
	}
	
	public ArrayList<Pais> vetorTresPaises() {
		Connection conn = null;
		try {
			conn = obtemConexao();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		 String sqlSelect = "SELECT * FROM Pais";
		PreparedStatement prepare = null;
		ResultSet result = null;
		ArrayList<Pais> lista = new ArrayList<Pais>();
		try {
			prepare = conn.prepareStatement(sqlSelect);
			result = prepare.executeQuery();
			while (result.next()) {
				Pais pais = new Pais();
				pais.setNome(result.getString("Brasil"));
				pais.setNome(result.getString("Japão"));
				pais.setNome(result.getString("Bolívia"));
				lista.add(pais);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (int) (populacao ^ (populacao >>> 32));
		return result;
	}
	@Override
	public String toString() {
	return "Pais [id=" + id + ", nome=" + nome + ", populacao=" + populacao + ", area =" + area + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (populacao != other.populacao)
			return false;
		return true;
	}

}


