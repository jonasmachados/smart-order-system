
package com.educandoweb.course2.services.exceptions;

/**
 *
 * @author Jonas created 25/01/2021
 */
//SUBCLASSE RUNTIMEEXCEPTION

public class ResourceNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1l;
    
    //Exception personalizada, execption to handling erro consult by ID
    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}
