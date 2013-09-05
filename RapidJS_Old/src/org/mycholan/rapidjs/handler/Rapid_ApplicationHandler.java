package org.mycholan.rapidjs.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.mycholan.rapidjs.db.Rapid_DerbyManager;
import org.mycholan.rapidjs.init.Rapid_BootLoader;
import org.mycholan.rapidjs.model.Rapid_AccessModel;
import org.mycholan.rapidjs.model.Rapid_ApplicationMetaData;
import org.mycholan.rapidjs.model.Rapid_ApplicationModel;
import org.mycholan.rapidjs.model.Rapid_DataSourceModel;
import org.mycholan.rapidjs.model.Rapid_FactoryMetaData;
import org.mycholan.rapidjs.model.Rapid_RoleModel;
import org.mycholan.rapidjs.model.Rapid_UserModel;
import org.mycholan.rapidjs.process.Rapid_DataAccessUtils;
import org.mycholan.rapidjs.session.Rapid_Session;

public class Rapid_ApplicationHandler {
	private Rapid_ApplicationMetaData AppMetaObj = null;
	private Rapid_FactoryMetaData FactoryMetaObj = null;
	private Rapid_Session Rj_Session = null;

	private Rapid_DataAccessUtils DataAccessUtils = null;

	static Logger log = Logger.getLogger(Rapid_ApplicationHandler.class);

	public Rapid_ApplicationHandler(Rapid_ApplicationMetaData appmeta, Rapid_FactoryMetaData factorymeta) {
		AppMetaObj = appmeta;
		FactoryMetaObj = factorymeta;
		Rj_Session = new Rapid_Session();
		DataAccessUtils = new Rapid_DataAccessUtils();
	}

	public Rapid_Session InitApplicationSession() {
		String app_table[] = { "RJ_APPLICATION", "RJ_DATASOURCE" };
		String factory_table[] = { "FACTORY_USER_ROLE", "FACTORY_USER_USER" };

		Rapid_DerbyManager djdb = new Rapid_DerbyManager();
		djdb.GetConnection();
		ResultSet rs = null;
		boolean flaQ = true;

		if (Rapid_BootLoader.SCHEMA_INIT) {
			for (int i = 0; i < factory_table.length; i++) {
				rs = djdb.ExecuteQuery(DataAccessUtils.ConstructSelectQuery(factory_table[i], FactoryMetaObj));
				if (factory_table[i].equals("FACTORY_USER_ROLE")) {
					if (!SetRoles(factory_table[i], rs)) {
						flaQ = false;
						break;
					}
				} else if (factory_table[i].equals("FACTORY_USER_USER")) {
					if (!SetUser(factory_table[i], rs)) {
						flaQ = false;
						break;
					}
				}
			}

			if (flaQ) {
				for (int i = 0; i < app_table.length; i++) {
					rs = djdb.ExecuteQuery(DataAccessUtils.ConstructSelectQuery(app_table[i], AppMetaObj));
					if (app_table[i].equals("RJ_APPLICATION")) {
						if (!SetApplication(app_table[i], rs)) {
							flaQ = false;
							break;
						}
					} else if (app_table[i].equals("RJ_APP_DATASOURCE")) {
						if (!SetAppDataSource(app_table[i], rs)) {
							flaQ = false;
							break;
						}
					}
				}
			}
		} else {
			flaQ = false;
		}

		djdb.CloseConnection();

		if (flaQ) {
			return Rj_Session;
		}
		return null;
	}

	private boolean SetRoles(String table, ResultSet rs) {
		ArrayList<Properties> RoleList = DataAccessUtils.FetchMultiRow(table, FactoryMetaObj, rs);

		if (RoleList == null) {
			return false;
		}

		Rj_Session.setRj_roles(RoleList);
		return true;
	}

	private boolean SetUser(String table, ResultSet rs) {
		ArrayList<Properties> UserList = DataAccessUtils.FetchMultiRow(table, FactoryMetaObj, rs);

		if (UserList == null) {
			return false;
		}

		Rj_Session.setRj_users(UserList);
		return true;
	}

	private boolean SetAccess(String table, ResultSet rs) {
		ArrayList<Properties> AccessList = DataAccessUtils.FetchMultiRow(table, FactoryMetaObj, rs);

		if (AccessList == null) {
			return false;
		}
		
		Rj_Session.setRj_access(AccessList);
		return true;
	}

	private boolean SetApplication(String table, ResultSet rs) {
		ArrayList<Properties> ApplicationList = DataAccessUtils.FetchMultiRow(table, AppMetaObj, rs);

		if (ApplicationList == null) {
			return false;
		}
		
		Rj_Session.setRj_apps(ApplicationList);
		return true;
	}

	private boolean SetAppDataSource(String table, ResultSet rs) {
		ArrayList<Properties> DataSourceList = DataAccessUtils.FetchMultiRow(table, AppMetaObj, rs);

		if (DataSourceList == null) {
			return false;
		}
		
		Rj_Session.setRj_app_datasources(DataSourceList);
		return true;
	}
}
