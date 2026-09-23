package com.mycompany.MiniProject2;

import java.util.ArrayList;

public class DonasiDarahManager {

    private ArrayList<Donor> daftarDonor;
    private ArrayList<RiwayatDonasi> daftarDonasi;

    private int jumlahIdDonor;
    private int jumlahIdDonasi;

    public DonasiDarahManager() {
        daftarDonor = new ArrayList<Donor>();
        daftarDonasi = new ArrayList<RiwayatDonasi>();
        jumlahIdDonor = 0;
        jumlahIdDonasi = 0;

        isiDataAwal();
    }

    // Dummy data awal, supaya fitur "Lihat Semua Donor/Donasi" langsung
    // menampilkan sesuatu tanpa harus input dari nol.
    private void isiDataAwal() {
        jumlahIdDonor = jumlahIdDonor + 1;
        Donor donorContoh1 = new DonorBaru(jumlahIdDonor, "Siti Aminah", "A", 22, "081234567890");
        daftarDonor.add(donorContoh1);

        jumlahIdDonor = jumlahIdDonor + 1;
        Donor donorContoh2 = new DonorTetap(jumlahIdDonor, "Budi Santoso", "O", 30, "081298765432", 3);
        daftarDonor.add(donorContoh2);

        jumlahIdDonasi = jumlahIdDonasi + 1;
        RiwayatDonasi donasiContoh = new RiwayatDonasi(jumlahIdDonasi, donorContoh2.getId(), "2026-01-15", 1);
        daftarDonasi.add(donasiContoh);
    }

    // =====================================================
    // ================= CRUD UNTUK DONOR ==================
    // =====================================================

    public void tambahDonorBaru(String nama, String golonganDarah, int umur, String noTelepon) {
        if (validasiDataDonor(nama, golonganDarah, umur)) {
            jumlahIdDonor = jumlahIdDonor + 1;
            Donor donorBaru = new DonorBaru(jumlahIdDonor, nama, golonganDarah, umur, noTelepon);
            daftarDonor.add(donorBaru);
            System.out.println("Data donor baru berhasil ditambahkan dengan ID " + jumlahIdDonor);
        }
    }

    public void tambahDonorTetap(String nama, String golonganDarah, int umur, String noTelepon,
            int jumlahDonasiSebelumnya) {
        if (validasiDataDonor(nama, golonganDarah, umur)) {
            jumlahIdDonor = jumlahIdDonor + 1;
            Donor donorBaru = new DonorTetap(jumlahIdDonor, nama, golonganDarah, umur, noTelepon,
                    jumlahDonasiSebelumnya);
            daftarDonor.add(donorBaru);
            System.out.println("Data donor tetap telah berhasil ditambahkan dengan ID " + jumlahIdDonor);
        }
    }

    // Validasi sebelum objek dibuat, supaya nomor ID tidak "terpakai sia-sia"
    // oleh data yang gagal ditambahkan.
    private boolean validasiDataDonor(String nama, String golonganDarah, int umur) {
        boolean valid = true;

        if (nama.equals("")) {
            System.out.println("Gagal: nama tidak boleh kosong.");
            valid = false;
        } else if (!(golonganDarah.equals("A") || golonganDarah.equals("B")
                || golonganDarah.equals("AB") || golonganDarah.equals("O"))) {
            System.out.println("Gagal: golongan darah harus A, B, AB, atau O.");
            valid = false;
        } else if (umur < 17 || umur > 65) {
            System.out.println("Gagal: umur pendonor harus antara 17 sampai 65 tahun.");
            valid = false;
        }

        return valid;
    }

    public void tampilkanSemuaDonor() {
        if (daftarDonor.size() == 0) {
            System.out.println("Belum ada data donor.");
        } else {
            for (int i = 0; i < daftarDonor.size(); i++) {
                System.out.println("-----------------------------");
                daftarDonor.get(i).tampilkanData();
            }
            System.out.println("-----------------------------");
        }
    }

    public Donor cariDonorById(int id) {
        Donor hasil = null;
        for (int i = 0; i < daftarDonor.size(); i++) {
            if (daftarDonor.get(i).getId() == id) {
                hasil = daftarDonor.get(i);
            }
        }
        return hasil;
    }

