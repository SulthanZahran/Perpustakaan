# Aplikasi Manajemen Peminjaman Buku

## Deskripsi

Aplikasi ini adalah sistem manajemen perpustakaan yang memungkinkan pengguna untuk melakukan CRUD (Create, Read, Update, Delete) pada data Buku dan Peminjam, serta menyediakan fitur peminjaman dan pengembalian buku.

## Fitur Utama

1. **CRUD Buku**
    - Menambahkan, mengedit, menghapus, dan melihat daftar buku.
2. **CRUD Peminjam**
    - Menambahkan, mengedit, menghapus, dan melihat daftar peminjam.
3. **Peminjaman dan Pengembalian Buku**
    - Peminjam dapat meminjam buku dengan batas maksimal 30 hari.
    - Buku yang dipinjam dapat dikembalikan dengan mencatat transaksi pengembalian.
4. **Admin Panel untuk Melihat Transaksi**
    - Melihat transaksi peminjaman berdasarkan ID, peminjam, atau buku.
    - Melihat transaksi aktif yang belum jatuh tempo.
    - Melihat transaksi yang melewati batas waktu peminjaman dan belum dikembalikan.
    

## Dokumentasi API

API dapat diakses _locally_ melalui **Swagger UI** di endpoint lokal berikut:

```
http://localhost:8080/swagger-ui/index.html
```

## Teknologi yang Digunakan

- **Spring Boot** – Framework backend utama
- **Spring Data JPA** – ORM untuk akses database
- **PostgreSQL** – Database yang digunakan
- **Swagger UI** – Dokumentasi API

## Kontributor

- Nama: Sulthan Zahran Sunata
- Email: Sulthan.zahran0709@gmail.conm

