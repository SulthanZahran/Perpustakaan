package com.perpustakaan.perpustakaan_manajemen.Service;

import com.perpustakaan.perpustakaan_manajemen.Model.Buku;
import com.perpustakaan.perpustakaan_manajemen.Repository.BukuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BukuServiceImpl implements BukuService{
    private final BukuRepository bukuRepository;

    public BukuServiceImpl(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    @Override
    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }

    @Override
    public Optional<Buku> getBukuByIsbn(String isbn) {
        return bukuRepository.findByIsbn(isbn);
    }

    @Override
    public Buku saveBuku(Buku buku) {
        return bukuRepository.save(buku);
    }

    @Override
    public Buku updateBuku(String isbn, Buku buku) {
        return bukuRepository.findByIsbn(isbn).map(existingBuku -> {
            existingBuku.setJudul(buku.getJudul());
            existingBuku.setStok(buku.getStok());
            return bukuRepository.save(existingBuku);
        }).orElseThrow(() -> new RuntimeException("Buku tidak ditemukan"));
    }

    @Override
    public void deleteBuku(String isbn) {
        bukuRepository.deleteByIsbn(isbn);
    }
}
