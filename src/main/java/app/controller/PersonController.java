package app.controller;

import java.text.DateFormatSymbols;
import java.util.Map;

import app.controller.paths.Template;
import app.controller.utils.ViewUtil;
import app.dao.PersonDAO;
import io.javalin.http.Handler;

public class PersonController {
	
	public static Handler servePersonPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        
        model.put("ActorName", PersonDAO.getSelectedPerson().getFullName().toString());
        model.put("ActorBIO", PersonDAO.getSelectedPerson().getBio().toString());
        model.put("ActorRole", PersonDAO.getSelectedPerson().getRole().toString());
        model.put("ActorPicture", PersonDAO.getSelectedPerson().getPhoto().toString());
        model.put("ActorDOB", formatDOB(PersonDAO.getSelectedPerson().getBirthdate().toString()));
        
        ctx.render(Template.PERSON, model);
    };
    
    //converts date of birth into a more readable format
    private static String formatDOB(String dob) {
    	String month = new DateFormatSymbols().getMonths()[Integer.parseInt( dob.substring(5, 7))];
    	
    	String formated = month + " " + dob.substring(8) + ", " + dob.substring(0, 4);
		return formated;
    	
    }
}