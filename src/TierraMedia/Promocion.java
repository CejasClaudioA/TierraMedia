package TierraMedia;

import java.util.ArrayList;

public abstract class Promocion {
	protected String nombre;
	protected TipoAtraccionEnum tipo;
	protected ArrayList<Atraccion> atraccion;
		
	public Promocion(String nombre, TipoAtraccionEnum tipo, ArrayList<Atraccion> atraccion) {
		this.nombre = nombre;
		this.tipo=tipo;
		if(distintoTipo(atraccion)) {
			throw new IllegalArgumentException("Error! Las atracciones deben ser del mismo tipo!");
		}
		this.atraccion = atraccion;
	}
	
	public double getCosto() {
		double costo = 0;
		for (int i = 0; i < atraccion.size(); i++) {
			costo += atraccion.get(i).getCostoDeVisita();
		}
		return costo;
	}
	
	private boolean distintoTipo(ArrayList<Atraccion> atraccionAux) {
		boolean aux = false;
		for (int i = 0; i < atraccionAux.size() ; i++) {
			if(!atraccionAux.get(i).getTipoAtraccion().equals(tipo)) {
				aux = true;
				break;
			}
		}
		return aux;
	}



	public abstract double getMontoPromo();
	
}