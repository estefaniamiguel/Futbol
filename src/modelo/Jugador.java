package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {
	List<Notificador> notificadores = new ArrayList<Notificador>();
	Atributos atributos;
	Equipo equipo;
	Botin botin;
	Personalidad personalidad;
	
	public Jugador(Atributos atributos, Equipo equipo, Botin botin,
			Personalidad personalidad) throws Exception {
		if (!atributos.sonSuficientes()) {
			throw new Exception();
		}
		this.atributos = atributos;
		this.equipo = equipo;
		this.botin = botin;
		this.personalidad = personalidad;
	}
	
	public void vender(Equipo nuevoEquipo) throws Exception {
		personalidad.vender(equipo, nuevoEquipo);
		equipo = nuevoEquipo;
	}
	
	public float valoracionGeneral() {
		float valoracion = botin.bonificiacion(atributos);
		valoracion += equipo.nivelSinergia;
		valoracion += valoracionDeAtributos();
		return valoracion;
	}
	
	abstract float valoracionDeAtributos();
	
	public float fuerzaVelocidadYResistenciaDefault() {
		return (float) (1.5 * atributos.getFuerza() + 1.5 * atributos.getVelocidad() + atributos.getResistencia());
	}
	
	public void penalizar() {
		// TODO Auto-generated method stub hay que averiguar mas
		
	}

	public void notificarQueJuega() {
		notificadores.forEach(notificador -> notificador.notificar("Vas a Jugar"));
		
	}

	public void notificarQueNoJuega() {
		notificadores.forEach(notificador -> notificador.notificar("NO vas a Jugar"));

	}
	
	public void agregarNotificador(Notificador notificador) {
		notificadores.add(notificador);
	}
	
	public void agregarMail(String mail) {
		notificadores.add(new NotificadorPorMail(mail));
	}

}
