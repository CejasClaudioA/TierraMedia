package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class User {

	private Integer id;
	private String username, password, img, preference;
	private Boolean admin;
	private Double coins;
	private Double time;
	private String attractionsId;
	
	private Map<String, String> errors;
	
	public User(Integer id, String username, String password, String img, String preference, Boolean admin,Double coins, Double time) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.img = img;
		this.preference = preference;
		this.admin = admin;
		this.coins = coins;
		this.time = time;
	}	
	
	public User(Integer id, String username, String preference, Double coins, Double time) {
		this.id = id;
		this.username = username;
		this.preference = preference;
		this.coins = coins;
		this.time = time;
	}
	
	public void validate() {
		errors = new HashMap<String, String>();
		if (coins <= 0) {
			errors.put("coins", "Debe ser positivo");
		}
		if (time <= 0) {
			errors.put("time", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public ArrayList<Attraction> getAttraction(){
		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		ArrayList<Attraction> attraction = new ArrayList<>();
		if(this.attractionsId != null) {
			for (String s : this.attractionsId.split("\\|")) {
				attraction.add(attractionDAO.find(Integer.parseInt(s)));
			}
		}
		return attraction;
	}

	public void addToItinerary(Attraction attraction) {
		this.coins -= attraction.getCost();
		this.time -= attraction.getDuration();
		
		if(this.attractionsId != null) {
			this.attractionsId += attraction.getId() + "|";
		}else {
			this.attractionsId = "";
			this.attractionsId = attraction.getId() + "|";
		}
	}
	
	public void addPromotionToItinerary(Promotion promotion) {
		this.coins -= promotion.getMontoPromo();
		this.time -= promotion.getTotalDuration();
		if(this.attractionsId != null) {
			this.attractionsId += promotion.getAttractionsId();
		}else{
			this.attractionsId = "";
			this.attractionsId += promotion.getAttractionsId();
		}
		
	}

	public boolean canAfford(Attraction attraction) {
		return attraction.getCost() <= this.coins;
	}
	
	public boolean canAffordPromotion(Promotion promotion) {
		return promotion.getMontoPromo() <= this.coins;
	}

	public boolean canAttend(Attraction attraction) {
		return attraction.getDuration() <= this.time;
	}
	public boolean canAttendPromotion(Promotion promotion) {
		boolean aux = false;
		for (Attraction attraction : promotion.getAttraction()) {
			if(!canAttend(attraction)) {
				aux = false;
				break;
			}
			aux = canAttend(attraction);
		}
		return aux;
		
	}
	
	public boolean allreadyHave(Attraction attraction) {
		boolean aux = true;
			if(this.attractionsId != null) {
				for (String s : this.attractionsId.split("\\|")) {
						if(attraction.getId() == Integer.parseInt(s)){
							aux = false;
							break;
						}
				}
		}
		return aux;
	}
	
	public boolean allreadyHavePromotion(Promotion promotion) {
		boolean aux = true;
		for (Attraction attraction : promotion.getAttraction()) {
			if(this.attractionsId != null) {
				if(!allreadyHave(attraction)) {
					aux = false;
					break;
				}
			}
		}
		return aux;
	}
	
	public boolean hasPreferencePromotion(Promotion promotion) {
		return this.preference.equals(promotion.getType());		
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	
	public String getAttractionsId() {
		return attractionsId;
	}

	public void setAttractionsId(String attractionsId) {
		this.attractionsId = attractionsId;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public Double getCoins() {
		return coins;
	}

	public Integer getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Double getTime() {
		return time;
	}

	public String getUsername() {
		return username;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public boolean isNull() {
		return false;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public void setCoins(Double coins) {
		this.coins = coins;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin + "]";
	}

}
