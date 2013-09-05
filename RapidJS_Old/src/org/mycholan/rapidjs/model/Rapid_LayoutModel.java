package org.mycholan.rapidjs.model;

import java.util.ArrayList;

public class Rapid_LayoutModel {
     private int id;
     private int conatinerid;
     private String layoutname;
     private int layouttype;
     private boolean active;
     private boolean display;

     private ArrayList<Rapid_ToolbarModel> ToolbarList;
     private Rapid_ViewModel View;

     public Rapid_LayoutModel() {
          super();
          // TODO Auto-generated constructor stub
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getConatinerid() {
          return conatinerid;
     }

     public void setConatinerid(int conatinerid) {
          this.conatinerid = conatinerid;
     }

     public String getLayoutname() {
          return layoutname;
     }

     public void setLayoutname(String layoutname) {
          this.layoutname = layoutname;
     }

     public int getLayouttype() {
          return layouttype;
     }

     public void setLayouttype(int layouttype) {
          this.layouttype = layouttype;
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

     public ArrayList<Rapid_ToolbarModel> getToolbarList() {
          return ToolbarList;
     }

     public void setToolbarList(ArrayList<Rapid_ToolbarModel> toolbarList) {
          ToolbarList = toolbarList;
     }

     public Rapid_ViewModel getView() {
          return View;
     }

     public void setView(Rapid_ViewModel view) {
          View = view;
     }
}
