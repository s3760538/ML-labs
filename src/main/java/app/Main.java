package app;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

import app.controller.AccountController;
import app.controller.IndexController;
import app.controller.LoginController;
<<<<<<< HEAD
import app.controller.PersonController;
=======
import app.controller.ShowController;
>>>>>>> 351c1ab14f945768af9e944b3fa208898e3d0b19
import app.controller.paths.Web;
import app.controller.utils.ViewUtil;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;





public class Main {





    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public");
            config.registerPlugin(new RouteOverviewPlugin("/routes"));
        }).start(getHerokuAssignedPort());

        app.routes(() -> {
            // You will have to update this, to limit who can see the reviews
            // before(LoginController.ensureLoginBeforeViewing);

            get(Web.INDEX, IndexController.serveIndexPage);
            post(Web.INDEX, IndexController.handleActorSearchPost);
           
            get(Web.LOGIN, LoginController.serveLoginPage);
            post(Web.LOGIN, LoginController.handleLoginPost);
            post(Web.LOGOUT, LoginController.handleLogoutPost);

            get(Web.ACCOUNT, AccountController.serveAccountPage);
            get(Web.PERSON, PersonController.servePersonPage);
            
            // Add new actions here
            // Seeing pages (get) and sending information in forms (post)
            get(Web.SHOW, ShowController.serveShowPage);
        });

        app.error(404, ViewUtil.notFound);
    }






    public static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 7000;
    }



}
