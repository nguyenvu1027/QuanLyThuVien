/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.btt2;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BTT2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ và tên của bạn: ");
        String hoTen = scanner.nextLine();
        System.out.println("Họ và tên của bạn là: " + hoTen);
    }
}
