package com.perpustakaan.perpustakaan_manajemen.Controller;

import com.perpustakaan.perpustakaan_manajemen.Model.Buku;
import com.perpustakaan.perpustakaan_manajemen.Service.BukuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buku")
public class BukuController {
    private final BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @GetMapping
    public List<Buku> getAllBuku() {
        return bukuService.getAllBuku();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Buku> getBukuById(@PathVariable String isbn) {
        return bukuService.getBukuByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Buku addBuku(@RequestBody Buku buku) {
        return bukuService.saveBuku(buku);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Buku> updateBuku(@PathVariable String isbn, @RequestBody Buku buku) {
        return ResponseEntity.ok(bukuService.updateBuku(isbn, buku));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteBuku(@PathVariable String isbn) {
        bukuService.deleteBuku(isbn);
        return ResponseEntity.noContent().build();
    }
}
