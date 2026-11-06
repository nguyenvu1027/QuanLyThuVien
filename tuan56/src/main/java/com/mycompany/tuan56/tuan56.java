/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tuan56;

import java.util.ArrayList;
import java.util.Scanner;

public class tuan56 {

    // Khai báo các ArrayList toàn cục (song song) để thay thế cho Object (Hướng cấu trúc)
    // Đáp ứng yêu cầu Bài 2 và Bài 3
    static ArrayList<String> danhSachMaSach = new ArrayList<>();
    static ArrayList<String> danhSachTenSach = new ArrayList<>();
    static ArrayList<Integer> danhSachSoLuong = new ArrayList<>();
    static ArrayList<Double> danhSachGiaTri = new ArrayList<>();
    
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // --- CHẠY BÀI 1 ---
        System.out.println("========== THỰC THI BÀI 1 ==========");
        thucHienBai1();
        
        System.out.println("\nNhấn Enter để tiếp tục sang phần Menu (Bài 2, 3, 4)...");
        scanner.nextLine();

        // --- CHẠY BÀI 4 (Bao gồm Bài 2 & Bài 3) ---
        chayMenuBai4();
    }

    // ==========================================
    // BÀI 1: TẠO MẢNG int[] soLuong CHO 5 CUỐN SÁCH
    // ==========================================
    public static void thucHienBai1() {
        int[] soLuong = new int[5]; // Tạo mảng chứa số lượng của 5 cuốn sách
        
        // Nhập số lượng
        System.out.println("Nhập số lượng cho 5 cuốn sách:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Cuốn thứ " + (i + 1) + ": ");
            soLuong[i] = scanner.nextInt();
        }
        
        // Hiển thị, tính tổng, tìm max
        System.out.print("Số lượng các cuốn sách vừa nhập: ");
        int tong = 0;
        int max = soLuong[0];
        
        for (int i = 0; i < 5; i++) {
            System.out.print(soLuong[i] + " ");
            tong += soLuong[i];
            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }
        
        System.out.println("\nTổng số lượng: " + tong);
        System.out.println("Số lượng lớn nhất: " + max);
        
        scanner.nextLine(); // Xóa bộ nhớ đệm
    }

    // ==========================================
    // BÀI 4: MENU HOÀN CHỈNH (TÍCH HỢP BÀI 2 & BÀI 3)
    // ==========================================
    public static void chayMenuBai4() {
        int luaChon;
        do {
            System.out.println("\n========== MENU QUẢN LÝ SÁCH ==========");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ nhớ đệm

            switch (luaChon) {
                case 1 -> themSach();
                case 2 -> hienThiSach();
                case 3 -> timSach();
                case 4 -> xoaSach();
                case 5 -> suaSach();
                case 6 -> tinhTongSoLuong();
                case 7 -> tinhTongGiaTri();
                case 8 -> System.out.println("Đã thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 8);
    }

    // 1. Thêm sách
    public static void themSach() {
        System.out.print("Nhập mã sách: ");
        danhSachMaSach.add(scanner.nextLine());
        
        System.out.print("Nhập tên sách: ");
        danhSachTenSach.add(scanner.nextLine());
        
        System.out.print("Nhập số lượng: ");
        danhSachSoLuong.add(scanner.nextInt());
        
        System.out.print("Nhập giá tiền (1 cuốn): ");
        danhSachGiaTri.add(scanner.nextDouble());
        scanner.nextLine(); // Xóa bộ nhớ đệm
        
        System.out.println("-> Đã thêm sách thành công!");
    }

    // 2. Hiển thị sách
    public static void hienThiSach() {
        if (danhSachMaSach.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("--- DANH SÁCH SÁCH ---");
        for (int i = 0; i < danhSachMaSach.size(); i++) {
            System.out.printf("[%d] Mã: %s | Tên: %s | SL: %d | Giá: %.2f\n", 
                    i, danhSachMaSach.get(i), danhSachTenSach.get(i), 
                    danhSachSoLuong.get(i), danhSachGiaTri.get(i));
        }
    }

    // 3. Tìm sách (theo mã)
    public static void timSach() {
        System.out.print("Nhập mã sách cần tìm: ");
        String maCanTim = scanner.nextLine();
        int index = danhSachMaSach.indexOf(maCanTim);
        
        if (index != -1) {
            System.out.println("-> TÌM THẤY SÁCH:");
            System.out.printf("Mã: %s | Tên: %s | SL: %d | Giá: %.2f\n", 
                    danhSachMaSach.get(index), danhSachTenSach.get(index), 
                    danhSachSoLuong.get(index), danhSachGiaTri.get(index));
        } else {
            System.out.println("-> Không tìm thấy mã sách này!");
        }
    }

    // 4. Xóa sách
    public static void xoaSach() {
        System.out.print("Nhập mã sách cần xóa: ");
        String maCanXoa = scanner.nextLine();
        int index = danhSachMaSach.indexOf(maCanXoa);
        
        if (index != -1) {
            danhSachMaSach.remove(index);
            danhSachTenSach.remove(index);
            danhSachSoLuong.remove(index);
            danhSachGiaTri.remove(index);
            System.out.println("-> Đã xóa thành công!");
        } else {
            System.out.println("-> Không tìm thấy mã sách để xóa!");
        }
    }

    // 5. Sửa sách
    public static void suaSach() {
        System.out.print("Nhập mã sách cần sửa: ");
        String maCanSua = scanner.nextLine();
        int index = danhSachMaSach.indexOf(maCanSua);
        
        if (index != -1) {
            System.out.println("Nhập thông tin mới (nhấn Enter để giữ nguyên mã cũ):");
            
            System.out.print("Tên sách mới: ");
            danhSachTenSach.set(index, scanner.nextLine());
            
            System.out.print("Số lượng mới: ");
            danhSachSoLuong.set(index, scanner.nextInt());
            
            System.out.print("Giá trị mới: ");
            danhSachGiaTri.set(index, scanner.nextDouble());
            scanner.nextLine(); // Xóa bộ nhớ đệm
            
            System.out.println("-> Đã sửa thông tin thành công!");
        } else {
            System.out.println("-> Không tìm thấy mã sách để sửa!");
        }
    }

    // 6. Tính tổng số lượng
    public static void tinhTongSoLuong() {
        int tong = 0;
        for (int sl : danhSachSoLuong) {
            tong += sl;
        }
        System.out.println("-> Tổng số lượng tất cả sách trong thư viện: " + tong);
    }

    // 7. Tính tổng giá trị
    public static void tinhTongGiaTri() {
        double tongGiaTri = 0;
        for (int i = 0; i < danhSachMaSach.size(); i++) {
            tongGiaTri += (danhSachSoLuong.get(i) * danhSachGiaTri.get(i));
        }
        System.out.printf("-> Tổng giá trị toàn bộ sách: %.2f\n", tongGiaTri);
    }
}