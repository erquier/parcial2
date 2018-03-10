import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.client.api.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class App {
    public static void main(String[] args) {
    	Logger log = LoggerFactory.getLogger(App.class);
    	
    	staticFiles.location("/public");
    	
    	
    	 get("/", (req , res) -> {
         	res.redirect("/start");
         	res.status(200);
         	return null;
         }, new FreeMarkerEngine());
        
    	 get("/start", (req , res) -> {
        	Map<String, Object> model = new HashMap<>();
        	model.put("titulo", "Titulo de mi pagina");
        	res.status(200);
        	return new ModelAndView(model, "index.ftl");
        }, new FreeMarkerEngine());
    	 
    	 
    	 get("/home", (req , res) -> {
    		 Map<String, Object> model = new HashMap<>();
           	res.status(200);
         	return new ModelAndView(model, "home.ftl");
          }, new FreeMarkerEngine());
    	 
    	 
    	 
    	 get("/contactus", (req , res) -> {
    		 Map<String, Object> model = new HashMap<>();
           	res.status(200);
         	return new ModelAndView(model, "contactus.ftl");
          }, new FreeMarkerEngine());
    	 
    	 get("/aboutus", (req , res) -> {
    		 Map<String, Object> model = new HashMap<>();
           	res.status(200);
         	return new ModelAndView(model, "aboutus.ftl");
          }, new FreeMarkerEngine());
    	 
    	 get("/login", (req , res) -> {
    		 Map<String, Object> model = new HashMap<>();
           	res.status(200);
         	return new ModelAndView(model, "login.ftl");
          }, new FreeMarkerEngine());
    	 
    	 before("/articulos/*", (req, res)->{
    		 halt(302, "working on it");	
    	 });
    	 
    	 //REGISTRO
    	 get("/registro", (req , res) -> {
    		 Map<String, Object> model = new HashMap<>();
           	res.status(200);
         	return new ModelAndView(model, "register.ftl");
          }, new FreeMarkerEngine());
    	 
    	  
    	  post("/registro", (req, res)->{
    		 String nombre = req.queryParams("Name");
    		 String correo = req.queryParams("Email");
    		 String password = req.queryParams("Pass");
    		 
    		 User user = new User (nombre, correo, password);
    		 ArrayList<User> Names = req.session().attribute("usuarios");
    		 if(Names == null) {
    			 Names = new ArrayList<User>();
    		 }
    		 Names.add(user);
    		 req.session().attribute("usuarios",Names);
    		 
    		 return user.getInfo();
    	 });
    	  
    	  get("/articulos", (req , res) -> {
     		 Map<String, Object> model = new HashMap<>();
            	res.status(200);
          	return new ModelAndView(model, "products.ftl");
           }, new FreeMarkerEngine());
    	  
    	  
    	 
    	//Pagina ME
    	 get("/me", (req, res) -> {
         	Map<String, Object> model = new HashMap<>();
         	User u = req.session().attribute("usuarioGuardado");
         	model.put("user", u);
         	return new ModelAndView(model, "userInfo.ftl");
         }, new FreeMarkerEngine());
    	 
    	    
        
    }//FIN DEL MAIN
}//FIN DE LA CLASE


/**
 
post("/registrar", (req, res) -> {
Map<String, Object> model = new HashMap<>();
String nombre = req.queryParamOrDefault("nombre", "Template");
String correo = req.queryParamOrDefault("correo", "Examen@template.com");
String password = req.queryParamOrDefault("password", "template01password01test");

User user = new User(nombre, correo, password);
req.session().attribute("usuarioGuardado");
res.redirect("/me");
res.status(200);
return null;
}, new FreeMarkerEngine());

 */


/** post("/registrar", (req, res) -> {
	 Map<String, Object> model = new HashMap<>();
	 String nombre = req.queryParamOrDefault("nombre", "Template");
	 String correo = req.queryParamOrDefault("correo", "Examen@template.com");
	 String password = req.queryParamOrDefault("password", "template01password01test");

	 User user = new User(nombre, correo, password);
	 
	 req.session().attribute("usuarioGuardado");
	 res.redirect("/me");
	 res.status(200);
	 return null;
	 }, new FreeMarkerEngine());**/

