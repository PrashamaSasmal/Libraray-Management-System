import java .io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
public class lmp2 extends HttpServlet{
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
           res.setContentType("text/html");
           PrintWriter pwl = res.getWriter();
       
       
        String name1 = req.getParameter("nm3");
        String password1 = req.getParameter("nm4");
        String id1= req.getParameter("nm5");
        String email1 = req.getParameter("nm6");
        String address1 = req.getParameter("nm7");
        String city1 = req.getParameter("nm8");
        String cno1 = req.getParameter("nm9");
       //pwl.println("<html><body bgcolor=red>Welcome  "+nm+"<br> your email:"+nm1+"<br> your Password:"+nm2+"<br> your address:"+nm3+"<br> your contact number:"+nm4+"<br> Sequrity question:"+nm5+"<br> your  Answer:"+nm6+"</body></html>");
         //pwl.println("<html><body bgcolor=red>Welcome  "+nm+"<br> your email:"+nm1+"<br> your Password:"+nm2+"<br> your address:"+nm3+"<br> your contact number:"+nm4+"<br> Sequrity question:"+nm5+"<br> your  Answer:"+nm6+"</body></html>");
      try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
          Statement st = cn.createStatement();
          String ql ="insert into library values('"+name1+"','"+password1+"','"+id1+"','"+email1+"','"+address1+"','"+city1+"','"+cno1+"')";
          int rs = st.executeUpdate(ql);
          if(rs>0){
          pwl.println("<html>\n" +
"<head><title>Messege</title>\n" +
"</head>\n" +
"<body>\n" +
"<form method=\"post\" action=\"lmsi3.html\">\n" +
"<div>Librarian added successfully!</div>\n" +
"<input type=\"submit\"  value=\"ok\">\n" +
"</form>\n" +
"</body>\n" +
"</html>");
          }
          else{
           pwl.println("something went wrong");
          }
          cn.close();
      }catch(Exception e){
          pwl.println(e);
      }
       }
}