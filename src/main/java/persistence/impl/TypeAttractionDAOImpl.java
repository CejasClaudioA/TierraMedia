package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.TypeAttraction;
import persistence.TypeAttractionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class TypeAttractionDAOImpl implements TypeAttractionDAO{

	@Override
	public TypeAttraction find(Integer id) {
		try {
			String sql = "SELECT * FROM TYPEATTRACTIONS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			TypeAttraction typeAttraction = null;

			if (resultados.next()) {
				typeAttraction = toTypeAttraction(resultados);
			}

			statement.close();
			return typeAttraction;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<TypeAttraction> findAll() {
		try {
			String sql = "SELECT * FROM TYPEATTRACTIONS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<TypeAttraction> typeAttractions = new LinkedList<TypeAttraction>();
			while (resultados.next()) {
				typeAttractions.add(toTypeAttraction(resultados));
			}

			statement.close();
			return typeAttractions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM TYPEATTRACTIONS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			statement.close();
			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(TypeAttraction typeAttraction) {
		try {
			String sql = "INSERT INTO TYPEATTRACTIONS (ID, DESC) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, typeAttraction.getId());
			statement.setString(2, typeAttraction.getDesc());
			int rows = statement.executeUpdate();

			statement.close();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(TypeAttraction typeAttractiont) {
		return 0;
	}

	@Override
	public int delete(TypeAttraction typeAttraction) {
		return 0;
	}
	
	public TypeAttraction toTypeAttraction(ResultSet userRegister) throws SQLException {
		return new TypeAttraction(userRegister.getInt("id"), userRegister.getString("desc"));
	}
}
