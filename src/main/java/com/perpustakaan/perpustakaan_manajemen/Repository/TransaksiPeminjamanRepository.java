package com.perpustakaan.perpustakaan_manajemen.Repository;

import com.perpustakaan.perpustakaan_manajemen.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransaksiPeminjamanRepository extends JpaRepository<TransaksiPeminjaman, Long> {
    Optional<TransaksiPeminjaman> findByPeminjamAndReturnedFalse(Peminjam peminjam);

    List<TransaksiPeminjaman> findByPeminjam(Peminjam peminjam);

    List<TransaksiPeminjaman> findByBuku(Buku buku);

    List<TransaksiPeminjaman> findByReturned(boolean returned);

    @Query("SELECT t FROM TransaksiPeminjaman t WHERE CURRENT_DATE < t.tanggalDeadline AND t.returned = false")
    List<TransaksiPeminjaman> findActiveAndNotOverdueTransactions();

    @Query("SELECT t FROM TransaksiPeminjaman t WHERE t.tanggalDeadline < CURRENT_DATE AND t.returned = false")
    List<TransaksiPeminjaman> findOverdueAndNotReturnedTransactions();
}
