package org.mycholan.rapidjs.action;

import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.mycholan.rapidjs.handler.Rapid_ApplicationManager;

public class Rapid_GetAction {
     private HttpServletRequest request = null;
     private Rapid_ApplicationManager ram = null;

     public Rapid_GetAction(HttpServletRequest request) {
          this.request = request;
          ram = new Rapid_ApplicationManager(this.request);
     }

     public String GetApplicationList() {
          ArrayList<Properties> appList = ram.GetApplicationList();
          JSONArray jArray = JSONArray.fromObject(appList);
          return jArray.toString();
     }

     public String GetWindowList(int appID) {
          ArrayList<Properties> windowList = ram.getWindowList(appID);
          JSONArray jArray = JSONArray.fromObject(windowList);
          return jArray.toString();
     }

     public String GetWindow(int windowID) {
          Properties window = ram.getWindow(windowID);
          JSONObject jObject = JSONObject.fromObject(window);
          return jObject.toString();
     }
}
