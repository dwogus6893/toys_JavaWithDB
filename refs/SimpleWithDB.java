package com.dwogus6893.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SimpleWithDB {
    public ArrayList<HashMap> getList(){
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        Statement statementAnswer = commons.getStatement();

        // 설문과 답항 내용 출력
        String query = "SELECT * FROM questions_list " +
                "ORDER BY ORDERS";
        ArrayList<HashMap> bundle_list = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                // 설문 문항에 맞는 설문 답항 출력
                System.out.print(resultSet.getInt("ORDERS") + ". ");
                System.out.println(resultSet.getString("QUESTIONS"));
                String uid = resultSet.getString("QUESTIONS_UID");
                HashMap<String, Object> question = new HashMap<String, Object>();
                question.put("ORDERS", resultSet.getInt("ORDERS"));
                question.put("QUESTIONS", resultSet.getString("QUESTIONS"));
                question.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));

                // 설문자 답 받기
                query = "SELECT example_list.EXAMPLE_UID, example_list.EXAMPLE, example_list.ORDERS " +
                        "FROM answers inner Join example_list " +
                        " on answers.EXAMPLE_UID = example_list.EXAMPLE_UID " +
                        " WHERE QUESTIONS_UID = '" + uid + "' " +
                        "ORDER BY ORDERS";
                ResultSet resultSetAnswer = statementAnswer.executeQuery(query);
                // 설문 답항 출력
                ArrayList<HashMap> example_list = new ArrayList<HashMap>();
                while (resultSetAnswer.next()) {
                    System.out.print(resultSetAnswer.getInt("ORDERS") + ". ");
                    System.out.println(resultSetAnswer.getString("EXAMPLE"));
                    HashMap<String, Object> answer = new HashMap<>();
                    }
                resultSetAnswer.close();
                HashMap<String, Object> bundle = new HashMap<>();
                bundle.put("question",question);
                bundle.put("example_list",example_list);

                bundle_list.add(bundle);
            }
            statementAnswer.close();
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bundle_list;
    }
}

