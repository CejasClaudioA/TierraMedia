package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import persistence.AttractionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class AttractionDAOImpl implements AttractionDAO {

	public List<Attraction> findAll() {
		try {
			String sql = "SELECT * FROM ATTRACTIONS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			List<Attraction> attractions = new LinkedList<Attraction>();
			while (resultados.next()) {
				attractions.add(toAttraction(resultados));
			}
			statement.close();
			return attractions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	@Override
	public List<Attraction> findByAttractionsId(String attractionsId) {
		List<Attraction> attractions = new LinkedList<Attraction>();
		if(attractionsId != null) {
			for (String s : attractionsId.split("\\|")) {
				attractions.add(find(Integer.parseInt(s)));
			}
		}
		return attractions;
	}

	@Override
	public Attraction find(Integer id) {
		try {
			String sql = "SELECT * FROM ATTRACTIONS WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultados = statement.executeQuery();

			Attraction attraction = null;
			if (resultados.next()) {
				attraction = toAttraction(resultados);
			}
			
			statement.close();
			return attraction;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public List<Attraction> findByTypeAttraction(String TypeAttraction) {
		try {
			String sql = "SELECT * FROM ATTRACTIONS WHERE type = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, TypeAttraction);
			
			ResultSet resultados = statement.executeQuery();
			
			List<Attraction> attractions = new LinkedList<Attraction>();
			while (resultados.next()) {
				attractions.add(toAttraction(resultados));
			}
			statement.close();
			return attractions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private Attraction toAttraction(ResultSet attractionRegister) throws SQLException {
		return new Attraction(attractionRegister.getInt("id"), attractionRegister.getString("name"), attractionRegister.getString("img"), attractionRegister.getString("desc"),attractionRegister.getDouble("cost"), attractionRegister.getDouble("duration"), attractionRegister.getInt("capacity"), attractionRegister.getString("type"));
	}

	@Override
	public int insert(Attraction attraction) {
		try {
			String sql = "INSERT INTO ATTRACTIONS (NAME, TYPE, COST, DURATION, CAPACITY) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, attraction.getName());
			statement.setString(i++, attraction.getType());
			statement.setDouble(i++, attraction.getCost());
			statement.setDouble(i++, attraction.getDuration());
			statement.setInt(i++, attraction.getCapacity());
			int rows = statement.executeUpdate();
			
			statement.close();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Attraction attraction) {
		try {
			String sql = "UPDATE ATTRACTIONS SET NAME = ?, TYPE = ?, COST = ?, DURATION = ?, CAPACITY = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, attraction.getName());
			statement.setString(2, attraction.getType());
			statement.setDouble(3, attraction.getCost());
			statement.setDouble(4, attraction.getDuration());
			statement.setInt(5, attraction.getCapacity());
			statement.setInt(6, attraction.getId());
			int rows = statement.executeUpdate();
			
			statement.close();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Attraction attraction) {
		try {
			String sql = "DELETE FROM ATTRACTIONS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, attraction.getId());
			int rows = statement.executeUpdate();
			
			statement.close();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM ATTRACTIONS";
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


}
