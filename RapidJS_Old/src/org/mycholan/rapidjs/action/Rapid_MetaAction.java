package org.mycholan.rapidjs.action;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.mycholan.rapidjs.init.Rapid_Initializer;
import org.mycholan.rapidjs.model.Rapid_FactoryMetaData;
import org.mycholan.rapidjs.model.Rapid_ParamModel;

/**
 * 
 * @author saravana
 * @usage Used to retrieve meta data needed by factory page. 
 * 
 */		
public class Rapid_MetaAction {
	private HttpServletRequest request;
	private Rapid_ParamModel RP;
	
	public Rapid_MetaAction(HttpServletRequest req, Rapid_ParamModel rp) {
		request = req;
		RP = rp;
	}
	
	public String GetMetaData() {
		Rapid_FactoryMetaData FactoryMetaObj = Rapid_Initializer.LoadFactoryMeta();
		JSONArray jArray = null;
		
		if(RP.getTable().equals("BASE")) {
			/*return all the table which will be to create tabs in factory page*/
			jArray = JSONArray.fromObject(FactoryMetaObj.getFactoryTab());
		}else if(RP.getTable().equals("SUBTAB")) {
			/*return meta tab which will be used to create sub tabs*/
			jArray = JSONArray.fromObject(FactoryMetaObj.getFactorySubTab());
		}else{
			/*return column list of particular table */
			for(int i = 0; i < FactoryMetaObj.getFactoryMetaData().size(); i++) {
				if(FactoryMetaObj.getFactoryMetaData().get(i).getTablename().equals(RP.getTable())) {
					jArray = JSONArray.fromObject(FactoryMetaObj.getFactoryMetaData().get(i).getColumn());
				}
			}
		}
		
		if(jArray != null) {
			return jArray.toString();
		}
		
		return "{\"status\":\"Table not found\", \"info\":\"\"}";
	}
}
