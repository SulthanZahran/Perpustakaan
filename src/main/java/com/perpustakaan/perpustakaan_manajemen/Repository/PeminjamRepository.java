package com.perpustakaan.perpustakaan_manajemen.Repository;

import com.perpustakaan.perpustakaan_manajemen.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeminjamRepository extends JpaRepository<Peminjam, String> {
    Optional<Peminjam> findByNoKtp(String noKtp);
}