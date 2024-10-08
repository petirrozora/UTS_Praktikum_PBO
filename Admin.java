package HotelReservation;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


class Admin extends User {
    private ArrayList<String> availableRooms = new ArrayList<>();
    private ArrayList<String> bookingReport = new ArrayList<>();

    public Admin(String name, String email, String password) {
        super(name, email, password);
        availableRooms.add("Deluxe");
        availableRooms.add("Standard");
        availableRooms.add("Suite");
    }

    @Override
    public void login(Scanner scanner) {
        System.out.print("Masukkan email: ");
        String inputEmail = scanner.next();
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.next();

        if (inputEmail.equals(this.email) && inputPassword.equals(this.password)) {
            System.out.println("Admin " + name + " berhasil login.");
        } else {
            System.out.println("Login gagal. Email atau password salah.");
        }
    }

    public void manageRooms() {
        System.out.println("Kamar yang tersedia: ");
        for (String room : availableRooms) {
            System.out.println(room);
        }
    }

    public void addRoom(String roomType) {
        availableRooms.add(roomType);
        System.out.println("Kamar " + roomType + " berhasil ditambahkan.");
    }

    public void removeRoom(String roomType) {
        if (availableRooms.contains(roomType)) {
            availableRooms.remove(roomType);
            System.out.println("Kamar " + roomType + " berhasil dihapus.");
        } else {
            System.out.println("Kamar " + roomType + " tidak ditemukan.");
        }
    }

    // Metode untuk melihat semua pemesanan dari semua customer
    public void viewAllBookings(List<Customer> customers) {
        System.out.println("Laporan Semua Pesanan:");
        for (Customer customer : customers) {
            customer.viewBookingHistory();
        }
    }
}

