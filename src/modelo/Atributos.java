package modelo;

public class Atributos {
	int ataque = 0;
	int defensa = 0;
	int fuerza = 0;
	int velocidad = 0;
	int resistencia = 0;
	public boolean sonSuficientes() {
		return ataque <= 10 && defensa <= 10 && fuerza <= 10 && velocidad <= 10 && resistencia <= 10;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getFuerza() {
		return fuerza;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public double getResistencia() {
		return resistencia;
	}
}
