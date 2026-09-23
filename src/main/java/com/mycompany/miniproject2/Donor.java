package com.mycompany.MiniProject2;

public abstract class Donor {

    protected int id;
    protected String nama;
    protected String golonganDarah;
    protected int umur;
    protected String noTelepon;

    public Donor(int id, String nama, String golonganDarah, int umur, String noTelepon) {
        setId(id);
        setNama(nama);
        setGolonganDarah(golonganDarah);
        setUmur(umur);
        setNoTelepon(noTelepon);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Peringatan: ID donor harus lebih dari 0, ID tidak diubah.");
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.equals("")) {
            System.out.println("Peringatan: nama tidak boleh kosong, nama tidak diubah.");
        } else {
            this.nama = nama;
        }
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        if (golonganDarah != null && (golonganDarah.equals("A") || golonganDarah.equals("B")
                || golonganDarah.equals("AB") || golonganDarah.equals("O"))) {
            this.golonganDarah = golonganDarah;
        } else {
            System.out.println("Peringatan: golongan darah harus A, B, AB, atau O, golongan darah tidak diubah.");
        }
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        if (umur >= 17 && umur <= 65) {
            this.umur = umur;
        } else {
            System.out.println("Peringatan: umur pendonor harus 17-65 tahun, umur tidak diubah.");
        }
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        if (noTelepon == null || noTelepon.equals("")) {
            System.out.println("Peringatan: nomor telepon tidak boleh kosong, nomor telepon tidak diubah.");
        } else {
            this.noTelepon = noTelepon;
        }
    }

    public abstract String getKategori();

    public void tampilkanData() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Golongan Darah: " + golonganDarah);
        System.out.println("Umur: " + umur);
        System.out.println("No. Telepon: " + noTelepon);
        System.out.println("Kategori: " + getKategori());
    }
}