package juaracoding;

import java.util.Scanner;

public class AplikasiFilmBioskop {

    // scanner buat input
    static Scanner scanner = new Scanner(System.in);
    // array buat nyimpen judul film
    static String[] judulFilm = new String[10];
    // buat nyimpen berapa banyak film yg udah ditambah
    static int jumlahFilm = 0;

    public static void main(String[] args) {
        // cek login dulu
        if (login()) {
            int pilihan;
            do {
                tampilkanMenu();
                System.out.print("Pilih: ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); // biar nggak error pas nextLine
                switch (pilihan) {
                    case 1:
                        tampilkanFilm(); // liat daftar film yg udah masuk
                        break;
                    case 2:
                        inputFilm(); // input film baru
                        break;
                    case 3:
                        cariFilm(); // cari film berdasarkan judul
                        break;
                    case 4:
                        System.out.println("Keluar dari program. Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } while (pilihan != 4);
        }
    }

    // login sederhana, user: admin, pass: 12345
    static boolean login() {
        while (true) {
            System.out.println("=== Login ===");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            if (username.equals("admin") && password.equals("12345")) {
                System.out.println("Login berhasil!\n");
                return true;
            } else {
                System.out.println("Username atau password salah. Coba lagi.\n");
            }
        }
    }

    // menu utama yang muncul setelah login
    static void tampilkanMenu() {
        System.out.println("=== Menu Utama ===");
        System.out.println("1. Tampilkan Daftar Film");
        System.out.println("2. Input Data Film");
        System.out.println("3. Cari Film");
        System.out.println("4. Keluar");
    }

    // input beberapa film baru, maksimal 10 total
    static void inputFilm() {
        if (jumlahFilm >= 10) {
            System.out.println("Data film sudah penuh (maksimal 10).\n");
            return;
        }
        System.out.print("Masukkan jumlah film yang ingin ditambah: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // bersihin newline
        for (int i = 0; i < jumlah && jumlahFilm < 10; i++) {
            System.out.print("Judul film ke-" + (jumlahFilm + 1) + ": ");
            judulFilm[jumlahFilm] = scanner.nextLine();
            jumlahFilm++;
        }
        System.out.println("Film berhasil ditambahkan.\n");
    }

    // print semua film yang udah disimpan
    static void tampilkanFilm() {
        if (jumlahFilm == 0) {
            System.out.println("Belum ada data film.\n");
            return;
        }
        System.out.println("=== Daftar Film ===");
        for (int i = 0; i < jumlahFilm; i++) {
            System.out.println((i + 1) + ". " + judulFilm[i]);
        }
        System.out.println();
    }

    // cari film berdasarkan input judul
    static void cariFilm() {
        if (jumlahFilm == 0) {
            System.out.println("Belum ada data film.\n");
            return;
        }
        System.out.print("Masukkan judul film yang dicari: ");
        String cari = scanner.nextLine();
        boolean ditemukan = false;
        for (int i = 0; i < jumlahFilm; i++) {
            if (judulFilm[i].equalsIgnoreCase(cari)) {
                System.out.println("Film ditemukan: " + judulFilm[i] + "\n");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Film tidak ditemukan.\n");
        }
    }
}
