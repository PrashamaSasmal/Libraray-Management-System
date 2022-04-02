import java .io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
public class lmp11 extends HttpServlet{
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
           res.setContentType("text/html");
           PrintWriter pwl = res.getWriter();
       
          String st1= req.getParameter("abj2");
         
       
          
       //pwl.println("<html><body bgcolor=red>Welcome  "+nm+"<br> your email:"+nm1+"<br> your Password:"+nm2+"<br> your address:"+nm3+"<br> your contact number:"+nm4+"<br> Sequrity question:"+nm5+"<br> your  Answer:"+nm6+"</body></html>");
     
           try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
          Statement st = cn.createStatement();
          String ql ="delete from library2 where name='"+st1+"'";
          ResultSet rs = st.executeQuery(ql);
         
        
             
         if(rs.next()){
             pwl.println("successful");
          }
         
         
          else{
          pwl.println("unsuccessful");
          }

          }
         
         
      catch(Exception e){
          pwl.println(e);
      }
       }
}