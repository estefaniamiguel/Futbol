package exception;

public class NoSePuedeCerrarException extends RuntimeException {
	public NoSePuedeCerrarException(String mensaje) {
		super(mensaje);
	}
}
