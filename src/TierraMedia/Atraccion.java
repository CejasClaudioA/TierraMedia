package TierraMedia;

public class Atraccion {
	private String nombre;
	private int costoDeVisita;
	private double tiempo;
	private int cupo;
	private TipoAtraccionEnum tipoAtraccion;
	
	public Atraccion() {
		
	}
	
	public Atraccion(String nombre, int costoDeVisita, double tiempo, int cupo, TipoAtraccionEnum tipoAtraccion) {
		this.nombre=nombre;
		this.costoDeVisita = costoDeVisita;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipoAtraccion = tipoAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCostoDeVisita() {
		return costoDeVisita;
	}


	public void setCostoDeVisita(int costoDeVisita) {
		this.costoDeVisita = costoDeVisita;
	}


	public double getTiempo() {
		return tiempo;
	}


	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}


	public int getCupo() {
		return cupo;
	}


	public void setCupo(int cupo) {
		this.cupo = cupo;
	}


	public TipoAtraccionEnum getTipoAtraccion() {
		return tipoAtraccion;
	}


	public void setTipoAtraccion(TipoAtraccionEnum tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}

	@Override
	public String toString() {
		return "Nombre atraccion: " + nombre + ", costoDeVisita: $" + costoDeVisita + ", tiempo: " + tiempo + ", cupo:"
				+ cupo + ", tipoAtraccion:" + tipoAtraccion;
	}
	
	
	public void agregarAtraccion() {
		
	}


	
	
	
	
}
