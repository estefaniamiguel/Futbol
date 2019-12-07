package modelo;

public class Delantero extends Jugador {

	public Delantero(Atributos atributos, Equipo equipo, Botin botin,
			Personalidad personalidad) throws Exception {
		super(atributos, equipo, botin, personalidad);
	}

	@Override
	public float valoracionDeAtributos() {
		return (float) (6 * atributos.getAtaque() + fuerzaVelocidadYResistenciaDefault());
	}

}
