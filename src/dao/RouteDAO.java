package dao;

import app.MainRun;
import entity.Route;

import java.sql.*;

public class RouteDAO {
    public void readData(){
        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Ntdptit2821@");){
            String sql = "Select * from Route";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                float distance = rs.getFloat(2);
                int numberOfStops = rs.getInt(3);
                Route route = new Route(id,distance,numberOfStops);
                MainRun.routeList.add(route);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void writeData(Route route){
        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Ntdptit2821@")){
            String sql = ("insert into Route values(?,?,?)");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,route.getMaTuyen());
            statement.setFloat(2,route.getKhoangCach());
            statement.setInt(3,route.getSoDiemDung());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
