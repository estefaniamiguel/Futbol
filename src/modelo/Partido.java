package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exception.NoPuedeInscribirseException;
import exception.NoSePuedeCerrarException;

public class Partido {

	private List<Jugador> jugadoresSolidarios = new ArrayList<Jugador>();
	private List<Jugador> jugadoresEstandar = new ArrayList<Jugador>();

	public List<Jugador> getJugadoresSolidarios() {
		return jugadoresSolidarios;
	}

	public List<Jugador> getJugadoresEstandar() {
		return jugadoresEstandar;
	}

	public List<Jugador> getJugadoresConfirmados() {
		List<Jugador> jugadoresConfirmados = new ArrayList<Jugador>();
		jugadoresConfirmados.addAll(jugadoresEstandar);
		jugadoresConfirmados.addAll(jugadoresSolidarios);
		return jugadoresConfirmados.stream().limit(10).collect(Collectors.toList());
	}
	
	public List<Jugador> getJugadoresQueNoJuegan() {
		List<Jugador> jugadoresNoConfirmados = new ArrayList<Jugador>();
		jugadoresNoConfirmados.addAll(jugadoresEstandar);
		jugadoresNoConfirmados.addAll(jugadoresSolidarios);
		jugadoresNoConfirmados.removeAll(getJugadoresConfirmados());
		return jugadoresNoConfirmados;
	}
	
	

	public void inscribir(Jugador jugador, Modo modo) {
		modo.inscribir(jugador, this);
//		if (modo.equals("standar")) {
//			inscribirJugadorEstandar(jugador);
//		} else if (modo.equals("solidario")) {
//			inscribirJugadorSolidario(jugador);
//		} else {
//			throw new NoPuedeInscribirseException("necesita definir el modo"); 
//		}
			
	}

	private void inscribirJugadorSolidario(Jugador jugador) {
		jugadoresSolidarios.add(jugador);
	}

	private void inscribirJugadorEstandar(Jugador jugador) {
		List<Jugador> jugadores = getJugadoresConfirmados();
		if (jugadores.size() >= 10) {
			throw new NoPuedeInscribirseException("ya hay 10 jugadores confirmados");
		}
		jugadoresEstandar.add(jugador);
	}

	public void cancelarInscripcion(Jugador jugador) {
		jugador.penalizar();
		if (jugadoresEstandar.contains(jugador)) {
			jugadoresEstandar.remove(jugador);
		} else {
			jugadoresSolidarios.remove(jugador);
		}
	}

	public void finalizarInscripcion() {
		if (getJugadoresConfirmados().size() < 10) {
			throw new NoSePuedeCerrarException("faltan jugadores: " + (10 - getJugadoresConfirmados().size()));
		}
		getJugadoresConfirmados().stream().forEach(jugador -> jugador.notificarQueJuega());
		getJugadoresQueNoJuegan().stream().forEach(jugador -> jugador.notificarQueNoJuega());
	}

	public void agregarJugadorEstandar(Jugador jugador) {
		jugadoresEstandar.add(jugador);
	}
	
	public void agregarJugadorSolidario(Jugador jugador) {
		jugadoresSolidarios.add(jugador);
	}


}
