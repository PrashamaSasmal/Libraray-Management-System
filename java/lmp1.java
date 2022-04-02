import java .io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
public class lmp1 extends HttpServlet{
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
           res.setContentType("text/html");
           PrintWriter pwl = res.getWriter();
       
       
       String name = req.getParameter("n1");
        String password = req.getParameter("n2");
       
       //pwl.println("<html><body bgcolor=red>Welcome  "+nm+"<br> your email:"+nm1+"<br> your Password:"+nm2+"<br> your address:"+nm3+"<br> your contact number:"+nm4+"<br> Sequrity question:"+nm5+"<br> your  Answer:"+nm6+"</body></html>");
      try
      {
          
          
          String myStr1="admin";
          String myStr2="admin123";
          if(myStr1.equals(name) && myStr2.equals(password)){
          pwl.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Admin Section</title>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <style>\n" +
"            body{\n" +
"                background-color: scrollbar;\n" +
"            }\n" +
"            #btn{\n" +
"    position: fixed;\n" +
"    top:20%;\n" +
"    left: 50%;\n" +
"           \n" +
"            }\n" +
"            input{\n" +
"                height: 70px;\n" +
"                width: 160px;\n" +
"                padding: 20px;\n" +
"                margin: 10px;\n" +
"               \n" +
"            }\n" +
"            h1{\n" +
"                position: absolute;\n" +
"                left:50%;\n" +
"                \n" +
"            }\n" +
"            a{\n" +
"                text-decoration: none;\n" +
"            }\n" +
"           \n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"    <center><h1>Admin Section</h1></center>\n" +
"    \n" +
"\n" +
"           \n" +
"            <div id=\"btn\">\n" +
"                \n" +
"            <div id=\"btn1\"><a href=\"lmsi4.html\"><input type=\"submit\"  value=\"Add Librarian\"></a></div>\n" +
"            \n" +
"            <form method=post action=lmp3> <div id=\"btn2\"><input type=\"submit\"  value=\"View Librarian\"></div>\n</form>" +
"         <div id=\"btn2\"><a href=\"lmsi5.html\"><input type=\"submit\"  value=\"Delete Librarian\"></a></div>\n" +    
"             <div id=\"btn2\"><a href=\"lmsi.html\"><input type=\"submit\"  value=\"Logout\"></a></div>\n" +
"            </div>\n" +
"        \n" +
"    </body>\n" +
"</html>\n" +
"");
          }
          else{
           pwl.println("Please enter a valid name and password");
          }
         
      }catch(Exception e){
          pwl.println(e);
      }
       }
}