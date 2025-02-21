package com.perpustakaan.perpustakaan_manajemen.Model;

import jakarta.persistence.*;

@Entity
public class Buku{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String judul;

    @Column(unique = true)
    private String isbn;

    private int stok;

    public Buku(Long id, String judul, String isbn, int stok) {
        this.id = id;
        this.judul = judul;
        this.isbn = isbn;
        this.stok = stok;
    }

    public Buku() {
    }

    public Long getId() {
        return this.id;
    }

    public String getJudul() {
        return this.judul;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public int getStok() {
        return this.stok;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
