/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import smile.Network;
import smile.*;
import smile.learning.*;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author violetliu
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  System.setProperty("java.library.path", "C:\\Users\\Omar\\Downloads\\jsmile_win32\\jsmile.dll");
         DecimalFormat df = new DecimalFormat("####0.000");
        String curNodeName = null;
        Network net = new Network();
  
        String resourcesPath = System.getenv("MH_RESOURCES");
        String xdslFileIn = (new File(resourcesPath, "C:\\Users\\YU\\Desktop\\wine.xdsl")).toString();
        net.readFile(xdslFileIn);

        // First get all the value nodes and their initial definitions
       
      
        int outcomeIndex=0;
        net.clearAllEvidence();
        String opt1 = request.getParameter("element_1");
        String opt2 = request.getParameter("element_2");
        String opt3 = request.getParameter("element_3");
        String opt4 = request.getParameter("element_4");
        String opt5 = request.getParameter("element_5");
        String opt6 = request.getParameter("element_6");
        String opt7 = request.getParameter("element_7");
        String opt8 = request.getParameter("element_8");
        String opt9 = request.getParameter("element_9");
        String opt10 = request.getParameter("element_10");
        String opt11 = request.getParameter("element_11");
        String opt12 = request.getParameter("element_12");
        
        if(opt1 != "" && opt1 != null && !opt1.isEmpty())
            net.setEvidence("Vfixed_acidity", opt1);
        else
            opt1 = "not selected";
        
          if(opt2 != "" && opt2 != null && !opt2.isEmpty())
            net.setEvidence("Vvolatile_acidity", opt2);
          else
            opt2 = "not selected";
          
            if(opt3 != "" && opt3 != null && !opt3.isEmpty())
            net.setEvidence("Vcitric_acid", opt3);
            else
            opt3 = "not selected";
                  
                if(opt4 != "" && opt4 != null && !opt4.isEmpty())
            net.setEvidence("Vresidual_sugar", opt4);
                else
            opt4 = "not selected";
                
                  if(opt5 != "" && opt5 != null && !opt5.isEmpty())
            net.setEvidence("chlorides", opt5);
                  else
            opt5 = "not selected";
                  
                    if(opt6 != "" && opt6 != null && !opt6.isEmpty())
            net.setEvidence("Vfree_sulfur_dioxide", opt6);
                    else
            opt6 = "not selected";
                    
                      if(opt7 != "" && opt7 != null && !opt7.isEmpty())
            net.setEvidence("Vtotal_sulfur_dioxide", opt7);
                      else
            opt7 = "not selected";
                      
                        if(opt8 != "" && opt8 != null && !opt8.isEmpty())
            net.setEvidence("density", opt8);
                        else
            opt8 = "not selected";
                        
                            if(opt9 != "" && opt9 != null && !opt9.isEmpty())
            net.setEvidence("pH", opt9);
                            else
            opt9 = "not selected";
                            
                              if(opt10 != "" && opt10 != null && !opt10.isEmpty())
            net.setEvidence("sulphates", opt10);
                              else
            opt10 = "not selected";
                              
                                if(opt11 != "" && opt11 != null && !opt11.isEmpty())
            net.setEvidence("alcohol", opt11);
                                else
            opt11 = "not selected";
                        
                                if(opt12 != "" && opt12 != null && !opt12.isEmpty() && (opt12.contains("red")  || opt12.contains("white")))
            net.setEvidence("type", opt12);
                                else
            opt12 = "not selected";
        net.updateBeliefs();
        
        String[] aQualityOutcomeIds = net.getOutcomeIds("quality");
        double[] aValues = net.getNodeValue("quality");
        double[]  P_Quality = new double[11];
        String quality = null;
        for (outcomeIndex = 0; outcomeIndex < aQualityOutcomeIds.length; outcomeIndex++)
        {
            P_Quality[outcomeIndex] = aValues[outcomeIndex];
            System.out.println("Quality " + aQualityOutcomeIds[outcomeIndex] +  " Value: " + df.format(aValues[outcomeIndex]));
        }

        int maxIndex = 0;
        for (int i = 1; i < aValues.length; i++){
            double number = aValues[i];
            if ((number > aValues[maxIndex])){
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
        System.out.println("Max Quality " + aQualityOutcomeIds[maxIndex] +  " Value: " + df.format(aValues[maxIndex]));
        if (aQualityOutcomeIds[maxIndex].contains("State3"))
            quality = "This wine has a quality of 3 "+  " at probability of " + df.format(aValues[maxIndex]);
        else if (aQualityOutcomeIds[maxIndex].contains("State4"))
            quality = "This wine has a quality of 4 "+ " at probability of " + df.format(aValues[maxIndex]);
        else if (aQualityOutcomeIds[maxIndex].contains("State5"))
            quality = "This wine has a quality of 5 " + " at probability of " + df.format(aValues[maxIndex]);
        else if (aQualityOutcomeIds[maxIndex].contains("State6"))
            quality = "This wine has a quality of 6 "+ " at probability of " + df.format(aValues[maxIndex]);
        else if (aQualityOutcomeIds[maxIndex].contains("State7"))
            quality = "This wine has a quality of 7 " + " at probability of " + df.format(aValues[maxIndex]);
        else if (aQualityOutcomeIds[maxIndex].contains("State8"))
            quality = "This wine has a quality of 8 "+ " at probability of " + df.format(aValues[maxIndex]);
        else
            quality = "This wine has a quality of 9 " + " at probability of " + df.format(aValues[maxIndex]);
        
        HttpSession session = request.getSession();
        session.setAttribute("opt1", opt1);
        session.setAttribute("opt2", opt2);
        session.setAttribute("opt3", opt3);
        session.setAttribute("opt4", opt4);
        session.setAttribute("opt5", opt5);
        session.setAttribute("opt6", opt6);
        session.setAttribute("opt7", opt7);
        session.setAttribute("opt8", opt8);
        session.setAttribute("opt9", opt9);
        session.setAttribute("opt10", opt10);
        session.setAttribute("opt11", opt11);
        session.setAttribute("opt12", opt12 );
        session.setAttribute("Quality", quality);
        session.setAttribute("Probability3",df.format(aValues[0]));
        session.setAttribute("Probability4",df.format(aValues[1]));
        session.setAttribute("Probability5",df.format(aValues[2]));
        session.setAttribute("Probability6",df.format(aValues[3]));
        session.setAttribute("Probability7",df.format(aValues[4]));
        session.setAttribute("Probability8",df.format(aValues[5]));
        session.setAttribute("Probability9",df.format(aValues[6]));
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/newjsp.jsp");
        rd.forward(request, response);

//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
//            out.println("<h1>Servlet NewServlet at " + opt1 + "</h1>");
//            out.println("<h1>Servlet NewServlet at " + opt2 + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
