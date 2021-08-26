package TierraMedia;

import java.util.*;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoAtraccionEnum preferenciaAtraccion;
	private List<Promocion> promociones = new ArrayList<>();
	
	public Usuario(String nombre, int presupuesto, double tiempoDisponible, TipoAtraccionEnum preferenciaAtraccion) {
		this.nombre=nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferenciaAtraccion=preferenciaAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public TipoAtraccionEnum getPreferenciaAtraccion() {
		return preferenciaAtraccion;
	}

	public void setPreferenciaAtraccion(TipoAtraccionEnum preferenciaAtraccion) {
		this.preferenciaAtraccion = preferenciaAtraccion;
	}

	@Override
	public String toString() {
		return "Nombre usuario: " + nombre + ", presupuesto: $" + presupuesto + ", tiempoDisponible: " + tiempoDisponible
				+ ", preferenciaAtraccion:" + preferenciaAtraccion;
	}	
	
	
}
