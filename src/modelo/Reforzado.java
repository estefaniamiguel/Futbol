package modelo;

public class Reforzado implements Botin {

	@Override
	public float bonificiacion(Atributos atributos) {
		return atributos.getFuerza() + 1;
	}

}
