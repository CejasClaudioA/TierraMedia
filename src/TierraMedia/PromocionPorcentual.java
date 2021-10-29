package TierraMedia;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {
	private int descuento;
	protected double montoPromo;

	public PromocionPorcentual(String nombre, String tipo, TipoPromocionEnum tipoProm,
			ArrayList<Atraccion> atraccion, int descuento) {
		super(nombre, tipo, tipoProm, atraccion);
		this.descuento = descuento;
		this.montoPromo = getMontoPromo();
	}

	@Override
	public double getMontoPromo() {
		return getCosto() - (getCosto() * this.descuento) / 100;
	}
	
	@Override
	public String toString() {
		String aux = "Nombre: " + nombre + " | "+ "Tipo de promocion: " + tipoProm + " | " + "Tipo de atracciones: " + tipo + " | " + "Monto total: " + getMontoPromo() + " | "
				+ "Tiempo total: " + getTiempoTotal() + " | " + "Atracciones: ";
		for (int i = 0; i < atraccion.size(); i++) {
			aux += atraccion.get(i).getNombre() + " | ";
		}
		aux+= "(con un: " + descuento + "% de Descuento)";
		return aux;
	}

}
