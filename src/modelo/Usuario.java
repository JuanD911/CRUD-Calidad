package modelo;

public abstract class Usuario {

	private int id;
	private String nombre;
    private String telefono;
    private String f_nacimiento;
    private String direccion;
    private String c_electronico;
    
    public Usuario() {
    }
    
    public Usuario(int id, String nombre, String telefono, String f_nacimiento, String direccion, String c_electronico) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.f_nacimiento = f_nacimiento;
		this.direccion = direccion;
		this.c_electronico = c_electronico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getF_nacimiento() {
		return f_nacimiento;
	}

	public void setF_nacimiento(String f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getC_electronico() {
		return c_electronico;
	}

	public void setC_electronico(String c_electronico) {
		this.c_electronico = c_electronico;
	}
	
	 public String toString() {
	    	return nombre;
	 }
    
}   
 