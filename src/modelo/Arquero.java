package modelo;

public class Arquero extends Jugador {

	public Arquero(Atributos atributos, Equipo equipo, Botin botin,
			Personalidad personalidad) throws Exception {
		super(atributos, equipo, botin, personalidad);
	}

	@Override
	public float valoracionDeAtributos() {
		return (float) (2 * atributos.getDefensa() + 3 * atributos.getFuerza() + 4 * atributos.getVelocidad() + atributos.getResistencia());
	}

}
