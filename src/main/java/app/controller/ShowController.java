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
        
        model.put("ShowName", ShowDAO.getSelectedShow().getShowTitle().toString());
        model.put("ShowType", ShowDAO.getSelectedShow().getType().toString());
        model.put("ShowInformation", ShowDAO.getSelectedShow().getAllInfo().toString());
        
        ctx.render(Template.SHOW, model);
	};
}
