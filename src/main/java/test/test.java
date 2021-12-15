package test;

import java.util.List;

import model.Attraction;
import model.Promotion;
import services.AttractionService;
import services.PromotionService;

public class test {

	public static void main(String[] args) {
		AttractionService attractionService = new AttractionService();
		List<Attraction> attractions = attractionService.listByTypeAttraction("DEGUSTACION");
		System.out.println(attractions);
		
	}

}
