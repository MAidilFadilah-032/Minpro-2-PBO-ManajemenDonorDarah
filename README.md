# MINPRO 2 PBO<br>
Nama: Muhammad Aidil Fadilah<br>
Nim: 2509116032<br>
Kelas: Sistem Informasi A 2025<br>

**Deskripsi Singkat Program**<br>
Sistem Manajemen Donasi Darah adalah program CRUD (Create, Read, Update, Delete) berbasis Java yang berjalan lewat command line. Program ini digunakan untuk mengelola dua jenis data: data pendonor darah dan data riwayat kegiatan donor menyumbangkan darah. Program dibangun dengan menerapkan konsep utama Pemrograman Berorientasi Objek, yaitu Class, Object, Constructor, Access Modifier, Encapsulation getter dan setter, serta Inheritance/pewarisan antara superclass Donor dengan dua subclassnya, DonorBaru dan DonorTetap.<br>
<br><br>
**Penjelasan Alur Program**<br>
- Program dimulai dari class Main, yang menampilkan Menu Utama di dalam perulangan while sehingga program terus berjalan sampai user memilih menu 0 (Keluar).

- Saat program pertama kali dijalankan, DonasiDarahManager otomatis mengisi 2 data donor dan 1 data riwayat donasi sebagai dummy data awal, supaya fitur Lihat Data langsung menampilkan isi tanpa harus input dari nol.

- Dari Menu Utama, user masuk ke salah satu dari 3 submenu (Kelola Data Donor, Kelola Data Donasi, atau Lihat Ringkasan) melalui struktur percabangan switch.

- Di submenu Kelola Data Donor, user bisa Tambah Donor (memilih kategori Donor Baru atau Donor Tetap terlebih dahulu), Lihat Semua Donor, Update Donor, atau Hapus Donor.

- Di submenu Kelola Data Donasi, user bisa Catat Donasi Baru (dikaitkan ke salah satu ID donor yang sudah ada), Lihat Semua Donasi, Update Donasi, atau Hapus Donasi.

- Setiap kali donasi baru dicatat untuk seorang Donor Tetap, jumlah donasi sebelumnya pada donor tersebut otomatis bertambah satu -- ini adalah bentuk nyata dari inheritance dan polymorphism yang bekerja di dalam program.

- Seluruh data disimpan sementara di dalam ArrayList selama program berjalan; data akan hilang setiap program ditutup karena belum terhubung ke database.

- Program berhenti saat user memilih menu 0 di Menu Utama, ditandai dengan pesan penutup di layar.
<br><br>

**Penjelasan Penerapan Encapsulation dan Inheritance**<br>
Encapsulation:<br>
- Semua atribut pada class Donor, DonorTetap, dan RiwayatDonasi bersifat private atau protected, sehingga tidak bisa diubah langsung dari luar class.

- Setiap atribut memiliki getter (untuk membaca nilai) dan setter (untuk mengubah nilai) yang bersifat public.

- Setiap setter melakukan validasi sebelum benar-benar mengubah nilai atributnya, misalnya golongan darah harus A/B/AB/O, umur harus 17-65 tahun, dan jumlah kantong darah harus lebih dari 0. Jika data yang dimasukkan tidak valid, setter menolak perubahan dan menampilkan pesan peringatan, sementara nilai lama tetap dipertahankan.

- Constructor pada setiap class memanggil setter miliknya sendiri, bukan langsung this.atribut = nilai, sehingga validasi tetap berlaku bahkan saat objek pertama kali dibuat.

- Fitur Update Donor dan Update Donasi memanggil setter langsung pada objek yang sudah tersimpan di ArrayList, sehingga encapsulation benar-benar dipakai dalam alur program.
<br>
Inheritance:<br>

- Class Donor berperan sebagai superclass (induk) yang bersifat abstract, karena Donor secara umum tidak pernah dibuat objeknya secara langsung.

- Donor menyimpan atribut dan method yang dimiliki bersama oleh semua jenis donor, yaitu id, nama, golonganDarah, umur, noTelepon, beserta getter/setter dan method tampilkanData().

- Ada 2 subclass yang mewarisi class Donor yaitu: DonorBaru untuk donor yang baru pertama kali terdaftar, dan DonorTetap untuk donor yang sudah pernah donor sebelumnya, dengan tambahan atribut khusus jumlahDonasiSebelumnya yang tidak dimiliki DonorBaru.

