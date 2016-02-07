package org.wadzapi.employeeService.util.logger.remoteLevel;

import javax.management.DynamicMBean;

/**
 * Интерфейс удаленного конфигурирования уровня логирования
 */
public interface LoggerRemoteManager extends DynamicMBean {

    /**
     * Метод задания уровня логирования
     *
     * @param loggerName  название логгера
     * @param loggerLevel уровень логирования
     */
    void setLevel(String loggerName, String loggerLevel);
}
