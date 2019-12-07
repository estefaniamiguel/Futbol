package modelo;

public class Solidario implements Modo {

	@Override
	public void inscribir(Jugador jugador, Partido partido) {
		partido.agregarJugadorSolidario(jugador);

	}

}
