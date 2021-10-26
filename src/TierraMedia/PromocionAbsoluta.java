package TierraMedia;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {
	protected double montoPromo;

	public PromocionAbsoluta(String nombre, String tipo, TipoPromocionEnum tipoProm,
			ArrayList<Atraccion> atraccion) {
		super(nombre, tipo, tipoProm, atraccion);
		this.montoPromo = getMontoPromo();
	}

	@Override
	public double getMonto() {
		return this.montoPromo;
	}

	@Override
	public double getMontoPromo() {
		return getCosto() - this.atraccion.size();
	}

}
