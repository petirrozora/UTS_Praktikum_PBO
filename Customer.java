package HotelReservation;

import java.util.Scanner;
import java.util.ArrayList;

class Customer extends User implements Reservation {
    private String roomType;
    private boolean roomBooked;
    private ArrayList<String> bookingHistory = new ArrayList<>();
    private double totalAmount;
    private boolean paymentStatus;
    private double discount;

    public Customer(String name, String email, String password) {
        super(name, email, password);
        this.roomBooked = false;
        this.paymentStatus = false;
        this.discount = 0.0;
    }

    @Override
    public void bookRoom() {
        if (!roomBooked) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Pilih jenis kamar:");
            System.out.println("1. Deluxe (Rp 200000)");
            System.out.println("2. Standard (Rp 150000)");
            System.out.println("3. Suite (Rp 300000)");
            System.out.print("Masukkan pilihan (1-3): ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    roomType = "Deluxe";
                    totalAmount = 200000;
                    break;
                case 2:
                    roomType = "Standard";
                    totalAmount = 150000;
                    break;
                case 3:
                    roomType = "Suite";
                    totalAmount = 300000;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Pemesanan dibatalkan.");
                    return; // Keluar dari metode jika pilihan tidak valid
            }

            roomBooked = true;
            bookingHistory.add("Kamar " + roomType + " dipesan.");
            System.out.println("Kamar " + roomType + " berhasil dipesan dengan harga Rp " + totalAmount);
        } else {
            System.out.println("Anda sudah memiliki kamar yang dipesan.");
        }
    }
    
    

    @Override
    public void checkAvailability() {
        System.out.println("Kamar tersedia: Deluxe - Rp 200000, Standard - Rp 150000, Suite - Rp 300000.");
    }

    @Override
    public void viewBookingDetails() {
        if (roomBooked) {
            System.out.println("Detail Pesanan: Kamar " + roomType + " dipesan atas nama " + name);
            System.out.println("Total yang harus dibayar: Rp " + totalAmount);
            System.out.println("Status Pembayaran: " + (paymentStatus ? "Sudah dibayar" : "Belum dibayar"));
        } else {
            System.out.println("Anda belum memesan kamar.");
        }
    }
    

    @Override
    public void login(Scanner scanner) {
        System.out.print("Masukkan email: ");
        String inputEmail = scanner.next();
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.next();

        if (inputEmail.equals(this.email) && inputPassword.equals(this.password)) {
            System.out.println("Customer " + name + " berhasil login.");
        } else {
            System.out.println("Login gagal. Email atau password salah.");
        }
    }

    @Override
    public void makePayment() {
        if (!paymentStatus) {
            System.out.println("Melakukan pembayaran sebesar Rp " + totalAmount);
            paymentStatus = true;
            bookingHistory.add("Pembayaran sebesar Rp " + totalAmount + " telah dilakukan.");
            System.out.println("Pembayaran berhasil.");
        } else {
            System.out.println("Anda sudah melakukan pembayaran.");
        }
    }


    @Override
    public void applyDiscount() {
        if (roomBooked && !paymentStatus) {
            discount = 10000; // Diskon dalam Rupiah
            totalAmount -= discount;
            bookingHistory.add("Diskon sebesar Rp " + discount + " diterapkan.");
            System.out.println("Diskon berhasil diterapkan. Total yang harus dibayar sekarang: Rp " + totalAmount);
        } else {
            System.out.println("Tidak bisa menerapkan diskon saat ini.");
        }
    }


    public void cancelBooking() {
        if (roomBooked) {
            System.out.println("Pesanan kamar " + roomType + " telah dibatalkan.");
            bookingHistory.add("Pesanan kamar " + roomType + " dibatalkan.");
            roomBooked = false;
            paymentStatus = false;
        } else {
            System.out.println("Anda belum memiliki pesanan untuk dibatalkan.");
        }
    }

    public void viewBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println("Belum ada riwayat pemesanan.");
        } else {
            System.out.println("Riwayat Pemesanan:");
            for (String history : bookingHistory) {
                System.out.println(history);
            }
        }
    }
}