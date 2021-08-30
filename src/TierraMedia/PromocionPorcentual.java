package TierraMedia;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion{
	private int descuento;
	
	public PromocionPorcentual(String nombre, TipoAtraccionEnum tipo, ArrayList<Atraccion> atraccion, int descuento) {
		super(nombre, tipo, atraccion);
		this.descuento = descuento;
	}

	@Override
	public double getMontoPromo() {
		return getCosto() - (getCosto()*this.descuento)/100;
	}


}
