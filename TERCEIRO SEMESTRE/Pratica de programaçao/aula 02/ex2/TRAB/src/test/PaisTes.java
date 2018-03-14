package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ex1.Pais;

@SuppressWarnings("unused")
public class PaisTes {


	Pais pais, copia;
	int id = 0;
	
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais(id, "Italia", 2077, 301338);
		copia = new Pais(id, "Italia", 2077, 301338 );
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		
			Pais fixture = new Pais(1, "Brasil", 208, 8516000);
			Pais novo = new Pais(1, null, -1, -1);
			novo.carregar();
			assertEquals("testa inclusao", novo, fixture);
		
	}
	@Test
	public void test01Criar() {
		System.out.println("criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);

	/*	
    pais = new Pais(8, "Italia", 91, 12345.12000);
    pais.setId(8);
    pais.setNome("italia");
    pais.setPopulacao(91);
    pais.setArea(12345.12000);
    pais.criar();
    System.out.println(pais);
    assertEquals("testa criacao", pais, copia);

*/
	}
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(208);
		copia.setPopulacao(208);
		pais.atualizar();
		pais.carregar();
		
		
	}
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(-1);
		copia.setArea(-1);
		pais.excluir();
		pais.carregar();
		assertEquals("testa exclusao", pais, copia);
		
		
 
	}
	
	public void testeMaiorPop() {
		System.out.println("Maior população");
		Pais teste = new Pais(1, "Estados Unidos", 323, 8516000.00);
		Pais novoPais = new Pais();
		novoPais = novoPais.maiorPopulacao();
		assertEquals("Teste de maior população", teste, novoPais);
		
	}
	
	public void testeMenorArea() {
		System.out.println("Menor área");
		Pais teste = new Pais(5,"Portugal",1032,92212);
		Pais novoPais = new Pais();
		novoPais = novoPais.menorArea();
		assertEquals("Teste de menor área", teste, novoPais);
	}
	
	
	@Test
	public void testeVetorTresPaises() {
		
		Pais teste[] = new Pais[3];
		teste[0] = new Pais(1, "Brasil", 207, 8516000);
		teste[1] = new Pais(2,"Argentina",4385,2780000.00);
		teste[2] = new Pais(3,"Bolivia",1089,1099000.00);
		ArrayList<Pais> novo = new ArrayList<>();
        Pais novoPais = new Pais();
        System.out.println("vetorTresPaises" +teste[0]+"\n "+teste[1]+"\n"+teste[2]);
        novo = novoPais.vetorTresPaises();
		for (int i = 0; i < novo.size(); i++) {
			assertEquals("Teste de menor área", teste, novoPais);
		}
		
	}
	
	

}

