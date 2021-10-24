package TierraMedia;

public enum TipoPromocionEnum {
	PROMOCIONABSOLUTA("Promocion Absoluta"), PROMOCIONPORCENTUAL("Promocion Porcentual"), PROMOCIONAXB("Promocion AxB");

	private String descripcion;

	private TipoPromocionEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}
}
