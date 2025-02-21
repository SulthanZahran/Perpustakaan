package com.perpustakaan.perpustakaan_manajemen.Service;

import com.perpustakaan.perpustakaan_manajemen.Model.Buku;

import java.util.List;
import java.util.Optional;

public interface BukuService {
    List<Buku> getAllBuku();
    Optional<Buku> getBukuByIsbn(String isbn);
    Buku saveBuku(Buku buku);
    Buku updateBuku(String isbn, Buku buku);
    void deleteBuku(String isbn);
}
