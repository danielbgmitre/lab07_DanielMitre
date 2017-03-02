package unittests;

import static org.junit.Assert.*;
import jogo.*;

import org.junit.Before;
import org.junit.Test;

import usuario.*;
import excecoes.*;

public class UsuarioTest {
	public Usuario eduarda;
	public Usuario daniel;
	public Usuario arthur;
	
	Noob noob;
	Veterano veterano;
	
	Plataforma marioWorld;
	Luta guilty;
	RPG paperMario;
	
	@Before
	public void Before() throws InvalidFieldValueException {
		noob = new Noob();
		veterano = new Veterano();
		
		eduarda = new Usuario("dudahc", "Maria Eduarda Hipolito da Costa", noob);
		daniel = new Usuario("swordseeker", "Daniel Bezerra Galvao Mitre", noob);
		arthur = new Usuario("thuthu", "Arthur da Costa Mitre");
		
		marioWorld = new Plataforma("Super Mario World", 30.00);
		guilty = new Luta("Guilty Gears", 80.00);
		paperMario = new RPG("Paper Mario", 75.00);
	}
	
	@Test
	public void atributos(){
		assertEquals(eduarda.getUsername(), "dudahc");
		assertEquals(eduarda.getNome(), "Maria Eduarda Hipolito da Costa");
		assertEquals(eduarda.getTipoName(), "Jogador Noob");
		
		assertEquals(0, eduarda.getX2p());
		assertEquals(0, eduarda.getMoney(), 0);
	}

	@Test
	public void metodos() throws InvalidFieldValueException, FakeHighscoreException, GameNotFoundException {
		eduarda.addMoney(322);
		eduarda.addMoney(10.5);
		assertEquals(eduarda.getMoney(), 332.5, 0);
		
		assertEquals(eduarda.calculaPreco(marioWorld), 27.0, 0);
		assertEquals(eduarda.calculaPreco(guilty), 72.0, 0);
		assertEquals(eduarda.calculaPreco(paperMario), 67.5, 0);
		
		eduarda.compraJogo(marioWorld);
		assertEquals(eduarda.getX2p(), 300);
		
		
		eduarda.registraJogada("Super Mario World", 1000, false);
		eduarda.registraJogada("Super Mario World", 2000, false);
		eduarda.registraJogada("Super Mario World", 3000, true);
		eduarda.registraJogada("Super Mario World", 4000, true);
		eduarda.registraJogada("Super Mario World", 5000, true);
		assertEquals(eduarda.getX2p(), 360);
		
		eduarda.compraJogo(guilty);
		eduarda.compraJogo(paperMario);
		assertEquals(eduarda.getMoney(), 166, 0);
		
		daniel.addMoney(75);
		daniel.compraJogo(guilty);
		
		daniel.registraJogada("Guilty Gears", 80000, true);
		assertEquals(daniel.getX2p(), 880);
		
		arthur.addMoney(67.5);
		arthur.compraJogo(paperMario);
		for (int i=0; i<15; i++){
			arthur.registraJogada("Paper Mario", 48000, false);
		}
		assertEquals(arthur.getX2p(), 900);
		assertEquals(arthur.getMoney(), 0, 0);
		
		eduarda.listarJogos();
	}
	
	@Test
	public void testaRegistraJogada() throws InvalidFieldValueException, FakeHighscoreException, GameNotFoundException {
		try{
			eduarda.registraJogada("Super Mario World", 0, false);
			fail();
		} catch (GameNotFoundException e){
			assertEquals(e.getClass(), GameNotFoundException.class);
		}
		
		eduarda.addMoney(27);
		eduarda.compraJogo(marioWorld);
		eduarda.registraJogada("Super Mario World", 0, false);
		
		try{
			eduarda.registraJogada("Super Mario World", -15, false);
			fail();
		} catch (InvalidFieldValueException e){
			assertEquals(e.getClass(), InvalidFieldValueException.class);
		}
				
	}
	
	@Test
	public void testaUpgrade() throws InvalidFieldValueException  {		
		assertEquals(eduarda.upgrade(), false);
		
		eduarda.addX2p(999);
		assertEquals(eduarda.upgrade(), false);
		
		eduarda.addX2p(1);
		assertEquals(eduarda.upgrade(), true);
		
		
		
		
	}
	
}
