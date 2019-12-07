package modelo;

public class NotificadorPorMail implements Notificador {
	
	private String email;

	public NotificadorPorMail(String email) {
		this.email = email;
	}

	@Override
	public void notificar(String string) {
		// TODO se manda la notificacion por mail
		
	}

}
