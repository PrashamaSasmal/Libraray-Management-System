import java .io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
public class lmp10 extends HttpServlet{
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
           res.setContentType("text/html");
           PrintWriter pwl = res.getWriter();
       
          String st1= req.getParameter("npnt1");
          String st2= req.getParameter("npnt2");
       
          int issue1=0;
          int quantity1=0;
          String ide=null;
          String issue2=null;String quantity2=null;
       
       //pwl.println("<html><body bgcolor=red>Welcome  "+nm+"<br> your email:"+nm1+"<br> your Password:"+nm2+"<br> your address:"+nm3+"<br> your contact number:"+nm4+"<br> Sequrity question:"+nm5+"<br> your  Answer:"+nm6+"</body></html>");
     
           try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
          Statement st = cn.createStatement();
          String ql ="delete from library3 where studentid='"+st2+"' and bookcallno='"+st1+"'";
          ResultSet rs = st.executeQuery(ql);
         
        
              String qlt ="select * from library2 where call_no='"+st1+"'";
          ResultSet rst = st.executeQuery(qlt);
          
         if(rst.next()){
         String issue =rst.getString(7);
         String quantity =rst.getString(6);
         ide = rst.getString(1);
         issue1=Integer.parseInt(issue);
         
         quantity1=Integer.parseInt(quantity);
         
         if(issue1==0){
             pwl.println("<html>\n" +
"<head><title>Messege</title>\n" +
"</head>\n" +
"<body>\n" +
"<form method=\"post\" action=\"lmsi7.html\">\n" +
"<div> no book was issued plz check!</div>\n" +
"<input type=\"submit\"  value=\"ok\">\n" +
"</form>\n" +
"</body>\n" +
"</html>");
         }
         quantity1++;
         issue1--;
          issue2=Integer.toString(issue1);
          quantity2=Integer.toString(quantity1);
           String qlp ="update library2 set issueb='"+issue2+"',quantity='"+quantity2+"' where call_no='"+st1+"'";    
           int y = st.executeUpdate(qlp);
           if(y>0){
           pwl.println("<html>\n" +
"<head><title>Messege</title>\n" +
"</head>\n" +
"<body>\n" +
"<form method=\"post\" action=\"lmsi7.html\">\n" +
"<div> successfull!</div>\n" +
"<input type=\"submit\"  value=\"ok\">\n" +
"</form>\n" +
"</body>\n" +
"</html>");
          }
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