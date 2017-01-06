package com.pranav.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public final class LogMessage {
	private LogMessage() {
		super();
	}

	/**
	 * Public class for Message Logging. Logging levels NONE < ERROR < WARN <
	 * INFO < DEBUG.
	 */

	public static int logLevel = 4;
	public static final Logger LOGGER = Logger.getLogger(LogMessage.class);
	public static final ThreadLocal<String> logThreadLocal = new ThreadLocal<String>();

	static public void setLogLevel(final String lgLevel) {
		if (lgLevel.toUpperCase().startsWith("NO")) { // None
			logLevel = 0;
		} else if (lgLevel.toUpperCase().startsWith("ERR")) { // Error
			logLevel = 1;
		} else if (lgLevel.toUpperCase().startsWith("WARN")) { // Warning
			logLevel = 2;
		} else if (lgLevel.toUpperCase().startsWith("INFO")) { // Info
			logLevel = 3;
		} else if (lgLevel.toUpperCase().startsWith("DEB")) { // Debug
			logLevel = 4;
		}
	}

	static public String getLogLevel() {
		String retLevel = null;
		switch (logLevel) {
		case 0:
			retLevel = "NONE";
			break;
		case 1:
			retLevel = "ERROR";
			break;
		case 2:
			retLevel = "WARN";
			break;
		case 3:
			retLevel = "INFO";
			break;
		case 4:
			retLevel = "DEBUG";
		}
		return retLevel;
	}

	static public void error(final String msg) {
		/**
		 * Writes message to log file if the Logging level is set to ERROR. The
		 * ERROR level is the lowest logging level.
		 * 
		 * @param <I>msg</I>
		 *            - Error Message String.
		 */
		try {
			if (logLevel > 0) {
				log("ERROR: " + msg);
			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void error(final String msg, final Exception exception) {
		/**
		 * Writes message to log file if the Logging level is set to ERROR. The
		 * ERROR level is the lowest logging level.
		 * 
		 * @param <I>msg</I>
		 *            - Error Message String.
		 */
		try {
			if (logLevel > 0) {
				log("ERROR: " + msg);
				if (exception != null) {
					log("Exception Trace: ", exception);
				}
			}

		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void warn(final String msg) {
		/**
		 * Writes message to log file if the Logging level is set to WARN. WARN
		 * level will log all ERROR & WARN messages.
		 * 
		 * @param <I>msg</I>
		 *            - Warning Message String.
		 */
		try {
			if (logLevel > 1) {
				log("WARN : " + msg);
			}

		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void info(final String msg) {
		/**
		 * Writes message to log file if the Logging level is set to INFO. INFO
		 * level will log all ERROR, WARN and INFO messages
		 * 
		 * @param <I>msg</I>
		 *            - Info Message String.
		 */
		try {
			if (logLevel > 2) {
				log("INFO : " + msg);
			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void debug(final String msg) {
		/**
		 * Writes message to log file if the logging level is set to DEBUG DEBUG
		 * level will log all ERROR, WARN, INFO and DEBUG messages.
		 * 
		 * @param <I>msg</I>
		 *            - Debug message String.
		 */
		try {
			if (logLevel > 3) {
				log("DEBUG: " + msg);
			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void log(final String msg) {
		/**
		 * Writes message to system log file.
		 * 
		 * @param <I>msg</I>
		 *            - log message String.
		 */
		try {

			if (LOGGER != null) {
				LOGGER.info("RamseyFood -" + msg);

			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void log(final String msg, final Exception exception) {
		/**
		 * Writes message to system log file.
		 * 
		 * @param <I>msg</I>
		 *            - log message String.
		 */
		try {

			if (LOGGER != null) {
				LOGGER.info("RamseyFood -" + msg);
				LOGGER.error("RamseyFood - EXCEPTION: ", exception);
			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}

	static public void logBatchJob(final String msg, final Logger LoggerName) {
		/**
		 * Writes message to system log file.
		 * 
		 * @param <I>msg</I>
		 *            - log message String.
		 */
		try {

			if (LoggerName != null) {
				LoggerName.info(msg);
			}
		} catch (final Exception e) {
			LogMessage.error(e.getMessage(), e);
		}
	}
}