package br.senai.maria.api;

import java.util.Set;

import br.senai.maria.controller.handler.ExceptionHandler;
import br.senai.maria.controller.login.LoginController;
import br.senai.maria.controller.message.MessageController;

/**
*
* @author everton
*/
@javax.ws.rs.ApplicationPath("/rest")
public class Application extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {

    	resources.add(CORSFilter.class);
    	resources.add(ConfigContextResolver.class);
    	resources.add(ExceptionHandler.class);
    	resources.add(MessageController.class);
    	resources.add(LoginController.class);
    	
    }
}
