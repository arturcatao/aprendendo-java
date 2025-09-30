package lab3FilmNow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filmnow.Filme;
import filmnow.HotList;

class HotListTest {

	private HotList hl;
	
	@BeforeEach
	void setUp() {
		hl = new HotList();
	}
	
	@Test
	void testHotList() {
		assertArrayEquals(hl.exibir(), new String[0]);
	}
	
	
	@Test
	void testHotListAddFilme() {
		Filme filme = new Filme("Interstellar", "2014", "EUA");
		assertTrue(hl.addFilme(filme, 1));
	}
	
	@Test
	void testHotListAddFilmePosMaior() {
		Filme filme = new Filme("Interstellar", "2014", "EUA");
		assertFalse(hl.addFilme(filme, 11));
	}
	
	@Test
	void testHotListAddFilmePosMenor() {
		Filme filme = new Filme("Interstellar", "2014", "EUA");
		assertFalse(hl.addFilme(filme, 0));
	}
	
	@Test
	void testHotListAddFilmeMaiorPos() {
		Filme filme = new Filme("Interstellar", "2014", "EUA");
		assertTrue(hl.addFilme(filme, 10));
	}
	
	@Test
	void testHotListAddFilmeMenorPos() {
		Filme filme = new Filme("Interstellar", "2014", "EUA");
		assertTrue(hl.addFilme(filme, 1));
	}
	
	@Test
	void testHotListRmFilme() {
		Filme filme = new Filme("Interstellar", "2014", "EUA");
		assertTrue(hl.addFilme(filme, 1));
		assertTrue(hl.rmvFilme(1));
	}
	
	@Test
	void testHotListRmFilme2() {
		assertFalse(hl.rmvFilme(2));
	}
	
	@Test
	void testHotListGetQtd1() {
		Filme filme = new Filme("Interstellar", "2014", "EUA");
		hl.addFilme(filme, 1);
		assertEquals(hl.getQtdFilmes(), 1);
	}
	
	@Test
	void testHotListGetQtd2() {
		Filme filme = new Filme("Interstellar", "2014", "EUA");
		Filme filme2 = new Filme("Star Wars", "1977", "EUA");
		hl.addFilme(filme, 1);
		hl.addFilme(filme2, 2);
		assertEquals(hl.getQtdFilmes(), 2);
	}
	
	@Test
	void testHotListGetQtd3() {
		assertEquals(hl.getQtdFilmes(), 0);
	}
	
	@Test
	void testHotListExibir() {
		Filme filme = new Filme("Interstellar", "2014", "EUA");
		hl.addFilme(filme, 1);
		assertEquals(hl.exibir()[0], "1 - Interstellar, 2014");
	}
	
	@Test
	void testHotListExibir2() {
		Filme filme = new Filme("Interstellar", "2014", "EUA");
		Filme filme2 = new Filme("Star Wars", "1977", "EUA");
		hl.addFilme(filme, 1);
		hl.addFilme(filme2, 5);
		assertEquals(hl.exibir()[0], "1 - Interstellar, 2014");
		assertEquals(hl.exibir()[1], "5 - Star Wars, 1977");
	}
	
	@Test
	void testHotListExibirVazia() {
		assertArrayEquals(hl.exibir(), new String[0]);
	}
	
}
