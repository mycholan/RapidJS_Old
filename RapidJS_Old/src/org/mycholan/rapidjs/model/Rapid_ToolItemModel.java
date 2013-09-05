package org.mycholan.rapidjs.model;

public class Rapid_ToolItemModel {
     private int id;
     private int toolbarid;
     private String toolitemname;
     private String toolitemtext;
     private String tooltip;
     private String imageurl;
     private String cssclass;
     private String action;
     private String handler;
     private boolean readonly;
     private boolean display;

     public Rapid_ToolItemModel() {
          super();
          // TODO Auto-generated constructor stub
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getToolbarid() {
          return toolbarid;
     }

     public void setToolbarid(int toolbarid) {
          this.toolbarid = toolbarid;
     }

     public String getToolitemname() {
          return toolitemname;
     }

     public void setToolitemname(String toolitemname) {
          this.toolitemname = toolitemname;
     }

     public String getToolitemtext() {
          return toolitemtext;
     }

     public void setToolitemtext(String toolitemtext) {
          this.toolitemtext = toolitemtext;
     }

     public String getTooltip() {
          return tooltip;
     }

     public void setTooltip(String tooltip) {
          this.tooltip = tooltip;
     }

     public String getImageurl() {
          return imageurl;
     }

     public void setImageurl(String imageurl) {
          this.imageurl = imageurl;
     }

     public String getCssclass() {
          return cssclass;
     }

     public void setCssclass(String cssclass) {
          this.cssclass = cssclass;
     }

     public String getAction() {
          return action;
     }

     public void setAction(String action) {
          this.action = action;
     }

     public String getHandler() {
          return handler;
     }

     public void setHandler(String handler) {
          this.handler = handler;
     }

     public boolean isReadonly() {
          return readonly;
     }

     public void setReadonly(boolean readonly) {
          this.readonly = readonly;
     }

     public boolean isDisplay() {
          return display;
     }

     public void setDisplay(boolean display) {
          this.display = display;
     }
}
