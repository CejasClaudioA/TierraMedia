package TierraMedia;

import java.util.ArrayList;

public abstract class Promocion implements Comparable<Promocion> {
	protected String nombre;
	protected TipoAtraccionEnum tipo;
	protected TipoPromocionEnum tipoProm;
	protected double tiempoTotal;
	protected ArrayList<Atraccion> atraccion;

	public Promocion() {
		super();
	}

	public Promocion(String nombre, TipoAtraccionEnum tipo, TipoPromocionEnum tipoProm,
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

	public TipoAtraccionEnum getTipo() {
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
	public String toString() {
		String aux = "Nombre: " + nombre + " | " + "Tipo: " + tipo + " | " + "Monto total: " + getMonto() + " | "
				+ "Tiempo total: " + getTiempoTotal() + " | " + "Atracciones: ";
		for (int i = 0; i < atraccion.size(); i++) {
			aux += atraccion.get(i).getNombre() + " | ";
		}
		return aux;
	}

	public abstract double getMontoPromo();

	public abstract double getMonto();

}