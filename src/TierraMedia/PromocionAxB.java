package TierraMedia;

import java.util.ArrayList;

public class PromocionAxB extends Promocion{

	public PromocionAxB(String nombre, TipoAtraccionEnum tipo, ArrayList<Atraccion> atraccion) {
		super(nombre, tipo, atraccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getMontoPromo() {
		return getCosto() - this.atraccion.get(this.atraccion.size()-1).getCostoDeVisita();
	}

}
