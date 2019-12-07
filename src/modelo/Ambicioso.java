package modelo;

public class Ambicioso extends Personalidad {

	@Override
	boolean vendible(Equipo equipo, Equipo equipoNuevo) {
		return equipo.nivelSinergia < equipoNuevo.nivelSinergia;
	}

}
