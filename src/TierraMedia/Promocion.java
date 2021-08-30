package TierraMedia;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Promocion implements Comparable<Promocion>{
	protected String nombre;
	protected TipoAtraccionEnum tipo;
	protected ArrayList<Atraccion> atraccion;
		
	public Promocion(String nombre, TipoAtraccionEnum tipo, ArrayList<Atraccion> atraccion) {
		this.nombre = nombre;
		this.tipo=tipo;
		this.atraccion = atraccion;
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
	
	public int compareTo(Promocion o) {
		int res = 0;
		if(this.getMontoPromo() < o.getMontoPromo()){
			res = 1;
		}else{
			if(this.getMontoPromo() > o.getMontoPromo()) {
				res = -1;
			}else {
				if (this.getMontoPromo() == o.getMontoPromo()) {
					res = 0;
				}else {
					if(this.getTiempoTotal() < o.getTiempoTotal()) {
						res = 1;						
					}else{
						if(this.getTiempoTotal() > o.getTiempoTotal()) {
							res = -1;
						}else{
							if(this.getTiempoTotal() == o.getTiempoTotal()) {
								res = 0;
							}
						}
					}
				}
			}
		}
		return res;
		
	}
	
	public int compare(Promocion o1, Promocion o2) {
		int res = 0;
		if(o1.getMontoPromo() > o2.getMontoPromo()){
			res = 1;
		}else{
			if(o1.getMontoPromo() < o2.getMontoPromo()) {
				res = 1;
			}else {
				if(o1.getTiempoTotal() > o2.getTiempoTotal()) {
					res = 1;
				}else {
					if(o1.getTiempoTotal() < o2.getTiempoTotal()) {
						res = 1;
					}
				}
			}
		}
		return res;
	}
	
	


	@Override
	public String toString() {
		return "nombre: " + nombre + ", tipo: " + tipo + ", atraccion: " + atraccion;
	}

	public abstract double getMontoPromo();

	
	
}