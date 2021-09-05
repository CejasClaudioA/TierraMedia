package TierraMedia;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion{
	protected double montoPromo;
	
	public PromocionAbsoluta(String nombre, TipoAtraccionEnum tipo, ArrayList<Atraccion> atraccion) {
		super(nombre, tipo, atraccion);
		this.montoPromo = getMontoPromo();
	}
	
	public double getMonto() {
		return this.montoPromo;
	}

	@Override
	public double getMontoPromo() {
		return getCosto() - this.atraccion.size();
	}
	
	
}
