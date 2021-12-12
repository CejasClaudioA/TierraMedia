package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import model.Promotion;
import model.PromotionAbsoluta;
import model.PromotionAxB;
import model.PromotionPorcentual;
import persistence.PromotionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class PromotionDAOImpl implements PromotionDAO{

	@Override
	public Promotion find(Integer id) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Promotion promotions = null;
			if (resultados.next()) {
				promotions = toPromotion(resultados);
			}

			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Promotion> findAll() {
		try {
			String sql = "SELECT * FROM PROMOTIONS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Promotion> promotions = new LinkedList<Promotion>();
			while (resultados.next()) {
				promotions.add(toPromotion(resultados));
			}
			Collections.sort(promotions);
			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	@Override
	public List<Promotion> findByType(String type) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE type = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, type);
			ResultSet resultados = statement.executeQuery();

			List<Promotion> promotions = new LinkedList<Promotion>();
			while (resultados.next()) {
				promotions.add(toPromotion(resultados));
			}
			Collections.sort(promotions);
			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public List<Promotion> findByAlternativeType(String type) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE type != ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, type);
			ResultSet resultados = statement.executeQuery();

			List<Promotion> promotions = new LinkedList<Promotion>();
			while (resultados.next()) {
				promotions.add(toPromotion(resultados));
			}
			Collections.sort(promotions);
			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM PROMOTIONS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Promotion promotion) {
		return 0;
	}

	@Override
	public int update(Promotion promotion) {
		try {
			String sql = "UPDATE PROMOTIONS SET NAME = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promotion.getName());
			statement.setInt(2, promotion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Promotion promotion) {
		try {
			String sql = "DELETE FROM PROMOTIONS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, promotion.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private Promotion toPromotion(ResultSet promotionRegister) throws SQLException {
		Promotion Promotion = null;
		switch (promotionRegister.getString("typeProm")) {
		case "PROMOCIONABSOLUTA":
			Promotion = new PromotionAbsoluta(promotionRegister.getInt("id"), promotionRegister.getString("name"), promotionRegister.getString("type"), promotionRegister.getString("typeProm"), promotionRegister.getString("attractions"));
		case "PROMOCIONPORCENTUAL":
			Promotion = new PromotionPorcentual(promotionRegister.getInt("id"), promotionRegister.getString("name"), promotionRegister.getString("type"), promotionRegister.getString("typeProm"), promotionRegister.getString("attractions"), promotionRegister.getInt("discount"));
		case "PROMOCIONAXB":
			Promotion = new PromotionAxB(promotionRegister.getInt("id"), promotionRegister.getString("name"), promotionRegister.getString("type"), promotionRegister.getString("typeProm"), promotionRegister.getString("attractions"));
		}
		return Promotion;
	}
	
	

}
