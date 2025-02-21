package com.perpustakaan.perpustakaan_manajemen.Controller;

import com.perpustakaan.perpustakaan_manajemen.Model.Peminjam;
import com.perpustakaan.perpustakaan_manajemen.Service.PeminjamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peminjam")
public class PeminjamController {
    private final PeminjamService peminjamService;

    public PeminjamController(PeminjamService peminjamService) {
        this.peminjamService = peminjamService;
    }

    @GetMapping
    public List<Peminjam> getAllPeminjam() {
        return peminjamService.getAllPeminjam();
    }

    @GetMapping("/{noKtp}")
    public ResponseEntity<Peminjam> getPeminjamByNoKtp(@PathVariable String noKtp) {
        return peminjamService.getPeminjamByNoKtp(noKtp)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Peminjam> createPeminjam(@RequestBody Peminjam peminjam) {
        return ResponseEntity.ok(peminjamService.savePeminjam(peminjam));
    }

    @PutMapping("/{noKtp}")
    public ResponseEntity<Peminjam> updatePeminjam(@PathVariable String noKtp, @RequestBody Peminjam peminjam) {
        return ResponseEntity.ok(peminjamService.updatePeminjam(noKtp, peminjam));
    }

    @DeleteMapping("/{noKtp}")
    public ResponseEntity<Void> deletePeminjam(@PathVariable String noKtp) {
        peminjamService.deletePeminjam(noKtp);
        return ResponseEntity.noContent().build();
    }
}
