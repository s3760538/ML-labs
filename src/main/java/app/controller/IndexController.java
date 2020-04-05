package app.controller;

import java.util.Map;

import app.controller.paths.Template;
import app.controller.paths.Web;
import app.controller.utils.ViewUtil;
import app.dao.PersonDAO;
import app.dao.ShowDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;




public class IndexController {


    public static Handler serveIndexPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        ctx.render(Template.INDEX, model);
    };
    
    // Show and actor search
    public static Handler handleSearchPost = ctx -> {
    	Map<String, Object> model = ViewUtil.baseModel(ctx);
    	if (ShowDAO.createShow(getQueryShowTitle(ctx))) {
    		ctx.redirect(Web.SHOW);
    	} else if (PersonDAO.createPerson(getQueryPersonName(ctx))) {
    		ctx.redirect(Web.PERSON);
    	}
    	ctx.render(Template.INDEX, model); 
    };
    
    public static Handler changeToPerson = ctx -> {
    	Map<String, Object> model = ViewUtil.baseModel(ctx);
    	ctx.render(Template.PERSON, model);
    };
    
    public static Handler changeToShow = ctx -> {
    	Map<String, Object> model = ViewUtil.baseModel(ctx);
    	ctx.render(Template.SHOW, model);
    };
    
    public static String getQueryPersonName(Context ctx) {
    	return ctx.formParam("actorName");
    }

    public static String getQueryShowTitle(Context ctx) {
    	return ctx.formParam("showTitle");
    }

}
