import java .io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
public class lmp6 extends HttpServlet{
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
           res.setContentType("text/html");
           PrintWriter pwl = res.getWriter();
       
        int count = 0;
        String callno = req.getParameter("ab1");
        String name = req.getParameter("ab2");
        String author= req.getParameter("ab3");
        String publisher = req.getParameter("ab4");
        String quantity = req.getParameter("ab5");
       // String date = req.getParameter("ab6");
        Date d=new Date();
        //SimpleDateFormat f=new SimpleDateFormat("dd/mm/yy");
        int dd=d.getDate();
        int mm=d.getMonth()+1;
        int yy=d.getYear()+1900;
        String date =dd+"/"+mm+"/"+yy; 
        
 //     String issue="null";
//       int count=0;
   
    
      try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
          Statement st = cn.createStatement(); 
          String qlt="select * from library2";
          ResultSet rs = st.executeQuery(qlt);
          if(rs.next()){
             while(rs.next()){
             
             String sr1= rs.getString(1);
             count=Integer.parseInt(sr1);}
          }
          else{
      
             count=1;
          }
          String count1=Integer.toString(count);
          String issue="0";
          String ql ="insert into library2 values('"+count1+"','"+callno+"','"+name+"','"+author+"','"+publisher+"','"+quantity+"','"+issue+"','"+date+"')";
          int rst = st.executeUpdate(ql);
          if(rst>0){
          pwl.println("<html>\n" +
"<head><title>Messege</title>\n" +
"</head>\n" +
"<body>\n" +
"<form method=\"post\" action=\"lmsi7.html\">\n" +
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