package TierraMedia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sistema {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Promocion> promociones;

	public Sistema() throws IOException, SQLException {
		this.promociones = cargarPromocionesDao();
		this.usuarios = cargarUsuariosDAO();
	}

	public void reset() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from Atracciones");
		preparedStatement.executeUpdate();
		preparedStatement = connection
				.prepareStatement("INSERT INTO Atracciones(nombre, costoDeVisita, tiempo, cupo, tipoAtraccion) VALUES  "
						+ "('Minas Tirith', 5.0, 2.5, 10, 'PAISAJE'), ('La Comarca', 5.0, 2.5, 10, 'PAISAJE'), "
						+ "('Mordor', 25.0, 3.0, 4, 'AVENTURA'), ('Abismo de Helm', 5.0, 2.0, 14, 'PAISAJE'), "
						+ "('Lothlorien', 35.0, 1.0, 7, 'DEGUSTACION'), " + "('Erebor', 12.0, 3.0, 10, 'PAISAJE'), "
						+ "('Bosque Negro', 3.0, 4.0, 3, 'AVENTURA'), "
						+ "('Monte del Destino', 40.0, 7.0, 2, 'AVENTURA'), "
						+ "('Rivendel', 16.5, 1.5, 10, 'PAISAJE'), " + "('Moria', 11.0, 2.5, 6, 'AVENTURA'), "
						+ "('Numeror', 4.5, 3.0, 23, 'PAISAJE'), " + "('Fangorn', 5.5, 6.0, 2, 'DEGUSTACION');");

		preparedStatement.executeUpdate();
		preparedStatement = connection.prepareStatement("delete from Promociones");
		preparedStatement.executeUpdate();
		preparedStatement = connection
				.prepareStatement("INSERT INTO Promociones(nombre, tipo, tipoProm, atraccion, descuento) VALUES "
						+ "('Pack Aventura V1', 'AVENTURA', 'PROMOCIONPORCENTUAL', 'Bosque Negro|Mordor', 20), "
						+ "('Pack Degustacion V1', 'DEGUSTACION', 'PROMOCIONABSOLUTA', 'Lothlorien|La Comarca', NULL), "
						+ "('Pack Paisajes V1', 'PAISAJE', 'PROMOCIONAXB', 'Minas Tirith|Abismo de Helm|Erebor', NULL), "
						+ "('Pack Aventura V2', 'AVENTURA', 'PROMOCIONABSOLUTA', 'Monte del Destino|Moria', NULL), "
						+ "('Pack Paisaje V2', 'PAISAJE', 'PROMOCIONAXB', 'Rivendel|Numeror', NULL), "
						+ "('Pack Degustacion V2', 'DEGUSTACION', 'PROMOCIONPORCENTUAL', 'Lothlorien|Fangorn', 35);");

		preparedStatement.executeUpdate();

		preparedStatement = connection.prepareStatement("delete from Usuarios");
		preparedStatement.executeUpdate();
		preparedStatement = connection.prepareStatement(
				"INSERT INTO Usuarios(nombre, presupuesto, tiempoDisponible, preferenciaAtraccion) VALUES "
						+ "('Sam', 36.5, 20.0, 'DEGUSTACION'), " + "('Gandalf', 100.0, 50.0, 'PAISAJE'), "
						+ "('Eowyn', 100.0, 80.0, 'AVENTURA'), " + "('Galadriel', 45.0, 100.0, 'PAISAJE'), "
						+ "('Frodo', 65.0, 56.5, 'AVENTURA'), " + "('Aragorn', 25.0, 200.0, 'DEGUSTACION'), "
						+ "('Saruman', 49.5, 33.5, 'PAISAJE');");
		preparedStatement.executeUpdate();
		
		this.promociones = cargarPromocionesDao();
		this.usuarios = cargarUsuariosDAO();
	}

	public ArrayList<Usuario> cargarUsuariosDAO() throws SQLException {
		ArrayList<Usuario> usuariosAux = new ArrayList<>();
		@SuppressWarnings("unused")
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Usuarios");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Usuario Usuario = new Usuario(resultSet.getString("nombre"), resultSet.getDouble("presupuesto"),
					resultSet.getDouble("tiempoDisponible"),
					TipoAtraccionEnum.valueOf(resultSet.getString("preferenciaAtraccion")));
			if (resultSet.getString("promociones") != null) {
				String[] array = resultSet.getString("promociones").split("\\|");
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < this.promociones.size(); j++) {
						if (array[i].equals(this.promociones.get(j).getNombre())) {
							Usuario.setPromociones(this.promociones.get(j));
						}
					}
				}
			}

			usuariosAux.add(Usuario);
		}
		return usuariosAux;
	}

	public ArrayList<Atraccion> cargarAtraccionesDAO() throws SQLException {
		ArrayList<Atraccion> atraccionesAux = new ArrayList<>();
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Atracciones");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			atraccionesAux.add(new Atraccion(resultSet.getString("nombre"), resultSet.getDouble("costoDeVisita"),
					resultSet.getDouble("tiempo"), resultSet.getInt("cupo"),
					TipoAtraccionEnum.valueOf(resultSet.getString("tipoAtraccion"))));
		}
		return atraccionesAux;
	}

	public ArrayList<Promocion> cargarPromocionesDao() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Promociones");
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		while (resultSet.next()) {
			promocionesAux.add(toPromocion(resultSet));
		}
		return promocionesAux;
	}

	public Atraccion seleccionarAtraccion(String atraccion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from Atracciones WHERE nombre LIKE " + "'" + atraccion + "%';");
		ResultSet resultSet = preparedStatement.executeQuery();
		return new Atraccion(resultSet.getString("nombre"), resultSet.getDouble("costoDeVisita"),
				resultSet.getDouble("tiempo"), resultSet.getInt("cupo"),
				TipoAtraccionEnum.valueOf(resultSet.getString("tipoAtraccion")));
	}

	public void actualizarPromocion(Promocion promocion) throws SQLException {
		String sql = "UPDATE Atracciones SET cupo = ? WHERE nombre = ?";
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		for (int i = 0; i < promocion.getAtraccion().size(); i++) {
			preparedStatement.setInt(1, promocion.getAtraccion().get(i).getCupo() - 1);
			preparedStatement.setString(2, promocion.getAtraccion().get(i).getNombre());
			preparedStatement.executeUpdate();
			cargarAtraccionesDAO();
		}
		cargarPromocionesDao();
	}

	public Usuario actualizarUsuario(Usuario usuario, Promocion promocion, double Presupuesto, double tiempoDisponible)
			throws SQLException {
		usuario.setPromociones(promocion);
		usuario.setPresupuesto(Presupuesto);
		usuario.setTiempoDisponible(tiempoDisponible);
		String sql = "UPDATE Usuarios SET presupuesto = ? , tiempoDisponible = ? , promociones = ? WHERE nombre = ?";
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDouble(1, usuario.getPresupuesto());
		preparedStatement.setDouble(2, usuario.getTiempoDisponible());
		preparedStatement.setString(3, usuario.getPromocionesDAO());
		preparedStatement.setString(4, usuario.getNombre());
		preparedStatement.executeUpdate();
		cargarUsuariosDAO();
		return usuario;
	}

	public ArrayList<Promocion> construirListaPromociones(Usuario usuario, ArrayList<Promocion> promociones) {
		ArrayList<Promocion> selecPromociones = new ArrayList<>();

		for (int i = 0; i < promociones.size(); i++) {
			if (usuario.puedeAñadirPromocion(promociones.get(i))) {
				selecPromociones.add(promociones.get(i));
			}
		}
		Collections.sort(selecPromociones);
		return selecPromociones;
	}

	public ArrayList<Promocion> construirListaPromocionesAlternas(Usuario usuario, ArrayList<Promocion> promociones) {
		ArrayList<Promocion> selecPromociones = new ArrayList<>();

		for (int i = 0; i < promociones.size(); i++) {
			if (usuario.puedeAñadirPromocionAlterna(promociones.get(i))) {
				selecPromociones.add(promociones.get(i));
			}
		}
		Collections.sort(selecPromociones);
		return selecPromociones;
	}

	public Usuario seleccionarPromocionDAO(Usuario usuario) throws SQLException {
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		if (construirListaPromociones(usuario, this.promociones).size() == 0) {
			System.out.println("\t" + "No hay promociones disponibles" + "\n");
		} else {
			promocionesAux = construirListaPromociones(usuario, this.promociones);
			while (promocionesAux.size() > 0) {
				System.out.println("\t" + "Presupuesto restante: " + usuario.getPresupuesto()
						+ "| Tiempo disponible restante: " + usuario.getTiempoDisponible() + "\n");
				System.out.println(
						"\t" + "Seleccione una promocion con el numero correspondiente o escriba x para salir: ");
				for (int i = 0; i < promocionesAux.size(); i++) {
					System.out.println("\t" + (i + 1) + ". " + promocionesAux.get(i));
				}
				String aux = sc.nextLine();
				if (aux.equalsIgnoreCase("x")) {
					break;
				}
				int v = Integer.parseInt(aux);
				v = v - 1;
				if (v >= promocionesAux.size() || v < 0) {
					System.out.println(
							"\n" + "\t" + "Numero incorrecto, por favor ingrese el numero nuevamente: " + "\n");
					construirListaPromociones(usuario, this.promociones);
				} else {
					usuario = actualizarUsuario(usuario, promocionesAux.get(v),
							usuario.getPresupuesto() - promocionesAux.get(v).getMontoPromo(),
							usuario.getTiempoDisponible() - promocionesAux.get(v).getTiempoTotal());
					actualizarPromocion(promocionesAux.get(v));
					promocionesAux.remove(v);
					promocionesAux = construirListaPromociones(usuario, promocionesAux);
				}
			}
		}
		if (construirListaPromocionesAlternas(usuario, this.promociones).size() == 0) {
			System.out.println("\t" + "No hay promociones alternativas disponibles" + "\n");
		} else {
			promocionesAux = construirListaPromocionesAlternas(usuario, this.promociones);
			while (promocionesAux.size() > 0) {
				System.out.println("\t" + "Presupuesto restante: " + usuario.getPresupuesto()
						+ "| Tiempo disponible restante: " + usuario.getTiempoDisponible());
				System.out.println("\t"
						+ "Seleccione una promocion alterna con el numero correspondiente o escriba x para salir: ");
				for (int i = 0; i < promocionesAux.size(); i++) {
					System.out.println("\t" + (i + 1) + ". " + promocionesAux.get(i));
				}
				String aux = sc.nextLine();
				if (aux.equalsIgnoreCase("x")) {
					break;
				}
				int v = Integer.parseInt(aux);
				v = v - 1;
				if (v >= promocionesAux.size() || v < 0) {
					System.out.println(
							"\n" + "\t" + "Numero incorrecto, por favor ingrese el numero nuevamente: " + "\n");
					construirListaPromocionesAlternas(usuario, this.promociones);
				} else {
					usuario = actualizarUsuario(usuario, promocionesAux.get(v),
							usuario.getPresupuesto() - promocionesAux.get(v).getMontoPromo(),
							usuario.getTiempoDisponible() - promocionesAux.get(v).getTiempoTotal());
					actualizarPromocion(promocionesAux.get(v));
					promocionesAux.remove(v);
					promocionesAux = construirListaPromocionesAlternas(usuario, promocionesAux);
				}
			}
		}
		return usuario;
	}

	public Promocion toPromocion(ResultSet resultSet) throws SQLException {
		Promocion Promocion = null;
		String atraccion = resultSet.getString("atraccion");
		ArrayList<Atraccion> atraccionesAux = new ArrayList<>();
		String[] array = atraccion.split("\\|");
		for (int i = 0; i < array.length; i++) {
			atraccionesAux.add(seleccionarAtraccion(array[i]));
		}

		switch (TipoPromocionEnum.valueOf(resultSet.getString("tipoProm"))) {
		case PROMOCIONPORCENTUAL:
			Promocion = new PromocionPorcentual(resultSet.getString("nombre"),
					TipoAtraccionEnum.valueOf(resultSet.getString("tipo")),
					TipoPromocionEnum.valueOf(resultSet.getString("tipoProm")), atraccionesAux,
					resultSet.getInt("descuento"));

			break;
		case PROMOCIONABSOLUTA:
			Promocion = new PromocionAbsoluta(resultSet.getString("nombre"),
					TipoAtraccionEnum.valueOf(resultSet.getString("tipo")),
					TipoPromocionEnum.valueOf(resultSet.getString("tipoProm")), atraccionesAux);
			break;
		case PROMOCIONAXB:
			Promocion = new PromocionAxB(resultSet.getString("nombre"),
					TipoAtraccionEnum.valueOf(resultSet.getString("tipo")),
					TipoPromocionEnum.valueOf(resultSet.getString("tipoProm")), atraccionesAux);
		}
		return Promocion;
	}

	public void menu() throws SQLException, IOException {
		System.out.println("\n" + "TIERRA MEDIA" + "\n");
		System.out.println("Los itinerarios se generaran en el directorio: C:\\Users\\Public\\Documents" + "\n");
		System.out.println("Ingrese a un usuario con el numero correspondiente: " + "\n" + "----------------------");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println((i + 1) + ". " + usuarios.get(i).getNombre());
		}
		System.out.println("----------------------" + "\n" + (usuarios.size() + 1) + ". Resetear usuarios" + "\n"
				+ (usuarios.size() + 2) + ". Salir" + "\n");
		int aux = sc.nextInt();
		aux = aux - 1;
		if (aux == usuarios.size()) {
			System.out.println("\n" + "Todos los usuarios han sido reseteados a sus valores por defecto!" + "\n");
			reset();
			menu();
		} else {
			if (aux == usuarios.size() + 1) {
				System.exit(0);
			} else {
				if (aux >= usuarios.size() || aux < 0) {
					System.out.println("\n" + "Numero incorrecto, por favor ingrese el numero nuevamente: " + "\n");
					menu();
				}
			}
		}
		System.out.println(this.usuarios.get(aux) + "\n");
		this.usuarios.set(aux, seleccionarPromocionDAO(this.usuarios.get(aux)));
		generarItinerario(this.usuarios.get(aux));
		menu();
	}

	public void generarItinerario(Usuario usuario) throws IOException {
		File nombre_de_objeto_fichero = new File(
				"C:/Users/Public/Documents/atracciones" + usuario.getNombre() + ".txt");

		BufferedWriter bw = new BufferedWriter(new FileWriter(nombre_de_objeto_fichero));
		bw.write("Nombre del Usuario: " + usuario.getNombre() + " | Su presupuesto: " + usuario.getPresupuesto()
				+ " | Su tiempo disponible: " + usuario.getTiempoDisponible() + "\n" + "\n");

		for (int i = 0; i < usuario.getPromociones().size(); i++) {
			bw.write(usuario.getPromociones().get(i).getAtracciones());
		}

		bw.write(usuario.getTotalesPromociones());
		bw.close();
	}
}
