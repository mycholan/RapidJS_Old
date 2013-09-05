package org.mycholan.rapidjs.session;

import java.util.ArrayList;
import java.util.Properties;

import org.mycholan.rapidjs.model.Rapid_AccessModel;
import org.mycholan.rapidjs.model.Rapid_ApplicationModel;
import org.mycholan.rapidjs.model.Rapid_DataSourceModel;
import org.mycholan.rapidjs.model.Rapid_RoleModel;
import org.mycholan.rapidjs.model.Rapid_UserModel;

public class Rapid_Session {
     private ArrayList<Properties> rj_apps;
     private ArrayList<Properties> rj_app_datasources;
     private ArrayList<Properties> rj_access;
     private ArrayList<Properties> rj_roles;
     private ArrayList<Properties> rj_users;

     public Rapid_Session() {
          super();
     }

	public ArrayList<Properties> getRj_apps() {
		return rj_apps;
	}
	
	public void setRj_apps(ArrayList<Properties> rj_apps) {
		this.rj_apps = rj_apps;
	}
	
	public ArrayList<Properties> getRj_app_datasources() {
		return rj_app_datasources;
	}
	
	public void setRj_app_datasources(ArrayList<Properties> rj_app_datasources) {
		this.rj_app_datasources = rj_app_datasources;
	}
	
	public ArrayList<Properties> getRj_access() {
		return rj_access;
	}
	
	public void setRj_access(ArrayList<Properties> rj_access) {
		this.rj_access = rj_access;
	}
	
	public ArrayList<Properties> getRj_roles() {
		return rj_roles;
	}
	
	public void setRj_roles(ArrayList<Properties> rj_roles) {
		this.rj_roles = rj_roles;
	}
	
	public ArrayList<Properties> getRj_users() {
		return rj_users;
	}
	
	public void setRj_users(ArrayList<Properties> rj_users) {
		this.rj_users = rj_users;
	}     
}
