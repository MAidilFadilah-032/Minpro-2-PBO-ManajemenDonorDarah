package com.mycompany.MiniProject2;

public class DonorBaru extends Donor {

    public DonorBaru(int id, String nama, String golonganDarah, int umur, String noTelepon) {
        super(id, nama, golonganDarah, umur, noTelepon);
    }

    @Override
    public String getKategori() {
        return "Donor Baru";
    }
}