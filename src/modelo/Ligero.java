package modelo;

public class Ligero implements Botin {

	@Override
	public float bonificiacion(Atributos atributos) {
		return atributos.getVelocidad() + 1;
	}

}
