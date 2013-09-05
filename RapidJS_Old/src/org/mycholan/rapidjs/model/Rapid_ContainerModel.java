package org.mycholan.rapidjs.model;

public class Rapid_ContainerModel {
     private int id;
     private int windowid;
     private String containername;
     private String containertitle;
     private boolean active;
     private boolean display;

     private Rapid_LayoutModel Layout;

     public Rapid_ContainerModel() {
          super();
          // TODO Auto-generated constructor stub
     }

     public Rapid_ContainerModel(int id, int windowid, String containername, boolean active,
               boolean display, Rapid_LayoutModel layout) {
          super();
          this.id = id;
          this.windowid = windowid;
          this.containername = containername;
          this.active = active;
          this.display = display;
          this.Layout = layout;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getWindowid() {
          return windowid;
     }

     public void setWindowid(int windowid) {
          this.windowid = windowid;
     }

     public String getContainername() {
          return containername;
     }

     public void setContainername(String containername) {
          this.containername = containername;
     }

     public String getContainertitle() {
          return containertitle;
     }

     public void setContainertitle(String containertitle) {
          this.containertitle = containertitle;
     }

     public boolean isActive() {
          return active;
     }

     public void setActive(boolean active) {
          this.active = active;
     }

     public boolean isDisplay() {
          return display;
     }

     public void setDisplay(boolean display) {
          this.display = display;
     }

     public Rapid_LayoutModel getLayout() {
          return Layout;
     }

     public void setLayout(Rapid_LayoutModel layout) {
          this.Layout = layout;
     }
}