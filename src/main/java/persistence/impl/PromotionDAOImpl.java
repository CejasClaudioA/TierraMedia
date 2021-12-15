package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.Promotion;
import model.PromotionAbsoluta;
import model.PromotionAxB;
import model.PromotionPorcentual;
import persistence.PromotionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import services.AttractionService;

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
			statement.close();
			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	@Override
	public Promotion findByName(String name) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE name = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet resultados = statement.executeQuery();

			Promotion promotions = null;
			if (resultados.next()) {
				promotions = toPromotion(resultados);
			}
			
			statement.close();
			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Promotion findByNameAxB(String name) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE name = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet resultados = statement.executeQuery();

			PromotionAxB promotions = null;
			if (resultados.next()) {
				promotions = toPromotionAxB(resultados);
			}
			
			statement.close();
			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Promotion findByNameAbsolute(String name) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE name = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet resultados = statement.executeQuery();

			PromotionAbsoluta promotions = null;
			if (resultados.next()) {
				promotions = toPromotionAbsoluta(resultados);
			}
			
			statement.close();
			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Promotion findByNamePorcentual(String name) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE name = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet resultados = statement.executeQuery();

			PromotionPorcentual promotions = null;
			if (resultados.next()) {
				promotions = toPromotionPorcentual(resultados);
			}
			
			statement.close();
			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Promotion findByIdAxB(Integer id) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			PromotionAxB promotions = null;
			if (resultados.next()) {
				promotions = toPromotionAxB(resultados);
			}
			
			statement.close();
			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Promotion findByIdAbsolute(Integer id) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			PromotionAbsoluta promotions = null;
			if (resultados.next()) {
				promotions = toPromotionAbsoluta(resultados);
			}
			
			statement.close();
			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Promotion findByIdPorcentual(Integer id) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			PromotionPorcentual promotions = null;
			if (resultados.next()) {
				promotions = toPromotionPorcentual(resultados);
			}
			
			statement.close();
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
				if(resultados.getString("attractions") != null) {
					promotions.add(toPromotion(resultados));
				}
			}
			if(!promotions.isEmpty()) {
				Collections.sort(promotions);
			}
			
			statement.close();
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
				if(resultados.getString("attractions") != null) {
					promotions.add(toPromotion(resultados));
				}
			}
			if(!promotions.isEmpty()) {
				Collections.sort(promotions);
			}
			
			statement.close();
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
				if(resultados.getString("attractions") != null) {
					promotions.add(toPromotion(resultados));
				}
			}
			if(!promotions.isEmpty()) {
				Collections.sort(promotions);
			}
			
			statement.close();
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
			
			statement.close();
			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Promotion promotion) {
		try {
			String sql = "INSERT INTO PROMOTIONS (NAME, TYPE, TYPEPROM) VALUES (?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promotion.getName());
			statement.setString(2, promotion.getType());
			statement.setString(3, promotion.getTypeProm());
			int rows = statement.executeUpdate();
			
			statement.close();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int updateAbsoluta(PromotionAbsoluta promotion) {
		try {
			String sql = "UPDATE PROMOTIONS SET NAME = ?, ATTRACTIONS = ?, TOTALCOST = ?  WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promotion.getName());
			statement.setString(2, promotion.getAttractionsId());
			statement.setDouble(3, promotion.getMontoPromo());
			statement.setInt(4, promotion.getId());
			int rows = statement.executeUpdate();
			statement.close();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int updateAxB(PromotionAxB promotion) {
		try {
			String sql = "UPDATE PROMOTIONS SET NAME = ?, ATTRACTIONS = ?, TOTALCOST = ?  WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promotion.getName());
			statement.setString(2, promotion.getAttractionsId());
			statement.setDouble(3, promotion.getMontoPromo());
			statement.setInt(4, promotion.getId());
			int rows = statement.executeUpdate();
			statement.close();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int updatePorcentual(PromotionPorcentual promotion) {
		try {
			String sql = "UPDATE PROMOTIONS SET NAME = ?, ATTRACTIONS = ?, DISCOUNT = ?, TOTALCOST = ?  WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promotion.getName());
			statement.setString(2, promotion.getAttractionsId());
			statement.setInt(3, promotion.getDiscount());
			statement.setDouble(4, promotion.getMontoPromo());
			statement.setInt(5, promotion.getId());
			int rows = statement.executeUpdate();
			statement.close();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	

	@Override
	public int delete(Integer id) {
		try {
			String sql = "DELETE FROM PROMOTIONS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			int rows = statement.executeUpdate();
			
			statement.close();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private Promotion toPromotion(ResultSet promotionRegister) throws SQLException {
		Promotion Promotion = null;
		switch (promotionRegister.getString("typeProm")) {
		case "PROMOCIONABSOLUTA":
			Promotion = new PromotionAbsoluta(promotionRegister.getInt("id"), promotionRegister.getString("name"), promotionRegister.getString("type"), promotionRegister.getString("typeProm"), promotionRegister.getString("attractions"), promotionRegister.getDouble("totalCost"));
		case "PROMOCIONPORCENTUAL":
			Promotion = new PromotionPorcentual(promotionRegister.getInt("id"), promotionRegister.getString("name"), promotionRegister.getString("type"), promotionRegister.getString("typeProm"), promotionRegister.getString("attractions"), promotionRegister.getDouble("totalCost"), promotionRegister.getInt("discount"));
		case "PROMOCIONAXB":
			Promotion = new PromotionAxB(promotionRegister.getInt("id"), promotionRegister.getString("name"), promotionRegister.getString("type"), promotionRegister.getString("typeProm"), promotionRegister.getString("attractions"), promotionRegister.getDouble("totalCost"));
		}
		return Promotion;
	}
	
	private PromotionAbsoluta toPromotionAbsoluta(ResultSet promotionRegister) throws SQLException {
		PromotionAbsoluta promotionAbsoluta = new PromotionAbsoluta(promotionRegister.getInt("id"), promotionRegister.getString("name"), promotionRegister.getString("type"), promotionRegister.getString("typeProm"));;
		return promotionAbsoluta;
	}
	
	private PromotionAxB toPromotionAxB(ResultSet promotionRegister) throws SQLException {
		
		PromotionAxB promotionAxB = new PromotionAxB(promotionRegister.getInt("id"), promotionRegister.getString("name"), promotionRegister.getString("type"), promotionRegister.getString("typeProm"));
		return promotionAxB;
	}
	
	private PromotionPorcentual toPromotionPorcentual(ResultSet promotionRegister) throws SQLException {
		PromotionPorcentual promotionPorcentual = new PromotionPorcentual(promotionRegister.getInt("id"), promotionRegister.getString("name"), promotionRegister.getString("type"), promotionRegister.getString("typeProm"));
		return promotionPorcentual;
	}

	@Override
	public int update(Promotion t) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int delete(Promotion t) {
		// TODO Auto-generated method stub
		return 0;
	}



}
