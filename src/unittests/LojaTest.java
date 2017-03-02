package unittests;

import static org.junit.Assert.*;
import jogo.*;
import loja.*;

import org.junit.Before;
import org.junit.Test;

import usuario.*;
import excecoes.*;

public class LojaTest {
	LojaController loja;
	Usuario eduarda;
	Usuario daniel;
	Plataforma marioWorld;
	Luta guilty;
	RPG paperMario;
	
	@Before
	public void Before() throws InvalidFieldValueException, DuplicatedUsernameException {
		eduarda = new Usuario("dudahc", "Maria Eduarda Hipolito da Costa");
		daniel = new Usuario("swordseeker", "Daniel Bezerra Galvao Mitre");
		
		marioWorld = new Plataforma("Super Mario World", 30.00);
		guilty = new Luta("Guilty Gears", 80.00);
		paperMario = new RPG("Paper Mario", 75.00);
		
		loja = new LojaController();
		loja.addUsuario(eduarda);
	}
	
	@Test
	public void test() throws InvalidFieldValueException, UserNotFoundException, DuplicatedUsernameException{
		assertEquals(eduarda.upgrade(), false);
		
		
		assertEquals(eduarda.upgrade(), true);
		
		loja.fazUpgrade(eduarda);
		assertEquals(eduarda.upgrade(), false);
		
		try{
			loja.addMoney("swordseeker", 300);
			fail();
		} catch (UserNotFoundException e){
			assertEquals(e.getClass(), UserNotFoundException.class);
		}
		
		daniel.addMoney(300);
		
		try{
			loja.vendeJogo("swordseeker", marioWorld);
			fail();
		} catch (UserNotFoundException e){
			assertEquals(e.getClass(), UserNotFoundException.class);
		}
		
		loja.addUsuario(daniel);
		try{
			loja.addUsuario(daniel);
			fail();
		} catch (DuplicatedUsernameException e){
			assertEquals(e.getClass(), DuplicatedUsernameException.class);
		}
		
		loja.listarUsuarios();
	}
	

}
