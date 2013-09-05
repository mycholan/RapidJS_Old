package org.mycholan.rapidjs.session;

import java.util.ArrayList;
import java.util.Properties;

import org.mycholan.rapidjs.model.Rapid_ApplicationModel;
import org.mycholan.rapidjs.model.Rapid_UserModel;
import org.mycholan.rapidjs.model.Rapid_WindowModel;

/**
 * 
 * @author saravana
 * @usage holds currently active application related info (application object,
 *        window object and users)
 * 
 */
public class Rapid_Context {
	private Properties Application;
	private Properties Window;
	private ArrayList<Properties> Action;
	private Properties user;

	public Rapid_Context() {
		super();
	}

	public Properties getApplication() {
		return Application;
	}

	public void setApplication(Properties application) {
		Application = application;
	}

	public Properties getWindow() {
		return Window;
	}

	public void setWindow(Properties window) {
		Window = window;
	}
	
	public ArrayList<Properties> getAction() {
		return Action;
	}

	public void setAction(ArrayList<Properties> action) {
		Action = action;
	}

	public Properties getUser() {
		return user;
	}

	public void setUser(Properties user) {
		this.user = user;
	}
}
