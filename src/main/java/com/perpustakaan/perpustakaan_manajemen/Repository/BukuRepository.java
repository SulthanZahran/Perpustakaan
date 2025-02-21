package com.perpustakaan.perpustakaan_manajemen.Repository;

import com.perpustakaan.perpustakaan_manajemen.Model.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
    Optional<Buku> findByIsbn(String isbn);

    @Transactional
    void deleteByIsbn(String isbn);
}