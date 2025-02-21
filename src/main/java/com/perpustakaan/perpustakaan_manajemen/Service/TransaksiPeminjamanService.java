package com.perpustakaan.perpustakaan_manajemen.Service;

import com.perpustakaan.perpustakaan_manajemen.Model.Buku;
import com.perpustakaan.perpustakaan_manajemen.Model.Peminjam;
import com.perpustakaan.perpustakaan_manajemen.Model.TransaksiPeminjaman;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransaksiPeminjamanService {
    Optional<TransaksiPeminjaman> pinjamBuku(String ktpNumber, String isbn, Integer days);
    void returnBuku(Long TransaksiPeminjamanId);
    Optional<TransaksiPeminjaman> findById(Long id);
    List<TransaksiPeminjaman> findByPeminjam(Peminjam peminjam);
    List<TransaksiPeminjaman> findByBuku(Buku buku);
    List<TransaksiPeminjaman> findActiveAndNotOverdueTransactions() ;
    List<TransaksiPeminjaman> findOverdueAndNotReturnedTransactions();
}
