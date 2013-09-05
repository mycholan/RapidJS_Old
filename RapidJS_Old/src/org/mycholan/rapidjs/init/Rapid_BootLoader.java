package org.mycholan.rapidjs.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class Rapid_BootLoader implements ServletContextListener {
	private static Logger log = Logger.getLogger(Rapid_BootLoader.class);
	public static boolean SCHEMA_INIT = false;

	public void contextInitialized(ServletContextEvent contextEvent) {
		log.info("Routine : contextInitialized(), Message : contextInitialized() called Successfully.");

		if (Rapid_Initializer.LoadApplicationMeta() != null) {
			SCHEMA_INIT = true;
			log.info("Routine : contextInitialized(), Message : RJ_APP_META initialized Successfully.");
		} else {
			SCHEMA_INIT = false;
			log.info("Routine : contextInitialized(), Message : RJ_APP_META initialized Failed.");
		}

		if (Rapid_Initializer.LoadFactoryMeta() != null) {
			if (SCHEMA_INIT) {
				SCHEMA_INIT = true;
			}
			log.info("Routine : contextInitialized(), Message : RJ_FACTORY_META initialized Successfully.");
		} else {
			SCHEMA_INIT = false;
			log.info("Routine : contextInitialized(), Message : RJ_FACTORY_META initialized Failed.");
		}

		if (Rapid_Initializer.Init_RJ_Session() != null) {
			if (SCHEMA_INIT) {
				SCHEMA_INIT = true;
			}
			log.info("Routine : contextInitialized(), Message : RAPID_APP_SESSION initialized Successfully.");
		} else {
			SCHEMA_INIT = false;
			log.info("Routine : contextInitialized(), Message : RAPID_APP_SESSION initialized Failed.");
		}
	}

	public void contextDestroyed(ServletContextEvent contextEvent) {

	}
}
