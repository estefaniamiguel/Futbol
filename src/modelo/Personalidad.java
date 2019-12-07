package modelo;

public abstract class Personalidad {
	abstract boolean vendible(Equipo equipo, Equipo equipoNuevo);
	
	public void vender(Equipo equipo, Equipo equipoNuevo) throws Exception {
		if (!vendible(equipo, equipoNuevo)) {
			throw new Exception();
		}
	}
}
