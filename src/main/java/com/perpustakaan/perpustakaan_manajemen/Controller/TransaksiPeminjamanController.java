package com.perpustakaan.perpustakaan_manajemen.Controller;

import com.perpustakaan.perpustakaan_manajemen.Service.TransaksiPeminjamanService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiPeminjamanController {
    private final TransaksiPeminjamanService transaksiPeminjamanService;

    public TransaksiPeminjamanController(TransaksiPeminjamanService transaksiPeminjamanService) {
        this.transaksiPeminjamanService = transaksiPeminjamanService;
    }

    @PostMapping("/pinjam")
    public String borrowBook(@RequestParam String ktp, @RequestParam String isbn, @RequestParam Integer days) {
        transaksiPeminjamanService.pinjamBuku(ktp, isbn, days);
        return "Buku berhasil dipinjam!";
    }

    @PostMapping("/return/{loanId}")
    public String returnBook(@PathVariable Long loanId) {
        transaksiPeminjamanService.returnBuku(loanId);
        return "Buku berhasil dikembalikan!";
    }
}
