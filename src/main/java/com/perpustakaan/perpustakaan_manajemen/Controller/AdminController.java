package com.perpustakaan.perpustakaan_manajemen.Controller;

import com.perpustakaan.perpustakaan_manajemen.Model.Buku;
import com.perpustakaan.perpustakaan_manajemen.Model.Peminjam;
import com.perpustakaan.perpustakaan_manajemen.Model.TransaksiPeminjaman;
import com.perpustakaan.perpustakaan_manajemen.Repository.BukuRepository;
import com.perpustakaan.perpustakaan_manajemen.Repository.PeminjamRepository;
import com.perpustakaan.perpustakaan_manajemen.Service.TransaksiPeminjamanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final TransaksiPeminjamanService transaksiPeminjamanService;
    private final PeminjamRepository peminjamRepository;
    private final BukuRepository bukuRepository;

    public AdminController(TransaksiPeminjamanService transaksiPeminjamanService, PeminjamRepository peminjamRepository, BukuRepository bukuRepository) {
        this.transaksiPeminjamanService = transaksiPeminjamanService;
        this.peminjamRepository = peminjamRepository;
        this.bukuRepository = bukuRepository;
    }

    @GetMapping("/transaksi/{id}")
    public ResponseEntity<TransaksiPeminjaman> findTransaksiById(@PathVariable Long id) {
        return transaksiPeminjamanService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/transaksi/peminjam/{ktpNumber}")
    public ResponseEntity<List<TransaksiPeminjaman>> findTransaksiByPeminjam(@PathVariable String ktpNumber) {
        Peminjam peminjam = peminjamRepository.findById(ktpNumber)
                .orElseThrow(() -> new RuntimeException("Peminjam tidak ditemukan"));
        return ResponseEntity.ok(transaksiPeminjamanService.findByPeminjam(peminjam));
    }

    @GetMapping("/transaksi/buku/{isbn}")
    public ResponseEntity<List<TransaksiPeminjaman>> findTransaksiByBuku(@PathVariable String isbn) {
        Buku buku = bukuRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Buku tidak ditemukan"));
        return ResponseEntity.ok(transaksiPeminjamanService.findByBuku(buku));
    }

    @GetMapping("/transaksi/active")
    public ResponseEntity<List<TransaksiPeminjaman>> findActiveAndNotOverdueTransactions() {
        return ResponseEntity.ok(transaksiPeminjamanService.findActiveAndNotOverdueTransactions());
    }

    @GetMapping("/transaksi/active/not-returned")
    public ResponseEntity<List<TransaksiPeminjaman>> findOverdueAndNotReturnedTransactions() {
        return ResponseEntity.ok(transaksiPeminjamanService.findOverdueAndNotReturnedTransactions());
    }
}
