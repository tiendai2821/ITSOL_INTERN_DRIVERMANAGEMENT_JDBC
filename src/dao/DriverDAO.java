package dao;

import java.sql.*;
import java.util.List;

import app.MainRun;
import entity.Driver;
// ham doc du lieu cho driver => tra ve mang
// ghi du lieu => ghi tung cai
public class DriverDAO {
    public void readData(){
        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Ntdptit2821@");) {
            // read and write
            // read data from db

            String sql = "select * from Driver";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                int  id = res.getInt(1);
                String fullName = res.getString(2);
                String address = res.getString(3);
                long phone = res.getLong(4);
                String level = res.getString(5);
                Driver driver = new Driver(id,fullName,address,phone,level);
//                System.out.println(driver);
                MainRun.driverList.add(driver);
            }
            res.close();
            statement.close();

        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void writeData(Driver driver){
        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Ntdptit2821@")){
            String sql = "Insert into Driver values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,driver.getMaLx());
            statement.setString(2, driver.getName());
            statement.setString(3,driver.getAddress());
            statement.setLong(4,driver.getPhoneNum());
            statement.setString(5,driver.getTrinhDo());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
