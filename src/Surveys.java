import java.beans.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Surveys {
    public void surveys(java.sql.Statement statement){
        // 설문시작
       System.out.println("설문시작");
       
        // 이름과 휴대폰 입력 확인
        System.out.print("이름 :");
        

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.print("휴대폰 번호 :");
        String phone_number = scanner.next();

        String query = "INSERT INTO users_list(USERS_UID,PHONE,NAME)" + 
        "VALUES('U1','"+phone_number+"','"+name+"')";
        
        try {
            statement.execute(query);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            statement.execute(query);
        } catch(SQLException e){
            e.printStackTrace();
        }
        // 설문 내용 출력
        // 설문자 답 받기
    }

}
