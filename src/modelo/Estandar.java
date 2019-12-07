package modelo;

import java.util.List;

import exception.NoPuedeInscribirseException;

public class Estandar implements Modo {

	@Override
	public void inscribir(Jugador jugador, Partido partido) {
		List<Jugador> jugadores = partido.getJugadoresConfirmados();
		if (jugadores.size() >= 10) {
			throw new NoPuedeInscribirseException("ya hay 10 jugadores confirmados");
		}
		partido.agregarJugadorEstandar(jugador);

	}


}
