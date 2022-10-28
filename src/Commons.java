import java.sql.DriverManager;
import java.util.*;
import java.sql.*;
imp

public class Commons {
    public Statement getStatement(){
        String url = "jdbc:mysql://localhost:3306/health_club";
        //DB접속 ID
        String user = "root";
        //DB접속 패스워드
        String password = "aa6236";
        
        Statement statement;
try {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement  = connection.createStatement();
    } catch(SQLException e) {
        e.printStackTrace();
    }
    return statement;
    }
    public String getGenerationID() {
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyyhh:mm:ss");  
        String strDate = formatter.format(date);
        return strDate;
    }
}
