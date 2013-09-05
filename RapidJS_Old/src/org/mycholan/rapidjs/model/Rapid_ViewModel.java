package org.mycholan.rapidjs.model;

import java.util.ArrayList;

public class Rapid_ViewModel {
     private int id;
     private int layoutid;
     private String viewname;
     private int viewtype;
     private int columncount;
     private boolean active;
     private boolean display;
     private ArrayList<Rapid_ControlModel> ControlList;

     public Rapid_ViewModel() {
          super();
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getLayoutid() {
          return layoutid;
     }

     public void setLayoutid(int layoutid) {
          this.layoutid = layoutid;
     }

     public String getViewname() {
          return viewname;
     }

     public void setViewname(String viewname) {
          this.viewname = viewname;
     }

     public int getViewtype() {
          return viewtype;
     }

     public void setViewtype(int viewtype) {
          this.viewtype = viewtype;
     }

     public int getColumncount() {
          return columncount;
     }

     public void setColumncount(int columncount) {
          this.columncount = columncount;
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

     public ArrayList<Rapid_ControlModel> getControlList() {
          return ControlList;
     }

     public void setControlList(ArrayList<Rapid_ControlModel> controlList) {
          ControlList = controlList;
     }
}
