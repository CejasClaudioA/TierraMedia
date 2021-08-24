package TierraMedia;

public class Atraccion {
	private double costoDeVisita;
	private double tiempo;
	private int cupo;
	private TipoAtraccionEnum tipoAtraccion;
	
	
	public Atraccion(double costoDeVisita, double tiempo, int cupo, TipoAtraccionEnum tipoAtraccion) {
		this.costoDeVisita = costoDeVisita;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipoAtraccion = tipoAtraccion;
	}


	public double getCostoDeVisita() {
		return costoDeVisita;
	}


	public void setCostoDeVisita(double costoDeVisita) {
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
		return "Atraccion [costoDeVisita=" + costoDeVisita + ", tiempo=" + tiempo + ", cupo=" + cupo+ ", tipoAtraccion=" + tipoAtraccion + "]";
	}
	
	
	
}
