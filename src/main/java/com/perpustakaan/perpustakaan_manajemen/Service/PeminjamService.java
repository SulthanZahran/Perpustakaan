package com.perpustakaan.perpustakaan_manajemen.Service;

import com.perpustakaan.perpustakaan_manajemen.Model.Peminjam;

import java.util.List;
import java.util.Optional;

public interface PeminjamService {
    List<Peminjam> getAllPeminjam();
    Optional<Peminjam> getPeminjamByNoKtp(String noKtp);
    Peminjam savePeminjam(Peminjam peminjam);
    Peminjam updatePeminjam(String noKtp, Peminjam peminjam);
    void deletePeminjam(String noKtp);
}
