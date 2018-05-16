package service;

import java.util.ArrayList;

import Dao.PaisDao;
import pacote.Pais;

public class vendedorService {

	PaisDao dao;
	
	public vendedorService(){
		dao = new PaisDao();
	}
	public ArrayList<Pais> listarPais(){
		return dao.listarPais();
	}
	public ArrayList<Pais> listarPais(String chave){
		return dao.listarPais(chave);
	}

}
