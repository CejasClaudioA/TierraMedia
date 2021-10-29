package TierraMedia;

import java.util.*;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private String preferenciaAtraccion;
	private List<Promocion> promociones = new ArrayList<>();

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, String preferenciaAtraccion) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferenciaAtraccion = preferenciaAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
		if (this.presupuesto < 0) {
			this.presupuesto = 0;
		}
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
		if (this.tiempoDisponible < 0) {
			this.tiempoDisponible = 0;
		}
	}

	public String getPreferenciaAtraccion() {
		return preferenciaAtraccion;
	}

	public void setPromociones(Promocion promocion) {
		this.promociones.add(promocion);
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public String getPromocionesDAO() {
		String aux = "";
		for (int i = 0; i < promociones.size(); i++) {
			aux += promociones.get(i).getNombre() + "|";
		}
		return aux;
	}

	public boolean puedeAñadirPromocion(Promocion promocion) {
		return this.presupuesto >= promocion.getMontoPromo() && this.tiempoDisponible > promocion.getTiempoTotal()
				&& !this.promociones.contains(promocion) && this.preferenciaAtraccion.equals(promocion.getTipo())
				&& promocion.tieneCupos();
	}

	public boolean puedeAñadirPromocionAlterna(Promocion promocion) {
		return this.presupuesto >= promocion.getMontoPromo() && this.tiempoDisponible > promocion.getTiempoTotal()
				&& !this.promociones.contains(promocion) && !this.preferenciaAtraccion.equals(promocion.getTipo())
				&& promocion.tieneCupos();
	}

	public double getCostoTotalPromociones() {
		double montoTotal = 0;
		for (int i = 0; i < promociones.size(); i++) {
			montoTotal += promociones.get(i).getMontoPromo();
		}

		return montoTotal;
	}

	public double getTiempoTotalPromociones() {
		double tiempoTotal = 0;
		for (int i = 0; i < promociones.size(); i++) {
			tiempoTotal += promociones.get(i).getTiempo();
		}

		return tiempoTotal;
	}

	public String getTotalesPromociones() {
		double montoTotal = 0;
		double tiempoTotal = 0;
		for (int i = 0; i < promociones.size(); i++) {
			montoTotal += promociones.get(i).getMontoPromo();
			tiempoTotal += promociones.get(i).getTiempo();
		}

		return "Costo Total: $" + montoTotal + " | " + " Tiempo Total: " + tiempoTotal + "hs";
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
		return "Usuario: " + nombre + " | Su Presupuesto: $" + presupuesto + " | Su Tiempo Disponible: "
				+ tiempoDisponible + "hs  | Su tipo Atraccion Preferida: " + preferenciaAtraccion;
	}

}
