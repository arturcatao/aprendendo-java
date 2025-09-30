package lab3FilmNow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filmnow.FilmNow;

class FilmNowTeste {
	
	private FilmNow fn;
	
	@BeforeEach
	void setUp() {
		fn = new FilmNow();
	}
	
	// TESTES CADASTRA FILME
	@Test
	void testCadastrarFilme() {
		assertEquals(fn.cadastraFilme(1, "A", "0", "A"), "FILME ADICIONADO");
	}
	
	@Test
	void testCadastrarFilmeMenorPosicao() {
		assertEquals(fn.cadastraFilme(1, "A", "0", "A"), "FILME ADICIONADO");
	}
	
	@Test
	void testCadastrarFilmeMaiorPosicao() {
		assertEquals(fn.cadastraFilme(100, "A", "0", "A"), "FILME ADICIONADO");
	}
	
	@Test
	void testCadastrarFilmePosicaoMenor() {
		assertEquals(fn.cadastraFilme(0, "A", "0", "A"), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testCadastrarFilmePosicaoMaior() {
		assertEquals(fn.cadastraFilme(101, "A", "0", "A"), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testCadastrarFilmeJaAdicionado() {
		assertEquals(fn.cadastraFilme(1, "A", "0", "A"), "FILME ADICIONADO");
		assertEquals(fn.cadastraFilme(2, "A", "0", "A"), "FILME JÁ ADICIONADO");
	}
	@Test
	void testCadastrarFilmeJaAdicionado2() {
		assertEquals(fn.cadastraFilme(1, "A", "0", "A"), "FILME ADICIONADO");
		assertEquals(fn.cadastraFilme(2, "A", "0", "B"), "FILME JÁ ADICIONADO");
	}
	
	@Test
	void testCadastrarFilmeJaAdicionado3() {
		assertEquals(fn.cadastraFilme(1, "A", "0", "A"), "FILME ADICIONADO");
		assertEquals(fn.cadastraFilme(2, "A", "1", "A"), "FILME ADICIONADO");
	}
	
	@Test
	void testCadastrarFilmeJaAdicionado4() {
		assertEquals(fn.cadastraFilme(1, "A", "0", "A"), "FILME ADICIONADO");
		assertEquals(fn.cadastraFilme(2, "B", "0", "A"), "FILME ADICIONADO");
	}
	
	@Test
	void testCadastrarFilmeTroca() {
		assertEquals(fn.cadastraFilme(1, "A", "0", "A"), "FILME ADICIONADO");
		assertEquals(fn.cadastraFilme(1, "B", "0", "A"), "FILME ADICIONADO");
		assertEquals(fn.detalharFilme(1), "\nDados do filme:\n" + "B" + ", " + "0" + "\n" + "A");
	}
	
	@Test
	void testCadastrarFilmeJaAdicionadoTroca() {
		assertEquals(fn.cadastraFilme(1, "A", "0", "A"), "FILME ADICIONADO");
		assertEquals(fn.cadastraFilme(1, "A", "0", "A"), "FILME ADICIONADO");
	}
	
	
	@Test
	void testCadastrarFilmeLocalVazio() {
		assertEquals(fn.cadastraFilme(1, "A", "0", ""), "FILME ADICIONADO");
	}
	
	@Test
	void testCadastrarFilmeAnoVazio() {
		assertEquals(fn.cadastraFilme(1, "A", "", "A"), "FILME ADICIONADO");
	}
	
	@Test
	void testCadastrarFilmeNomeVazio() {
		assertEquals(fn.cadastraFilme(1, "", "0", "A"), "FILME INVALIDO");
	}
	
	// Testes de detalharFilme()
	@Test
	void testDetalharFilmes() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.detalharFilme(1), "\nDados do filme:\nInterstellar, 2014\nEUA");
	}
	
	@Test
	void testDetalharFilmesSemAno() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.detalharFilme(1), "\nDados do filme:\nInterstellar\nEUA");
	}
	
