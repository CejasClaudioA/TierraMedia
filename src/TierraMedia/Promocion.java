package TierraMedia;

import java.util.*;

public abstract class Promocion {
	protected String nombre;
	protected TipoAtraccionEnum tipo;
	protected ArrayList<Atraccion> atraccion;
		
	public Promocion(String nombre, TipoAtraccionEnum tipo) {
		this.nombre = nombre;
		this.tipo=tipo;
	}



	public abstract double getMontoPromo();
	
}
