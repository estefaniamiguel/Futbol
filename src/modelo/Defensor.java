package modelo;

public class Defensor extends Jugador {

	public Defensor(Atributos atributos, Equipo equipo, Botin botin,
			Personalidad personalidad) throws Exception {
		super(atributos, equipo, botin, personalidad);
	}

	@Override
	public float valoracionDeAtributos() {
		return (float) (6 * atributos.getDefensa() + fuerzaVelocidadYResistenciaDefault());
	}

}
