package com.mycompany.MiniProject2;

public class DonorTetap extends Donor {

    private int jumlahDonasiSebelumnya;

    public DonorTetap(int id, String nama, String golonganDarah, int umur, String noTelepon,
            int jumlahDonasiSebelumnya) {
        super(id, nama, golonganDarah, umur, noTelepon);
        setJumlahDonasiSebelumnya(jumlahDonasiSebelumnya);
    }

    public int getJumlahDonasiSebelumnya() {
        return jumlahDonasiSebelumnya;
    }

    public void setJumlahDonasiSebelumnya(int jumlahDonasiSebelumnya) {
        if (jumlahDonasiSebelumnya >= 1) {
            this.jumlahDonasiSebelumnya = jumlahDonasiSebelumnya;
        } else {
            System.out.println("Peringatan: jumlah donasi sebelumnya tidak boleh kosong ataupun negatif, nilai tidak valid.");
        }
    }

    @Override
    public String getKategori() {
        return "Donor Tetap (" + jumlahDonasiSebelumnya + "x donasi sebelumnya)";
    }
}