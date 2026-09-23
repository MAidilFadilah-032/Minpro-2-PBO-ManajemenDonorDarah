package com.mycompany.MiniProject2;

/**
 * Class RiwayatDonasi
 * Merepresentasikan satu kegiatan donasi darah yang dilakukan oleh Donor.
 */
public class RiwayatDonasi {

    private int idDonasi;
    private int idDonor;
    private String tanggalDonasi;
    private int jumlahKantong;

    public RiwayatDonasi(int idDonasi, int idDonor, String tanggalDonasi, int jumlahKantong) {
        // Constructor memanggil setter supaya validasi tetap berlaku
        // saat objek pertama kali dibuat.
        setIdDonasi(idDonasi);
        setIdDonor(idDonor);
        setTanggalDonasi(tanggalDonasi);
        setJumlahKantong(jumlahKantong);
    }

    public int getIdDonasi() {
        return idDonasi;
    }

    public void setIdDonasi(int idDonasi) {
        if (idDonasi > 0) {
            this.idDonasi = idDonasi;
        } else {
            System.out.println("Peringatan: ID donasi harus lebih dari 0, ID tidak diubah.");
        }
    }

    public int getIdDonor() {
        return idDonor;
    }

    public void setIdDonor(int idDonor) {
        if (idDonor > 0) {
            this.idDonor = idDonor;
        } else {
            System.out.println("Peringatan: ID donor harus lebih dari 0, ID donor tidak diubah.");
        }
    }

    public String getTanggalDonasi() {
        return tanggalDonasi;
    }

    public void setTanggalDonasi(String tanggalDonasi) {
        if (tanggalDonasi == null || tanggalDonasi.equals("")) {
            System.out.println("Peringatan: tanggal donasi tidak boleh kosong, tanggal tidak diubah.");
        } else {
            this.tanggalDonasi = tanggalDonasi;
        }
    }

    public int getJumlahKantong() {
        return jumlahKantong;
    }

    public void setJumlahKantong(int jumlahKantong) {
        if (jumlahKantong > 0) {
            this.jumlahKantong = jumlahKantong;
        } else {
            System.out.println("Peringatan: jumlah kantong darah harus lebih dari 0, jumlah tidak diubah.");
        }
    }

    public void tampilkanData() {
        System.out.println("ID Donasi      : " + idDonasi);
        System.out.println("ID Donor       : " + idDonor);
        System.out.println("Tanggal Donasi : " + tanggalDonasi);
        System.out.println("Jumlah Kantong : " + jumlahKantong);
    }
}