package usuario;

import excecoes.*;

public class TipoUsuarioFactory {
	public static final String NOOB = "noob";
	public static final String VETERANO = "veterano";	

	public static TipoUsuario criaTipoUsuario(String tipoUsuario) throws InvalidFieldValueException, TipoUsuarioNotRecognizedException {
		if (tipoUsuario.toLowerCase().equals(NOOB)){
			return new Noob();
		} else if (tipoUsuario.toLowerCase().equals(VETERANO)){
			return new Veterano();
		} else {
			throw new TipoUsuarioNotRecognizedException();
		}
	}
}
