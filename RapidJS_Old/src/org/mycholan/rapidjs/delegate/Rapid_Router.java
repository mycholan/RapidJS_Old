package org.mycholan.rapidjs.delegate;

import javax.servlet.http.HttpServletRequest;

import org.mycholan.rapidjs.action.Rapid_GetAction;
import org.mycholan.rapidjs.action.Rapid_InitAction;
import org.mycholan.rapidjs.action.Rapid_LoginAction;
import org.mycholan.rapidjs.action.Rapid_MetaAction;
import org.mycholan.rapidjs.model.Rapid_ParamModel;

public class Rapid_Router {
     public String ActionRouter(HttpServletRequest request, Rapid_ParamModel RPM) {
          String responseStr = "";
          if (RPM.getAction().equals("INIT")) {
               Rapid_InitAction RIA = new Rapid_InitAction(request);
               responseStr = RIA.StartAdmin();
          } else if (RPM.getAction().equals("LOGIN")) {
               Rapid_LoginAction RLA = new Rapid_LoginAction(request);
               responseStr = RLA.CheckUser(RPM);
          } else if (RPM.getAction().equals("LOGOUT")) {

          } else if (RPM.getAction().equals("NEW")) {

          } else if (RPM.getAction().equals("SAVE")) {

          } else if (RPM.getAction().equals("DELETE")) {

          } else if (RPM.getAction().equals("GET")) {
               Rapid_GetAction RGA = new Rapid_GetAction(request);
               responseStr = RGA.GetApplicationList();
          } else if (RPM.getAction().equals("CHECK")) {

          } else if(RPM.getAction().equals("META")) {
        	  Rapid_MetaAction RMA = new Rapid_MetaAction(request, RPM);
        	  responseStr = RMA.GetMetaData();
          }
          
          return responseStr;
     }
}
