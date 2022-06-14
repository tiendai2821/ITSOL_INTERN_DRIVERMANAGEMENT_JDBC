package service;

import app.MainRun;
import dao.DriverDAO;
import entity.Driver;
import sun.applet.Main;

import java.util.Scanner;

public class DriverService {
    public void addDriver(){
        if(MainRun.driverList.isEmpty()){
            Driver.setMaLxLast(9999);
        }else {
            Driver.setMaLxLast(MainRun.driverList.get(MainRun.driverList.size()-1).getMaLx());
        }
        int numDriver;
        System.out.println("Nhập số lượng lái xe muốn thêm: ");
        while(true){
            try{
                numDriver = Integer.parseInt(new Scanner(System.in).next());
                break;
            }catch(NumberFormatException e){
                System.out.println("Chỉ nhập số, mời nhập lại số lượng lái xe: ");
            }
        }
        for(int i = 0 ; i<numDriver; i++){
            Driver driver = new Driver();
            driver.inputInfo();
            MainRun.driverList.add(driver);
            DriverDAO driverDAO = new DriverDAO();
            driverDAO.writeData(driver);
        }
//        FileUtil fileUtil = new FileUtil();
//        fileUtil.writeDataToFile(MainRun.driverList,MainRun.diverFile);

    }
    public void showDriverTable(){
        for(Driver d: MainRun.driverList){
            System.out.println(d);
        }
    }
}
