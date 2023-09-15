package modelo;

public class Grupo {
	private int id;
    private String nombre;
    private int monitor;
    private int instructor;
    
    public Grupo() {
    	
    }

	public Grupo(int id, String nombre, int monitor, int instructor) {
		this.id = id;
		this.nombre = nombre;
		this.monitor = monitor;
		this.instructor = instructor;
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

	public int getMonitor() {
		return monitor;
	}

	public void setMonitor(int monitor) {
		this.monitor = monitor;
	}

	public int getInstructor() {
		return instructor;
	}

	public void setInstructor(int instructor) {
		this.instructor = instructor;
	}
	
	
}