    // Update memanggil setter langsung pada objek yang sudah ada di ArrayList,
    // bukan membuat objek baru -- supaya encapsulation (setter) benar-benar dipakai.
    public void updateDonor(int id, String nama, String golonganDarah, int umur, String noTelepon) {
        Donor donor = cariDonorById(id);

        if (donor == null) {
            System.out.println("Gagal: data donor dengan ID " + id + " tidak ditemukan.");
        } else {
            donor.setNama(nama);
            donor.setGolonganDarah(golonganDarah);
            donor.setUmur(umur);
            donor.setNoTelepon(noTelepon);

            System.out.println("Proses update donor ID " + id + " selesai. Data terbaru:");
            donor.tampilkanData();
        }
    }

    public void hapusDonor(int id) {
        int indexDitemukan = -1;
        for (int i = 0; i < daftarDonor.size(); i++) {
            if (daftarDonor.get(i).getId() == id) {
                indexDitemukan = i;
            }
        }

        if (indexDitemukan == -1) {
            System.out.println("Gagal: data donor dengan ID " + id + " tidak ditemukan.");
        } else {
            daftarDonor.remove(indexDitemukan);
            System.out.println("Data donor ID " + id + " berhasil dihapus.");
        }
    }

    // =====================================================
    // ================ CRUD UNTUK DONASI ==================
    // =====================================================

    public void tambahDonasi(int idDonor, String tanggal, int jumlahKantong) {
        Donor donor = cariDonorById(idDonor);

        if (donor == null) {
            System.out.println("Gagal: donor dengan ID " + idDonor + " tidak ditemukan.");
        } else if (jumlahKantong <= 0) {
            System.out.println("Gagal: jumlah kantong darah harus lebih dari 0.");
        } else {
            jumlahIdDonasi = jumlahIdDonasi + 1;
            RiwayatDonasi donasiBaru = new RiwayatDonasi(jumlahIdDonasi, idDonor, tanggal, jumlahKantong);
            daftarDonasi.add(donasiBaru);

            // Polymorphism: kalau donornya DonorTetap, hitungan donasi
            // sebelumnya otomatis bertambah lewat setter-nya sendiri.
            if (donor instanceof DonorTetap) {
                DonorTetap donorTetap = (DonorTetap) donor;
                donorTetap.setJumlahDonasiSebelumnya(donorTetap.getJumlahDonasiSebelumnya() + 1);
            }

            System.out.println("Donasi berhasil dicatat dengan ID " + jumlahIdDonasi);
        }
    }

    public void tampilkanSemuaDonasi() {
        if (daftarDonasi.size() == 0) {
            System.out.println("Belum ada data donasi.");
        } else {
            for (int i = 0; i < daftarDonasi.size(); i++) {
                System.out.println("-----------------------------");
                daftarDonasi.get(i).tampilkanData();
            }
            System.out.println("-----------------------------");
        }
    }

    public RiwayatDonasi cariDonasiById(int id) {
        RiwayatDonasi hasil = null;
        for (int i = 0; i < daftarDonasi.size(); i++) {
            if (daftarDonasi.get(i).getIdDonasi() == id) {
                hasil = daftarDonasi.get(i);
            }
        }
        return hasil;
    }

    public void updateDonasi(int id, String tanggal, int jumlahKantong) {
        RiwayatDonasi donasi = cariDonasiById(id);

        if (donasi == null) {
            System.out.println("Gagal: data donasi dengan ID " + id + " tidak ditemukan.");
        } else {
            donasi.setTanggalDonasi(tanggal);
            donasi.setJumlahKantong(jumlahKantong);

            System.out.println("Proses update donasi ID " + id + " selesai. Data terbaru:");
            donasi.tampilkanData();
        }
    }

    public void hapusDonasi(int id) {
        int indexDitemukan = -1;
        for (int i = 0; i < daftarDonasi.size(); i++) {
            if (daftarDonasi.get(i).getIdDonasi() == id) {
                indexDitemukan = i;
            }
        }

        if (indexDitemukan == -1) {
            System.out.println("Gagal: data donasi dengan ID " + id + " tidak ditemukan.");
        } else {
            daftarDonasi.remove(indexDitemukan);
            System.out.println("Data donasi ID " + id + " berhasil dihapus.");
        }
    }

    public int getJumlahDonor() {
        return daftarDonor.size();
    }

    public int getJumlahDonasi() {
        return daftarDonasi.size();
    }
}