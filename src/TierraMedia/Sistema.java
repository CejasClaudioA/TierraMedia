package TierraMedia;

import java.util.ArrayList;
import java.util.Collections;

public class Sistema {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Promocion> promociones;

	// Al instanciar la clase Sistema automaticamente tomamos los datos del archivos
	// de entrada con un constructor por defecto.
	public Sistema() {

	}

	// Se llama para consultar por pantalla si quiere o no conservar la sugerencia.
	public boolean menu() {
		return true;

	}

	// Se envia un usuario por parametros para seleccionar todas las promociones que
	// coincidan con las preferencias del usuario.
	public ArrayList<Promocion> seleccionarPromociones(Usuario usuario) {
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		for (int i = 0; i < promociones.size(); i++) {
			if (usuario.getPreferenciaAtraccion().equals(promociones.get(i).getTipo())
					&& usuario.getTiempoDisponible() > promociones.get(i).getTiempoTotal()
					&& usuario.getPresupuesto() > promociones.get(i).getMontoPromo()) {
				promocionesAux.add(promociones.get(i));
			}

		}
		Collections.sort(promocionesAux);
		return promocionesAux;
	}

	public void sugerirPromociones(Usuario usuario) {

	}

	public void generarItinerario() {

	}

	// Recorre la lista usuarios, les asigna las sugerencias y genera sus
	// itinenarios, se utilizaria en el JUnit
	public void probarSistema() {

	}

}
