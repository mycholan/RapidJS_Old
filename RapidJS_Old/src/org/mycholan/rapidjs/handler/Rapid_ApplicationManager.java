package org.mycholan.rapidjs.handler;

import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.mycholan.rapidjs.init.Rapid_BootLoader;
import org.mycholan.rapidjs.init.Rapid_Initializer;
import org.mycholan.rapidjs.session.Rapid_Session;

public class Rapid_ApplicationManager {
	private Properties CurrentApp;
	private Properties CurrentWindow;
	private Rapid_WindowHandler WindowHandler = null;
	private Rapid_ActionHandler ActionHandler = null;
	private HttpServletRequest request = null;
	static Logger log = Logger.getLogger(Rapid_ApplicationManager.class);

	public Rapid_ApplicationManager(HttpServletRequest _request) {
		request = _request;
		WindowHandler = new Rapid_WindowHandler(request);
		ActionHandler = new Rapid_ActionHandler();
		log.info("Routine : Construtor, DJ_ApplicationManager Instanciated");
	}

	public ArrayList<Properties> GetApplicationList() {
		Rapid_Session rj_session = Rapid_Initializer.Init_RJ_Session();

		if (rj_session == null) {
			log.info("Routine : GetApplication, Getting DJ_SESSION attribute operation failed ");
			return null;
		}

		return rj_session.getRj_apps();
	}

	public Properties GetApplication(int appID) {
		log.info("Routine : GetApplication, Function called with appID " + appID);
		boolean flaQ = false;

		Rapid_Session rj_session = Rapid_Initializer.Init_RJ_Session();
		if (rj_session == null) {
			log.info("Routine : GetApplication, Getting DJ_SESSION attribute operation failed ");
			return null;
		}

		if (Rapid_BootLoader.SCHEMA_INIT) {
			for (int i = 0; i < rj_session.getRj_apps().size(); i++) {
				if (Integer.parseInt(rj_session.getRj_apps().get(i).getProperty("ID")) == appID) {
					this.CurrentApp = rj_session.getRj_apps().get(i);
					flaQ = true;
					break;
				}
			}
		} else {
			log.info("Routine : GetApplication, Fatal Error, DJ_SCHEMA not initialized ");
			return null;
		}
		if (flaQ) {
			return this.CurrentApp;
		}
		log.info("Routine : GetApplication, Application not found");
		return null;
	}

	public ArrayList<Properties> getWindowList(int appID) {
		return WindowHandler.GetWindowObj(appID);
	}

	public Properties getWindow(int windowID) {
		ArrayList<Properties> WindowList = WindowHandler.GetWindowObj(Integer.parseInt(CurrentApp.getProperty("ID")));
		boolean flaQ = false;
		for (int i = 0; i < WindowList.size(); i++) {
			if (Integer.parseInt(WindowList.get(i).getProperty("ID")) == windowID) {
				CurrentWindow = WindowList.get(i);
				flaQ = true;
				break;
			}
		}
		if (flaQ) {
			return CurrentWindow;
		}
		return null;
	}
	
	public ArrayList<Properties> GetApplicationActionList(int appID) {
		return ActionHandler.GetApplicationActionList(appID);
	}
	
	public ArrayList<Properties> GetWindowActionList(int appID) {
		return ActionHandler.GetWindowActionList(appID);
	}

	public ArrayList<Properties> GetRapidUserList() {
		Rapid_Session rj_session = Rapid_Initializer.Init_RJ_Session();
		if (rj_session == null) {
			log.info("Routine : GetApplication, Getting DJ_SESSION attribute operation failed ");
			return null;
		}
		return rj_session.getRj_users();
	}

	public Properties getCurrentApp() {
		return CurrentApp;
	}

	public void setCurrentApp(Properties currentApp) {
		CurrentApp = currentApp;
	}

	public Properties getCurrentWindow() {
		return CurrentWindow;
	}

	public void setCurrentWindow(Properties currentWindow) {
		CurrentWindow = currentWindow;
	}
}