- Kedua subclass memanggil constructor superclass-nya lewat super(...) untuk mengisi atribut yang sama-sama dimiliki, lalu DonorTetap menambahkan pengisian atribut khususnya sendiri.

- ArrayList&lt;Donor&gt; pada DonasiDarahManager bisa menyimpan objek DonorBaru maupun DonorTetap sekaligus dalam satu wadah yang sama, karena keduanya sama-sama adalah Donor.
<br><br>

**Penjelasan Letak Penerapan Override di DonorBaru dan DonorTetap**<br>
- Superclass Donor mendeklarasikan satu method abstract, yaitu public abstract String getKategori(). Method ini sengaja tidak diberi isi di Donor, karena setiap subclass wajib mengisi perilakunya masing-masing.

- Di class DonorBaru, method getKategori() di-override dengan anotasi @Override, dan selalu mengembalikan teks "Donor Baru".

- Di class DonorTetap, method getKategori() juga di-override dengan anotasi @Override, tetapi mengembalikan teks dinamis "Donor Tetap (Nx donasi sebelumnya)", dengan N diambil dari nilai atribut jumlahDonasiSebelumnya milik objek tersebut.

- Method tampilkanData() pada superclass Donor memanggil getKategori() untuk mencetak baris Kategori. Karena getKategori() bersifat polymorphic, baris Kategori yang tampil otomatis berbeda tergantung objeknya DonorBaru atau DonorTetap, tanpa perlu menulis method tampilkanData() terpisah untuk masing-masing subclass.

