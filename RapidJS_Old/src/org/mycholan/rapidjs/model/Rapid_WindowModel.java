package org.mycholan.rapidjs.model;

public class Rapid_WindowModel {
	private int id;
	private int app_id;
	private String window_name;
	private String window_title;
	private int window_type;
	private int container_type;
	private int windowwidth;
	private int windowheight;
	private int windowposx;
	private int windowposy;
	private int windowiscenteralign;
	private boolean active;

	private Rapid_ContainerContainerModel ContainerList;

	public Rapid_WindowModel() {
		// TODO Auto-generated constructor stub
	}

	public Rapid_WindowModel(int id, int app_id, String window_name, String window_title,
			int window_type, int container_type, boolean active,
			Rapid_ContainerContainerModel containerlist) {
		super();
		this.id = id;
		this.app_id = app_id;
		this.window_name = window_name;
		this.window_title = window_title;
		this.window_type = window_type;
		this.container_type = container_type;
		this.active = active;
		this.ContainerList = containerlist;
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

	public String getWindow_name() {
		return window_name;
	}

	public void setWindow_name(String window_name) {
		this.window_name = window_name;
	}

	public String getWindow_title() {
		return window_title;
	}

	public void setWindow_title(String window_title) {
		this.window_title = window_title;
	}

	public int getWindow_type() {
		return window_type;
	}

	public void setWindow_type(int window_type) {
		this.window_type = window_type;
	}

	public int getContainer_type() {
		return container_type;
	}

	public void setContainer_type(int container_type) {
		this.container_type = container_type;
	}     

	public int getWindowwidth() {
		return windowwidth;
	}

	public void setWindowwidth(int windowwidth) {
		this.windowwidth = windowwidth;
	}

	public int getWindowheight() {
		return windowheight;
	}

	public void setWindowheight(int windowheight) {
		this.windowheight = windowheight;
	}

	public int getWindowposx() {
		return windowposx;
	}

	public void setWindowposx(int windowposx) {
		this.windowposx = windowposx;
	}

	public int getWindowposy() {
		return windowposy;
	}

	public void setWindowposy(int windowposy) {
		this.windowposy = windowposy;
	}

	public int getWindowiscenteralign() {
		return windowiscenteralign;
	}

	public void setWindowiscenteralign(int windowiscenteralign) {
		this.windowiscenteralign = windowiscenteralign;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Rapid_ContainerContainerModel getContainerList() {
		return ContainerList;
	}

	public void setContainerList(Rapid_ContainerContainerModel containerList) {
		ContainerList = containerList;
	}
}
