package TierraMedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Sistema {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Promocion> promociones;

	// Al instanciar la clase Sistema automaticamente tomamos los datos del archivos
	// de entrada con un constructor por defecto.
	public Sistema() {
	}

	// Se llama para consultar por pantalla si quiere o no conservar la sugerencia.
	public boolean menu() {
		System.out.println("Ingrese 1 para aceptar o 0 para denegar: ");	
		int r;
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		return r == 1;

	}

	// Se envia un usuario por parametros para seleccionar todas las promociones que
	// coincidan con las preferencias del usuario.
	public ArrayList<Promocion> seleccionarPromociones(Usuario usuario) {
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		for (int i = 0; i < promociones.size(); i++) {
			if (usuario.getPreferenciaAtraccion().equals(promociones.get(i).getTipo())
					&& usuario.getTiempoDisponible() > promociones.get(i).getMontoPromo()
					&& usuario.getPresupuesto() > promociones.get(i).getMontoPromo()) {
				promocionesAux.add(promociones.get(i));
			}

		}
		Collections.sort(promocionesAux);
		return promocionesAux;
	}

	public void sugerirPromociones(Usuario usuario) {
		
	}

	public void generarItinerario(Usuario usuario) {

	}

	// Recorre la lista usuarios, les asigna las sugerencias y genera sus
	// itinenarios, se utilizaria en el JUnit
	public void probarSistema() {
		System.out.println();
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println("Usuario: " + usuarios.get(i).getNombre());
			sugerirPromociones(usuarios.get(i));
			generarItinerario(usuarios.get(i));
		}
		
		
	}

}
