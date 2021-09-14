package TierraMedia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sistema {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Atraccion> atracciones;
	private ArrayList<Promocion> promociones;

	public Sistema() throws IOException {
		this.usuarios = cargarUsuarios(); 
		this.atracciones = cargarAtracciones(); 
		this.promociones = cargarPromociones();
	}

	public Sistema(ArrayList<Usuario> usuarios, ArrayList<Promocion> promociones) {
		super();
		this.usuarios = usuarios;
		this.promociones = promociones;
	}
	
	
	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public ArrayList<Usuario> cargarUsuarios() throws IOException {
		FileReader  fr = new FileReader ("usuarios.txt");
		BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
		ArrayList<Usuario> usuariosAux = new ArrayList<>();
        ArrayList<String> aux = new ArrayList<String>();
        while((linea != null)){
        	aux.add(linea);
            linea = br.readLine();
            if(aux.size() == 4) {
            	double auxDouble1 = Double.parseDouble(aux.get(1));
            	double auxDouble2 = Double.parseDouble(aux.get(2));
            	usuariosAux.add(new Usuario(aux.get(0),auxDouble1, auxDouble2, TipoAtraccionEnum.valueOf(aux.get(3))));
            	aux = new ArrayList<String>();
            }
        }
        return usuariosAux;
	}
	
	public ArrayList<Atraccion> cargarAtracciones() throws IOException {
		FileReader  fr = new FileReader ("atracciones.txt");
		BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        ArrayList<Atraccion> atraccionesAux = new ArrayList<>();
        ArrayList<String> aux = new ArrayList<String>();
        while((linea != null)){
        	aux.add(linea);
            linea = br.readLine();
            if(aux.size() == 5) {
            	double auxDouble1 = Double.parseDouble(aux.get(1));
            	double auxDouble2 = Double.parseDouble(aux.get(2));
            	int auxInteger = Integer.parseInt(aux.get(3)); 
            	atraccionesAux.add(new Atraccion(aux.get(0), auxDouble1, auxDouble2, auxInteger, TipoAtraccionEnum.valueOf(aux.get(4))));
            	aux = new ArrayList<String>();
            }
        }
        return atraccionesAux;
	}
	
	public ArrayList<Promocion> cargarPromociones() throws IOException {
		FileReader  fr = new FileReader ("promociones.txt");
		BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<String>();
		String[] array;
		while((linea != null)){
        	aux.add(linea);
            linea = br.readLine();
            if(aux.size() == 4) {
            	ArrayList<Atraccion> atraccionesAux = new ArrayList<>();
            	switch(TipoPromocionEnum.valueOf(aux.get(2))) {
            		case PROMOCIONPORCENTUAL:
            			array = aux.get(3).split("\\|",-1);
            			for (int i = 0; i < array.length - 1; i++) {
                    		atraccionesAux.add(seleccionarAtraccion(array[i]));
                		}
            			int auxInteger = Integer.parseInt(array[array.length - 1]);
            			Promocion PromocionPorcentual = new PromocionPorcentual(aux.get(0), TipoAtraccionEnum.valueOf(aux.get(1)), TipoPromocionEnum.valueOf(aux.get(2)), atraccionesAux, auxInteger);
            			promocionesAux.add(PromocionPorcentual);
            			break;
            		case PROMOCIONABSOLUTA:
            			array = aux.get(3).split("\\|",-1);
            			for (int i = 0; i < array.length; i++) {
                    		atraccionesAux.add(seleccionarAtraccion(array[i]));
                		}
            			Promocion PromocionAbsoluta = new PromocionAbsoluta(aux.get(0), TipoAtraccionEnum.valueOf(aux.get(1)), TipoPromocionEnum.valueOf(aux.get(2)), atraccionesAux);
            			promocionesAux.add(PromocionAbsoluta);
            			break;
            		case PROMOCIONAXB:
            			array = aux.get(3).split("\\|",-1);
            			for (int i = 0; i < array.length; i++) {
                    		atraccionesAux.add(seleccionarAtraccion(array[i]));
                		}
            			Promocion PromocionAxB = new PromocionAxB(aux.get(0), TipoAtraccionEnum.valueOf(aux.get(1)), TipoPromocionEnum.valueOf(aux.get(2)), atraccionesAux);
            			promocionesAux.add(PromocionAxB);
            			break;
            			
            	}
            	atraccionesAux = new ArrayList<>();
            	aux = new ArrayList<String>();
            }
        }
		return promocionesAux;
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
	
	public Atraccion seleccionarAtraccion(String atraccion){
		Atraccion aux = new Atraccion();
		for (int i = 0; i < atracciones.size(); i++) {
			if(atracciones.get(i).getNombre().equals(atraccion)) {
				aux = atracciones.get(i);
				break;
			}
		}
		return aux;
	}

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
			actualizarPromocion(promocionesAux.get(v));
			actualizarUsuario(usuario, promocionesAux.get(v));
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
		bw.write("Nombre del Usuario: " + usuario.getNombre() + " | Su presupuesto: " + usuario.getPresupuesto() + " | Su tiempo disponible: " + usuario.getTiempoDisponible() + "\n" + "\n");
		for (int i = 0; i < usuario.getPromociones().size(); i++) {
			bw.write(usuario.getPromociones().get(i).getAtracciones());
		}

		bw.write(usuario.getTotalesPromociones());
		bw.close();
	}

	public void probarSistema() throws IOException {
		for (int i = 0; i < this.usuarios.size(); i++) {
			System.out.println(this.usuarios.get(i).toString());
			sugerirPromociones(this.usuarios.get(i));
		}

	}

}
