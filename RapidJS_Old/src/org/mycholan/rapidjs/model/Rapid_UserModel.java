package org.mycholan.rapidjs.model;

public class Rapid_UserModel {
     private int id;
     private String username;
     private String password;
     private boolean active;
     private String roleids;

     public Rapid_UserModel() {
          // TODO Auto-generated constructor stub
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public boolean isActive() {
          return active;
     }

     public void setActive(boolean active) {
          this.active = active;
     }

	public String getRoleids() {
		return roleids;
	}

	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}
}
