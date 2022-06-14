package dao;

import app.MainRun;
import entity.Assignment;
import entity.Driver;
import entity.Route;
import service.AssignmentService;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
// nguyên tắc: đọc toàn bộ ra list ==> xử lý đọc như cũ.
// ghi: ghi thêm, không ghi đè ===> ghi phần thêm vào db + ghi phần thêm vào list = đồng bộ
// ví dụ: bảng db gồm 3 cột ==>Khởi tạo: chuyển 3 cột về object trong list => ghi: ghi dữ liệu kiểu object vào list, ghi thông tin tương ứng của object vào 3 cột
public class AssignmentDAO {
    public void readData(){
        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Ntdptit2821@");) {
            // read and write
            // read data from db

            String sql = "select driver_id from assignments group by driver_id";
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql);

            while(res.next()){
                int  driver_id = res.getInt(1);
                String sql1 = "select * from assignments where driver_id = ?";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                statement1.setInt(1,driver_id);
                ResultSet res1 = statement1.executeQuery();
                Driver driver = AssignmentService.findDriverById(driver_id);
                Map<Route,Integer> rm = new HashMap<>();
                while (res1.next()){
                    int route_id = res1.getInt(2);
                    int soLuot = res1.getInt(3);
                    Route route  = AssignmentService.findRouteById(route_id);
                    rm.put(route,soLuot);

                }
                Assignment assignment = new Assignment(driver,rm);
                MainRun.assignmentList.add(assignment);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void writeData(int driver_id,int route_id, int soLuot){
        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Ntdptit2821@");) {
            PreparedStatement statement = connection.prepareStatement("insert into assignments values(?,?,?)");
            statement.setInt(1,driver_id);
            statement.setInt(2,route_id);
            statement.setInt(3,soLuot);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
