package lab3FilmNow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filmnow.Filme;


class FilmeTest {
	
	private Filme filme;

	@BeforeEach
	void setUp() {
		filme = new Filme("Star Wars", "1977", "EUA");
	}
	
	@Test
	void testSetHot1() {
		assertEquals(filme.isHot(), false);
	}
	
	@Test
	void testSetHot2() {
		filme.setHot(true);
		assertEquals(filme.isHot(), true);
	}
	
	@Test
	void testToString() {
		assertEquals(filme.toString(), "Star Wars, 1977\nEUA");
	}
	
	@Test
	void testToStringHot() {
		filme.setHot(true);
		assertEquals(filme.toString(), "🔥 Star Wars, 1977\nEUA");
	}
	
	@Test
	void testGetNome() {
		assertEquals(filme.getNome(), "Star Wars");
	}
	
	@Test
	void testGetAno() {
		assertEquals(filme.getAno(), "1977");
	}
	
	@Test
	void testGetLocal() {
		assertEquals(filme.getLocal(), "EUA");
	}
	
	@Test
	void testEquals() {
		Filme filme2 = new Filme("Interstellar", "2014", "EUA");
		assertFalse(filme.equals(filme2));
	}
	
	@Test
	void testEquals2() {
		Filme filme2 = new Filme("Star Wars", "1977", "EUA");
		assertTrue(filme.equals(filme2));
	}
	
	@Test
	void testEquals3() {
		int num = 1;
		assertFalse(filme.equals(num));
	}
	
	@Test
	void testEquals4() {
		assertTrue(filme.equals(filme));
	}

	@Test
	void testHashCode() {
		Filme filme2 = new Filme("Star Wars", "1977", "EUA");
		assertEquals(filme.hashCode(), filme2.hashCode());
	}
	
	@Test
	void testHashCode2() {
		Filme filme2 = new Filme("Interstellar", "2014", "EUA");
		assertNotEquals(filme.hashCode(), filme2.hashCode());
	}

}
