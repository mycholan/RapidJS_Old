package org.mycholan.rapidjs.model;

public class Rapid_ApplicationModel {
     private int id;
     private String app_name;
     private int app_type;
     private boolean active;

     public Rapid_ApplicationModel() {
          super();
          // TODO Auto-generated constructor stub
     }

     public Rapid_ApplicationModel(int id, String app_name, int app_type, boolean active) {
          super();
          this.id = id;
          this.app_name = app_name;
          this.app_type = app_type;
          this.active = active;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getApp_name() {
          return app_name;
     }

     public void setApp_name(String app_name) {
          this.app_name = app_name;
     }

     public int getApp_type() {
          return app_type;
     }

     public void setApp_type(int app_type) {
          this.app_type = app_type;
     }

     public boolean isActive() {
          return active;
     }

     public void setActive(boolean active) {
          this.active = active;
     }
}
