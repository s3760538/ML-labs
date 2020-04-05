package app.controller;

import java.util.Map;

import app.controller.paths.Template;
import app.controller.utils.ViewUtil;
import app.dao.ShowDAO;
import io.javalin.http.Handler;

public class ShowController
{
	public static Handler serveShowPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        
        //model.put(ShowDAO.accessShow(0).toString());
        
        model.put("ShowInformation", ShowDAO.accessShow(0).toString());
        ctx.render(Template.SHOW, model);
	};

}
