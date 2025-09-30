package Testes;

import static org.junit.jupiter.api.Assertions.*;

import mrbet.MrBetSistema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMrBet {

	private MrBetSistema mb;

	@BeforeEach
	void setUp() throws Exception {
		this.mb = new MrBetSistema();
		mb.incluirTime("250_PB", "Nacional de Patos", "Canário");
		mb.incluirTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		mb.incluirTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		mb.incluirTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");

	}

	@Test
	void CadastrarCamp() {
		assertEquals(mb.incluirCampeonato("Brasileirão série A 2023", 2), "CAMPEONATO ADICIONADO!");
	}

	@Test
	void CadastrarCampExistente() {
		mb.incluirCampeonato("Brasileirão série A 2023", 2);
		assertEquals(mb.incluirCampeonato("Brasileirão série A 2023", 2), "CAMPEONATO JA EXISTE!");
	}

	@Test
	void IncluirTimeCampeonato() {
		mb.incluirCampeonato("Brasileirão série A 2023", 2);
		assertEquals(mb.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"), "TIME INCLUIDO NO CAMPEONATO!");
		assertEquals(mb.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"), "TIME INCLUIDO NO CAMPEONATO!");
	}

	@Test
	void IncluirTimeCampeonatoJaIncluso() {
		mb.incluirCampeonato("Brasileirão série A 2023", 2);
		assertEquals(mb.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"), "TIME INCLUIDO NO CAMPEONATO!");
		assertEquals(mb.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"), "TIME INCLUIDO NO CAMPEONATO!");
	}

	@Test
	void IncluirTimeNaoCadastradoCamp() {
		mb.incluirCampeonato("Brasileirão série A 2023", 2);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			mb.incluirTimeCampeonato("005_PB", "Brasileirão série A 2023");
		});

		assertEquals("O TIME NAO EXISTE!", exception.getMessage());
	}

	@Test
	void IncluirTimeCampNaoCadastrado() {

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			mb.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
		});

		assertEquals("CAMPEONATO NAO EXISTE!", exception.getMessage());
	}

	@Test
	void IncluirTimeCampeonatoLimite() {
		mb.incluirCampeonato("Brasileirão série A 2023", 2);
		assertEquals(mb.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"), "TIME INCLUIDO NO CAMPEONATO!");
		assertEquals(mb.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"), "TIME INCLUIDO NO CAMPEONATO!");
		assertEquals(mb.incluirTimeCampeonato("002_RJ", "Brasileirão série A 2023"),
				"TODOS OS TIMES DESSE CAMPEONATO JA FORAM INCLUIDOS!");
	}

	@Test
	void VerificaTimeCamp() {
		mb.incluirCampeonato("Brasileirão série A 2023", 2);
		assertEquals(mb.verificaTimeCampeonato("250_PB", "Brasileirão série A 2023"), "O TIME NAO ESTA NO CAMPEONATO!");
	}

	@Test
	void VerificaTimeCampNaoExistente() {

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			mb.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
		});

		assertEquals("CAMPEONATO NAO EXISTE!", exception.getMessage());
	}

	@Test
	void VerificaTimeNaoExistenteCamp() {

		mb.incluirCampeonato("Brasileirão série A 2023", 2);
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			mb.incluirTimeCampeonato("258_PB", "Brasileirão série A 2023");
		});

		assertEquals("O TIME NAO EXISTE!", exception.getMessage());
	}
}
