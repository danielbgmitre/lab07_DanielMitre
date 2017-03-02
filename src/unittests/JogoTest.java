package unittests;

import static org.junit.Assert.*;
import jogo.*;

import org.junit.Before;
import org.junit.Test;

import excecoes.*;

public class JogoTest {
	Plataforma marioWorld;
	Luta guilty;
	RPG paperMario;
	
	@Before
	public void Before() throws Exception{
		marioWorld = new Plataforma("Super Mario World", 30.00);
		guilty = new Luta("Guilty Gears", 80.00);
		paperMario = new RPG("Paper Mario", 75.00);
	}
	
	@Test
	public void construtor(){
		try {
			new Plataforma(" ", 3.00);
			fail();
		} catch (Exception e){
			assertEquals(e.getClass(), InvalidFieldValueException.class);
		}
		
		try {
			new Plataforma(" oi ", -1);
			fail();
		} catch (Exception e){
			assertEquals(e.getClass(), InvalidFieldValueException.class);
		}
		
		try {
			new Plataforma(" ", 3.00);
			fail();
		} catch (Exception e){
			assertEquals(e.getClass(), InvalidFieldValueException.class);
		}
	}
	
	@Test
	public void atributos() {
		assertEquals("Super Mario World", marioWorld.getNome());
		assertEquals(30.0, marioWorld.getPreco(), 0);
		
		assertEquals("Guilty Gears", guilty.getNome());
		assertEquals(80.0, guilty.getPreco(), 0);
		
		assertEquals("Paper Mario", paperMario.getNome());
		assertEquals(75.0, paperMario.getPreco(), 0);
	}
	
	@Test
	public void metodos(){
		try {
			marioWorld.registraJogada(-1, true);
			fail();
		} catch (Exception e){
			assertEquals(e.getClass(), InvalidFieldValueException.class);
		}
		
		try {
			marioWorld.setHighestScore(-1);
			fail();
		} catch (Exception e){
			assertEquals(e.getClass(), FakeHighscoreException.class);
		}
		
		try {
			marioWorld.setTipoJogo("  ");
			fail();
		} catch (Exception e){
			assertEquals(e.getMessage(), InvalidFieldValueException.class);
		}
		
	}
	
	@Test
	public void Plataforma() throws Exception{
		assertEquals(0, marioWorld.getTimesPlayed());
		assertEquals(0, marioWorld.getTimesFinished());
		assertEquals(0, marioWorld.getHighestScore());
		
		assertEquals(0, marioWorld.registraJogada(333, false));
		assertEquals(20, marioWorld.registraJogada(223, true));
		
		assertEquals(333, marioWorld.getHighestScore());
		assertEquals(2, marioWorld.getTimesPlayed());
		assertEquals(1, marioWorld.getTimesFinished());
	}
	
	@Test
	public void RPG() throws Exception{
		assertEquals(0, paperMario.getTimesPlayed());
		assertEquals(0, paperMario.getTimesFinished());
		assertEquals(0, paperMario.getHighestScore());
		
		assertEquals(10, paperMario.registraJogada(333, false));
		assertEquals(10, paperMario.registraJogada(223, true));
		
		assertEquals(333, paperMario.getHighestScore());
		assertEquals(2, paperMario.getTimesPlayed());
		assertEquals(1, paperMario.getTimesFinished());
	}
	
	@Test
	public void Luta() throws Exception{
		assertEquals(0, guilty.getTimesPlayed());
		assertEquals(0, guilty.getTimesFinished());
		assertEquals(0, guilty.getHighestScore());
		
		assertEquals(0, guilty.registraJogada(333, false));
		assertEquals(4, guilty.registraJogada(4333, true));
		
		assertEquals(4333, guilty.getHighestScore());
		assertEquals(2, guilty.getTimesPlayed());
		assertEquals(1, guilty.getTimesFinished());
	}

}
