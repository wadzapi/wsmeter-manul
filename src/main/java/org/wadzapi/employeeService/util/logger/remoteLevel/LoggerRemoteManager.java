package org.wadzapi.employeeService.util.logger.remoteLevel;

/**
 * Интерфейс удаленного конфигурирования уровня логирования
 */
public interface LoggerRemoteManager {

    /**
     * Метод задания уровня логирования
     *
     * @param loggerName  название логгера
     * @param loggerLevel уровень логирования
     */
    void setLevel(String loggerName, String loggerLevel);
}
