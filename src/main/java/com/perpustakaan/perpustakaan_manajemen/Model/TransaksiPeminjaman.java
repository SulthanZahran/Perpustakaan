package com.perpustakaan.perpustakaan_manajemen.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TransaksiPeminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Peminjam peminjam;

    @ManyToOne
    private Buku buku;

    private LocalDate tanggalPinjam;
    private LocalDate tanggalDeadline;
    private LocalDate tanggalPengembalian;
    private boolean returned;

    public TransaksiPeminjaman(Long id, Peminjam peminjam, Buku buku, LocalDate tanggalPinjam, LocalDate tanggalDeadline, LocalDate tanggalPengembalian, boolean returned) {
        this.id = id;
        this.peminjam = peminjam;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalDeadline = tanggalDeadline;
        this.tanggalPengembalian = tanggalPengembalian;
        this.returned = returned;
    }

    public TransaksiPeminjaman() {
    }

    public Long getId() {
        return this.id;
    }

    public Peminjam getPeminjam() {
        return this.peminjam;
    }

    public Buku getBuku() {
        return this.buku;
    }

    public LocalDate getTanggalPinjam() {
        return this.tanggalPinjam;
    }

    public LocalDate getTanggalDeadline() {
        return this.tanggalDeadline;
    }

    public LocalDate getTanggalPengembalian() {
        return this.tanggalPengembalian;
    }

    public boolean isReturned() {
        return this.returned;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPeminjam(Peminjam peminjam) {
        this.peminjam = peminjam;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public void setTanggalPinjam(LocalDate tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public void setTanggalDeadline(LocalDate tanggalDeadline) {
        this.tanggalDeadline = tanggalDeadline;
    }

    public void setTanggalPengembalian(LocalDate tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
