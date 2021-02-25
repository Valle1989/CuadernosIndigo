package ar.com.CuadernosIndigo.mail;

public class MailForm {
	
	private String nombre;
	
	private String email;
	
	private String asunto;

	public MailForm() {
		super();
	}

	public MailForm(String nombre, String email, String asunto) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.asunto = asunto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	@Override
	public String toString() {
		return "MailForm [nombre=" + nombre + ", email=" + email + ", asunto=" + asunto + "]";
	}
	
	

}
