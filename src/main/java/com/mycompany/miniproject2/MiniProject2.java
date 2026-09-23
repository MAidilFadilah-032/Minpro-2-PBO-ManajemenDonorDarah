package com.mycompany.MiniProject2;

import java.util.Scanner;

public class MiniProject2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DonasiDarahManager manager = new DonasiDarahManager();

        boolean programBerjalan = true;

        while (programBerjalan) {
            System.out.println("=========================================");
            System.out.println("     SISTEM MANAJEMEN DONASI DARAH");
            System.out.println("=========================================");
            System.out.println("1. Kelola Data Donor");
            System.out.println("2. Kelola Data Donasi");
            System.out.println("3. Lihat Ringkasan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilihanUtama = Integer.parseInt(scanner.nextLine());

            switch (pilihanUtama) {
                case 1 -> {
                    boolean kembaliDonor = false;

                    while (!kembaliDonor) {
                        System.out.println("--- KELOLA DATA DONOR ---");
                        System.out.println("1. Tambah Donor");
                        System.out.println("2. Lihat Semua Donor");
                        System.out.println("3. Update Donor");
                        System.out.println("4. Hapus Donor");
                        System.out.println("0. Kembali ke Menu Utama");
                        System.out.print("Pilih menu: ");
                        int pilihanDonor = Integer.parseInt(scanner.nextLine());

                        switch (pilihanDonor) {
                            case 1 -> {
                                System.out.println("Pilih kategori donor:");
                                System.out.println("1. Donor Baru");
                                System.out.println("2. Donor Tetap");
                                System.out.print("Pilih kategori: ");
                                int kategoriDonor = Integer.parseInt(scanner.nextLine());

                                System.out.print("Nama Donor: ");
                                String nama = scanner.nextLine();
                                System.out.print("Golongan Darah (A/B/AB/O): ");
                                String golongan = scanner.nextLine();
                                System.out.print("Umur: ");
                                int umur = Integer.parseInt(scanner.nextLine());
                                System.out.print("No. Telepon: ");
                                String telepon = scanner.nextLine();

                                if (kategoriDonor == 2) {
                                    System.out.print("Jumlah donasi sebelumnya: ");
                                    int jumlahSebelumnya = Integer.parseInt(scanner.nextLine());
                                    manager.tambahDonorTetap(nama, golongan, umur, telepon, jumlahSebelumnya);
                                } else {
                                    manager.tambahDonorBaru(nama, golongan, umur, telepon);
                                }
                            }

                            case 2 -> manager.tampilkanSemuaDonor();

                            case 3 -> {
                                manager.tampilkanSemuaDonor();
                                System.out.print("Masukkan ID Donor yang ingin diupdate: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                System.out.print("Nama baru: ");
                                String nama = scanner.nextLine();
                                System.out.print("Golongan darah baru: ");
                                String golongan = scanner.nextLine();
                                System.out.print("Umur baru: ");
                                int umur = Integer.parseInt(scanner.nextLine());
                                System.out.print("No. telepon baru: ");
                                String telepon = scanner.nextLine();
                                manager.updateDonor(id, nama, golongan, umur, telepon);
                            }

                            case 4 -> {
                                manager.tampilkanSemuaDonor();
                                System.out.print("Masukkan ID Donor yang ingin dihapus: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                manager.hapusDonor(id);
                            }

                            case 0 -> kembaliDonor = true;

                            default -> System.out.println("Pilihan tidak tersedia.");
                        }
                    }
                }

                case 2 -> {
                    boolean kembaliDonasi = false;

                    while (!kembaliDonasi) {
                        System.out.println("");
                        System.out.println("--- KELOLA DATA DONASI ---");
                        System.out.println("1. Catat Donasi Baru");
                        System.out.println("2. Lihat Semua Donasi");
                        System.out.println("3. Update Donasi");
                        System.out.println("4. Hapus Donasi");
                        System.out.println("0. Kembali ke Menu Utama");
                        System.out.print("Pilih menu: ");
                        int pilihanDonasi = Integer.parseInt(scanner.nextLine());

                        switch (pilihanDonasi) {
                            case 1 -> {
                                manager.tampilkanSemuaDonor();
                                System.out.print("ID Donor: ");
                                int idDonor = Integer.parseInt(scanner.nextLine());
                                System.out.print("Tanggal (yyyy-MM-dd): ");
                                String tanggal = scanner.nextLine();
                                System.out.print("Jumlah Kantong: ");
                                int jumlahKantong = Integer.parseInt(scanner.nextLine());
                                manager.tambahDonasi(idDonor, tanggal, jumlahKantong);
                            }

                            case 2 -> manager.tampilkanSemuaDonasi();

                            case 3 -> {
                                manager.tampilkanSemuaDonasi();
                                System.out.print("Masukkan ID Donasi yang ingin diupdate: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                System.out.print("Tanggal baru (yyyy-MM-dd): ");
                                String tanggal = scanner.nextLine();
                                System.out.print("Jumlah kantong baru: ");
                                int jumlahKantong = Integer.parseInt(scanner.nextLine());
                                manager.updateDonasi(id, tanggal, jumlahKantong);
                            }

                            case 4 -> {
                                manager.tampilkanSemuaDonasi();
                                System.out.print("Masukkan ID Donasi yang ingin dihapus: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                manager.hapusDonasi(id);
                            }

                            case 0 -> kembaliDonasi = true;

                            default -> System.out.println("Pilihan tidak tersedia.");
                        }
                    }
                }

                case 3 -> {
                    System.out.println("");
                    System.out.println("--- RINGKASAN ---");
                    System.out.println("Total Donor terdaftar : " + manager.getJumlahDonor());
                    System.out.println("Total Donasi tercatat  : " + manager.getJumlahDonasi());
                }

                case 0 -> {
                    programBerjalan = false;
                    System.out.println("Terima kasih telah menggunakan Sistem Donasi Darah.");
                }

                default -> System.out.println("Pilihan tidak tersedia.");
            }
        }
    }
}