package modelo;

import java.util.List;

public class Equipo {
	float nivelSinergia;
	List<Jugador> jugadores;
	
	public void transferirJugadores(List<Jugador> jugadoresAVender, Equipo otroEquipo) throws Exception {
		for(Jugador jugador : jugadoresAVender) {
			jugador.vender(otroEquipo);
			jugadores.remove(jugador);
		}
	}
}
