package modelo;
import modelo.Jugador;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import exception.NoPuedeInscribirseException;
import exception.NoSePuedeCerrarException;


public class PartidoTest {

	@Test
	public void inscribir_unJugadorSolidarioSeInscribeAUnPartido() {
		Jugador jugador = Mockito.mock(Jugador.class);
		Partido partido = new Partido();
		partido.inscribir(jugador, new Solidario());
		Assert.assertEquals("el jugador inscripto no es solidario",
				1, partido.getJugadoresSolidarios().size());
		Assert.assertEquals("al inscribir se modificó la lista de jugadores standar",
				0, partido.getJugadoresEstandar().size());
		Assert.assertEquals("el jugador inscripto no fue confirmado",
				1, partido.getJugadoresConfirmados().size());
	}
	
	@Test
	public void inscribir_unJugadorStandarSeInscribeAUnPartido() {
		Jugador jugador = Mockito.mock(Jugador.class);
		Partido partido = new Partido();
		partido.inscribir(jugador, new Estandar());
		Assert.assertEquals("el jugador inscripto no es standar",
				1, partido.getJugadoresEstandar().size());
		Assert.assertEquals("al inscribir se modificó la lista de jugadores solidarios",
				0, partido.getJugadoresSolidarios().size());
		Assert.assertEquals("el jugador inscripto no fue confirmado",
				1, partido.getJugadoresConfirmados().size());
	}
	
	@Test
	public void getJugadoresConfirmados_UnPartidoCon10JugadoresSolidariosYUnoStandarMuestraSolo10Confirmados() {
		Jugador jugador = Mockito.mock(Jugador.class);
		Partido partidoCon10JugadoresConfirmados = new Partido();
		partidoCon10JugadoresConfirmados.inscribir(jugador, new Estandar());
		for (int i = 0; i < 10; i++) {
			partidoCon10JugadoresConfirmados.inscribir(jugador, new Solidario());
		}
		Assert.assertEquals("no hay 10 jugadores inscriptos",
				10, partidoCon10JugadoresConfirmados.getJugadoresConfirmados().size());
	}
	
	@Test(expected = NoPuedeInscribirseException.class)
	public void inscribir_unJugadorStandarSeInscribeAUnPartidoCon10JugadoresConfirmados() {
		Jugador jugador = Mockito.mock(Jugador.class);
		Partido partidoCon10JugadoresConfirmados = new Partido();
		partidoCon10JugadoresConfirmados.inscribir(jugador, new Estandar());
		for (int i = 0; i < 10; i++) {
			partidoCon10JugadoresConfirmados.inscribir(jugador, new Solidario());
		}
		partidoCon10JugadoresConfirmados.inscribir(jugador, new Estandar());
	}
	
	@Test
	public void cancelarInscripcion_UnJugadorCancelaYEsPenalizado() {
		Jugador jugador = Mockito.mock(Jugador.class);
		Partido partidoFeo = new Partido();
		partidoFeo.inscribir(jugador, new Estandar());
		
		partidoFeo.cancelarInscripcion(jugador);
		
		Mockito.verify(jugador).penalizar();
	}
	
	@Test(expected = NoSePuedeCerrarException.class)
	public void finalizarInscripcion_NoSePuedeCerrarInscripcionConMenosJugadoresDeLosPermitidos() {
		Partido partidoNuevo = new Partido();
		partidoNuevo.finalizarInscripcion();
	}
	
	
	@Test()
	public void finalizarInscripcion_NoSePuedeCerrarInscripcionConCantidadDeJugadoresPermitidos() {
		Jugador jugador = Mockito.mock(Jugador.class);
		Jugador jugadorExtra = Mockito.mock(Jugador.class);

		Partido partidoCon10JugadoresConfirmados = new Partido();
		partidoCon10JugadoresConfirmados.inscribir(jugador, new Estandar());
		for (int i = 0; i < 10; i++) {
			partidoCon10JugadoresConfirmados.inscribir(jugadorExtra, new Solidario());
		}
		Jugador jugadorBaboso = Mockito.mock(Jugador.class);
		partidoCon10JugadoresConfirmados.inscribir(jugadorBaboso, new Solidario());

		partidoCon10JugadoresConfirmados.finalizarInscripcion();
		Mockito.verify(jugador).notificarQueJuega();
		Mockito.verify(jugadorBaboso).notificarQueNoJuega();

	}
}
