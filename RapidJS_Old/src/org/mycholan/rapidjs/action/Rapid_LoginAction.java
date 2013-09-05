package org.mycholan.rapidjs.action;

import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.mycholan.rapidjs.handler.Rapid_ApplicationManager;
import org.mycholan.rapidjs.model.Rapid_ParamModel;
import org.mycholan.rapidjs.session.Rapid_Context;

public class Rapid_LoginAction {
	private HttpServletRequest request;

	public Rapid_LoginAction(HttpServletRequest request) {
		this.request = request;
	}

	public String CheckUser(Rapid_ParamModel rpm) {
		Rapid_ApplicationManager AppManager = new Rapid_ApplicationManager(this.request);
		ArrayList<Properties> UserList = AppManager.GetRapidUserList();
		HttpSession sess = this.request.getSession();
		boolean flaQ = false;
		int index = -1;

		String UserName = rpm.getDownloadValue()[0];
		String Password = rpm.getDownloadValue()[1];

		if (UserList != null) {
			for (int i = 0; i < UserList.size(); i++) {
				if (UserName.equals(UserList.get(i).getProperty("USERNAME")) && Password.equals(UserList.get(i).getProperty("PASSWORD"))) {
					flaQ = true;
					index = i;
					break;
				}
			}
		} else {
			return "{\"status\":\"User List Is Empty\", \"param\":\"Authentication Failed\"}";
		}

		if (flaQ) {
			Rapid_Context RC = (Rapid_Context) sess.getAttribute("");
			RC.setUser(UserList.get(index));
			sess.removeAttribute("");
			sess.setAttribute("", RC);
		} else {
			return "{\"status\":\"Authentication Failed\", \"param\":\"Authentication Failed\"}";
		}

		JSONArray jArray = JSONArray.fromObject(AppManager.GetApplicationList());
		return jArray.toString();
	}
}
