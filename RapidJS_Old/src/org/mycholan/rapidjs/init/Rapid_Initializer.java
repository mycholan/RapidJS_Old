package org.mycholan.rapidjs.init;

import org.mycholan.rapidjs.handler.Rapid_ApplicationHandler;
import org.mycholan.rapidjs.model.Rapid_ApplicationMetaData;
import org.mycholan.rapidjs.model.Rapid_FactoryMetaData;
import org.mycholan.rapidjs.session.Rapid_Session;

public class Rapid_Initializer {
     private static Rapid_ApplicationMetaData RJ_APP_META = null;
     private static Rapid_FactoryMetaData RJ_FACTORY_META = null;
     
     private static Rapid_Session RAPID_APP_SESSION = null;
     
     public static synchronized Rapid_ApplicationMetaData LoadApplicationMeta() {
    	 if(RJ_APP_META == null) {
    		 RJ_APP_META = org.mycholan.rapidjs.dao.Rapid_InitSchema.InitApplicationSchema();
    	 }
    	 return RJ_APP_META;
     }
     
     public static synchronized Rapid_FactoryMetaData LoadFactoryMeta() {
    	 if(RJ_FACTORY_META == null) {
    		 RJ_FACTORY_META = org.mycholan.rapidjs.dao.Rapid_InitSchema.InitFactorySchema();
    	 }
    	 return RJ_FACTORY_META;
     }

     public static synchronized Rapid_Session Init_RJ_Session() {
          if (RAPID_APP_SESSION == null) {
               Rapid_ApplicationHandler DIA = new Rapid_ApplicationHandler(LoadApplicationMeta(), LoadFactoryMeta());
               RAPID_APP_SESSION = DIA.InitApplicationSession();
          }
          return RAPID_APP_SESSION;
     }
}
