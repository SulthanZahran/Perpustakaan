package com.perpustakaan.perpustakaan_manajemen.Service;

import com.perpustakaan.perpustakaan_manajemen.Model.Peminjam;
import com.perpustakaan.perpustakaan_manajemen.Repository.PeminjamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PeminjamServiceImpl implements PeminjamService{
    private final PeminjamRepository peminjamRepository;

    public PeminjamServiceImpl(PeminjamRepository peminjamRepository) {
        this.peminjamRepository = peminjamRepository;
    }

    @Override
    public List<Peminjam> getAllPeminjam() {
        return peminjamRepository.findAll();
    }

    @Override
    public Optional<Peminjam> getPeminjamByNoKtp(String noKtp) {
        return peminjamRepository.findByNoKtp(noKtp);
    }

    @Override
    public Peminjam savePeminjam(Peminjam peminjam) {
        if (peminjamRepository.existsById(peminjam.getNoKtp())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Peminjam dengan No KTP ini sudah terdaftar");
        }
        return peminjamRepository.save(peminjam);
    }

    @Override
    public Peminjam updatePeminjam(String noKtp, Peminjam peminjam) {
        return peminjamRepository.findById(noKtp).map(existingPeminjam -> {
            existingPeminjam.setNama(peminjam.getNama());
            existingPeminjam.setEmail(peminjam.getEmail());
            return peminjamRepository.save(existingPeminjam);
        }).orElseThrow(() -> new RuntimeException("Peminjam tidak ditemukan"));
    }

    @Override
    public void deletePeminjam(String noKtp) {
        peminjamRepository.deleteById(noKtp);
    }
}
