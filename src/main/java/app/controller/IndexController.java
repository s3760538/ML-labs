package app.controller;

import java.util.Map;

import app.controller.paths.Template;
import app.controller.paths.Web;
import app.controller.utils.ViewUtil;
import app.dao.PersonDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;




public class IndexController {


    public static Handler serveIndexPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        ctx.render(Template.INDEX, model);
    };
    
    public static Handler handleActorSearchPost = ctx -> {
    	Map<String, Object> model = ViewUtil.baseModel(ctx);
    	if (PersonDAO.createPerson(getQueryPersonName(ctx))) 
    	{
    		ctx.redirect(Web.PERSON);
    	}
    	//System.out.println(PersonDAO.getSelectedPerson().getBio().toString());
    	ctx.render(Template.INDEX, model); 
    	//ctx.redirect(Web.PERSON);
    };
    
    public static Handler changeToPerson = ctx -> {
    	Map<String, Object> model = ViewUtil.baseModel(ctx);
    	ctx.render(Template.PERSON, model);
    };
    
    public static String getQueryPersonName(Context ctx) {
    	return ctx.formParam("actorName");
    }


}
