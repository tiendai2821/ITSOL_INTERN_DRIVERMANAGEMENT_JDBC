package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Route implements Serializable {
    private static int maTuyenLast;
    private int maTuyen;
    private float khoangCach;
    private int soDiemDung;

    public Route() {
        maTuyenLast ++;
        this.maTuyen = maTuyenLast;
    }

    public Route(int maTuyen, float khoangCach, int soDiemDung) {
        this.maTuyen = maTuyen;
        this.khoangCach = khoangCach;
        this.soDiemDung = soDiemDung;
    }

    public static int getMaTuyenLast() {
        return maTuyenLast;
    }

    public static void setMaTuyenLast(int maTuyenLast) {
        Route.maTuyenLast = maTuyenLast;
    }

    public int getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(int maTuyen) {
        this.maTuyen = maTuyen;
    }

    public float getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(float khoangCach) {
        this.khoangCach = khoangCach;
    }

    public int getSoDiemDung() {
        return soDiemDung;
    }

    public void setSoDiemDung(int soDiemDung) {
        this.soDiemDung = soDiemDung;
    }

    public void inputInfo(){

        while (true){
            System.out.println("Nhập khoảng cách cho tuyến: ");
            try {
                this.khoangCach = Float.parseFloat(new Scanner(System.in).next());
                break;
            }catch (NumberFormatException e){
                System.out.println("Khoảng cách cho tuyến phải là 1 số, mời nhập lại: ");
            }
        }
        while (true){
            System.out.println("Nhập số điểm dừng cho tuyến: ");
            try {
                this.soDiemDung = Integer.parseInt(new Scanner(System.in).next());
                break;
            }catch (NumberFormatException e){
                System.out.println("Số điểm dừng cho tuyến phải là 1 số nguyên, mời nhập lại: ");
            }
        }

    }

    @Override
    public String toString() {
        return "Route{ Mã tuyến: " + maTuyen +", Khoảng cách: "+ khoangCach + ", Số điểm dừng: "+soDiemDung +"}";
    }

    @Override
    public int hashCode() {
        return this.getMaTuyen();
    }
}
