package modelo;

public class FielComoUnMalditoPerro extends Personalidad {

	@Override
	boolean vendible(Equipo equipo, Equipo equipoNuevo) {
		return false;
	}

}
