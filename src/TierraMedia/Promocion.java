package TierraMedia;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Promocion implements Comparable<Promocion> {
	protected String nombre;
	protected String tipo;
	protected TipoPromocionEnum tipoProm;
	protected double tiempoTotal;
	protected ArrayList<Atraccion> atraccion;

	public Promocion() {
		super();
	}

	public Promocion(String nombre, String tipo, TipoPromocionEnum tipoProm,
			ArrayList<Atraccion> atraccion) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.tipoProm = tipoProm;
		this.atraccion = atraccion;
		this.tiempoTotal = getTiempoTotal();
	}

	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		double costo = 0;
		for (int i = 0; i < atraccion.size(); i++) {
			costo += atraccion.get(i).getCostoDeVisita();
		}
		return costo;
	}

	public String getTipo() {
		return tipo;
	}

	public double getTiempoTotal() {
		double tiempo = 0;
		for (int i = 0; i < atraccion.size(); i++) {
			tiempo += atraccion.get(i).getTiempo();
		}
		return tiempo;
	}

	public double getTiempo() {
		return this.tiempoTotal;
	}

	public ArrayList<Atraccion> getAtraccion() {
		return atraccion;
	}

	public String getAtracciones() {
		String aux = "";
		for (int i = 0; i < atraccion.size(); i++) {
			aux += atraccion.get(i).toString() + "\n";
		}
		return aux;
	}
	
	public String getAtraccionesItinenario() {
		String aux = "";
		for (int i = 0; i < atraccion.size(); i++) {
			aux += atraccion.get(i).getNombre() + "|";
		}
		return aux;
	}

	public boolean tieneCupos() {
		boolean aux = true;
		for (int i = 0; i < atraccion.size(); i++) {
			if (atraccion.get(i).getCupo() <= 0) {
				aux = false;
				break;
			}
		}
		return aux;
	}

	public int compareTo(Promocion o) {
		int res = 0;
		if (this.getMontoPromo() < o.getMontoPromo()) {
			res = 1;
		} else {
			if (this.getMontoPromo() > o.getMontoPromo()) {
				res = -1;
			} else {
				if (this.getMontoPromo() == o.getMontoPromo()) {
					res = 0;
				} else {
					if (this.getTiempoTotal() < o.getTiempoTotal()) {
						res = 1;
					} else {
						if (this.getTiempoTotal() > o.getTiempoTotal()) {
							res = -1;
						} else {
							if (this.getTiempoTotal() == o.getTiempoTotal()) {
								res = 0;
							}
						}
					}
				}
			}
		}
		return res;

	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, tiempoTotal, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempoTotal) == Double.doubleToLongBits(other.tiempoTotal)
				&& Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		String aux = "Nombre: " + nombre + " | "+ "Tipo de promocion: " + tipoProm + " | " + "Tipo de atracciones: " + tipo + " | " + "Monto total: " + getMonto() + " | "
				+ "Tiempo total: " + getTiempoTotal() + " | " + "Atracciones: ";
		for (int i = 0; i < atraccion.size(); i++) {
			aux += atraccion.get(i).getNombre() + " | ";
		}
		return aux;
	}

	public abstract double getMontoPromo();

	public abstract double getMonto();

}