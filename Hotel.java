package HotelReservation;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class Hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("Fathir", "fathir.ilham2405@gmail.com", "fathir123");
        Customer customer1 = new Customer("Azahrah", "azah22@gmail.com", "azah2210");
        Customer customer2 = new Customer("Wiejaya", "wiejaya01@gmail.com", "jaya0104");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Sistem Reservasi Hotel ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Customer");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    admin.login(scanner);
                    boolean adminExit = false;
                    while (!adminExit) {
                        System.out.println("\n=== Menu Admin ===");
                        System.out.println("1. Lihat Kamar yang Tersedia");
                        System.out.println("2. Tambah Kamar");
                        System.out.println("3. Hapus Kamar");
                        System.out.println("4. Lihat Laporan Semua Pesanan");
                        System.out.println("5. Logout");
                        System.out.print("Pilih opsi: ");
                        int adminChoice = scanner.nextInt();

                        switch (adminChoice) {
                            case 1:
                                admin.manageRooms();
                                break;
                            case 2:
                                System.out.print("Masukkan tipe kamar yang ingin ditambahkan: ");
                                String roomType = scanner.next();
                                admin.addRoom(roomType);
                                break;
                            case 3:
                                System.out.print("Masukkan tipe kamar yang ingin dihapus: ");
                                String roomToDelete = scanner.next();
                                admin.removeRoom(roomToDelete);
                                break;
                            case 4:
                                admin.viewAllBookings(customers); // Menggunakan List
                                break;
                            case 5:
                                adminExit = true;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                                break;
                        }
                    }
                    break;

                case 2:
                    System.out.print("Masukkan nama pengguna (1 untuk Azahrah, 2 untuk Wiejaya): ");
                    int customerNumber = scanner.nextInt();
                    Customer selectedCustomer = (customerNumber == 1) ? customer1 : customer2;
                    selectedCustomer.login(scanner);
                    boolean customerExit = false;
                    while (!customerExit) {
                        System.out.println("\n=== Menu Customer ===");
                        System.out.println("1. Cek Ketersediaan Kamar");
                        System.out.println("2. Pesan Kamar");
                        System.out.println("3. Lihat Detail Pesanan");
                        System.out.println("4. Batalkan Pesanan");
                        System.out.println("5. Lihat Riwayat Pesanan");
                        System.out.println("6. Lakukan Pembayaran");
                        System.out.println("7. Terapkan Diskon");
                        System.out.println("8. Logout");
                        System.out.print("Pilih opsi: ");
                        int customerChoice = scanner.nextInt();

                        switch (customerChoice) {
                            case 1:
                                selectedCustomer.checkAvailability();
                                break;
                            case 2:
                                selectedCustomer.bookRoom();
                                break;
                            case 3:
                                selectedCustomer.viewBookingDetails();
                                break;
                            case 4:
                                selectedCustomer.cancelBooking();
                                break;
                            case 5:
                                selectedCustomer.viewBookingHistory();
                                break;
                            case 6:
                                selectedCustomer.makePayment();
                                break;
                            case 7:
                                selectedCustomer.applyDiscount();
                                break;
                            case 8:
                                customerExit = true;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                                break;
                        }
                    }
                    break;

                case 3:
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan aplikasi reservasi hotel.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
        scanner.close();
    }
}