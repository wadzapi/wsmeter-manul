package org.wadzapi.employeeService.util.logger.remoteLevel;

import org.apache.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Реализаця интерфейса удаленного конфигурирования уровня логирования
 */
public class SimpleLoggerRemoteManager implements LoggerRemoteManager {

    /**
     * {@inheritDoc}
     */
    public void setLevel(String loggerName, String loggerLevel) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        if (logger instanceof org.apache.log4j.Logger) {
            org.apache.log4j.Logger log4jLogger = (org.apache.log4j.Logger) logger;
            switch (loggerLevel) {
                case "INFO":
                    log4jLogger.setLevel(Level.INFO);
                    break;
                case "DEBUG":
                    log4jLogger.setLevel(Level.DEBUG);
                    break;
                case "ERROR":
                    log4jLogger.setLevel(Level.ERROR);
                    break;
                case "WARN":
                    log4jLogger.setLevel(Level.WARN);
                    break;
                default:
                    throw new IllegalArgumentException("Передан недопустимый уровень логирования: " + loggerLevel);
            }
        } else {
            throw new IllegalStateException("Выбранный логгер не является реализацией log4j2");
        }
    }
}
