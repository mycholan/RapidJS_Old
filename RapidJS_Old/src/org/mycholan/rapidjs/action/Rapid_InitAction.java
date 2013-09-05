package org.mycholan.rapidjs.action;

import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.mycholan.rapidjs.handler.Rapid_ApplicationManager;
import org.mycholan.rapidjs.model.Rapid_ApplicationModel;
import org.mycholan.rapidjs.model.Rapid_WindowModel;
import org.mycholan.rapidjs.session.Rapid_Context;

/**
 * 
 * @author Saravana Kumar K
 * @purpose this is class which will be initiated for starting Admin application which is the first
 *          application initialized after starting the web server
 * 
 */
public class Rapid_InitAction {
     private HttpServletRequest request = null;
     private Rapid_ApplicationManager AppManager;
     private Rapid_Context RC = null;

     private static Logger log = Logger.getLogger(Rapid_InitAction.class);

     public Rapid_InitAction(HttpServletRequest _request) {
          request = _request;
          RC = new Rapid_Context();
          AppManager = new Rapid_ApplicationManager(request);
     }

     public String StartAdmin() {
          Properties AdminApp = AppManager.GetApplication(1);
          
          if (AdminApp == null) {
               log.info("Routine : getLoginPage, Getting application object, operation failed");
               return "{\"status\":\"Applcation not initiated\", \"info\":\"\"}";
          }

          Properties windowObj = AppManager.getWindow(1);
          
          ArrayList<Properties> actionList = AppManager.GetWindowActionList(1);
          
          RC.setApplication(AdminApp);
          RC.setWindow(windowObj);
          RC.setAction(actionList);

          HttpSession sess = request.getSession();
          sess.setAttribute("RapidContext", RC);

          JSONObject jObj = JSONObject.fromObject(RC);
          return jObj.toString();
     }
}
