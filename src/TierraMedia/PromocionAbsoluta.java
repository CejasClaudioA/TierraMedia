package TierraMedia;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion{

	public PromocionAbsoluta(String nombre, TipoAtraccionEnum tipo, ArrayList<Atraccion> atraccion) {
		super(nombre, tipo, atraccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getMontoPromo() {
		return getCosto() - this.atraccion.size();
	}
	
	
}