- Hasil override ini terlihat langsung pada setiap gambar output di dokumen ini, lewat baris "Kategori: Donor Baru" atau "Kategori: Donor Tetap (Nx donasi sebelumnya)".
<br><br>
**Tampilan Awal**<br>
<img width="479" height="220" alt="image" src="https://github.com/user-attachments/assets/470a04ee-5857-47cd-a019-c03ccb5a8247" />
<br>
Tampilan menu utama saat program pertama kali dijalankan, berisi 3 menu utama (Kelola Data Donor, Kelola Data Donasi, Lihat Ringkasan) dan opsi Keluar.<br>
<br>
1. Kelola Data Donor<br>
<img width="300" height="215" alt="image" src="https://github.com/user-attachments/assets/f0ec7991-811d-4e35-a520-8f4281a62a64" />
<br>
Submenu Kelola Data Donor dengan 4 pilihan CRUD (Tambah, Lihat, Update, Hapus Donor) beserta opsi kembali ke Menu Utama.
<br><br>
<img width="251" height="133" alt="image" src="https://github.com/user-attachments/assets/00b77c15-8d13-45e9-8b0c-5737db1511e7" />
<br>
Sebelum mengisi data donor baru, program lebih dulu menanyakan kategori donor: Donor Baru atau Donor Tetap. Pilihan ini menentukan objek subclass mana, DonorBaru atau DonorTetap yang akan dibuat.
<br><br>
<img width="554" height="160" alt="image" src="https://github.com/user-attachments/assets/1c51813a-3cf1-42d7-996e-58f95b589306" />
<br>
Contoh penambahan Donor Baru bernama Aidil. Karena kategori yang dipilih adalah 1 (Donor Baru), program membuat objek DonorBaru dan memberinya ID 3.
<br><br>
<img width="634" height="185" alt="image" src="https://github.com/user-attachments/assets/53e102ca-23c7-46b8-b7b4-01603198f9f9" />
<br>
Contoh penambahan Donor Tetap bernama Fadlan, dengan input tambahan Jumlah donasi sebelumnya 3 yang hanya diminta untuk kategori Donor Tetap. Objek yang dibuat adalah DonorTetap dengan ID 4.
<br><br>
<img width="513" height="934" alt="image" src="https://github.com/user-attachments/assets/d556e384-17f1-4435-9fba-48ec119b74d4" />
<br>
Menampilkan seluruh data donor yang tersimpan 4 data: 2 dummy data awal + 2 data yang baru ditambahkan. Pada baris Kategori pada setiap donor, ini adalah hasil pemanggilan method getKategori() yang di override berbeda oleh DonorBaru dan DonorTetap.
<br><br>
<img width="375" height="721" alt="image" src="https://github.com/user-attachments/assets/4818dc74-b74e-4e60-bc83-d6097c0a626e" />
<br>
Proses update data donor dengan ID 3 yaitu Aidil. Umur dan nomor telepon diperbarui melalui pemanggilan setter langsung pada objek yang sudah ada, sehingga validasi di setter tetap berlaku.
<br><br>
<img width="454" height="794" alt="image" src="https://github.com/user-attachments/assets/03565f8e-780c-401b-a3a2-50b411f414c1" />
<br>
Proses menghapus data donor dengan ID 4 yaitu Fadlan dari ArrayList.
<br><br>
<img width="454" height="553" alt="image" src="https://github.com/user-attachments/assets/6ad4237d-5220-4aa1-9af5-856f0c77af39" />
<br>
Menampilkan ulang data donor untuk memastikan donor ID 4 yaitu Fadlan sudah benar-benar terhapus dan ID 3 yaitu Aidil datanya telah di perbarui.
<br><br>
<img width="434" height="219" alt="image" src="https://github.com/user-attachments/assets/fb5c850e-b60b-4e66-9f6e-f8e67c83e4c8" />
<br>
Kembali ke Menu Utama setelah selesai mengelola data donor.
<br><br>
2. Kelola Data Donasi<br>
<img width="420" height="391" alt="image" src="https://github.com/user-attachments/assets/a78bb759-36ad-4b2c-bdc0-c2ec8effb31c" />
<br>
Submenu Kelola Data Donasi dengan 4 pilihan CRUD (Catat, Lihat, Update, Hapus Donasi) beserta opsi kembali ke Menu Utama.
<br><br>
<img width="465" height="678" alt="image" src="https://github.com/user-attachments/assets/9d3bbebd-0048-4678-ad25-811c88855905" />
<br>
Sebelum mencatat donasi baru, program menampilkan daftar donor yang tersedia. Donasi baru dicatat untuk donor ID 3 (Aidil, kategori Donor Baru), menghasilkan data Riwayat Donasi baru dengan ID 2.
<br><br>
<img width="351" height="290" alt="image" src="https://github.com/user-attachments/assets/c75a57b7-6925-4b5f-bcf9-97df990a33fc" />
<br>
Menampilkan seluruh riwayat donasi yang tersimpan, data dummy ID 1 milik donor ID 2, dan data baru ID 2 milik donor ID 3.
<br><br>
<img width="494" height="500" alt="image" src="https://github.com/user-attachments/assets/7c724d38-a875-4adf-b104-45dbe4322766" />
<br>
Proses update data donasi dengan ID 2, mengubah tanggal donasi menjadi 2026-November-22 melalui pemanggilan setter pada objek yang sudah ada.
<br><br>
<img width="415" height="348" alt="image" src="https://github.com/user-attachments/assets/1c4dd85b-7c4a-4f61-bfdf-be5f96b21442" />
<br>
Proses menghapus data donasi dengan ID 2 dari ArrayList.
<br><br>
<img width="316" height="178" alt="image" src="https://github.com/user-attachments/assets/6f4850bb-3e8f-4714-8aef-490aa3f6af65" />
<br>
Menampilkan ulang data donasi untuk memastikan donasi ID 2 sudah terhapus. Tersisa 1 data donasi, yaitu data dummy awal.
<br><br>
<img width="419" height="221" alt="image" src="https://github.com/user-attachments/assets/976bd3be-cee5-46ad-a7a0-c71b4366ef9b" />
<br>
Kembali ke Menu Utama setelah selesai mengelola data donasi.
<br><br>
3. Lihat Ringkasan & Keluar<br>
<img width="435" height="295" alt="image" src="https://github.com/user-attachments/assets/1fe45467-dd55-4401-9abc-fea5d9585b48" />
<br>
Menampilkan ringkasan jumlah total donor terdaftar (3) dan total donasi tercatat (1), sesuai kondisi data setelah seluruh operasi CRUD sebelumnya.
<br><br>
<img width="735" height="194" alt="image" src="https://github.com/user-attachments/assets/c7ac9d76-e1c1-41b4-bd17-a55d10f86f6c" />
<br>
Program keluar setelah user memilih menu 0, ditandai pesan penutup "Terima kasih telah menggunakan Sistem Donasi Darah." Baris BUILD SUCCESS di bawahnya adalah output dari IDE/Maven yang menandakan program berhasil dijalankan sampai selesai.
