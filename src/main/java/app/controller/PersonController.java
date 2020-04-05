package app.controller;

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
        
        ctx.render(Template.PERSON, model);
    };
}
