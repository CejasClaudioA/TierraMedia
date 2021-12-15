package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.TypeAttraction;
import model.TypePromotion;
import persistence.TypePromotionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class TypePromotionDAOImpl implements TypePromotionDAO{

	@Override
	public TypePromotion find(Integer id) {
		try {
			String sql = "SELECT * FROM TYPEPROMOTIONS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			TypePromotion typePromotion = null;

			if (resultados.next()) {
				typePromotion = toTypePromotion(resultados);
			}

			statement.close();
			return typePromotion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<TypePromotion> findAll() {
		try {
			String sql = "SELECT * FROM TYPEPROMOTIONS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<TypePromotion> typePromotion = new LinkedList<TypePromotion>();
			while (resultados.next()) {
				typePromotion.add(toTypePromotion(resultados));
			}

			statement.close();
			return typePromotion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM TYPEPROMOTIONS";
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
	public int insert(TypePromotion typePromotion) {
		try {
			String sql = "INSERT INTO TYPEPROMOTIONS (ID, DESC) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, typePromotion.getId());
			statement.setString(2, typePromotion.getDesc());
			int rows = statement.executeUpdate();

			statement.close();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(TypePromotion typePromotion) {
		return 0;
	}

	@Override
	public int delete(TypePromotion typePromotion) {
		return 0;
	}
	
	public TypePromotion toTypePromotion(ResultSet userRegister) throws SQLException {
		return new TypePromotion(userRegister.getInt("id"), userRegister.getString("desc"));
	}
}
