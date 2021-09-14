package TierraMedia;

public class Atraccion {
	private String nombre;
	private double costoDeVisita;
	private double tiempo;
	private int cupo;
	private TipoAtraccionEnum tipoAtraccion;
	
	public Atraccion() {

	}

	public Atraccion(String nombre, double costoDeVisita, double tiempo, int cupo, TipoAtraccionEnum tipoAtraccion) {
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

	public double getCostoDeVisita() {
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
		if (this.cupo < 0) {
			this.cupo = 0;
		}
	}


	public TipoAtraccionEnum getTipoAtraccion() {
		return tipoAtraccion;
	}


	public void setTipoAtraccion(TipoAtraccionEnum tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}

	@Override
	public String toString() {
		return "Nombre atraccion: " + nombre + " | Costo de visita: $" + costoDeVisita + " | Tiempo: " + tiempo + "hs | Cupos disponibles:"
				+ cupo + " | Tipo de atraccion: " + tipoAtraccion + "\n";
	}
	
}
