package modelo;

public class Mediocampista extends Jugador {

	public Mediocampista(Atributos atributos, Equipo equipo, Botin botin,
			Personalidad personalidad) throws Exception {
		super(atributos, equipo, botin, personalidad);
	}
	
	public float valoracionDeAtributos() {
		return (float) (3 * atributos.getAtaque() + 3 * atributos.getDefensa() + fuerzaVelocidadYResistenciaDefault());
	}

}
