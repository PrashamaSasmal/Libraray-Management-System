import java .io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
public class lmp5 extends HttpServlet{
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
           res.setContentType("text/html");
           PrintWriter pwl = res.getWriter();
       
        String st1= req.getParameter("np1");
        String st2= req.getParameter("np2");
       
       
       //pwl.println("<html><body bgcolor=red>Welcome  "+nm+"<br> your email:"+nm1+"<br> your Password:"+nm2+"<br> your address:"+nm3+"<br> your contact number:"+nm4+"<br> Sequrity question:"+nm5+"<br> your  Answer:"+nm6+"</body></html>");
         
           try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
          Statement st = cn.createStatement();
          String ql ="select * from library where name='"+st1+"' and password='"+st2+"'";
          ResultSet rs = st.executeQuery(ql);
          
          if(rs.next()){
          pwl.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Librarian  Section</title>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <style>\n" +
"            body{\n" +
"                background-color: scrollbar;\n" +
"               \n" +
"            }\n" +
"            #btn{\n" +
"                position:absolute;\n" +
"                top:20%;\n" +
"                left:40%;\n" +
"           \n" +
"            }\n" +
"            input{\n" +
"                height: 50px;\n" +
"                width: 160px;\n" +
"                padding: 10px;\n" +
"                margin: 10px;\n" +
"               \n" +
"            }\n" +
"            h1{\n" +
"                position: absolute;\n" +
"               \n" +
"                left: 40%;\n" +
"                \n" +
"            }\n" +
"            a{\n" +
"                text-decoration: none;\n" +
"            }\n" +
"           \n" +
"        </style>\n" +
"    </head>\n" +
"    <body> \n" +
"    <center><h1>Librarian Section</h1></center>\n" +
"    \n" +
"\n" +
"           \n" +
"            <div id=\"btn\">\n" +
"                \n" +
"                <div ><form method=\"post\" action=\"lmp6\"><div id=\"btn1\"><input type=\"submit\"  value=\"Add Book \"></div>\n" +
"            \n" +
"              <form method=\"post\" action=\"\"><div id=\"btn2\"><input type=\"submit\"  value=\"View Books \"></div></form>\n" +
"              <form method=\"post\" action=\"\"><div id=\"btn3\"><input type=\"submit\"  value=\"Issue Books \"></div></form>\n" +
"              <form method=\"post\" action=\"\"><div id=\"btn4\"><input type=\"submit\"  value=\"View  Issued Books \"></div></form>\n" +
"              <form method=\"post\" action=\"\"><div id=\"btn5\"><input type=\"submit\"  value=\"Return Book\"></div></form>\n" +
"              <div id=\"btn6\"><a href=\"\"><input type=\"submit\"  value=\"Logout\"></a></div>\n" +
"             \n" +
"            </div>\n" +
"        \n" +
"    </body>\n" +
"</html>\n" +
"");

          }
          else{
           pwl.println("Something went wrong");
          }

          }
         
         
      catch(Exception e){
          pwl.println(e);
      }
       }
}