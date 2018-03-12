
public class User {
	private String nombre;
	private String correo;
	private String password;
	
	public User(String nombre, String correo, String password) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfo() {
		// TODO Auto-generated method stub
		return this.nombre +"  "+ this.correo+" "+ this.password;
		}//fin getInfo
	}
