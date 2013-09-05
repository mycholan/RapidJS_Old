package org.mycholan.rapidjs.face;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mycholan.rapidjs.action.Rapid_InitAction;
import org.mycholan.rapidjs.delegate.Rapid_Router;
import org.mycholan.rapidjs.process.Rapid_ParseParameter;
import org.mycholan.rapidjs.session.Rapid_Context;

/**
 * 
 * @author Saravana Kumar K
 * @purpose Primary Interface, all the communication between browser and server will happens through
 *          this servlet
 * 
 */
@WebServlet("/Rapid_Docker")
public class Rapid_Docker extends HttpServlet {
     private static final long serialVersionUID = 1L;
     static Logger log = Logger.getLogger(Rapid_Docker.class);

     public Rapid_Docker() {
          super();
     }

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
          doPost(request, response);
     }

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
          PrintWriter writerR = response.getWriter();
          HttpSession sess = request.getSession();
          Rapid_ParseParameter rpp = null;
          Rapid_Router RR = new Rapid_Router();
          Rapid_Context RC = (Rapid_Context) sess.getAttribute("RapidContext");

          /*
           * If RC == null, this is the first request arrived after web server started are
           * session timeout occurred. In both case we need to redirect to login page
           */
          if (RC == null) {
               Rapid_InitAction ria = new Rapid_InitAction(request);
               writerR.println(ria.StartAdmin());
               return;
          }

          String requestStr = request.getParameter("DATA");
          log.info("Routine : Rapid_Docker.doPost(), Message : request arrived");

          if (requestStr != null && requestStr.equals("") && requestStr.equals(" ")) {
               writerR.println("{\"status\":\"Parameter Missing\", \"info\":\"expected parameter is DATA\"}");
               return;
          }

          rpp = new Rapid_ParseParameter(requestStr);
          writerR.println(RR.ActionRouter(request, rpp.GetParameter()));
     }
}
