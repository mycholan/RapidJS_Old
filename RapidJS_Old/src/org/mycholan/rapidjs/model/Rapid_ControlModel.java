package org.mycholan.rapidjs.model;

public class Rapid_ControlModel {
     private int id;
     private int viewid;
     private int xtype;
     private String label;
     private String controlid;
     private String cssclass;
     private String action;
     private String handler;
     private boolean mandatory;
     private boolean readonly;
     private boolean error;
     private boolean visible;

     public Rapid_ControlModel(int id, int viewid, int xtype, String label, String controlid,
               String cssclass, String action, String handler, boolean mandatory, boolean readonly,
               boolean error, boolean isvisible) {
          super();
          this.id = id;
          this.viewid = viewid;
          this.xtype = xtype;
          this.label = label;
          this.controlid = controlid;
          this.cssclass = cssclass;
          this.action = action;
          this.handler = handler;
          this.mandatory = mandatory;
          this.readonly = readonly;
          this.error = error;
          this.visible = isvisible;
     }

     public Rapid_ControlModel() {
          super();
          // TODO Auto-generated constructor stub
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getViewid() {
          return viewid;
     }

     public void setViewid(int viewid) {
          this.viewid = viewid;
     }

     public int getXtype() {
          return xtype;
     }

     public void setXtype(int xtype) {
          this.xtype = xtype;
     }

     public String getLabel() {
          return label;
     }

     public void setLabel(String label) {
          this.label = label;
     }

     public String getControlid() {
          return controlid;
     }

     public void setControlid(String controlid) {
          this.controlid = controlid;
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

     public boolean isMandatory() {
          return mandatory;
     }

     public void setMandatory(boolean mandatory) {
          this.mandatory = mandatory;
     }

     public boolean isReadonly() {
          return readonly;
     }

     public void setReadonly(boolean readonly) {
          this.readonly = readonly;
     }

     public boolean isError() {
          return error;
     }

     public void setError(boolean error) {
          this.error = error;
     }

     public boolean isVisible() {
          return visible;
     }

     public void setVisible(boolean visible) {
          this.visible = visible;
     }
}
