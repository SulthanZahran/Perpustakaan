package com.perpustakaan.perpustakaan_manajemen.Service;

import com.perpustakaan.perpustakaan_manajemen.Model.Buku;
import com.perpustakaan.perpustakaan_manajemen.Model.Peminjam;
import com.perpustakaan.perpustakaan_manajemen.Model.TransaksiPeminjaman;
import com.perpustakaan.perpustakaan_manajemen.Repository.BukuRepository;
import com.perpustakaan.perpustakaan_manajemen.Repository.PeminjamRepository;
import com.perpustakaan.perpustakaan_manajemen.Repository.TransaksiPeminjamanRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransaksiPeminjamanServiceImpl implements TransaksiPeminjamanService{
    private final TransaksiPeminjamanRepository transaksiPeminjamanRepository;
    private final PeminjamRepository peminjamRepository;
    private final BukuRepository BukuRepository;

    public TransaksiPeminjamanServiceImpl(TransaksiPeminjamanRepository transaksiPeminjamanRepository, PeminjamRepository peminjamRepository, BukuRepository BukuRepository) {
        this.transaksiPeminjamanRepository = transaksiPeminjamanRepository;
        this.peminjamRepository = peminjamRepository;
        this.BukuRepository = BukuRepository;
    }

    @Override
    @Transactional
    public Optional<TransaksiPeminjaman> pinjamBuku(String ktpNumber, String isbn, Integer days) {
        if (days > 30) {
            throw new RuntimeException("Maksimal peminjaman adalah 30 hari!");
        }

        Peminjam peminjam = peminjamRepository.findById(ktpNumber).orElseThrow(() -> new RuntimeException("Peminjam tidak ditemukan"));

        if (transaksiPeminjamanRepository.findByPeminjamAndReturnedFalse(peminjam).isPresent()) {
            throw new RuntimeException("Peminjam sedang memiliki peminjaman aktif!");
        }

        Buku buku = BukuRepository.findByIsbn(isbn).orElseThrow(() -> new RuntimeException("Buku tidak ditemukan"));
        if (buku.getStok() < 1) {
            throw new RuntimeException("Stok buku habis!");
        }

        buku.setStok(buku.getStok() - 1);
        BukuRepository.save(buku);

        TransaksiPeminjaman TransaksiPeminjaman = new TransaksiPeminjaman(null, peminjam, buku, LocalDate.now(), LocalDate.now().plusDays(days),
                null, false);

        return Optional.of(transaksiPeminjamanRepository.save(TransaksiPeminjaman));
    }

    @Override
    @Transactional
    public void returnBuku(Long TransaksiPeminjamanId) {
        TransaksiPeminjaman transaksiPeminjaman = transaksiPeminjamanRepository.findById(TransaksiPeminjamanId).orElseThrow(() -> new RuntimeException("Peminjaman tidak ditemukan"));
        if (transaksiPeminjaman.isReturned()) {
            throw new RuntimeException("Buku sudah dikembalikan!");
        }

        Buku Buku = transaksiPeminjaman.getBuku();
        Buku.setStok(Buku.getStok() + 1);
        BukuRepository.save(Buku);

        transaksiPeminjaman.setReturned(true);
        transaksiPeminjaman.setTanggalPengembalian(LocalDate.now());
        transaksiPeminjamanRepository.save(transaksiPeminjaman);
    }

    @Override
    public Optional<TransaksiPeminjaman> findById(Long id) {
        return transaksiPeminjamanRepository.findById(id);
    }

    @Override
    public List<TransaksiPeminjaman> findByPeminjam(Peminjam peminjam) {
        return transaksiPeminjamanRepository.findByPeminjam(peminjam);
    }

    @Override
    public List<TransaksiPeminjaman> findByBuku(Buku buku) {
        return transaksiPeminjamanRepository.findByBuku(buku);
    }

    @Override
    public List<TransaksiPeminjaman> findActiveAndNotOverdueTransactions() {
        return transaksiPeminjamanRepository.findActiveAndNotOverdueTransactions();
    }

    @Override
    public List<TransaksiPeminjaman> findOverdueAndNotReturnedTransactions() {
        return transaksiPeminjamanRepository.findOverdueAndNotReturnedTransactions();
    }
}
