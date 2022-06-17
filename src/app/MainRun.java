package app;

import dao.AssignmentDAO;
import dao.DriverDAO;
import dao.RouteDAO;
import entity.Assignment;
import entity.Driver;
import entity.Route;
import service.AssignmentService;
import service.DriverService;
import service.RouteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// add student => add vao db
// neu db doc = 0 => them tu dau
// neu db doc != 0 => them moi
// ko can doc ham khoi tao
public class MainRun {
    public static DriverService driverService = new DriverService();
    public static RouteService routeService = new RouteService();
    public static AssignmentService assignmentService = new AssignmentService();
    public static List<Route> routeList = new ArrayList<>();
    public static List<Driver> driverList = new ArrayList<>();
    public static List<Assignment> assignmentList = new ArrayList<>();
    public static void main(String[] args) {

        initData();
        Menu();
    }
    private static void initData(){
        DriverDAO driverDAO = new DriverDAO();
        driverDAO.readData();
        RouteDAO routeDAO = new RouteDAO();
        routeDAO.readData();
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        assignmentDAO.readData();
        MainRun.driverList.sort((Driver a,Driver b) -> a.getMaLx()-b.getMaLx());
        MainRun.routeList.sort((Route a,Route b)-> a.getMaTuyen()-b.getMaTuyen());
    }
    private static void Menu() {
        while (true) {
            int function = -1;
            try {

                while (true) {
                    System.out.println("\n\n-------Phần mềm quản lý phân công lái xe-------\n\n");
                    System.out.println("1.Nhập lái xe mới và in ra danh sách lái xe");
                    System.out.println("2.Nhập tuyến mới và in ra danh sách tuyến");
                    System.out.println("3.Nhập và in ra danh sách phân công cho mỗi lái xe");
                    System.out.println("4.Sắp xếp danh sách phân công theo họ tên lái xe");
                    System.out.println("5.Sắp xếp danh sách phân công theo số lượng tuyến");
                    System.out.println("6.Thống kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe");
                    System.out.println("7.Thoát chương trình");
                    function = Integer.parseInt(new Scanner(System.in).next());
                    if (function <= 7 && function >= 1) {
                        break;
                    }
                    System.out.println("Chỉ nhập từ 1 đến 7, mời nhập lại");
                }


            } catch (NumberFormatException e) {
                System.out.println("Đầu vào là 1 số, mời nhập lại: ");
            }
            switch (function){
                case 1:
                    driverService.addDriver();
                    driverService.showDriverTable();
                    break;
                case 2:
                    routeService.addRoute();
                    routeService.showRouteTable();
                    break;
                case 3:
                    assignmentService.addAssignment();
                    assignmentService.showAssignment();
                    break;
                case 4:
                    assignmentService.sortByName();
                    assignmentService.showAssignment();
                    break;
                case 5:
                    assignmentService.sortByQuantity();
                    assignmentService.showAssignment();
                    break;
                case 6:
                    assignmentService.statisticByDistance();
                    break;
                case 7:
                    System.out.println("Tks for use our system!!!");
                    return;
            }
        }
    }
}
