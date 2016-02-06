package org.wadzapi.employeeService;

import org.apache.logging.log4j.web.Log4jServletContainerInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * Класс, реализующий инициализацию сервиса работников
 */
public class EmployeeServiceInitializer implements ServletContainerInitializer {

    private Log4jServletContainerInitializer log4jServletContainerInitializer;


    public EmployeeServiceInitializer() {
        log4jServletContainerInitializer = new Log4jServletContainerInitializer();
    }

    //@HandlesTypes(Log4jConfigListener)
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        Class startedClazz = c.getClass();
        System.out.println(startedClazz.getName() + " ; " + c.toString());
    }
    //TODO extends SpringServletContainerInitializer {
}
