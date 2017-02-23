package usuario;

import excecoes.InvalidFieldValueException;
import excecoes.TipoUsuarioNotRecognizedException;

public class UsuarioFactory {
	public static Usuario criaUsuario(String username, String nome, String tipoUsuario) throws InvalidFieldValueException, TipoUsuarioNotRecognizedException{
		TipoUsuario tipo;
		tipo = TipoUsuarioFactory.criaTipoUsuario(tipoUsuario);
		return new Usuario(username, nome, tipo);
	}
}
