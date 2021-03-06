import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;
//@WebServlet(name = "viewServlet", value = "/viewServlet")
public class viewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Reading All Requested Parameters";
        out.println ("<HTML><HEAD><TITLE>" + title + "</TITLE></HEAD>" +
                "<BODY>\n" +
                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TR>\n" +
                "<TH>Parameter Name<TH>Parameter Value(s)");
        Enumeration Names = request.getParameterNames();
        while(Names.hasMoreElements()) {
            String paramName = (String)Names.nextElement();
            out.print("<TR><TD>" + paramName + "\n<TD>");
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0) out.println("<I>No Value</I>");
                else out.println(paramValue);
            } else {
                out.println("<UL>");
                for(int i=0; i<paramValues.length; i++)
                { out.println("<LI>" +paramValues[i]);   }
                out.println("</UL>");
            }
        }
        out.println("</TABLE>\n</BODY></HTML>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        doGet(request, response);
    }
}
