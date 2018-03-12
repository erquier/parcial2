import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class App {
    public static void main(String[] args) {
    	Logger log = LoggerFactory.getLogger(App.class);
    	
    	staticFiles.location("/public");
    	
    	//before
    	before((req, res) ->{
    		ArrayList<User> lista = req.session().attribute("usuarios");
    		
    		if(lista == null) {
    			lista = new ArrayList<User>();
    		}
    		
    		// usuario administrador
    		
    		boolean isAdminCreated = false;
    		for(User u: lista) {
    			if(u.getNombre() == "admin") {
    				isAdminCreated = true;
    			}
    		}
    		
    		if(!isAdminCreated) {
    			User u = new User ("admin", "admin", "0");
    			lista.add(u);
    			log.info("admin creado");
    		}
    		
    		req.session().attribute("usuarios", lista);
    		
    	});
    	
    	before("/no-entre" ,(req,res) -> {  
    		
    		User user = req.session().attribute("user");
    		res.redirect("/start");
    		if (user == null) { halt(401, "Se equivoco, Bai"); }
    	});
    	
    	
    	exception(SessionNoLogeada.class, (e,req,res) -> {
    		
    		res.status(401); 
    		res.body(e.toString());
    	});
    	
    	
    	before("/articulos/*", (req, res)->{
   		 halt(302, "working on it");	
   	 });
    	
    	
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
    	 
    	 
    	 
    	 //Login
    	 get("/iniciar-session", (req , res) -> {
    		 Map<String, Object> model = new HashMap<>();
           	res.status(200);
         	return new ModelAndView(model, "login.ftl");
          }, new FreeMarkerEngine());
    	 
    	 post("/iniciar-session", (req, res)->{
    		 	String nombre = req.queryParams("nombre");
    			
    			ArrayList<User> lista = req.session().attribute("login");

    			
    			if(lista == null)  {return "list equals null , you can't Log in";}
    				
    				boolean inicioSesion = false;
    				for(User u : lista) {
    				
    				if(u.getNombre() == nombre) { 
    					req.session().attribute("usuarioIniciado", u);
    					inicioSesion = true;
    					}
    			}
    				if (inicioSesion) {return "Loged in succesfully";}
    				
    				
    				
    			return "not loged, need to log in";
    		});//FIN INICIO SESION
    	
    	    	 
    	 
    	 
    	 //REGISTRO
    	 get("/registro", (req , res) -> {
    		 Map<String, Object> model = new HashMap<>();
           	res.status(200);
         	return new ModelAndView(model, "register.ftl");
          }, new FreeMarkerEngine());
    	 
    	  
    	  post("/registro", (req, res)->{
    		  log.info("testing testing U.U");
    		 String nombre = req.queryParams("nombre");
    		 String correo = req.queryParams("correo");
    		 String password = req.queryParams("password");
    		 
    		 User user = new User (nombre, correo, password);
    		 ArrayList<User> Names = req.session().attribute("usuarios");
    		 if(Names == null) {
    			 Names = new ArrayList<User>();
    		 }
    		 Names.add(user);
    		 req.session().attribute("usuarios",Names);
    		 res.redirect("/me");
    		 
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

