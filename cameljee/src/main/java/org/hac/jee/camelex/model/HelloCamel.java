package org.hac.jee.camelex.model;

import javax.inject.Named;
import org.apache.camel.Body;

/**
 *
 * @author Markus Eisele
 */
@Named
public class HelloCamel {

    public String sayHello(@Body String message) {
        return ">> Hello " + message + " user.";
    }
}