/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tuan56;

// LƯU Ý: Nếu ở file cũ của bạn có dòng "package ...;" ở trên cùng, hãy gõ lại dòng đó lên trên dòng import này nhé!

import java.util.Scanner;

public class tuan56 {

    // Khai báo các mảng toàn cục để lưu trữ dữ liệu (Mô phỏng hướng cấu trúc)
    static final int MAX_SACH = 100; // Số lượng sách tối đa
    static String[] danhSachMaSach = new String[MAX_SACH];
    static String[] danhSachTenSach = new String[MAX_SACH];
    static int[] danhSachSoLuong = new int[MAX_SACH];
    static double[] danhSachGiaBan = new double[MAX_SACH];
    
    // Biến đếm số lượng đầu sách hiện có trong thư viện
    static int soLuongSachHienTai = 0;
    
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int luaChon;
        
        // Bài 3: Menu lặp đến khi chọn Thoát (sử dụng vòng lặp do-while)
        do {
            hienThiMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ nhớ đệm sau khi nhập số

            switch (luaChon) {
                case 1 -> nhapDanhSachSach();
                case 2 -> tinhTongSoLuongVaGiaTri();
                case 3 -> timSachTheoMa();
                case 0 -> System.out.println("Đã thoát chương trình quản lý thư viện.");
                default -> System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (luaChon != 0);
    }

    // Hàm hiển thị Menu
    public static void hienThiMenu() {
        System.out.println("\n========== MENU QUẢN LÝ THƯ VIỆN ==========");
        System.out.println("1. Nhập n sách vào thư viện (Bài 1)");
        System.out.println("2. Tính tổng số lượng và tổng giá trị (Bài 2)");
        System.out.println("3. Tìm sách theo mã (Bài 4)");
        System.out.println("0. Thoát (Bài 3)");
        System.out.println("===========================================");
    }

    // Bài 1: Nhập n sách bằng vòng lặp
    public static void nhapDanhSachSach() {
        System.out.print("Nhập số lượng đầu sách bạn muốn thêm (n): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ nhớ đệm

        if (soLuongSachHienTai + n > MAX_SACH) {
            System.out.println("Không đủ bộ nhớ! Chỉ có thể thêm tối đa " + (MAX_SACH - soLuongSachHienTai) + " sách nữa.");
            return;
        }

        // Vòng lặp for để nhập n sách
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin cho cuốn sách thứ " + (i + 1) + ":");
            
            System.out.print("- Mã sách: ");
            danhSachMaSach[soLuongSachHienTai] = scanner.nextLine();
            
            System.out.print("- Tên sách: ");
            danhSachTenSach[soLuongSachHienTai] = scanner.nextLine();
            
            System.out.print("- Số lượng: ");
            danhSachSoLuong[soLuongSachHienTai] = scanner.nextInt();
            
            System.out.print("- Giá trị (1 cuốn): ");
            danhSachGiaBan[soLuongSachHienTai] = scanner.nextDouble();
            scanner.nextLine(); // Xóa bộ nhớ đệm

            soLuongSachHienTai++; // Tăng tổng số đầu sách lên 1
        }
        System.out.println("-> Đã nhập thành công " + n + " cuốn sách.");
    }

    // Bài 2: Tính tổng số lượng và tổng giá trị sách
    public static void tinhTongSoLuongVaGiaTri() {
        if (soLuongSachHienTai == 0) {
            System.out.println("Thư viện hiện tại chưa có sách!");
            return;
        }

        int tongSoLuong = 0;
        double tongGiaTri = 0;

        // Vòng lặp duyệt qua các mảng để tính toán
        for (int i = 0; i < soLuongSachHienTai; i++) {
            tongSoLuong += danhSachSoLuong[i];
            tongGiaTri += (danhSachSoLuong[i] * danhSachGiaBan[i]);
        }

        System.out.println("\n--- THỐNG KÊ THƯ VIỆN ---");
        System.out.println("Tổng số lượng sách: " + tongSoLuong + " cuốn");
        System.out.printf("Tổng giá trị toàn bộ sách: %,.2f VNĐ\n", tongGiaTri);
    }

    // Bài 4: Tìm sách theo mã
    public static void timSachTheoMa() {
        if (soLuongSachHienTai == 0) {
            System.out.println("Thư viện hiện tại chưa có sách!");
            return;
        }

        System.out.print("\nNhập mã sách cần tìm: ");
        String maCanTim = scanner.nextLine();
        
        boolean timThay = false;

        // Vòng lặp tìm kiếm tuyến tính
        for (int i = 0; i < soLuongSachHienTai; i++) {
            if (danhSachMaSach[i].equalsIgnoreCase(maCanTim)) {
                System.out.println("-> ĐÃ TÌM THẤY SÁCH:");
                System.out.println("Mã sách: " + danhSachMaSach[i]);
                System.out.println("Tên sách: " + danhSachTenSach[i]);
                System.out.println("Số lượng: " + danhSachSoLuong[i]);
                System.out.println("Giá bán: " + danhSachGiaBan[i]);
                timThay = true;
                break; // Thoát vòng lặp khi đã tìm thấy
            }
        }

        if (!timThay) {
            System.out.println("-> Không tìm thấy sách nào có mã: " + maCanTim);
        }
    }
}
