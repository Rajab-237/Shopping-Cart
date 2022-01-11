import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;
//@WebServlet(name = "LogServlet", value = "/LogServlet")
public class LogServlet extends HttpServlet {
    private void LoginForm(HttpServletResponse response,boolean withErrorMessage) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Login</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");

        if (withErrorMessage)
            out.println("Login failed. Please try again.<BR>");
        out.println("<BR>");
        out.println("<BR>Please enter your user name and password.");
        out.println("<BR><FORM METHOD=POST>");
        out.println("<BR>User Name: <INPUT TYPE=TEXT NAME=userName>");
        out.println("<BR>Password: <INPUT TYPE=PASSWORD NAME=password>");
        out.println("<BR><INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginForm(response, false);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String pass = request.getParameter("password");
//        /* HttpSession session = request.getSession(true);
//    session.setAttribute("loggedIn", new String("true")); */
        Cookie c_1 = new Cookie("userName", userName);
        Cookie c_2 = new Cookie ("password", pass);
        response.addCookie(c_1);
        response.addCookie(c_2);
        if (userName!=null && pass!=null && userName.equals("cse4635") && pass.equals("web")) {
            response.sendRedirect("/showCartServlet.java");
        }
        else {
            LoginForm(response, true);
        }
    }
}