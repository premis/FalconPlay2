package controllers;

import play.mvc.*;


/**
 *
 * @author premis
 *
 * This represents the main Application controller. It will just redirect to the messages display page.
 */
public class Application extends Controller {
  
    public static Result index() {

        return redirect(routes.MessagerController.getMessagerPage());

    }

}