	@Test
	void testDetalharFilmesSemLocal() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", ""), "FILME ADICIONADO");
		assertEquals(fn.detalharFilme(1), "\nDados do filme:\nInterstellar, 2014"); 
	}
	
	@Test
	void testDetalharFilmesPosicaoMaior() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.detalharFilme(101), "\nPOSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testDetalharFilmesPosicaoMenor() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.detalharFilme(0), "\nPOSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testDetalharFilmesPosicaoSemNada() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.detalharFilme(2), "");
	}
	
	@Test
	void testDetalharFilmesHot() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 1), "ADICIONADO À HOTLIST NA POSIÇÃO 1!");
		assertEquals(fn.detalharFilme(1), "\nDados do filme:\n🔥 Interstellar, 2014\nEUA");
	}
	
	//Testes de mostrarFilmes()

	@Test
	void testMostraFilmes() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.mostrarFilmes(), "\n1 - Interstellar");
	}
	
	@Test
	void testMostraFilmes2() {
		assertEquals(fn.cadastraFilme(50, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.mostrarFilmes(), "\n50 - Interstellar");
	}
	
	@Test
	void testMostraFilmes3() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.cadastraFilme(2, "Star Wars IV", "1977", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.mostrarFilmes(), "\n1 - Interstellar\n2 - Star Wars IV");
	}
	
	@Test
	void testMostraFilmes4() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.cadastraFilme(65, "Star Wars IV", "1977", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.mostrarFilmes(), "\n1 - Interstellar\n65 - Star Wars IV");
		
	}
	
	@Test
	void testMostraFilmes5() {
				assertEquals(fn.mostrarFilmes(), "");
	}
	
	//Testes HotList()
	
	@Test
	void testHotList() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 1), "ADICIONADO À HOTLIST NA POSIÇÃO 1!");
		assertEquals(fn.detalharFilme(1), "\nDados do filme:\n🔥 Interstellar, 2014\nEUA");
	}
	
	@Test
	void testHotList2() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(2, 6), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testHotList3() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 5), "ADICIONADO À HOTLIST NA POSIÇÃO 5!");
		assertEquals(fn.cadastraFilme(2, "Star Wars", "1977", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(2, 5), "ADICIONADO À HOTLIST NA POSIÇÃO 5!");
		assertEquals(fn.detalharFilme(1), "\nDados do filme:\nInterstellar, 2014\nEUA");
	}
	
	@Test
	void testHotListRmFilme() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 1), "ADICIONADO À HOTLIST NA POSIÇÃO 1!");
		assertTrue(fn.removerHot(1));
	}
	
	@Test
	void testHotListRmFilme2() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 1), "ADICIONADO À HOTLIST NA POSIÇÃO 1!");
		assertFalse(fn.removerHot(2));
	}
	
	@Test
	void testHotListGetQtd1() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 1), "ADICIONADO À HOTLIST NA POSIÇÃO 1!");
		assertEquals(fn.getQtdHotList(), 1);
	}
	
	@Test
	void testHotListGetQtd2() {
		assertEquals(fn.getQtdHotList(), 0); 
	}
	
	@Test
	void testHotListExibir() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 1), "ADICIONADO À HOTLIST NA POSIÇÃO 1!");
		assertEquals(fn.exibirHotList()[0], "1 - Interstellar, 2014");
	}
	
	@Test
	void testHotListExibir2() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 5), "ADICIONADO À HOTLIST NA POSIÇÃO 5!");
		assertEquals(fn.cadastraFilme(2, "Star Wars", "1977", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(2, 1), "ADICIONADO À HOTLIST NA POSIÇÃO 1!");
		assertEquals(fn.exibirHotList()[1], "5 - Interstellar, 2014");
		assertEquals(fn.exibirHotList()[0], "1 - Star Wars, 1977");

	}
	
	@Test
	void testHotListExibirVazia() {
		assertArrayEquals(fn.exibirHotList(), new String[0]);
	}
	
	@Test
	void testHotListCadastroPosMaior() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(101, 1), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testHotListCadastroPosMenor() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(0, 1), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testHotListCadastroPosMaiorHot() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 11), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testHotListCadastroPosMenorHot() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 0), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testHotListCadastroMenorPosHot() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 1), "ADICIONADO À HOTLIST NA POSIÇÃO 1!");
	}
	
	@Test
	void testHotListCadastroMaiorPosHot() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 10), "ADICIONADO À HOTLIST NA POSIÇÃO 10!");
	}
	
	@Test
	void testHotListFilmeJaAdicionado() {
		assertEquals(fn.cadastraFilme(1, "Interstellar", "2014", "EUA"), "FILME ADICIONADO");
		assertEquals(fn.atribuirHot(1, 1), "ADICIONADO À HOTLIST NA POSIÇÃO 1!");
		assertEquals(fn.atribuirHot(1, 3), "FILME JÁ ADICIONADO");
	}
}
