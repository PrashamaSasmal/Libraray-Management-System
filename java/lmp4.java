import java .io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
public class lmp4 extends HttpServlet{
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
           res.setContentType("text/html");
           PrintWriter pwl = res.getWriter();
       
       
       
       String delete= req.getParameter("del");
       //pwl.println("<html><body bgcolor=red>Welcome  "+nm+"<br> your email:"+nm1+"<br> your Password:"+nm2+"<br> your address:"+nm3+"<br> your contact number:"+nm4+"<br> Sequrity question:"+nm5+"<br> your  Answer:"+nm6+"</body></html>");
     
           try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
          Statement st = cn.createStatement();
          
          String ql= "delete from library where id='"+delete+"'";
          
          int ex=st.executeUpdate(ql);
          if(ex>0)
              pwl.println("<html>\n" +
"<head><title>Messege</title>\n" +
"</head>\n" +
"<body>\n" +
"<form method=\"post\" action=\"lmsi3.html\">\n" +
"<div>Librarian deleted successfully!</div>\n" +
"<input type=\"submit\"  value=\"ok\">\n" +
"</form>\n" +
"</body>\n" +
"</html>");
          else{
              pwl.println("something went wrong");
          }
      cn.close();
      }
         
      catch(Exception e){
          pwl.println(e);
      }
       }
}