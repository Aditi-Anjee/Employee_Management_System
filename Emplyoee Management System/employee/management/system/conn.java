package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;//LOAD JDBC  driver into memory
import java.sql.Statement;

public class conn {//to connect with database

    Connection connection;//represent connection to database,its an interface provided by JDBC API
    Statement statement;//send sql queries and command

    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","Anjee@1234");//create connection to sql,3306-default port for mysql,indicate localhost is connected on local machine
            statement = connection.createStatement();//create statement object for executing sql query

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

         

