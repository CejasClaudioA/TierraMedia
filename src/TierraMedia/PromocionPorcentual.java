package TierraMedia;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {
	private int descuento;
	protected double montoPromo;

	public PromocionPorcentual(String nombre, TipoAtraccionEnum tipo, TipoPromocionEnum tipoProm,
			ArrayList<Atraccion> atraccion, int descuento) {
		super(nombre, tipo, tipoProm, atraccion);
		this.descuento = descuento;
		this.montoPromo = getMontoPromo();
	}

	@Override
	public double getMonto() {
		return this.montoPromo;
	}

	@Override
	public double getMontoPromo() {
		return getCosto() - (getCosto() * this.descuento) / 100;
	}

}
