import java .io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
public class lmp9 extends HttpServlet{
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
           res.setContentType("text/html");
           PrintWriter pwl = res.getWriter();
       
       
       
       
       //pwl.println("<html><body bgcolor=red>Welcome  "+nm+"<br> your email:"+nm1+"<br> your Password:"+nm2+"<br> your address:"+nm3+"<br> your contact number:"+nm4+"<br> Sequrity question:"+nm5+"<br> your  Answer:"+nm6+"</body></html>");
     
           try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
          Statement st = cn.createStatement();
          String ql ="select * from library3";
          ResultSet rs = st.executeQuery(ql);
          pwl.println("<html><body><table width=100% border=1><tr><th>Id</th><th>Bookcallno</th><th>StudentId</th><th>StudentName</th><th>StudentContact</th><th>IssueDate</th><tr>");
          while(rs.next()){
          pwl.println("<tr><td align=center>"+rs.getString(1)+" </td><td align=center>"+rs.getString(2)+" </td><td align=center>"+rs.getString(3)+" </td><td align=center> "+rs.getString(4)+"</td><td align=center>"+rs.getString(5)+" </td><td align=center>"+rs.getString(6)+" </td></tr>");
//        </td></tr>\n</table>\n" +
          }
pwl.println("</table><div id=\"btn6\"><a href=\"lmsi7.html\"><input type=\"submit\"  value=\"Back\">" +
"</body>\n" +
"</html>");
          }
         
         
      catch(Exception e){
          pwl.println(e);
      }
       }
}