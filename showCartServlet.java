import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
//@WebServlet(name = "showCartServlet", value = "/showCartServlet")
public class showCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        int length = cookies.length;
        String userName = null;
        String password = null;
        for (int i=0; i<length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("userName"))
                userName = cookie.getValue();
            else if (cookie.getName().equals("password"))
                password = cookie.getValue();
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Items to buy</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("Hello Mr. " + userName + " <BR>Your password is: "+password);
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>Select items to buy:");
        out.println("<BR><FORM METHOD=POST>");
        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=book VALUE= \"MacBook pro air 16\"> MacBook pro air 16");
        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=book VALUE=\"Iphone 13 Pro Max\"> Iphone 13 Pro Max");
        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=book VALUE= \"Fundamentals of Physics-Halliday,Resnick,Walker\"> Fundamentals of Physics-Halliday,Resnick,Walker");
        out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=book VALUE=\"IntelliJ Ultimate edition\"> IntelliJ Ultimate edition");
        out.println("<BR>");
        out.println("<BR><INPUT TYPE=SUBMIT VALUE=\"Add to Cart\">");
        out.println("</FORM>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] val = request.getParameterValues("product");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (val != null ) {
            int length = val.length;
            out.println("Items added in to your cart : ");
            out.println("<BR>");
            for (int i=0; i<length; i++) {
                out.println("<BR>" + val[i]);
            }
        }
        else
        {
            out.println("You have not selected any product, please go back and select items to buy");
        }
    }
}