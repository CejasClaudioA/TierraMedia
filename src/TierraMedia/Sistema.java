package TierraMedia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

	public Sistema(ArrayList<Usuario> usuarios, ArrayList<Promocion> promociones) {
		super();
		this.usuarios = usuarios;
		this.promociones = promociones;
	}

	public void actualizarPromocion(Promocion promocion) {
		for (int i = 0; i < promociones.size(); i++) {
			if (promociones.get(i).equals(promocion)) {
				promociones.get(i).actulizarCupos();
			}
		}
	}

	public void actualizarUsuario(Usuario usuario, Promocion promocion) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).equals(usuario)) {
				usuarios.set(i, usuario);
			}
		}
	}

	// Se envia un usuario por parametros para seleccionar todas las promociones que
	// coincidan con las preferencias del usuario.
	public ArrayList<Promocion> seleccionarPromociones(Usuario usuario, ArrayList<Promocion> promociones) {
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		for (int i = 0; i < promociones.size(); i++) {
			if (usuario.getPreferenciaAtraccion().equals(promociones.get(i).getTipo())
					&& usuario.getTiempoDisponible() > promociones.get(i).getTiempo()
					&& usuario.getPresupuesto() >= promociones.get(i).getMontoPromo()
					&& promociones.get(i).tieneCupos()) {
				promocionesAux.add(promociones.get(i));
			}
		}
		Collections.sort(promocionesAux);
		return promocionesAux;
	}

	public ArrayList<Promocion> seleccionarPromocionesAlternativas(Usuario usuario, ArrayList<Promocion> promociones) {
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		for (int i = 0; i < promociones.size(); i++) {
			if (!usuario.getPreferenciaAtraccion().equals(promociones.get(i).getTipo())
					&& usuario.getTiempoDisponible() > promociones.get(i).getTiempo()
					&& usuario.getPresupuesto() >= promociones.get(i).getMontoPromo()
					&& promociones.get(i).tieneCupos()) {
				promocionesAux.add(promociones.get(i));
			}
		}
		Collections.sort(promocionesAux);
		return promocionesAux;
	}

	public Usuario menu(Usuario usuario, ArrayList<Promocion> promociones) {
		ArrayList<Promocion> promocionesAux = promociones;
		while (seleccionarPromociones(usuario, promocionesAux).size() > 0) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int v;
			promocionesAux = seleccionarPromociones(usuario, promocionesAux);
			System.out.println("Para elegir una sugerencia ingrese el número correspondiente:");
			for (int j = 0; j < promocionesAux.size(); j++) {
				System.out.println((j + 1) + "-" + promocionesAux.get(j).toString());
			}
			v = sc.nextInt();
			v--;
			usuario.setPromociones(promocionesAux.get(v));
			usuario.setPresupuesto(usuario.getPresupuesto() - promocionesAux.get(v).getMonto());
			usuario.setTiempoDisponible(usuario.getTiempoDisponible() - promocionesAux.get(v).getTiempo());
			actualizarPromocion(promocionesAux.get(v));
			actualizarUsuario(usuario, promocionesAux.get(v));
			promocionesAux.remove(v);
		}
		promocionesAux = promociones;
		while (seleccionarPromocionesAlternativas(usuario, promocionesAux).size() > 0) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int v;
			promocionesAux = seleccionarPromocionesAlternativas(usuario, promocionesAux);
			System.out.println("Para elegir una sugerencia alternativa ingrese el número correspondiente:");
			for (int j = 0; j < promocionesAux.size(); j++) {
				System.out.println((j + 1) + "-" + promocionesAux.get(j).toString());
			}
			v = sc.nextInt();
			v--;
			usuario.setPromociones(promocionesAux.get(v));
			usuario.setPresupuesto(usuario.getPresupuesto() - promocionesAux.get(v).getMonto());
			usuario.setTiempoDisponible(usuario.getTiempoDisponible() - promocionesAux.get(v).getTiempo());
			promocionesAux.remove(v);
		}
		return usuario;
	}

	public void sugerirPromociones(Usuario usuario) throws IOException {
		ArrayList<Promocion> promocionesAux = this.promociones;
		System.out.println("Seleccione las promociones:");
		generarItinerario(menu(usuario, promocionesAux));
	}

	public void generarItinerario(Usuario usuario) throws IOException {
		File nombre_de_objeto_fichero = new File(
				"C:/Users/Public/Documents/atracciones" + usuario.getNombre() + ".txt");

		BufferedWriter bw = new BufferedWriter(new FileWriter(nombre_de_objeto_fichero));

		for (int i = 0; i < usuario.getPromociones().size(); i++) {
			bw.write(usuario.getPromociones().get(i).getAtracciones());
		}

		bw.write(usuario.getTotalesPromociones());
		bw.close();
//        for (int i = 0; i < usuario.getPromociones().size(); i++) {
//			
//			bw.write(usuario.toString());
//		}

//		 int nombreFichero = (int) Math.floor(Math.random()*6+1);

//		FileWriter fichero = new FileWriter("C:/Users/Public/Documents/atracciones"+nombreFichero+".txt");
//		fichero.write(usuario.getPromociones().toString());
//		for (int i = 0; i < usuario.getPromociones().size(); i++) {
//			
//			
//		fichero.write(usuario.getPromociones().get(i).getMonto()+" es");
//		}

//		for (int i = 0; i < usuario.getPromociones().size(); i++) {
//			
//			fichero.write(usuario.toString());
//		}

//		fichero.close();
	}

	// Recorre la lista usuarios, les asigna las sugerencias y genera sus
	// itinenarios, se utilizaria en el JUnit
	public void probarSistema() throws IOException {
		for (int i = 0; i < this.usuarios.size(); i++) {
			System.out.println(this.usuarios.get(i).toString());
			sugerirPromociones(this.usuarios.get(i));
		}

	}

}
