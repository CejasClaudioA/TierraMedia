package TierraMedia;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {
	protected double montoPromo;

	public PromocionAxB(String nombre, TipoAtraccionEnum tipo, TipoPromocionEnum tipoProm,
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
		return getCosto() - this.atraccion.get(this.atraccion.size() - 1).getCostoDeVisita();
	}

}
