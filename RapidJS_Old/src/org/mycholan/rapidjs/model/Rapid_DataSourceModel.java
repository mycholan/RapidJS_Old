package org.mycholan.rapidjs.model;

public class Rapid_DataSourceModel {
	private int id;
	private int app_id;
	private String db_engine;
	private String dbschema;
	private String db_user;
	private String db_password;
	private String db_url;
	private String db_driver;
	private boolean active;
	
	public Rapid_DataSourceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApp_id() {
		return app_id;
	}
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
	public String getDb_engine() {
		return db_engine;
	}
	public void setDb_engine(String db_engine) {
		this.db_engine = db_engine;
	}
	public String getDbschema() {
		return dbschema;
	}
	public void setDbschema(String dbschema) {
		this.dbschema = dbschema;
	}
	public String getDb_user() {
		return db_user;
	}
	public void setDb_user(String db_user) {
		this.db_user = db_user;
	}
	public String getDb_password() {
		return db_password;
	}
	public void setDb_password(String db_password) {
		this.db_password = db_password;
	}
	public String getDb_url() {
		return db_url;
	}
	public void setDb_url(String db_url) {
		this.db_url = db_url;
	}
	public String getDb_driver() {
		return db_driver;
	}
	public void setDb_driver(String db_driver) {
		this.db_driver = db_driver;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
