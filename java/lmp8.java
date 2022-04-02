import java .io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
public class lmp8 extends HttpServlet{
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
           res.setContentType("text/html");
           PrintWriter pwl = res.getWriter();
       
        String st1= req.getParameter("npn1");
        String st2= req.getParameter("npn2");
        String st3= req.getParameter("npn3");
        String st4= req.getParameter("npn4");
       int issue1=0;
       int quantity1=0;
       String ide=null;
       String issue2=null;String quantity2=null;
        Date d=new Date();
        //SimpleDateFormat f=new SimpleDateFormat("dd/mm/yy");
        int dd=d.getDate();
        int mm=d.getMonth()+1;
        int yy=d.getYear()+1900;
        String date =dd+"/"+mm+"/"+yy; 
       //pwl.println("<html><body bgcolor=red>Welcome  "+nm+"<br> your email:"+nm1+"<br> your Password:"+nm2+"<br> your address:"+nm3+"<br> your contact number:"+nm4+"<br> Sequrity question:"+nm5+"<br> your  Answer:"+nm6+"</body></html>");
         
           try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
          Statement st = cn.createStatement();
          String ql ="select * from library2 where call_no='"+st1+"'";
          ResultSet rs = st.executeQuery(ql);
          
         if(rs.next()){
         String issue =rs.getString(7);
         String quantity =rs.getString(6);
         ide = rs.getString(1);
         issue1=Integer.parseInt(issue);
         quantity1=Integer.parseInt(quantity);
         if(quantity1==0){
             pwl.println("<html>\n" +
"<head><title>Messege</title>\n" +
"</head>\n" +
"<body>\n" +
"<form method=\"post\" action=\"lmsi7.html\">\n" +
"<div> book out of stock!</div>\n" +
"<input type=\"submit\"  value=\"ok\">\n" +
"</form>\n" +
"</body>\n" +
"</html>");
         }
         quantity1--;
         issue1++;
          issue2=Integer.toString(issue1);
          quantity2=Integer.toString(quantity1);
          
          }
           String qlt ="insert into library3 values('"+ide+"','"+st1+"','"+st2+"','"+st3+"','"+st4+"','"+date+"')";
           int x = st.executeUpdate(qlt);
           if(x>0){
           pwl.println("book issued");
           }
           String qlp ="update library2 set issueb='"+issue2+"',quantity='"+quantity2+"' where call_no='"+st1+"'";
           int y = st.executeUpdate(qlp);
           if(x>0){
           pwl.println("<html>\n" +
"<head><title>Messege</title>\n" +
"</head>\n" +
"<body>\n" +
"<form method=\"post\" action=\"lmsi7.html\">\n" +
"<div> successfully!</div>\n" +
"<input type=\"submit\"  value=\"ok\">\n" +
"</form>\n" +
"</body>\n" +
"</html>");
           }
          }
         
         
      catch(Exception e){
          pwl.println(e);
      }
       }
}