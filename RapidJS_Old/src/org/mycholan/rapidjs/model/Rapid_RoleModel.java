package org.mycholan.rapidjs.model;

public class Rapid_RoleModel {
     private int id;
     private String role_name;
     private boolean active;

     public Rapid_RoleModel() {
          super();
          // TODO Auto-generated constructor stub
     }

     public Rapid_RoleModel(int id, String role_name, boolean active) {
          super();
          this.id = id;
          this.role_name = role_name;
          this.active = active;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getRole_name() {
          return role_name;
     }

     public void setRole_name(String role_name) {
          this.role_name = role_name;
     }

     public boolean isActive() {
          return active;
     }

     public void setActive(boolean active) {
          this.active = active;
     }
}
