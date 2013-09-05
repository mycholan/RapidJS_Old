package org.mycholan.rapidjs.model;

import java.util.ArrayList;

public class Rapid_ToolbarModel {
     private int id;
     private int layoutid;
     private String toolbarname;
     private int toolbartype;
     private boolean active;
     private boolean display;

     private ArrayList<Rapid_ToolItemModel> ToolItemList;

     public Rapid_ToolbarModel() {
          super();
          // TODO Auto-generated constructor stub
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

     public String getToolbarname() {
          return toolbarname;
     }

     public void setToolbarname(String toolbarname) {
          this.toolbarname = toolbarname;
     }

     public int getToolbartype() {
          return toolbartype;
     }

     public void setToolbartype(int toolbartype) {
          this.toolbartype = toolbartype;
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

     public ArrayList<Rapid_ToolItemModel> getToolItemList() {
          return ToolItemList;
     }

     public void setToolItemList(ArrayList<Rapid_ToolItemModel> toolItemList) {
          ToolItemList = toolItemList;
     }
}
