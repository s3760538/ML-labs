package app.controller;

import java.util.Map;

import app.controller.paths.Template;
import app.controller.utils.ViewUtil;
import app.dao.AccountDAO;
import io.javalin.http.Handler;



public class AccountController {

    public static Handler serveAccountPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        
        //model.put(AccountDAO.accessAcount(0).toString());
        
        model.put("UserInformation", AccountDAO.accessAcount(0).toString());
        ctx.render(Template.ACCOUNT, model);
    };




}
