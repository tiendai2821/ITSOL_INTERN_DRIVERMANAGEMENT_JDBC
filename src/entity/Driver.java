package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Driver extends Person {
    private static int maLxLast;
    private int maLx;
    private String trinhDo;

    public Driver() {
        super();
        this.maLxLast ++;
        this.maLx = maLxLast;
    }

    public Driver(int maLx,String name,String address, long phoneNum,String trinhDo) {
        super(name, address, phoneNum);
        this.maLx = maLx;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.trinhDo = trinhDo;
    }

    public static int getMaLxLast() {
        return maLxLast;
    }

    public static void setMaLxLast(int maLxLast) {
        Driver.maLxLast = maLxLast;
    }

    public int getMaLx() {
        return maLx;
    }

    public void setMaLx(int maLx) {
        this.maLx = maLx;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public void inputInfo(){
        System.out.println("Nhập tên cho lái xe: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập số địa chỉ cho lái xe: ");
        this.address = new Scanner(System.in).nextLine();

        while (true){
            System.out.println("Nhập số điện thoại cho lái xe: ");
            try {
                this.phoneNum = Long.parseLong(new Scanner(System.in).next());
                break;
            }catch (NumberFormatException e){
                System.out.println("Số điện thoại là chuỗi số có 10 chữ số, mời nhập lại: ");
            }
        }
        while (true){
            System.out.println("Nhập trình độ lái xe: ");
            System.out.println("1. Trình độ A");
            System.out.println("2. Trình độ B");
            System.out.println("3. Trình độ C");
            System.out.println("4. Trình độ D");
            System.out.println("5. Trình độ E");
            System.out.println("6. Trình độ F");

            int level;
            try {
                level = Integer.parseInt(new Scanner(System.in).next());
                switch (level){
                    case 1:
                        this.trinhDo = "A";
                        break;
                    case 2:
                        this.trinhDo = "B";
                        break;
                    case 3:
                        this.trinhDo = "C";
                        break;
                    case 4:
                        this.trinhDo = "D";
                        break;
                    case 5:
                        this.trinhDo = "E";
                        break;
                    case 6:
                        this.trinhDo = "F";
                        break;

                }
                if(level <=6 && level >=1){
                    break;
                }
                System.out.println("Chỉ nhập từ 1 đến 6, mới nhập lại: ");
            } catch (NumberFormatException e){
                System.out.println("Chỉ nhập số, mời nhập lại");
            }


        }

    }
    @Override
    public String toString() {
        return "Driver{ MaLx: "+maLx+", Name: "+ name +", Address: "+ address + ", Phonenum: "+phoneNum+" }";
    }
}

