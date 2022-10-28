import java.beans.Statement;
import java.sql.SQLException;

public class Surveys {
    public void surveys(Statement statement){
        System.out.println("설문시작");
       
        // 이름과 휴대폰 입력 확인
        System.out.print("이름 :");
        

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.print("휴대폰 번호 :");
        String phone_number = scanner.next();

        Commons commons = new Commons();
        String strDate = commons.getGenerationID();

        String query = "INSERT INTO users_list(USERS_UID,PHONE,NAME)" + 
                        "VALUES('"+strDate+"','"+phone_number+"','"+name+"')";
        
        statement.execute(query);
        try {
            statement.execute(query);
        } catch(SQLException e){
            e.printStackTrace();
        }
        // 설문 내용 출력
       query = "SELECT * FROM questions_list" 
                    + "order by ORDERS";
       try {
                 ResultSet resultSet = statement.execute(query);
                  // 설문자 답 받기
                 while(ResultSet.next()){
                    System.out.print(resultSet.getInt("ORDERS")+".");
                    System.out.println(resultSet.getString("QUESTIONS"));
                    String uid = resultSet.getString("QUESTION_UID");
                    
                    //설문 문항에 맞는 설문 답항 출력
                    query = "SELECT example_list.EXAMPLE_UID, example_list.EXAMPLE, example_list.ORDERS" +
                            "FROM answers inner Join example_list" +
                	        "on answers.EXAMPLE_UID = example_list.EXAMPLE_UID" +
                	        "WHERE QUESTIONS_UID = '"+uid+"'' "+
                            "ORDER BY ORDERS";
                        ResultSet resultSet2 = statement.executeQuery(query);
                        ArrayList arrayList = new ArrayList<>();
                        while(resultSet2.next()){
                            System.out.print(resultSet.getInt("ORDERS")+".");
                            System.out.print(resultSet.getString("EXAMPLE"));
                            }
                            // 설문자 답 받기
                            System.out.print("응답 번호 :");
                            String answer = scanner.next();    
                            
                        }
                    } catch(SQLException e) {
                    e.printStackTrace();
                }       
        }
}
