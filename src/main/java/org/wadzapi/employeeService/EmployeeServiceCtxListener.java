package org.wadzapi.employeeService;

import org.apache.logging.log4j.web.Log4jServletContextListener;
import org.apache.logging.log4j.web.Log4jWebSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wadzapi.employeeService.util.logger.remoteLevel.LoggerRemoteManager;
import org.wadzapi.employeeService.util.logger.remoteLevel.SimpleLoggerRemoteManager;

import javax.management.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.management.ManagementFactory;

/**
 * Класс, реализующий инициализацию сервиса работников
 */
public class EmployeeServiceCtxListener implements ServletContextListener {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceCtxListener.class);

    /**
     * Обработчик регистрации логгирования
     */
    private Log4jServletContextListener log4jServletContextListener;

    /**
     * Название в реестре
     */
    private static final String LOGGER_REMOTE_MANAGER_OBJECT_NAME = "RemoteLoggingUtils: type=LoggerRemoteManager";

    /**
     * Конструктор класса
     */
    public EmployeeServiceCtxListener() {
        this.log4jServletContextListener = new Log4jServletContextListener();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //TODO Переход на декларативную регистрацию (через mbeans-descriptors.xml)
        String loggerPath = "WEB-INF/classes/log4j2.xml";
        sce.getServletContext().setInitParameter(Log4jWebSupport.LOG4J_CONFIG_LOCATION, loggerPath);
        log4jServletContextListener.contextInitialized(sce);
        registerRemoteLogManager();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log4jServletContextListener.contextDestroyed(sce);
        unregisterRemoteLogManager();
    }

    /**
     * Метод регистрации обработчика удаленной настройки уровня логирования
     */
    private void registerRemoteLogManager() {
        final MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            ObjectName loggerRemoteManagerObjectName = new ObjectName(LOGGER_REMOTE_MANAGER_OBJECT_NAME);
            final LoggerRemoteManager loggerRemoteManager = new SimpleLoggerRemoteManager();
            mBeanServer.registerMBean(loggerRemoteManager, loggerRemoteManagerObjectName);
        } catch (MalformedObjectNameException | NotCompliantMBeanException | InstanceAlreadyExistsException | MBeanRegistrationException e) {
            LOGGER.error("Ошибка регистрация обработчика удаленной настройки уровня логирования");
        }
    }

    /**
     * Метод отвязки обработчика удаленной настройки уровня логирования
     */
    private void unregisterRemoteLogManager() {
        final MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            ObjectName loggerRemoteManagerObjectName = new ObjectName(LOGGER_REMOTE_MANAGER_OBJECT_NAME);
            mBeanServer.unregisterMBean(loggerRemoteManagerObjectName);
        } catch (MalformedObjectNameException | InstanceNotFoundException | MBeanRegistrationException e) {
            LOGGER.error("Ошибка отвязки обработчика удаленной настройки уровня логирования", e);
        }
    }
}
