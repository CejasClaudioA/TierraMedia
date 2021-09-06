package TierraMedia;

import java.util.*;

public class Usuario {
	private String nombre;
	private double presupuesto;
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

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double d) {
		this.presupuesto = d;
		if(this.presupuesto < 0) {
			this.presupuesto = 0;
		}
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
		if(this.tiempoDisponible < 0) {
			this.tiempoDisponible = 0;
		}
	}

	public TipoAtraccionEnum getPreferenciaAtraccion() {
		return preferenciaAtraccion;
	}

	public void setPreferenciaAtraccion(TipoAtraccionEnum preferenciaAtraccion) {
		this.preferenciaAtraccion = preferenciaAtraccion;
	}
	
	public void setPromociones(Promocion promocion) {
		this.promociones.add(promocion);
	}

	
	public List<Promocion> getPromociones() {
		return promociones;
	}
	
	public String getTotalesPromociones() {
		double montoTotal = 0;
		double tiempoTotal = 0;
		for (int i = 0; i < promociones.size(); i++) {
			montoTotal += promociones.get(i).getMonto();
			tiempoTotal += promociones.get(i).getTiempo();
		}
		
		return "Costo Total: $" + montoTotal + " | " + " Tiempo Total: " + tiempoTotal;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Usuario: "  + nombre + " | Su Presupuesto: " + presupuesto + " | Su Tiempo Disponible: " + tiempoDisponible
				+ " | Su tipo Atraccion Preferida: " + preferenciaAtraccion;
	}
	
	
	
}
